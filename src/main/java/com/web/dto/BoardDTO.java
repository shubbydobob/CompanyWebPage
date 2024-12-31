package com.web.dto;

public class BoardDTO {
	 private int id;
	    private String title;
	    private String writer;
	    private String content;
	    private int views;
	    private String createdDate;
	    private String password; // 비밀번호 추가
	    
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
		@Override
		public String toString() {
			return "BoardDTO [id=" + id + ", title=" + title + ", writer=" + writer + ", content=" + content
					+ ", views=" + views + ", createdDate=" + createdDate + ", password=" + password + "]";
		}
	
	    
}
