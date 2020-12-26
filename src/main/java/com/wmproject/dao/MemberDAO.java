package com.wmproject.dao;

import java.util.List;

import com.wmproject.domain.MemberVO;
 
public interface MemberDAO {
    
    public List<MemberVO> selectMember() throws Exception;
    
}