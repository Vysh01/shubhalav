package com.example.shubhalav.model;

import java.util.ArrayList;

public class ShopListResponse {
    boolean error;
    ArrayList<ShopModel> shopList;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ArrayList<ShopModel> getShopList() {
        return shopList;
    }

    public void setShopList(ArrayList<ShopModel> shopList) {
        this.shopList = shopList;
    }
}
