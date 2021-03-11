package com.wmproject.dao;

import com.wmproject.domain.MemberVO;
 
public interface MemberDAO {

    public MemberVO selectMemberById(MemberVO vo) throws Exception;
    public MemberVO selectMemberByNick(String nickname) throws Exception;
    public int checkID(MemberVO vo) throws Exception;
    public int checkNickname(MemberVO vo) throws Exception;
    public void signUp(MemberVO vo) throws Exception;
    public int login(MemberVO vo) throws Exception;
}