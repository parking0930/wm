package com.wmproject.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wmproject.domain.MemberVO;
import com.wmproject.domain.RankPagingVO;
import com.wmproject.service.MemberService;

@Controller
@RequestMapping(value="/mapia")
public class GameController {
	
	@Inject
    private MemberService Mservice;
	
	@RequestMapping(value = "/lobby", method = RequestMethod.GET)
    public String lobby(HttpServletRequest request, HttpServletResponse response) throws Exception{
		if(request.getSession().getAttribute("member")==null) return "redirect:/";
		RankPagingVO pagingManager = new RankPagingVO(0, 10);
    	List<MemberVO> rankingList = Mservice.searchRanking(pagingManager);
    	
    	request.setAttribute("rankingList", rankingList);
		return "/mapia/lobby";
	}
}