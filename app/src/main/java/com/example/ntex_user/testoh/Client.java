package com.example.ntex_user.testoh;

import android.util.Log;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by NTex-User on 3/13/2017.
 */

public class Client {
    private static final String TAG="Client";
    private static Action1<Throwable> mOnError=throwable -> {
        Log.e(TAG, throwable.getMessage());
        throwable.printStackTrace();
    };
    public static <T>Subscription request(Observable<T> observable, Action1<? super T> onAction){
        return request(observable,onAction);
    }
    public static <T>Subscription request(Observable<T> observable,Action1<? super T> onAction,Action1<Throwable> onError){
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onAction,onError);
    }

}
