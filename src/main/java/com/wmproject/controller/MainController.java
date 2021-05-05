package com.wmproject.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wmproject.domain.MemberVO;
import com.wmproject.domain.RankPagingVO;
import com.wmproject.service.MemberService;


@Controller
public class MainController {
	
	@Inject
    private MemberService Mservice;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Locale locale, Model model) throws Exception{
 
        return "index";
    }
    
    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp() {
		return "signUp";
	}
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

    @RequestMapping(value = "/ranking", method = RequestMethod.GET)
	public String ranking(Model model) throws Exception {
    	RankPagingVO pagingManager = new RankPagingVO(Mservice.cntMember(), 0, 10);
    	List<MemberVO> rankingList = Mservice.searchRanking(pagingManager);
    	
    	model.addAttribute("rankingList", rankingList);
		return "ranking";
	}
    
    @ResponseBody
    @RequestMapping(value = "/ranking", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public String rankingPaging(@RequestParam(value= "start") int start) throws Exception {
    	System.out.println("ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
    	RankPagingVO pagingManager = new RankPagingVO(Mservice.cntMember(), start, 10);
    	List<MemberVO> rankingList = Mservice.searchRanking(pagingManager);
    	System.out.println(start);
		return rankingList.toString();
	}
}