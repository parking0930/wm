package com.wmproject.service;

import java.util.List;

import com.wmproject.domain.BoardVO;

public interface BoardService {
    public List<BoardVO> selectBoard(BoardVO board) throws Exception;
}
