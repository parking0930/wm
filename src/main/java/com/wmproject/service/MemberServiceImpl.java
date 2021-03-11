package com.wmproject.service;

import javax.inject.Inject;
 
import org.springframework.stereotype.Service;

import com.wmproject.dao.MemberDAO;
import com.wmproject.domain.MemberVO;
 
@Service
public class MemberServiceImpl implements MemberService {
 
    @Inject
    private MemberDAO dao;
    
    @Override
    public MemberVO selectMemberById(MemberVO vo) throws Exception {
        return dao.selectMemberById(vo);
    }

	@Override
	public MemberVO selectMemberByNick(String nickname) throws Exception {
		MemberVO getMember = dao.selectMemberByNick(nickname);
		getMember.setDate(getMember.getDate().split(" ")[0]);
		return getMember;
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

	@Override
	public int login(MemberVO vo) throws Exception {
		int result = dao.login(vo);
		return result;
	}
 
}