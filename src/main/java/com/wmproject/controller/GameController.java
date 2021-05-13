package com.wmproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/mapia")
public class GameController {
	@RequestMapping(value = "/lobby", method = RequestMethod.GET)
    public String lobby() throws Exception{
		return "/mapia/lobby";
	}
}