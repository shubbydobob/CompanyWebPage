package com.web.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.web.dto.AdminDTO;

@Mapper
public interface AdminMapper {

	AdminDTO getAdminById(String admin);
}
