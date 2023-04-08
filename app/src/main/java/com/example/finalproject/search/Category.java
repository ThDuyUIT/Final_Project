package com.example.finalproject.search;

import java.util.List;

public class Category {
    private String nameCategory;
    private List<ChuyenXe> chuyenXeList;

    public Category(String nameCategory, List<ChuyenXe> chuyenXeList) {
        this.nameCategory = nameCategory;
        this.chuyenXeList = chuyenXeList;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<ChuyenXe> getChuyenXeList() {
        return chuyenXeList;
    }

    public void setChuyenXeList(List<ChuyenXe> chuyenXeList) {
        this.chuyenXeList = chuyenXeList;
    }
}
