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
import org.springframework.web.multipart.MultipartFile;

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

	// **로그인 처리**
	@PostMapping("/Login")
	public String login(String admin, String password, HttpSession session, Model model) {
		if (adminService.login(admin, password)) {
			session.setAttribute("loggedIn", true);
			return "redirect:/Inquiry"; // 로그인 성공 시 문의 목록으로 이동
		} else {
			model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
			return "Login/Login"; // 로그인 실패 시 로그인 페이지로 돌아감
		}
	}

	// **로그아웃 처리**
	@GetMapping("/Logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 초기화
		return "redirect:/Login"; // 로그아웃 후 로그인 페이지로 이동
	}
}