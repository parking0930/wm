package com.wmproject.service;

import com.wmproject.domain.MemberVO;
 
public interface MemberService {
    public MemberVO selectMember(MemberVO vo) throws Exception;
    public int checkID(MemberVO vo) throws Exception;
    public int checkNickname(MemberVO vo) throws Exception;
    public void signUp(MemberVO vo) throws Exception;
    public int login(MemberVO vo) throws Exception;
}