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

import com.web.dto.BoardDTO;
import com.web.service.BoardService;

@Controller
@RequestMapping("/Board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    // 게시글 목록 조회
    @GetMapping
    public String getAllPosts(Model model) {
        List<BoardDTO> posts = boardService.getAllPosts();
        model.addAttribute("posts", posts);
        return "/Board/Board";
    }

    // 게시글 작성 페이지 이동
    @GetMapping("/Write")
    public String goToWrite() {
        return "/Board/Write";
    }


    // 게시글 상세 조회
    @GetMapping("/View/{id}")
    public String viewPost(@PathVariable int id, Model model) {
        boardService.increaseViews(id); // 조회수 증가
        BoardDTO post = boardService.getPostById(id);
        model.addAttribute("post", post);
        return "/Board/View";
    }

    // 비밀번호 확인 후 게시글 조회
    @PostMapping("/View/{id}")
    public String viewPostWithPassword(@PathVariable int id, @RequestParam String password, Model model) {
        BoardDTO post = boardService.getPostByIdAndPassword(id, password);
        if (post == null) {
            model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
            return "/Board/View";
        }
        model.addAttribute("post", post);
        return "/Board/Detail";
    }
    
 // 게시글 등록 처리
    @PostMapping("/Write")
    public String writePost(BoardDTO board, 
                            @RequestParam(value = "captcha", required = false) String captchaInput, 
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
}

