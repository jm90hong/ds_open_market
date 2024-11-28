package com.my.ds_open_market.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.ds_open_market.entity.Item;

@Repository 
public class ItemDao {

    @Autowired
    SqlSession s;
    

    public Item findByCode(String item_code){
        return s.selectOne("ItemMapper.findByCode",item_code);
    }

    public int totalCount(){
        return s.selectOne("ItemMapper.totalCount");
    }

    public List<Item> findAll(HashMap<String,Integer> map){
        return s.selectList("ItemMapper.findAll",map);
    }

    public int save(Item item) {
        return s.insert("ItemMapper.save", item);
    }
}
