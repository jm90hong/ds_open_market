package com.my.ds_open_market.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.ds_open_market.entity.ItemImg;

@Repository
public class ItemImgDao {


    @Autowired
    private SqlSession s;


    public List<ItemImg> findByItemIdx(Integer item_idx){
        return s.selectList("ItemImgMapper.findByItemIdx",item_idx);
    }


    public int save(ItemImg itemImg){
        return s.insert("ItemImgMapper.save", itemImg);
    }

    
}
