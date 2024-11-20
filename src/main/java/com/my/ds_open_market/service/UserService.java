package com.my.ds_open_market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.ds_open_market.dao.UserDao;
import com.my.ds_open_market.entity.User;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public User getById(String id) {
        return userDao.getById(id);
    }

    public User getByNick(String nick) {
        return userDao.getByNick(nick);
    }

    public int save(User user) {
        return userDao.save(user); 
    }
    

}
