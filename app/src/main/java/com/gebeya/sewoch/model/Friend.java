package com.gebeya.sewoch.model;

public class Friend {

    public int firendId;
    public String name;

    public Friend() {

        this.name="Addis Nega";

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

    public void setName(String name) {
        this.name = name;
    }

    public Friend(int firendId, String name) {
        this.firendId = firendId;
        this.name = name;
    }
}
