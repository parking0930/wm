package com.wmproject.controller;

import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {
    
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
    
}