package com.example.shopping.bean.login;

/**
 * 项目名：Shopping
 * 包名：  com.example.liangxq.shopping.bean
 * 文件名：UserBean
 * 创建者：liangxq
 * 创建时间：2020/8/27  17:02
 * 描述：TODO
 */
public class UserBean {
    /**
     * id : 208
     * userName : 2
     * userMobile : 2
     * pushId : 1a0018970a15f936c81
     */

    private int id;
    private String userName;
    private String userMobile;
    private String pushId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", pushId='" + pushId + '\'' +
                '}';
    }
}
