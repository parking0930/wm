package com.wmproject.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.wmproject.dao.BoardDAO;
import com.wmproject.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	 
    @Inject
    private BoardDAO dao;
    
	@Override
	public List<BoardVO> selectBoard(BoardVO board) throws Exception {
		List<BoardVO> list = dao.selectBoard(board);
		for(BoardVO tmp:list) {
			tmp.setDate(tmp.getDate().split(" ")[0]);
		}
		return list;
	}

}
