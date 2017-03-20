package com.example.ntex_user.testoh;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by NTex-User on 3/13/2017.
 */

public class Rest {
    public static final String BASE_URL="http://ooh-api.ntex.vn/";
    public static Service buid(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }
}
