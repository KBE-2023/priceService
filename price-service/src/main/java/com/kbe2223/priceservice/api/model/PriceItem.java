package com.kbe2223.priceservice.api.model;

public class PriceItem {

    public PriceItem(String name, String desc, double price) {
        this.name = name;
        this.desc = desc;
        this.price = price;
    }


    private String name;
    private String desc;
    private double price;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
