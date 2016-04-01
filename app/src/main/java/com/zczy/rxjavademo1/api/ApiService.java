package com.zczy.rxjavademo1.api;

import com.zczy.rxjavademo1.api.response.GetIpInfoResponse;
import com.zczy.rxjavademo1.api.response.GetVersionResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mac on 16/4/1.
 */
public interface ApiService{

    //http://ip.taobao.com/service/getIpInfo.php?ip=21.22.11.33
//    public static final String ENDPOINT = "http://ip.taobao.com";
    public static final String ENDPOINT = "http://www.zczy56.com:3356";


    @GET("service/getIpInfo.php")
    Call<GetIpInfoResponse> getIpInfo(@Query("ip") String ip,@Query("PARM2") String sss);

    @GET("app/revision/queryRevision.xhtml")
    Call<GetVersionResponse> queryRevision();
}
