package com.wmproject.service;

import java.util.List;

import com.wmproject.domain.MemberVO;
 
public interface MemberService {
    public List<MemberVO> selectMember() throws Exception;
}