package com.wmproject.service;

import java.util.List;

import com.wmproject.domain.BoardVO;
import com.wmproject.domain.CommentVO;

public interface BoardService {
    public List<BoardVO> selectBoard(BoardVO board) throws Exception;
    public BoardVO searchBoardId(BoardVO board) throws Exception;
    public BoardVO getBoard(BoardVO board) throws Exception;
    public void insertBoard(BoardVO board) throws Exception;
    public void updateBoard(BoardVO board) throws Exception;
    public List<CommentVO> selectComments(BoardVO board) throws Exception;
    public void writeComment(CommentVO comment) throws Exception;
}
