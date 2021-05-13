package com.wmproject.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.wmproject.domain.BoardVO;
import com.wmproject.domain.CommentVO;
import com.wmproject.domain.PagingVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

    @Inject
    private SqlSession sqlSession;

    private static final String Namespace = "mappers.boardMapper";
    
	@Override
	public List<BoardVO> selectBoard(PagingVO paging) throws Exception {
		return sqlSession.selectList(Namespace+".selectBoard", paging);
	}

	@Override
	public int cntBoard(BoardVO board) throws Exception {
		return sqlSession.selectOne(Namespace+".cntBoard", board);
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
	public void editBoard(BoardVO board) throws Exception {
		sqlSession.update(Namespace+".editBoard", board);
	}

	@Override
	public void deleteBoard(BoardVO board) throws Exception {
		sqlSession.delete(Namespace+".deleteBoard", board);
	}

	@Override
	public void updateBoard(BoardVO board) throws Exception {
		sqlSession.update(Namespace+".updateBoard", board);
	}

	@Override
	public List<CommentVO> selectComments(BoardVO board) throws Exception {
		return sqlSession.selectList(Namespace+".selectComments", board);
	}

	@Override
	public void writeComment(CommentVO comment) throws Exception {
		sqlSession.insert(Namespace+".writeComment", comment);
		return;
	}

	@Override
	public List<BoardVO> getRecentNotice() throws Exception {
		return sqlSession.selectList(Namespace+".getRecentNotice");
	}

	@Override
	public List<BoardVO> getRecentCommunity() throws Exception {
		return sqlSession.selectList(Namespace+".getRecentCommunity");
	}

}
