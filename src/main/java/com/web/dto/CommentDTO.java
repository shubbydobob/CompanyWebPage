package com.web.dto;

import java.sql.Timestamp;
import java.util.List;

public class CommentDTO {

	private int id;
	private int boardId;
	private String author;
	private String content;
	private String createdDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "CommentDTO [id=" + id + ", boardId=" + boardId + ", author=" + author + ", content=" + content
				+ ", createdDate=" + createdDate + "]";
	}
	
	
	
}
