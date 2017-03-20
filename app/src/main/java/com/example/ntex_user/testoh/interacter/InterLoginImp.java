package com.example.ntex_user.testoh.interacter;

import com.example.ntex_user.testoh.Client;
import com.example.ntex_user.testoh.Rest;
import com.example.ntex_user.testoh.model.User;
import com.example.ntex_user.testoh.model.Verify;

/**
 * Created by NTex-User on 3/13/2017.
 */

public class InterLoginImp implements InterLogin {
    @Override
    public void checkLogin(User user, OnLoginResponseListener listener) {
        Client.request(Rest.buid().login(user),listener::onResponse,listener::onError);
    }

    @Override
    public void verifyCode(String token, Verify code, OnLoginResponseListener listener) {
        Client.request(Rest.buid().verify(token,code),listener::onResponse,listener::onError);
    }

    @Override
    public void getDataTask(String token, OnLoginResponseListener listener) {
        Client.request(Rest.buid().task(token),listener::onResponse,listener::onError);
    }
}
