package com.example.ntex_user.testoh.presenter;

import android.util.Log;

import com.example.ntex_user.testoh.CommonResponse;
import com.example.ntex_user.testoh.interacter.InterLogin;
import com.example.ntex_user.testoh.interacter.InterLoginImp;
import com.example.ntex_user.testoh.model.LoginData;
import com.example.ntex_user.testoh.model.OneObject;
import com.example.ntex_user.testoh.model.User;
import com.example.ntex_user.testoh.model.Verify;
import com.example.ntex_user.testoh.view.ViewLogin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NTex-User on 3/13/2017.
 */

public class PrLoginImp implements PrLogin {
    private ViewLogin viewLogin;
    private InterLoginImp interLoginImp;
    private List<OneObject> listObject;

    public PrLoginImp(ViewLogin viewLogin) {
        this.viewLogin = viewLogin;
        interLoginImp = new InterLoginImp();
    }

    @Override
    public void checkLogin(User user) {
        interLoginImp.checkLogin(user, new InterLogin.OnLoginResponseListener() {
            @Override
            public void onResponse(CommonResponse commonResponse) {

                Log.e("Tag-data", commonResponse.getData());
                Log.e("Tag-startus", String.valueOf(commonResponse.getStatus()));
                LoginData token = commonResponse.parseData(LoginData.class);
                Log.e("hung-TAG-token", token.getToken());
                viewLogin.succes(token.getToken());
            }

            @Override
            public void onError(Throwable throwable) {
                Log.d("Hung-Throwble", throwable.getMessage());
                throwable.printStackTrace();
                viewLogin.failed();
            }
        });
    }

    @Override
    public void verifyCode(String token, Verify code) {
        interLoginImp.verifyCode(token, code, new InterLogin.OnLoginResponseListener() {
            @Override
            public void onResponse(CommonResponse commonResponse) {
                Log.e("Tag-", commonResponse.getData());
                Log.e("Tag-", String.valueOf(commonResponse.getStatus()));
            }

            @Override
            public void onError(Throwable throwable) {
                Log.d("Hung-Throwble", throwable.getMessage());
                throwable.printStackTrace();

            }
        });
    }

    @Override
    public void getTask(String token) {
        interLoginImp.getDataTask(token, new InterLogin.OnLoginResponseListener() {
            @Override
            public void onResponse(CommonResponse response) {
                listObject=new ArrayList<OneObject>();
                OneObject[] oneObject = response.parseJsonTree(OneObject[].class);
                for (OneObject s1:oneObject){
                    OneObject object=s1;
                   if(object.getType()==4){
                       listObject.add(s1);
                   }
                }
                viewLogin.succsesTask(listObject);


            }

            @Override
            public void onError(Throwable throwable) {
                Log.d("Hung-Throwble", throwable.getMessage());
                throwable.printStackTrace();
            }
        });
    }

}
