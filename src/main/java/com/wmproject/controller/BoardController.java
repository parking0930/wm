package com.wmproject.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wmproject.domain.BoardVO;
import com.wmproject.domain.MemberVO;
import com.wmproject.service.BoardService;
import com.wmproject.service.MemberService;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	@Inject
    private BoardService Bservice;
	
	@Inject
    private MemberService Mservice;
	
	@Resource(name="uploadPath")
    String uploadPath;
	
	String mainTitle;
	String subTitle;
	String leftTitle;
	HashMap<String, String> boardList;
	
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String board(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	String board = request.getParameter("board");
    	if(board==null) return "redirect:/";
    	request.setAttribute("board", board);
    	
    	boardList = new HashMap<String, String>();
    	switch(board) {
    		case "notice":
    			leftTitle = "공지사항";
    			mainTitle = "공지사항";
    			subTitle = "공지사항 게시판입니다.";
    			boardList.put("공지사항", "notice");
    			boardList.put("이벤트", "event");
    			break;
    		case "event":
    			leftTitle = "공지사항";
    			mainTitle = "이벤트";
    			subTitle = "이벤트 게시판입니다.";
    			boardList.put("공지사항", "notice");
    			boardList.put("이벤트", "event");
    			break;
    		case "free":
    			leftTitle = "커뮤니티";
    			mainTitle = "자유게시판";
    			subTitle = "자유게시판입니다.";
    			boardList.put("자유게시판", "free");
    			boardList.put("스크린샷", "screenshot");
    			break;
    		case "screenshot":
    			leftTitle = "커뮤니티";
    			mainTitle = "스크린샷";
    			subTitle = "스크린샷 게시판입니다.";
    			boardList.put("자유게시판", "free");
    			boardList.put("스크린샷", "screenshot");
    			break;
    		default:
    			return "redirect:/";
    	}
    	
    	BoardVO nameSampleBoard = new BoardVO();
    	nameSampleBoard.setBoard(board);
    	List<BoardVO> getlist = Bservice.selectBoard(nameSampleBoard);
    	request.setAttribute("getlist", getlist);

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

    	boardList = new HashMap<String, String>();
    	switch(board) {
    		case "notice":
    			leftTitle = "공지사항";
    			mainTitle = "공지사항";
    			subTitle = "공지사항 게시판입니다.";
    			boardList.put("공지사항", "notice");
    			boardList.put("이벤트", "event");
    			break;
    		case "event":
    			leftTitle = "공지사항";
    			mainTitle = "이벤트";
    			subTitle = "이벤트 게시판입니다.";
    			boardList.put("공지사항", "notice");
    			boardList.put("이벤트", "event");
    			break;
    		case "free":
    			leftTitle = "커뮤니티";
    			mainTitle = "자유게시판";
    			subTitle = "자유게시판입니다.";
    			boardList.put("자유게시판", "free");
    			boardList.put("스크린샷", "screenshot");
    			break;
    		case "screenshot":
    			leftTitle = "커뮤니티";
    			mainTitle = "스크린샷";
    			subTitle = "스크린샷 게시판입니다.";
    			boardList.put("자유게시판", "free");
    			boardList.put("스크린샷", "screenshot");
    			break;
    		default:
    			return "redirect:/";
    	}

    	request.setAttribute("mainTitle", mainTitle);
    	request.setAttribute("subTitle", subTitle);
    	request.setAttribute("leftTitle", leftTitle);
    	request.setAttribute("boardList", boardList);
    	request.setAttribute("board", board);
        return "write";
    }
    
    @RequestMapping(value = "/imgupload", method = RequestMethod.GET)
    public String imguploadGet(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	return "imgupload";
    }
    
    @ResponseBody
    @RequestMapping(value = "/imgupload", method = RequestMethod.POST)
    public String imguploadPost(HttpServletRequest request, HttpServletResponse response, MultipartFile file) throws Exception{
    	UUID uuid = UUID.randomUUID();
    	String fileName = uuid.toString()+"_"+file.getOriginalFilename();
    	String realPath = request.getServletContext().getRealPath(uploadPath);
    	
    	File target = new File(realPath, fileName);
    	if(!new File(realPath).exists()) new File(realPath).mkdirs();
    	
		try {
			FileCopyUtils.copy(file.getBytes(), target);
		}catch(Exception e) {
			e.printStackTrace(); System.out.println("업로드 오류 발생!");
		}
		
		return fileName;
    }
    
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	String board = request.getParameter("board");
    	String id = request.getParameter("id");
    	
    	if(board==null||id==null) return "redirect:/";

    	boardList = new HashMap<String, String>();
    	switch(board) {
    		case "notice":
    			leftTitle = "공지사항";
    			mainTitle = "공지사항";
    			subTitle = "공지사항 게시판입니다.";
    			boardList.put("공지사항", "notice");
    			boardList.put("이벤트", "event");
    			break;
    		case "event":
    			leftTitle = "공지사항";
    			mainTitle = "이벤트";
    			subTitle = "이벤트 게시판입니다.";
    			boardList.put("공지사항", "notice");
    			boardList.put("이벤트", "event");
    			break;
    		case "free":
    			leftTitle = "커뮤니티";
    			mainTitle = "자유게시판";
    			subTitle = "자유게시판입니다.";
    			boardList.put("자유게시판", "free");
    			boardList.put("스크린샷", "screenshot");
    			break;
    		case "screenshot":
    			leftTitle = "커뮤니티";
    			mainTitle = "스크린샷";
    			subTitle = "스크린샷 게시판입니다.";
    			boardList.put("자유게시판", "free");
    			boardList.put("스크린샷", "screenshot");
    			break;
    		default:
    			return "redirect:/";
    	}
    	
    	BoardVO getBoard = new BoardVO();
    	getBoard.setBoard(board);
    	getBoard.setId(id);
    	Bservice.updateBoard(getBoard);
    	getBoard = Bservice.getBoard(getBoard);
    	MemberVO writerInfo = Mservice.selectMemberByNick(getBoard.getNickname());
    	
    	request.setAttribute("mainTitle", mainTitle);
    	request.setAttribute("subTitle", subTitle);
    	request.setAttribute("leftTitle", leftTitle);
    	request.setAttribute("boardList", boardList);
    	request.setAttribute("board", board);
    	request.setAttribute("getBoard", getBoard);
    	request.setAttribute("writerInfo", writerInfo);
    	
        return "view";
    }
    
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	String board = request.getParameter("boardName");
    	String title = request.getParameter("title");
    	String contents = request.getParameter("contents");
    	String nickname = ((MemberVO)request.getSession().getAttribute("member")).getNickname();
    	
    	BoardVO newInsert = new BoardVO();
    	newInsert.setBoard(board);
    	newInsert.setTitle(title);
    	newInsert.setContents(contents);
    	newInsert.setNickname(nickname);
    	Bservice.insertBoard(newInsert);
    	
    	String id = Bservice.searchBoardId(newInsert).getId().toString();
    	System.out.println(id);
    	return "redirect:/board/view?board="+board+"&id="+id;
    }
}
