package com.wmproject.dao;

import java.util.List;

import com.wmproject.domain.BoardVO;

public interface BoardDAO {
    public List<BoardVO> selectBoard(BoardVO board) throws Exception;
    public BoardVO searchBoardId(BoardVO board) throws Exception;
    public BoardVO getBoard(BoardVO board) throws Exception;
    public void insertBoard(BoardVO board) throws Exception;
    public void updateBoard(BoardVO board) throws Exception;
}