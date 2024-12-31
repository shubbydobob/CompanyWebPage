package com.web.dto;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

public class InquiryDTO {
    private Long id;
	private String name;            // 회사명 또는 이름
    private String contact;         // 연락처
    private String email;           // 이메일
    private String inquiry_type;     // 문의 유형
    private String message;         // 문의 내용
    private String attachment_path;  // 첨부 파일 경로
    private LocalDateTime createdAt; // 생성일
    private MultipartFile attachment; // 첨부 파일
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInquiry_type() {
		return inquiry_type;
	}
	public void setInquiry_type(String inquiry_type) {
		this.inquiry_type = inquiry_type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAttachment_path() {
		return attachment_path;
	}
	public void setAttachment_path(String attachment_path) {
		this.attachment_path = attachment_path;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public MultipartFile getAttachment() {
		return attachment;
	}
	public void setAttachment(MultipartFile attachment) {
		this.attachment = attachment;
	}
	@Override
	public String toString() {
		return "InquiryDTO [id=" + id + ", name=" + name + ", contact=" + contact + ", email=" + email
				+ ", inquiry_type=" + inquiry_type + ", message=" + message + ", attachment_path=" + attachment_path
				+ ", createdAt=" + createdAt + ", attachment=" + attachment + "]";
	}
    
    
    
	
}
