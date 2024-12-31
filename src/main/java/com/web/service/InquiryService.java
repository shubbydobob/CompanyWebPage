package com.web.service;

import java.util.List;
import com.web.dto.InquiryDTO;

public interface InquiryService {
    void saveInquiry(InquiryDTO inquiryDTO); // 문의 저장
    List<InquiryDTO> getInquiries(); // 모든 문의 조회
}
