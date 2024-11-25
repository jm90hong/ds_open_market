package com.my.ds_open_market.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewController {

	
	@GetMapping("")
	public String home() {
		return "home";
	}


	@GetMapping("save-user")
	public String saveUser() {
		return "save-user";
	}

	@GetMapping("save-item")
	public String saveItem() {
		return "save-item";
	}


	@GetMapping("login")
	public String login() {
		return "login";
	}
}
