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

}
