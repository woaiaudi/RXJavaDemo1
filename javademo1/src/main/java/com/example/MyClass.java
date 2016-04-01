package com.example;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class MyClass {

    public static void main(String[] args){
        Observable<Object> 事件源 = Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                // 学号,姓名,性别,年级,班级
                subscriber.onNext(new String[]{"201","李建明","1","5","-6"});
            }
            //            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("这是 事件源 发出的一个事件");
//                subscriber.onCompleted();
//            }
        });

        //将 事件源 发出的 时间,在map中 转换下,发送给订阅者
        事件源 = 事件源.map(new Func1<Object, StudentModel>() {
            @Override
            public StudentModel call(Object arrObject) {
                String[] strings = (String[])arrObject;
                StudentModel returnModel = new StudentModel();
                try {
                    returnModel.setStuId(Long.parseLong(strings[0]));
                    returnModel.setStuName(strings[1]);
                    returnModel.setSex("1".equals(strings[2]) ? "男" : "女");
                    returnModel.setGrand(Long.parseLong(strings[3]));
                    returnModel.setClassmate(strings[4]);
                }catch (Exception e){
                }

                return returnModel;
            }
        });

        Subscriber<Object> 订阅者 = new Subscriber<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object s) {
                //s:就是 事件源 发出的事件
                StudentModel tmpModel = (StudentModel)s;
                System.out.println(tmpModel.toString());
            }
        };

        事件源.subscribe(订阅者);


     }
}
