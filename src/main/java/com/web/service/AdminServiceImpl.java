package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dto.AdminDTO;
import com.web.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean login(String admin, String password) {
        AdminDTO adminDTO = adminMapper.getAdminById(admin);

        // 관리자 정보 검증
        if (adminDTO != null && adminDTO.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

}
