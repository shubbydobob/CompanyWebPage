package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dto.AdminDTO;
import com.web.mapper.AdminMapper;

@Service
public class AdminService {

	 @Autowired
	    private AdminMapper adminMapper;

	    public boolean login(String admin, String password) {
	        AdminDTO adminDTO = adminMapper.getAdminById(admin);
	        // 관리자 정보 검증
	        if (adminDTO != null && adminDTO.getPassword().equals(password)) {
	            return true;  // 로그인 성공
	        }
	        return false;  // 로그인 실패
	    }
}