package com.eghm.rxjava;

import io.reactivex.rxjava3.core.Maybe;

/**
 * 0-1个数据 要么成功要么失败 类似于Single和Completable的混合体
 * @author 殿小二
 * @date 2020/8/6
 */
public class MaybeSimple {
    public static void main(String[] args) {
        Maybe.just("A").subscribe(System.out::println).dispose();
    }
}
