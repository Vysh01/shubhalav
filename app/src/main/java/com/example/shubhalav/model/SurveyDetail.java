package com.example.shubhalav.model;

import android.graphics.Bitmap;

public class SurveyDetail {

    private String tme_code_id;
    private String user_id;
    private String ctd_box;
    private String clean_ctd;
    private String visibiity;
    private Bitmap image;
    private Bitmap image2;
    private String verification;
    private  String status ;

    public String getTme_code_id() {
        return tme_code_id;
    }

    public void setTme_code_id(String tme_code_id) {
        this.tme_code_id = tme_code_id;
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

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Bitmap getImage2() {
        return image2;
    }

    public void setImage2(Bitmap image2) {
        this.image2 = image2;
    }

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
