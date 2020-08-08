package com.example.shopping.classification;

import com.google.gson.JsonElement;

import java.util.List;

public class GoodsClassBeanParent {

    /**
     * status : 0
     * message : 分类列表获取成功
     * data : [{"id":1,"categoryName":"电脑办公","parentId":0},{"id":2,"categoryName":"手机数码","parentId":0},{"id":3,"categoryName":"男装","parentId":0},{"id":4,"categoryName":"女装","parentId":0},{"id":5,"categoryName":"家用电器","parentId":0},{"id":6,"categoryName":"食品生鲜","parentId":0},{"id":7,"categoryName":"酒水饮料","parentId":0},{"id":8,"categoryName":"玩具乐器","parentId":0},{"id":9,"categoryName":"汽车用品","parentId":0},{"id":10,"categoryName":"家具家装","parentId":0},{"id":11,"categoryName":"礼品鲜花","parentId":0},{"id":12,"categoryName":"生活旅行","parentId":0},{"id":13,"categoryName":"二手商品","parentId":0}]
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
