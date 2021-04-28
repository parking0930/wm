package com.wmproject.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.wmproject.dao.BoardDAO;
import com.wmproject.domain.BoardVO;
import com.wmproject.domain.CommentVO;
import com.wmproject.domain.PagingVO;

@Service
public class BoardServiceImpl implements BoardService {
	 
    @Inject
    private BoardDAO dao;
    
    @Inject
    private MemberService Mservice;
    
	@Override
	public List<BoardVO> selectBoard(PagingVO paging) throws Exception {
		List<BoardVO> list = dao.selectBoard(paging);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
		String nowDate = sdf.format(new Date()).split(" ")[0];
		String tmpDate;
		for(BoardVO tmp:list) {
			tmpDate = tmp.getDate().split(" ")[0];
			if(nowDate.equals(tmpDate)) {
				Date parseDate = sdf.parse(tmp.getDate());
				tmp.setDate(sdf2.format(parseDate));
			}
			else tmp.setDate(tmpDate);
		}
		return list;
	}

	@Override
	public int cntBoard(BoardVO board) throws Exception {
		return dao.cntBoard(board);
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
	public void editBoard(BoardVO board) throws Exception {
		dao.editBoard(board);
		return;
	}

	@Override
	public void deleteBoard(BoardVO board) throws Exception {
		dao.deleteBoard(board);
		return;
	}

	@Override
	public void updateBoard(BoardVO board) throws Exception {
		dao.updateBoard(board);
		return;
	}

	@Override
	public List<CommentVO> selectComments(BoardVO board) throws Exception {
		List<CommentVO> commentList = dao.selectComments(board);
		for(CommentVO tmpComment:commentList) {
			tmpComment.setWriterinfo(Mservice.selectMemberByNick(tmpComment.getNickname()));
		}
		return commentList;
	}

	@Override
	public void writeComment(CommentVO comment) throws Exception {
		dao.writeComment(comment);
		return;
	}
	
}
