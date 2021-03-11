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

	@Override
	public BoardVO searchBoardId(BoardVO board) throws Exception {
		return dao.searchBoardId(board);
	}

	@Override
	public BoardVO getBoard(BoardVO board) throws Exception {
		return dao.getBoard(board);
	}

	@Override
	public void insertBoard(BoardVO board) throws Exception {
		dao.insertBoard(board);
		return;
	}

	@Override
	public void updateBoard(BoardVO board) throws Exception {
		dao.updateBoard(board);
		return;		
	}

}
