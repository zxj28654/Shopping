package com.example.shopping.bean.login;

public class CreateBadyBean {
   // mobile":"1553439217","pwd":"28654","verifyCode":"123456"
    private String mobile;
    private String pwd;
    private String verifyCode;

    public CreateBadyBean(String mobile, String pwd, String verifyCode) {
        this.mobile = mobile;
        this.pwd = pwd;
        this.verifyCode = verifyCode;
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

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
