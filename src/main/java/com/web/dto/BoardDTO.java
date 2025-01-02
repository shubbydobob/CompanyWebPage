package com.web.dto;

public class BoardDTO {
	private int id; // 게시물 ID
	private String title; // 제목
	private String writer; // 작성자
	private String content; // 내용
	private int views; // 조회수
	private String createdDate; // 생성일
	private String password; // 비밀번호
	private String contact; // 연락처
	private String category; // 분류

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "BoardDTO [id=" + id + ", title=" + title + ", writer=" + writer + ", content=" + content + ", views="
				+ views + ", createdDate=" + createdDate + ", password=" + password + ", contact=" + contact
				+ ", category=" + category + "]";
	}

}
