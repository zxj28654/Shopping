package com.example.shopping.bean;

import com.google.gson.JsonElement;

import java.util.List;

public class EegeddBean {

    /**
     * success : true
     * data : {"id":8,"name":"巴塔木圣诞歌","image_url":"http://img5g22.ergedd.com/album/8_20170414114412_sdg3.jpg","image_gif":"","image_ver":"","ext":null,"description":"经典圣诞歌曲","status":2,"video_count":0,"play_count":323465,"icon_url":"http://img5g22.ergedd.com/album/8_20170414114412_igue.jpg","icon_gif":"","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"watch_areas":["1"],"erge_img_url":"","free":5,"cost":0,"price":0,"expires_at":null,"vip_price":0,"publisher_name":"捷成华视-巴塔木"}
     * message : Get album successfully
     */

    private boolean success;
    private JsonElement data;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
