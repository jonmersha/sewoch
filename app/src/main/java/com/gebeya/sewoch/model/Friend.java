package com.gebeya.sewoch.model;

public class Friend {

    public int firendId;
    public String name;

    public Friend() {



    }

    public int getFirendId() {
        return firendId;
    }

    public void setFirendId(int firendId) {
        this.firendId = firendId;
    }

    public String getName() {
        return name;
    }

    public Friend setName(String name) {

        this.name = name;
        return this;
    }

    public Friend(int firendId, String name) {
        this.firendId = firendId;
        this.name = name;
    }
}
