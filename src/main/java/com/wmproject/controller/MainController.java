package com.wmproject.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wmproject.domain.BoardVO;
import com.wmproject.domain.MemberVO;
import com.wmproject.domain.RankPagingVO;
import com.wmproject.service.BoardService;
import com.wmproject.service.MemberService;


@Controller
public class MainController {
	
	@Inject
    private MemberService Mservice;
	
	@Inject
    private BoardService Bservice;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Locale locale, Model model) throws Exception{
    	List<BoardVO> noticeList = Bservice.getRecentNotice();
    	List<BoardVO> communityList = Bservice.getRecentCommunity();
    	
    	model.addAttribute("noticeList", noticeList);
    	model.addAttribute("communityList", communityList);
        return "index";
    }

    @RequestMapping(value = "/ranking", method = RequestMethod.GET)
	public String ranking(Model model) throws Exception {
    	RankPagingVO pagingManager = new RankPagingVO(0, 10);
    	List<MemberVO> rankingList = Mservice.searchRanking(pagingManager);
    	
    	model.addAttribute("rankingList", rankingList);
		return "ranking";
	}
    
    @ResponseBody
    @RequestMapping(value = "/ranking", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public String rankingPaging(@RequestParam(value= "start") int start) throws Exception {
    	RankPagingVO pagingManager = new RankPagingVO(start, 10);
    	List<MemberVO> rankingList = Mservice.searchRanking(pagingManager);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	String jsonStr = mapper.writeValueAsString(rankingList);
		return jsonStr;
	}
}