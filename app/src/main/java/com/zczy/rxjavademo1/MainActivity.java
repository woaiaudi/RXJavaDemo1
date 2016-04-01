package com.zczy.rxjavademo1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zczy.rxjavademo1.api.ApiService;
import com.zczy.rxjavademo1.api.HttpClient;
import com.zczy.rxjavademo1.api.response.GetIpInfoResponse;
import com.zczy.rxjavademo1.api.response.GetVersionResponse;

import java.io.IOException;
import java.lang.reflect.Method;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {


    private Button demo1_main_button;

    private Button demo1_main_button_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        demo1_main_button = (Button) findViewById(R.id.demo1_main_button);
        demo1_main_button.setOnClickListener(clickListener);

        demo1_main_button_2 = (Button) findViewById(R.id.demo1_main_button_2);
        demo1_main_button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //doRetroFit();

                //GET 泛型
                HttpClient.getInstance().GET(HttpClient.APS().queryRevision(), new Callback<GetVersionResponse>() {
                    @Override
                    public void onResponse(Call<GetVersionResponse> call, Response<GetVersionResponse> response) {
                        GetVersionResponse mGetVersionResponse = response.body();
                        Log.e("HHHVVVVV", mGetVersionResponse.toString());
                    }

                    @Override
                    public void onFailure(Call<GetVersionResponse> call, Throwable t) {

                    }
                });
            }
        });


    }


    private View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            HttpClient<GetIpInfoResponse> xxx = HttpClient.getInstance();
            xxx.GET(HttpClient.APS().getIpInfo("12.2.3.4", "sdsdsd"), new Callback<GetIpInfoResponse>() {
                @Override
                public void onResponse(Call<GetIpInfoResponse> call, Response<GetIpInfoResponse> response) {
                    GetIpInfoResponse getIpInfoResponse = response.body();
                    Log.e("HHH", getIpInfoResponse.data.toString());
                }

                @Override
                public void onFailure(Call<GetIpInfoResponse> call, Throwable t) {
                    Log.e("HHH_e_1", t.getLocalizedMessage());
                }
            });
            xxx.cancel();
        }
    };


    private void doRetroFit() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService mApiService = mRetrofit.create(ApiService.class);
        Call<GetIpInfoResponse> call = mApiService.getIpInfo("12.2.3.4", "www");
        call.enqueue(new Callback<GetIpInfoResponse>() {
            @Override
            public void onResponse(Call<GetIpInfoResponse> call, Response<GetIpInfoResponse> response) {
                GetIpInfoResponse getIpInfoResponse = response.body();
                Log.e("HHH333", getIpInfoResponse.data.toString());
            }

            @Override
            public void onFailure(Call<GetIpInfoResponse> call, Throwable t) {
                Log.e("HHH_e_2", t.getLocalizedMessage());
            }
        });
    }
}
