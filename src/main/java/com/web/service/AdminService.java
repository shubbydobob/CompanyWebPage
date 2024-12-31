package com.web.service;

import com.web.dto.AdminDTO;

public interface AdminService {
    boolean login(String admin, String password);
}