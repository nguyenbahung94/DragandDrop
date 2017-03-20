package com.example.ntex_user.testoh.interacter;

import com.example.ntex_user.testoh.CommonResponse;
import com.example.ntex_user.testoh.model.User;
import com.example.ntex_user.testoh.model.Verify;

/**
 * Created by NTex-User on 3/13/2017.
 */

public interface InterLogin {
    interface OnLoginResponseListener {
        void onResponse(CommonResponse commonResponse);

        void onError(Throwable throwable);
    }
    void checkLogin(User user, OnLoginResponseListener onLoginResponseListener);
    void verifyCode(String token, Verify code, OnLoginResponseListener onLoginResponseListener);
    void getDataTask(String token,OnLoginResponseListener onLoginResponseListener);
}
