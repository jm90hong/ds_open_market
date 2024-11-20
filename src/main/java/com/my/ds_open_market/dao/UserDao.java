package com.my.ds_open_market.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.ds_open_market.entity.User;

@Repository
public class UserDao {

    @Autowired
    SqlSession sqlSession;


    public User getById(String id) {
        return sqlSession.selectOne("UserMapper.getById", id);
    }

    public User getByNick(String nick) {
        return sqlSession.selectOne("UserMapper.getByNick", nick); 
    }

    public int save(User user) {
        return sqlSession.insert("UserMapper.save", user);
    }
}
