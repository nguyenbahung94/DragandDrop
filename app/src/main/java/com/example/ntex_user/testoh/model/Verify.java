package com.example.ntex_user.testoh.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by NTex-User on 3/13/2017.
 */

public class Verify {
    @SerializedName("verifyCode")
    private String code;

    public Verify(String code) {
        this.code = code;
    }
}
