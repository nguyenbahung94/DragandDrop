package com.example.ntex_user.testoh.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by NTex-User on 3/13/2017.
 */

public class User {
    @SerializedName("username")
    private String nameUser;
    @SerializedName("password")
    private String passWord;

    public User(String nameUser, String passWord) {
        this.nameUser = nameUser;
        this.passWord = passWord;
    }
}
