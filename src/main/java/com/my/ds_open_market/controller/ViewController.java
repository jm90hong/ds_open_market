package com.my.ds_open_market.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.ds_open_market.entity.User;

@Controller
public class ViewController {


	String getView(HttpSession session, String jspName){
		User me = (User)session.getAttribute("me");
		if(me==null){
			return "redirect:/login";
		}else{
			return jspName;	
		}
	}

	
	@GetMapping("")
	public String home() {
		return "home";
	}


	@GetMapping("save-user")
	public String saveUser() {
		return "save-user";
	}

	@GetMapping("save-item")
	public String saveItem(HttpSession session) {
		
		return getView(session,"save-item");
	}


	@GetMapping("login")
	public String login() {
		return "login";
	}
}
