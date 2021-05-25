package com.eghm.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * 不发送任何数据 只处理onComplete onError
 * @author 殿小二
 * @date 2020/8/6
 */
public class CompletableSimple {
    public static void main(String[] args) {
        create();
    }

    public static void create() {
        Completable.create(CompletableEmitter::onComplete).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onComplete() {
                System.out.println(" End ");
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });
    }
}
