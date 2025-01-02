package com.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.dto.InquiryDTO;
import com.web.service.AdminService;
import com.web.service.InquiryService;

@Controller
public class HomeController {

	@Autowired
    private AdminService adminService;
	

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	// **로그인 페이지 이동**
	@GetMapping("/Login")
	public String goLogin() {
		return "Login/Login";
	}

	 // 로그인 처리
    @PostMapping("/Login")
    public String login(@RequestParam String admin, @RequestParam String password,
                        HttpSession session, RedirectAttributes redirectAttributes) {

        // 로그인 검증
        boolean loginSuccess = adminService.login(admin, password);

        if (loginSuccess) {
            // 로그인 성공 시 세션에 'loggedIn'과 'isAdmin' 설정
            session.setAttribute("loggedIn", true);  // 로그인 상태
            session.setAttribute("isAdmin", true);   // 관리자 여부 설정
            session.setAttribute("username", admin); // 세션에 사용자 이름 저장
            return "redirect:/Board";  // 게시판으로 리다이렉트
        } else {
            // 로그인 실패 시 오류 메시지
            redirectAttributes.addFlashAttribute("error", "아이디나 비밀번호가 잘못되었습니다.");
            return "redirect:/Login/Login";  // 로그인 페이지로 리다이렉트
        }
    }


	// **로그아웃 처리**
	@GetMapping("/Logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 초기화
		return "redirect:/Login"; // 로그아웃 후 로그인 페이지로 이동
	}
}