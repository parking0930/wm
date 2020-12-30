package com.wmproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignUpController {
	
	private static final Logger logger = LoggerFactory.getLogger(SignUpController.class);
	
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUpAgree() {
		logger.info("signUp");
		return "signUp";
	}
}
