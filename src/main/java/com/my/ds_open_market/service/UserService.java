package com.my.ds_open_market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.ds_open_market.dao.UserDao;
import com.my.ds_open_market.entity.User;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAll(){
        return userDao.findAll();
    }

    public User getByIdAndPw(User user) {
        return userDao.getByIdAndPw(user);
    }

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
