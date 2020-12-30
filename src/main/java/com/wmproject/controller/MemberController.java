package com.wmproject.controller;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wmproject.domain.MemberVO;
import com.wmproject.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {

	@Inject
    private MemberService service;
	
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
	public String signup(MemberVO vo,HttpServletRequest request, HttpServletResponse response) throws Exception {
		int result = service.checkID(vo);
		if(result==1) return "redirect:/";
		result = service.checkNickname(vo);
		if(result==1) return "redirect:/";
		System.out.println(vo.toString());
		service.signUp(vo);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('회원가입이 완료되었습니다.');location.replace('/');</script>");
        out.close();
		return null;
	}
}
