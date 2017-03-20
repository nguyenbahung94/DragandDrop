package com.example.ntex_user.testoh.presenter;

import com.example.ntex_user.testoh.model.User;
import com.example.ntex_user.testoh.model.Verify;

/**
 * Created by NTex-User on 3/13/2017.
 */

public interface PrLogin {
    void checkLogin(User user);
    void verifyCode(String token,Verify code);
    void getTask(String token);
}
