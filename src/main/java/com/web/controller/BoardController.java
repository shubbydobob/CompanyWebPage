package com.web.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.dto.BoardDTO;
import com.web.dto.CommentDTO;
import com.web.service.BoardService;
import com.web.service.CommentService;

@Controller
@RequestMapping("/Board")
public class BoardController {
	@Autowired
	private BoardService boardService;

	@Autowired
    private CommentService commentService;
	
	// 게시글 목록 조회
	@GetMapping
	public String getAllPosts(Model model, HttpSession session) {
		// 관리자 체크
		boolean isAdmin = session.getAttribute("loggedIn") != null && (Boolean) session.getAttribute("loggedIn");
		List<BoardDTO> posts = boardService.getAllPosts();
		model.addAttribute("posts", posts);
		model.addAttribute("isAdmin", isAdmin);
		return "/Board/Board";
	}

	// 게시글 작성 페이지 이동
	@GetMapping("/Write")
	public String goToWrite() {
		return "/Board/Write";
	}

	// 게시글 등록 처리
	@PostMapping("/Write")
	public String writePost(BoardDTO board, @RequestParam(value = "captcha", required = false) String captchaInput,
			HttpSession session, Model model) {
		String generatedCaptcha = (String) session.getAttribute("captcha");

		// 디버깅 로그
		System.out.println("[CAPTCHA 검증] Input CAPTCHA: " + captchaInput);
		System.out.println("[CAPTCHA 검증] Generated CAPTCHA: " + generatedCaptcha);

		if (captchaInput == null || !captchaInput.equals(generatedCaptcha)) {
			model.addAttribute("error", "CAPTCHA가 일치하지 않습니다.");
			return "/Board/Write";
		}

		// CAPTCHA 검증 성공 -> 게시글 저장
		boardService.insertPost(board);
		return "redirect:/Board";
	}

	@GetMapping("/captcha")
	public void generateCaptcha(HttpSession session, HttpServletResponse response) throws Exception {
		// CAPTCHA 텍스트 생성
		String captchaText = String.valueOf(1000 + new Random().nextInt(9000));

		// 세션에 CAPTCHA 저장
		session.setAttribute("captcha", captchaText);

		// 디버깅 로그
		System.out.println("[CAPTCHA 생성] Generated CAPTCHA: " + captchaText);

		// CAPTCHA 이미지 생성
		int width = 150;
		int height = 50;
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bufferedImage.createGraphics();
		g2d.setColor(new Color(240, 240, 240));
		g2d.fillRect(0, 0, width, height);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Arial", Font.BOLD, 28));
		g2d.drawString(captchaText, 25, 35);
		g2d.dispose();

		response.setContentType("image/png");
		ImageIO.write(bufferedImage, "png", response.getOutputStream());
	}

	@GetMapping("/View/{id}")
	public String viewPost(@PathVariable int id, Model model, HttpSession session) {
		// 세션에서 loggedIn과 isAdmin 값을 가져옴 (기본값 false 설정)
		Boolean isLoggedIn = (Boolean) session.getAttribute("loggedIn");
		if (isLoggedIn == null) {
			isLoggedIn = false; // 세션에 로그인 상태가 없으면 기본값 false
		}

		Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
		if (isAdmin == null) {
			isAdmin = false; // 세션에 관리자 여부가 없으면 기본값 false
		}

		// 게시글 조회
		BoardDTO post = boardService.getPostById(id);
		if (post == null) {
			// 게시글이 없으면 오류 처리 또는 페이지 리다이렉트
			return "redirect:/Board"; // 게시글이 없으면 목록 페이지로 리다이렉트
		}

		model.addAttribute("post", post);

		// 관리자인 경우, 비밀번호 확인 없이 바로 상세 페이지로 이동
	    if (isAdmin) {
	        return "redirect:/Board/Detail/" + id; // 관리자용 게시글 상세보기 페이지로 리다이렉트
	    } else {
	        // 일반 사용자라면 비밀번호 확인 페이지로 이동
	        return "/Board/View"; // 비밀번호 확인 페이지로 이동
	    }
	}

	// 게시글 비밀번호 확인 후 상세 조회
	@PostMapping("/View/{id}")
	public String viewPostWithPassword(@PathVariable int id, @RequestParam String password,
			RedirectAttributes redirectAttributes) {
		// 게시글과 입력된 비밀번호로 게시글 조회
		BoardDTO post = boardService.getPostByIdAndPassword(id, password);

		if (post == null) {
			// 비밀번호가 맞지 않으면 에러 메시지 추가
			redirectAttributes.addFlashAttribute("error", "비밀번호가 일치하지 않습니다.");
			return "redirect:/Board/View/" + id; // 비밀번호 입력 페이지로 리다이렉트
		} else {
			// 비밀번호가 맞으면 게시글을 상세보기 페이지로 리다이렉트
			redirectAttributes.addFlashAttribute("post", post);
			return "redirect:/Board/Detail/" + id; // 상세 페이지로 리다이렉트
		}
	}

	@GetMapping("/Detail/{id}")
    public String showDetailPage(@PathVariable int id, Model model, HttpSession session) {
        
		boardService.increaseViews(id); // 조회수 증가

		// Get the board details
        BoardDTO post = boardService.getPostById(id);
        model.addAttribute("post", post);

        // Get the comments for the board
        List<CommentDTO> comments = commentService.getCommentsByBoardId(id);
        model.addAttribute("comments", comments);

        return "/Board/Detail";
    }

//	@PostMapping("/Detail/{id}/addResponse")
//	public String addComment(@PathVariable int id, @RequestParam String content, 
//	                         @RequestParam(required = false) String writer, HttpSession session) {
//	    // 세션에서 로그인된 사용자 정보 가져오기
//	    String username = (String) session.getAttribute("username");
//
//	    // author 값 설정
//	    String author = (username != null) ? username : writer; // 로그인된 경우 username, 그렇지 않으면 writer
//
//	    if (author == null || author.trim().isEmpty()) {
//	        throw new IllegalArgumentException("작성자 정보를 입력해주세요.");
//	    }
//
//	    // 댓글 객체 생성
//	    CommentDTO comment = new CommentDTO();
//	    comment.setBoardId(id);
//	    comment.setAuthor(author); // author 설정
//	    comment.setContent(content);
//
//	    // 댓글 저장
//	    commentService.addComment(comment);
//
//	    // 디버깅 로그 (선택 사항)
//	    System.out.println("[DEBUG] author: " + author);
//	    System.out.println("[DEBUG] content: " + content);
//
//	    // 상세 페이지로 리다이렉트
//	    return "redirect:/Board/Detail/" + id;
//	}
	// 게시글 삭제
	@PostMapping("/Delete/{id}")
	public String deletePost(@PathVariable int id) {
		boardService.deletePost(id);
		return "redirect:/Board"; // 게시글 목록으로 리다이렉트
	}
	
	
	
}
