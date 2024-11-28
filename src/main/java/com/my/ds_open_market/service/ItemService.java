package com.my.ds_open_market.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.ds_open_market.dao.ItemDao;
import com.my.ds_open_market.dao.UserDao;
import com.my.ds_open_market.entity.Item;
import com.my.ds_open_market.entity.User;

@Service
public class ItemService {

    @Autowired
    private ItemDao itemDao;

    public Item findByCode(String item_code){
        return itemDao.findByCode(item_code);
    }

    public int totalCount(){
        return itemDao.totalCount();
    }

    public List<Item> findAll(HashMap<String,Integer> map){
        return itemDao.findAll(map);
    }

    public int save(Item item) {
        return itemDao.save(item); 
    }
    

}
