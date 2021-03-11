package com.wmproject.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.wmproject.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

    @Inject
    private SqlSession sqlSession;

    private static final String Namespace = "mappers.boardMapper";
    
	@Override
	public List<BoardVO> selectBoard(BoardVO board) throws Exception {
		return sqlSession.selectList(Namespace+".selectBoard", board);
	}
	
	@Override
	public BoardVO searchBoardId(BoardVO board) throws Exception {
		return sqlSession.selectOne(Namespace+".searchBoardId", board);
	}

	@Override
	public BoardVO getBoard(BoardVO board) throws Exception {
		return sqlSession.selectOne(Namespace+".getBoard", board);
	}

	@Override
	public void insertBoard(BoardVO board) throws Exception {
		sqlSession.insert(Namespace+".insertBoard", board);
		return;		
	}

	@Override
	public void updateBoard(BoardVO board) throws Exception {
		sqlSession.update(Namespace+".updateBoard", board);
	}

}
