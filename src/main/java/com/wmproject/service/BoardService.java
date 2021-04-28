package com.wmproject.service;

import java.util.List;

import com.wmproject.domain.BoardVO;
import com.wmproject.domain.CommentVO;
import com.wmproject.domain.PagingVO;

public interface BoardService {
    public List<BoardVO> selectBoard(PagingVO paging) throws Exception;
    public int cntBoard(BoardVO board) throws Exception;
    public BoardVO searchBoardId(BoardVO board) throws Exception;
    public BoardVO getBoard(BoardVO board) throws Exception;
    public void insertBoard(BoardVO board) throws Exception;
    public void editBoard(BoardVO board) throws Exception;
    public void deleteBoard(BoardVO board) throws Exception;
    public void updateBoard(BoardVO board) throws Exception;
    public List<CommentVO> selectComments(BoardVO board) throws Exception;
    public void writeComment(CommentVO comment) throws Exception;
}
