package com.wmproject.dao;

import java.util.List;

import com.wmproject.domain.MemberVO;
import com.wmproject.domain.RankPagingVO;
 
public interface MemberDAO {

    public MemberVO selectMemberById(MemberVO vo) throws Exception;
    public MemberVO selectMemberByNick(String nickname) throws Exception;
    public int checkID(MemberVO vo) throws Exception;
    public int checkNickname(MemberVO vo) throws Exception;
    public void signUp(MemberVO vo) throws Exception;
    public int login(MemberVO vo) throws Exception;
    public void updateProfile(MemberVO vo) throws Exception;
    public List<MemberVO> searchRanking(RankPagingVO vo) throws Exception;
    public int cntMember() throws Exception;
}