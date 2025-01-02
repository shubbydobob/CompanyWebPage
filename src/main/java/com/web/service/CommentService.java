package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dto.CommentDTO;
import com.web.mapper.CommentMapper;

@Service
public class CommentService {

	@Autowired
	private CommentMapper commentMapper;

	// Add a comment
	public void addComment(CommentDTO commentDTO) {
		commentMapper.addComment(commentDTO);
	}

	public List<CommentDTO> getCommentsByBoardId(int boardId) {
		return commentMapper.getCommentsByBoardId(boardId);
	}

}
