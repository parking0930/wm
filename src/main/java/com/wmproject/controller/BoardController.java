package com.wmproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	String mainTitle;
	String subTitle;
	String leftTitle;
	String[] boardList;
	
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String board(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	String board = request.getParameter("board");
    	if(board==null) return "redirect:/";
    	request.setAttribute("board", board);
    	
    	switch(board) {
    		case "notice":
    			leftTitle = "공지사항";
    			mainTitle = "공지사항";
    			subTitle = "공지사항 게시판입니다.";
    			boardList = new String[]{"공지사항", "이벤트"};
    			break;
    		case "event":
    			leftTitle = "공지사항";
    			mainTitle = "이벤트";
    			subTitle = "이벤트 게시판입니다.";
    			boardList = new String[]{"공지사항", "이벤트"};
    			break;
    		case "free":
    			leftTitle = "커뮤니티";
    			mainTitle = "자유게시판";
    			subTitle = "자유게시판입니다.";
    			boardList = new String[]{"자유게시판", "스크린샷"};
    			break;
    		case "screenshot":
    			leftTitle = "커뮤니티";
    			mainTitle = "스크린샷";
    			subTitle = "스크린샷 게시판입니다.";
    			boardList = new String[]{"자유게시판", "스크린샷"};
    			break;
    		default:
    			return "redirect:/";
    	}

    	request.setAttribute("mainTitle", mainTitle);
    	request.setAttribute("subTitle", subTitle);
    	request.setAttribute("leftTitle", leftTitle);
    	request.setAttribute("boardList", boardList);
		return "board";
    }
    
    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	if(request.getSession().getAttribute("member")==null) return "redirect:/";
    	
    	String board = request.getParameter("board");
    	if(board==null) return "redirect:/";
    	
    	switch(board) {
    		case "notice":
    			leftTitle = "공지사항";
    			mainTitle = "공지사항";
    			subTitle = "공지사항 게시판입니다.";
    			boardList = new String[]{"공지사항", "이벤트"};
    			break;
    		case "event":
    			leftTitle = "공지사항";
    			mainTitle = "이벤트";
    			subTitle = "이벤트 게시판입니다.";
    			boardList = new String[]{"공지사항", "이벤트"};
    			break;
    		case "free":
    			leftTitle = "커뮤니티";
    			mainTitle = "자유게시판";
    			subTitle = "자유게시판입니다.";
    			boardList = new String[]{"자유게시판", "스크린샷"};
    			break;
    		case "screenshot":
    			leftTitle = "커뮤니티";
    			mainTitle = "스크린샷";
    			subTitle = "스크린샷 게시판입니다.";
    			boardList = new String[]{"자유게시판", "스크린샷"};
    			break;
    		default:
    			return "redirect:/";
    	}

    	request.setAttribute("mainTitle", mainTitle);
    	request.setAttribute("subTitle", subTitle);
    	request.setAttribute("leftTitle", leftTitle);
    	request.setAttribute("boardList", boardList);
        return "write";
    }
    
    @RequestMapping(value = "/imgupload", method = RequestMethod.GET)
    public String imguploadGet(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	return "imgupload";
    }
    @RequestMapping(value = "/imgupload", method = RequestMethod.POST)
    public void imguploadPost(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	
    }
}
