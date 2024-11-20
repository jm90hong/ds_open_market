package com.my.ds_open_market.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewController {

	
	@GetMapping("")
	public String home() {


		RandomStringUtils.randomAlphabetic(10);
		return "home";
	}


	@GetMapping("save-user")
	public String saveUser() {
		return "save-user";
	}
}
