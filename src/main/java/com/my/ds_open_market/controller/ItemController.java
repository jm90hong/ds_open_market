package com.my.ds_open_market.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.ds_open_market.entity.Item;
import com.my.ds_open_market.entity.ItemImg;
import com.my.ds_open_market.entity.User;
import com.my.ds_open_market.service.ItemImgService;
import com.my.ds_open_market.service.ItemService;

@RestController
@RequestMapping("api/item")
public class ItemController {


    @Autowired
    ItemService itemService;

    @Autowired
    ItemImgService itemImgService;


    @GetMapping("totalCount")
    public int totalCount(){
        return itemService.totalCount();
    }

    @GetMapping("findAll")
    public List<Item> findAll(
    		    @RequestParam(value="start") int start,
    		    @RequestParam(value="count") int count
    		){

        HashMap<String,Integer> map = new HashMap<>();
        map.put("start",start);
        map.put("count",count);
        
        return itemService.findAll(map);
    }   


    @PostMapping("imgs")
    public String imgs(
            @RequestParam(value="detail_img_urls[]") List<String> detail_img_urls
    ){
        for(int i=0;i<detail_img_urls.size();i++){
            String url = detail_img_urls.get(i);
            System.out.println(url);
        }
        return "ok";
    }


    @PostMapping("create")
    public String create(
            HttpSession session,
            @RequestParam(value="name") String name,
            @RequestParam(value="content") String content,
            @RequestParam(value="item_img_url") String item_img_url,
            @RequestParam(value="detail_img_urls[]") List<String> detail_img_urls,
            @RequestParam(value="price") int price,
            @RequestParam(value="discount_rate") double discount_rate
        
        ){



        User me = (User) session.getAttribute("me");
        if(me==null){
            return "not-login";
        }
        int user_idx = me.getUser_idx();
        String itemCode = RandomStringUtils.randomAlphanumeric(10);
        double m_rate = 0.01;


        Item item = new Item();
        item.setItem_code(itemCode);
        item.setUser_idx(user_idx);
        item.setName(name);
        item.setContent(content);
        item.setItem_img_url(item_img_url);
        item.setPrice(price);
        item.setDiscount_rate(discount_rate);
        item.setM_rate(m_rate);

        itemService.save(item);

        //자동 증가된  item_idx 가져오기
        int new_item_idx = item.getItem_idx();

        detail_img_urls.add(0,item_img_url);

        //상세 이미지 저장
        for(int i=0;i<detail_img_urls.size();i++){
            String url = detail_img_urls.get(i);

            ItemImg itemImg = new ItemImg();
            itemImg.setItem_idx(new_item_idx);
            itemImg.setItem_img_url(url);
            
            itemImgService.save(itemImg);
        }
      

        return "ok";
    }












    @PostMapping("createAll")
    public String createAll(
            HttpSession session,
            @RequestParam(value="name") String name,
            @RequestParam(value="content") String content,
            @RequestParam(value="item_img_url") String item_img_url,
            @RequestParam(value="detail_img_urls[]") List<String> detail_img_urls,
            @RequestParam(value="price") int price,
            @RequestParam(value="discount_rate") double discount_rate
        
        ){



        for(int j=0;j<300;j++){


            User me = (User) session.getAttribute("me");
            if(me==null){
                return "not-login";
            }
            int user_idx = me.getUser_idx();
            String itemCode = RandomStringUtils.randomAlphanumeric(10);
            double m_rate = 0.01;


            Item item = new Item();
            item.setItem_code(itemCode);
            item.setUser_idx(user_idx);
            item.setName(name+j);
            item.setContent(content);
            item.setItem_img_url(item_img_url);
            item.setPrice(price);
            item.setDiscount_rate(discount_rate);
            item.setM_rate(m_rate);

            itemService.save(item);

            //자동 증가된  item_idx 가져오기
            int new_item_idx = item.getItem_idx();

            detail_img_urls.add(0,item_img_url);

            //상세 이미지 저장
            for(int i=0;i<detail_img_urls.size();i++){
                String url = detail_img_urls.get(i);

                ItemImg itemImg = new ItemImg();
                itemImg.setItem_idx(new_item_idx);
                itemImg.setItem_img_url(url);
                
                itemImgService.save(itemImg);

                
            }
            






        }
        
      

        return "ok";
    }





}
