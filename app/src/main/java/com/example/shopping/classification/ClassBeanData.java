package com.example.shopping.classification;

public class ClassBeanData {
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
