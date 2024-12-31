package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dto.InquiryDTO;
import com.web.mapper.InquiryMapper;

@Service
public class InquiryServiceImpl implements InquiryService {

    @Autowired
    private InquiryMapper inquiryMapper;

    @Transactional // 트랜잭션 적용
    @Override
    public void saveInquiry(InquiryDTO inquiryDTO) {
        inquiryMapper.saveInquiry(inquiryDTO);
    }

    @Override
    public List<InquiryDTO> getInquiries() {
        return inquiryMapper.getAllInquiries();
    }
}
