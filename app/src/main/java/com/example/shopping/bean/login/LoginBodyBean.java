package com.example.shopping.bean.login;

public class LoginBodyBean {
    //pushId
    private String mobile;
    private String pwd;
    private String pushId;

    public LoginBodyBean(String mobile, String pwd, String pushId) {
        this.mobile = mobile;
        this.pwd = pwd;
        this.pushId = pushId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
