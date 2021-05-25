package com.eghm.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * 0-N个数据 不支持背压
 * @author 殿小二
 * @date 2020/8/5
 */
public class ObservableSimple {

    public static void main(String[] args) {
        // create();
        send();
    }

    private static void send() {
        Observable.create((ObservableOnSubscribe<String>) emitter -> {
            emitter.onNext("A");
            System.out.println("A send");
            emitter.onNext("B");
            emitter.onComplete();
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("subscribe: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("End");
            }
        });
    }

    private static void create() {
        Observable.just("A", "B", "A", "A", "B").subscribe(System.out::println).dispose();
        Observable.fromArray("A", "C", "B").subscribe(System.out::println).dispose();
    }
}
