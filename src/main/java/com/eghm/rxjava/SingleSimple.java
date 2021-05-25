package com.eghm.rxjava;

import io.reactivex.rxjava3.core.Single;

/**
 * 一个数据或错误
 * @author 殿小二
 * @date 2020/8/6
 */
public class SingleSimple {
    public static void main(String[] args) {
        Single.just("A").subscribe(System.out::println).dispose();
    }
}
