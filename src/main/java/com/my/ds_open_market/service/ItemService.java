package com.my.ds_open_market.service;

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

    public int save(Item item) {
        return itemDao.save(item); 
    }
    

}
