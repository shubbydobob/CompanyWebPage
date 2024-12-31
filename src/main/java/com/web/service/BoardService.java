package com.web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web.dto.BoardDTO;
import com.web.mapper.BoardMapper;

@Service
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;

    public List<BoardDTO> getAllPosts() {
        return boardMapper.getAllPosts();
    }

    public BoardDTO getPostById(int id) {
        return boardMapper.getPostById(id);
    }

    public BoardDTO getPostByIdAndPassword(int id, String password) {
        return boardMapper.getPostByIdAndPassword(id, password);
    }

    public void insertPost(BoardDTO board) {
        boardMapper.insertPost(board);
    }

    public void increaseViews(int id) {
        boardMapper.increaseViews(id);
    }

    public void deletePost(int id) {
        boardMapper.deletePost(id);
    }
}
