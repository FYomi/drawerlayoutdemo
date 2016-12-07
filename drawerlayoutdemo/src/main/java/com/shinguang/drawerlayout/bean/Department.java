package com.shinguang.drawerlayout.bean;

/**
 * Created by amdin on 2016/12/6.
 */

public class Department {
    private String name;
    private Boolean isChoose;

    public Department(String name, Boolean isChoose) {
        this.name = name;
        this.isChoose = isChoose;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getChoose() {
        return isChoose;
    }

    public void setChoose(Boolean choose) {
        isChoose = choose;
    }
}
