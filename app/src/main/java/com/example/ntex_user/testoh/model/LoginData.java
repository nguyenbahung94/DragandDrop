package com.example.ntex_user.testoh.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by NTex-User on 3/13/2017.
 */

public class LoginData {
    @SerializedName("token")
    private String token;

    public LoginData(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
