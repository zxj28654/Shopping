package com.example.shopping.classification;

import java.io.Serializable;
import java.util.List;

public class Beann implements Serializable{

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * id : 14
         * categoryName : Apple
         * categoryIcon : https://img13.360buyimg.com/n7/jfs/t2590/338/4222589387/237425/25e40fb/57b12ac6N61374a75.jpg
         * parentId : 1
         */

        private int id;
        private String categoryName;
        private String categoryIcon;
        private int parentId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCategoryIcon() {
            return categoryIcon;
        }

        public void setCategoryIcon(String categoryIcon) {
            this.categoryIcon = categoryIcon;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", categoryName='" + categoryName + '\'' +
                    ", categoryIcon='" + categoryIcon + '\'' +
                    ", parentId=" + parentId +
                    '}';
        }
    }


}
