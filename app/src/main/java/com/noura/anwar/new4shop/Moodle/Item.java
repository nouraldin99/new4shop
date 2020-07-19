package com.noura.anwar.new4shop.Moodle;

public class Item {

    private String name, category;
    private int price;
    private int image;
    public Item(){

    }

    public Item(String name, int price, int image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public Item(String name, String category, int price, int image) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
