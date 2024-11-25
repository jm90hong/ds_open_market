package com.my.ds_open_market.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.ds_open_market.entity.Item;
import com.my.ds_open_market.entity.User;
import com.my.ds_open_market.service.ItemService;

@RestController
@RequestMapping("api/item")
public class ItemController {


    @Autowired
    ItemService itemService;


    @GetMapping("findAll")
    public List<Item> findAll(){
        return itemService.findAll();
    }   

    @PostMapping("create")
    public String create(
            HttpSession session,
            @RequestParam(value="name") String name,
            @RequestParam(value="content") String content,
            @RequestParam(value="item_img_url") String item_img_url,
            @RequestParam(value="price") int price,
            @RequestParam(value="discount_rate") double discount_rate
        
        ){
        User me = (User) session.getAttribute("me");
        if(me==null){
            return "not-login";
        }
        int user_idx = me.getUser_idx();
        String itemCode = RandomStringUtils.randomAlphanumeric(10);
        double m_rate = 0.01;


        Item item = new Item();
        item.setItem_code(itemCode);
        item.setUser_idx(user_idx);
        item.setName(name);
        item.setContent(content);
        item.setItem_img_url(item_img_url);
        item.setPrice(price);
        item.setDiscount_rate(discount_rate);
        item.setM_rate(m_rate);

        itemService.save(item);
      

        return "ok";
    }
}
