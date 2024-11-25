package com.my.ds_open_market.entity;

public class Item {


    private int item_idx=0;
    private String item_code = null;
    private int user_idx = 0;
    private String name = null;
    private String content = null;
    private String item_img_url = null;
    private int price = 0;
    private double discount_rate = 0;
    private double m_rate = 0;
    private String created_date = null;

    
    public int getItem_idx() {
        return item_idx;
    }
    public void setItem_idx(int item_idx) {
        this.item_idx = item_idx;
    }
    public String getItem_code() {
        return item_code;
    }
    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }
    public int getUser_idx() {
        return user_idx;
    }
    public void setUser_idx(int user_idx) {
        this.user_idx = user_idx;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getItem_img_url() {
        return item_img_url;
    }
    public void setItem_img_url(String item_img_url) {
        this.item_img_url = item_img_url;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public double getDiscount_rate() {
        return discount_rate;
    }
    public void setDiscount_rate(double discount_rate) {
        this.discount_rate = discount_rate;
    }
    public double getM_rate() {
        return m_rate;
    }
    public void setM_rate(double m_rate) {
        this.m_rate = m_rate;
    }
    public String getCreated_date() {
        return created_date;
    }
    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }
    
    
}
