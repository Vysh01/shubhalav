package com.example.shubhalav.model;

import android.graphics.Bitmap;

public class SurveyDetail {

    private String shop_id;
    private String user_id;
    private String ctd_box;
    private String clean_ctd;
    private String visibiity;
    private Bitmap image1;
    private Bitmap image2;

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCtd_box() {
        return ctd_box;
    }

    public void setCtd_box(String ctd_box) {
        this.ctd_box = ctd_box;
    }

    public String getClean_ctd() {
        return clean_ctd;
    }

    public void setClean_ctd(String clean_ctd) {
        this.clean_ctd = clean_ctd;
    }

    public String getVisibiity() {
        return visibiity;
    }

    public void setVisibiity(String visibiity) {
        this.visibiity = visibiity;
    }

    public Bitmap getImage1() {
        return image1;
    }

    public void setImage1(Bitmap image1) {
        this.image1 = image1;
    }

    public Bitmap getImage2() {
        return image2;
    }

    public void setImage2(Bitmap image2) {
        this.image2 = image2;
    }
}
