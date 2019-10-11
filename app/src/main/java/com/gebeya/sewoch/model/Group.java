package com.gebeya.sewoch.model;

public class Group {

    private String name;
    private String detail;

    public Group() {
    }

    public Group(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public String getName() {
        return name;
    }

    public Group setName(String name) {
        this.name = name;
        return this;
    }

    public Group setDetail(String detail) {
        this.detail = detail;
        return this;
    }
}
