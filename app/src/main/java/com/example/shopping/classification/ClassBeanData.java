package com.example.shopping.classification;

import java.util.ArrayList;
import java.util.List;

public class ClassBeanData {
    private List<Datas> data;

    public List<Datas> getList() {
        return data;
    }

    public void setList(List<Datas> list) {
        data = list;
    }

    private class Datas {
        private int id;
        private String categoryName;
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

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        @Override
        public String toString() {
            return "ClassBeanData{" +
                    "id=" + id +
                    ", categoryName='" + categoryName + '\'' +
                    ", parentId=" + parentId +
                    '}';
        }
    }
}
