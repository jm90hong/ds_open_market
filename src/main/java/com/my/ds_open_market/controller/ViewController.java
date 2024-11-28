package com.my.ds_open_market.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.ds_open_market.entity.Item;
import com.my.ds_open_market.entity.ItemImg;
import com.my.ds_open_market.entity.User;
import com.my.ds_open_market.service.ItemImgService;
import com.my.ds_open_market.service.ItemService;

@Controller
public class ViewController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemImgService itemImgService;

	@GetMapping("detail-item")
	public String detailItem(
		@RequestParam("item_code") String itemCode,
		Model model
	) {
		

		Item item = itemService.findByCode(itemCode);
		List<ItemImg> itemImgs = itemImgService.findByItemIdx(item.getItem_idx());

		model.addAttribute("item",item);
		model.addAttribute("itemImgs",itemImgs);

		

		return "detail-item";
	}

	String getView(HttpSession session, String jspName){
		User me = (User)session.getAttribute("me");
		if(me==null){
			return "redirect:/login";
		}else{
			return jspName;	
		}
	}

	
	@GetMapping("")
	public String home(Model model) {

		// List<Item> items = itemService.findAll();
		// model.addAttribute("a",items);
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
