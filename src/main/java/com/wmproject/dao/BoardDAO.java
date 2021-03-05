package com.wmproject.dao;

import java.util.List;

import com.wmproject.domain.BoardVO;

public interface BoardDAO {
    public List<BoardVO> selectBoard(BoardVO board) throws Exception;
}