package com.shinguang.drawerlayout.bean;

/**
 * Created by amdin on 2016/12/6.
 */

public class Staff {
    private String name;
    private String job;
    private String state;

    public Staff(String name, String job, String state) {
        this.name = name;
        this.job = job;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
