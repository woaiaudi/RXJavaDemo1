package com.zczy.rxjavademo1.api.model;

/**
 * Created by mac on 16/4/1.
 */
public class IpInfo {
    public String country;
    public String country_id;
    public String area;
    public String area_id;
    public String ip;


    @Override
    public String toString() {
        return "IpInfo{" +
                "country='" + country + '\'' +
                ", country_id='" + country_id + '\'' +
                ", area='" + area + '\'' +
                ", area_id='" + area_id + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
