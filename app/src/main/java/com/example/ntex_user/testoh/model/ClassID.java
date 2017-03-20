package com.example.ntex_user.testoh.model;

/**
 * Created by NTex-User on 3/15/2017.
 */

public class ClassID {
    private int id;
    private String path;

    public ClassID(int id, String path) {
        this.id = id;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
