package com.example;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by mac on 16/4/1.
 */
public class Demo1_2 {
    public static void main(String[] args){
        Observable<String> 事件源 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("这是 事件源 发出的一个事件");
                subscriber.onCompleted();
            }
        });

//        事件源 = 事件源.map(new Func1<String, Integer>() {
//            @Override
//            public Integer call(String s) {
//                return s.hashCode();
//            }
//        })

        Subscriber<String> 订阅者 = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                //s:就是 事件源 发出的事件
                System.out.println(s);
            }
        };

        事件源.subscribe(订阅者);
    }
}
