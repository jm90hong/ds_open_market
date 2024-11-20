package com.my.ds_open_market.controller;

import org.springframework.web.bind.annotation.RestController;

import com.my.ds_open_market.entity.User;
import com.my.ds_open_market.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/user")
public class UserController {



    @Autowired
    private UserService userService;
    

    @GetMapping("getById")
    public User getById(@RequestParam String id) {
        return userService.getById(id);
    }

    @GetMapping("getByNick") 
    public User getByNick(@RequestParam String nick) {
        return userService.getByNick(nick);
    }

    @GetMapping("create")
    public String create(
            @RequestParam(value="id", required=true) String id,
            @RequestParam(value="pw", required=true) String pw,
            @RequestParam(value="nick", required=true) String nick, 
            @RequestParam(value="address", required=true) String address
        ) {
            
        User user = new User();
        user.setId(id);
        user.setPw(pw);
        user.setNick(nick);
        user.setAddress(address);
        user.setM_point(0);
        

        userService.save(user);
        return "ok";
    }
    


}
