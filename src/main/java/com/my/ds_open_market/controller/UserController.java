package com.my.ds_open_market.controller;

import org.springframework.web.bind.annotation.RestController;

import com.my.ds_open_market.entity.User;
import com.my.ds_open_market.service.UserService;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/user")
public class UserController {



    @Autowired
    private UserService userService;
    

    @GetMapping("findAll")
    public List<User> findAll(){
        return userService.findAll();
    }   

    @PostMapping("logout")
    public String logout(HttpSession session) {
        
        
        session.invalidate();
        return "ok";
    }



    @GetMapping("login")
    public User login(
        @RequestParam(value="id", required=true) String id,
        @RequestParam(value="pw", required=true) String pw,
        HttpSession session
    ){

        
        User user = new User();
        user.setId(id);
        user.setPw(pw);

        User result = userService.getByIdAndPw(user);
        if(result!=null){
            session.setAttribute("me", result);
        }

        return result;
    }

    @GetMapping("getById")
    public User getById(@RequestParam String id) {
        return userService.getById(id);
    }

    @GetMapping("getByNick") 
    public User getByNick(@RequestParam String nick) {
        return userService.getByNick(nick);
    }

    @PostMapping("create")
    public String create(
            @RequestParam(value="id", required=true) String id,
            @RequestParam(value="img_url", required=true) String img_url,
            @RequestParam(value="pw", required=true) String pw,
            @RequestParam(value="nick", required=true) String nick, 
            @RequestParam(value="address", required=true) String address
        ) {
            
        
        String user_code = RandomStringUtils.randomAlphabetic(10);

        User user = new User();
        user.setId(id);
        user.setPw(pw);
        user.setNick(nick);
        user.setAddress(address);
        user.setM_point(0);
        user.setUser_code(user_code);
        user.setImg_url(img_url);
        

        userService.save(user);
        return "ok";
    }
    


}
