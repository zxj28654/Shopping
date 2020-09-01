package com.example.shopping.bean.news;

/*

格言：你是怎样，你的世界就是怎样！
*/public class MsgInfoBean {

    /**
     * id : 1080
     * msgIcon : http://osea2fxp7.bkt.clouddn.com/108x108.png
     * msgTitle : 登录成功
     * msgContent : 恭喜您登录成功
     * msgTime : 2020-08-27 16:35
     * userId : 211
     */

    private int id;
    private String msgIcon;
    private String msgTitle;
    private String msgContent;
    private String msgTime;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsgIcon() {
        return msgIcon;
    }

    public void setMsgIcon(String msgIcon) {
        this.msgIcon = msgIcon;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
