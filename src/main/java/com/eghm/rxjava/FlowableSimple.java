package com.eghm.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.*;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * 0-N个数据支持背压
 * @author 殿小二
 * @date 2020/8/6
 */
public class FlowableSimple {
    public static void main(String[] args) {
        range();
        System.out.println("=============================");
        strategy();
    }

    public static void strategy() {
        Flowable.create((FlowableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onNext(4);
            emitter.onNext(5);
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER).subscribe(System.out::println).dispose();
    }

    public static void range() {
        Flowable.range(0, 10).subscribe(new Subscriber<Integer>() {

            Subscription subscription;
            @Override
            public void onSubscribe(@NonNull Subscription s) {
                subscription = s;
                subscription.request(1);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("start: " + integer);
                subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("End");
            }
        });
    }

    public static void create () {
        Flowable.just("A", "B", "C").subscribe(System.out::println).dispose();
    }
}
