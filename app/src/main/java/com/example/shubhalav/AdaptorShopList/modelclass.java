package com.example.shubhalav.AdaptorShopList;

public class modelclass {

private String no ;
    private String title ;
    private String body ;

    public modelclass(String no, String title, String body) {
        this.no = no;
        this.title = title;
        this.body = body;
    }

    public String getNo() {
        return no;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
