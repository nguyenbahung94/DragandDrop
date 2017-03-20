package com.example.ntex_user.testoh;


import com.example.ntex_user.testoh.model.User;
import com.example.ntex_user.testoh.model.Verify;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import rx.Observable;

/**
 * Created by NTex-User on 3/13/2017.
 */

public interface Service {
    @POST(Config.LOGIN)
    Observable<CommonResponse> login(@Body User user);
    @PUT(Config.VERIFY)
    Observable<CommonResponse> verify(@Header("token") String token,@Body Verify code);
    @GET(Config.TASK)
    Observable<CommonResponse> task(@Header("token") String token);
}
