package com.wmproject.controller;

import java.io.File;
import java.io.PrintWriter;
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

import com.wmproject.domain.MemberVO;
import com.wmproject.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {

	@Inject
    private MemberService service;

	@Resource(name="uploadProfilePath")
    String uploadProfilePath;
	
	@ResponseBody
	@RequestMapping(value = "/checkID", method = RequestMethod.POST)
	public String checkID(MemberVO vo) throws Exception {
		int result = service.checkID(vo);
		if(result==1)
			return "1";
		else
			return "0";
	}
	
	@ResponseBody
	@RequestMapping(value = "/checkNickname", method = RequestMethod.POST)
	public String checkNickname(MemberVO vo) throws Exception {
		int result = service.checkNickname(vo);
		if(result==1)
			return "1";
		else
			return "0";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(MemberVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int result = service.checkID(vo);
		if(result==1) return "redirect:/";
		result = service.checkNickname(vo);
		if(result==1) return "redirect:/";
		service.signUp(vo);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('회원가입이 완료되었습니다.');location.replace('/');</script>");
        out.close();
		return null;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int result = service.login(vo);
		if(result==1) {
			MemberVO myinfo = service.selectMemberById(vo);
			request.getSession().setAttribute("member", myinfo);
			response.sendRedirect("/");
			return null;
		}else {
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>alert('아이디 또는 비밀번호가 틀립니다.');history.go(-1);</script>");
	        out.close();
	        return null;
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception {
		request.getSession().invalidate();
		return "redirect:/";
	}
	

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(HttpServletRequest request) throws Exception {
		if(request.getSession().getAttribute("member")==null) return "redirect:/";
		return "mypage";
	}
	
	@RequestMapping(value = "/mypageSubmit", method = RequestMethod.POST)
	public void mypageSubmit(HttpServletRequest request, HttpServletResponse response, MultipartFile file) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String pw = request.getParameter("pw");
        String pwchk = request.getParameter("pwchk");
        
        if(!pw.equals(pwchk)) {
	        out.println("<script>alert('비밀번호가 일치하지 않습니다.');history.go(-1);</script>");
	        out.close();
        }
        
        MemberVO member = (MemberVO)(request.getSession().getAttribute("member"));
        member.setPw(pw);
        
        if(!file.getOriginalFilename().equals("")) {
    		UUID uuid = UUID.randomUUID();
        	String fileName = uuid.toString()+"_"+file.getOriginalFilename();
        	String realPath = request.getServletContext().getRealPath(uploadProfilePath);
        	
        	File target = new File(realPath, fileName);
        	if(!new File(realPath).exists()) new File(realPath).mkdirs();
        	
    		try {
    			FileCopyUtils.copy(file.getBytes(), target);
    		}catch(Exception e) {
    			e.printStackTrace();
    			System.out.println("업로드 오류 발생!");
    	        out.println("<script>alert('오류가 발생했습니다.');location.replace('/');</script>");
    	        out.close();
    		}
    		member.setProfile(fileName);		
        }
        
        service.updateProfile(member);
        request.getSession().setAttribute("member", member);
        out.println("<script>alert('내 정보 수정이 완료되었습니다.');location.replace('/');</script>");
        out.close();
	}
}
