package com.wmproject.service;

import java.util.List;

import javax.inject.Inject;
 
import org.springframework.stereotype.Service;

import com.wmproject.dao.MemberDAO;
import com.wmproject.domain.MemberVO;
 
@Service
public class MemberServiceImpl implements MemberService {
 
    @Inject
    private MemberDAO dao;
    
    @Override
    public List<MemberVO> selectMember() throws Exception {
 
        return dao.selectMember();
    }

	@Override
	public int checkID(MemberVO vo) throws Exception {
		int result = dao.checkID(vo);
		return result;
	}

	@Override
	public int checkNickname(MemberVO vo) throws Exception {
		int result = dao.checkNickname(vo);
		return result;
	}

	@Override
	public void signUp(MemberVO vo) throws Exception {
		dao.signUp(vo);
		return;
	}
 
}