package com.my.ds_open_market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewController {

	
	@GetMapping("")
	//@ResponseBody
	public String home() {
		return "home";
	}
}
