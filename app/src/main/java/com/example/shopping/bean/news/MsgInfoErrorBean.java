package com.example.shopping.bean.news;

/*

格言：你是怎样，你的世界就是怎样！
*/public class MsgInfoErrorBean {

    /**
     * status : 0
     * message : 列表为空
     */

    private int status;
    private String message;

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
}
