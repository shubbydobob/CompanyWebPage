package com.web.mapper;

import java.util.List;
import com.web.dto.InquiryDTO;

public interface InquiryMapper {
    void saveInquiry(InquiryDTO inquiryDTO); // 문의 저장
    List<InquiryDTO> getAllInquiries(); // 모든 문의 조회
}
