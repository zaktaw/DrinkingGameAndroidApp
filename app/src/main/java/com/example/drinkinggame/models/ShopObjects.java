package com.example.drinkinggame.models;

import java.util.ArrayList;

public class ShopObjects {
    public static ArrayList<ShopObject> shopObjects;

    public ShopObjects() {
        this.shopObjects = new ArrayList<ShopObject>();
    }

    public static void addShopObject(ShopObject shopObject) {
        shopObjects.add(shopObject);
    }

    public static ArrayList<ShopObject> getShopObjects() {
        return shopObjects;
    }
}
