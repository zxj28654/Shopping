package com.example.shopping.bean.login;

import com.google.gson.JsonElement;

public class LoginBean {


    /**
     * status : 0
     * message : 登录成功
     * data : {"id":9,"userName":"1553439217","userMobile":"15534392170","userIcon":"","userGender":"0","userSign":"","pushId":"12345"}
     */

    private int status;
    private String message;
    private JsonElement data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }


}
