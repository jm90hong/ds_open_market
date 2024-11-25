package com.my.ds_open_market.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.ds_open_market.entity.Item;

@Repository 
public class ItemDao {

    @Autowired
    SqlSession s;

    public List<Item> findAll(){
        return s.selectList("ItemMapper.findAll");
    }

    public int save(Item item) {
        return s.insert("ItemMapper.save", item);
    }
}
