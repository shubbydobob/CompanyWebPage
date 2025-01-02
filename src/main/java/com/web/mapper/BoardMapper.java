package com.web.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.web.dto.BoardDTO;

@Mapper
public interface BoardMapper {
    // 게시글 목록 조회
    List<BoardDTO> getAllPosts();

    // 게시글 상세 조회
    BoardDTO getPostById(@Param("id") int id);

    // 게시글 등록
    void insertPost(BoardDTO board);

    // 게시글 조회수 증가
    void increaseViews(@Param("id") int id);

    // 게시글 삭제
    void deletePost(@Param("id") int id);

    void addComment(BoardDTO boardDTO);
    
    // 비밀번호 확인 후 게시글 조회
    BoardDTO getPostByIdAndPassword(@Param("id") int id, @Param("password") String password);
}
