package com.wmproject.dao;

import java.util.List;

import com.wmproject.domain.MemberVO;
 
public interface MemberDAO {
    
    public List<MemberVO> selectMember() throws Exception;
    public int checkID(MemberVO vo) throws Exception;
    public int checkNickname(MemberVO vo) throws Exception;
    public void signUp(MemberVO vo) throws Exception;
}