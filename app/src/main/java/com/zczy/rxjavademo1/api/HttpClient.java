package com.zczy.rxjavademo1.api;

import android.util.Log;

import com.zczy.rxjavademo1.api.response.BaseResponse;
import com.zczy.rxjavademo1.api.response.GetIpInfoResponse;

import java.lang.reflect.Method;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mac on 16/4/1.
 */
public class HttpClient<T> {

    private static HttpClient ourInstance = new HttpClient();

    public static HttpClient getInstance() {
        return ourInstance;
    }

    private Retrofit mRetrofit;

    private ApiService mApiService;

    private Call mCall;

    private HttpClient() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApiService = mRetrofit.create(ApiService.class);
    }

    public static ApiService APS(){
        return ourInstance.mApiService;
    }


    public void GET(Call call, Callback<T> callBack){
        mCall = call;
        Log.e("HHH", mCall.request().toString());
        call.enqueue(callBack);
    }


    public void cancel(){
        mCall.cancel();
    }
}
