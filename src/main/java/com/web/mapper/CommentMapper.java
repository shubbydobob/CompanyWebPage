package com.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.dto.CommentDTO;

@Mapper
public interface CommentMapper {
	void addComment(CommentDTO commentDTO);

	List<CommentDTO> getCommentsByBoardId(int boardId);

	List<CommentDTO> getChildComments(int parentId);
}
