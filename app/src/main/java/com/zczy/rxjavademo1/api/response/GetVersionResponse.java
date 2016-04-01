package com.zczy.rxjavademo1.api.response;

/**
 * Created by mac on 16/4/1.
 */
public class GetVersionResponse extends BaseResponse{
    private String versionPath;
    private String versionNum;

    @Override
    public String toString() {
        return "GetVersionResponse{" +
                "versionPath='" + versionPath + '\'' +
                ", versionNum='" + versionNum + '\'' +
                '}';
    }
}
