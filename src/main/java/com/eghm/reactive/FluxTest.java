package com.eghm.reactive;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

/**
 * @author 殿小二
 * @date 2021/5/25
 */
public class FluxTest {
    
    public static void main(String[] args) {
        System.out.println("-------flatMap");
        flatMap();
        System.out.println("-------concatMap");
        concatMap();
        System.out.println("-------verify");
        verify();
        System.out.println("-------interval");
        interval();
        System.out.println("-------zip");
        zip();
    }
    
    /**
     * 降维操作
     */
    private static void flatMap() {
        Flux.just(new String[]{"A", "B"}, new String[]{"E", "F"}, new String[]{"C", "D"})
                .flatMap(Flux::fromArray).subscribe(System.out::println);
    }
    
    private static void concatMap() {
        Flux.just(new String[]{"A", "B"}, new String[]{"E", "F"}, new String[]{"C", "D"})
                .concatMap(Flux::fromArray).subscribe(System.out::println);
    }
    
    
    private static void verify() {
        StepVerifier.create(Flux.just("A", "B")).expectNext("A").expectNext("B").verifyComplete();
    }
    
    private static void interval() {
        Flux.interval(Duration.ofSeconds(1)).take(5).subscribe(System.out::println);
    
    }
    
    private static void zip() {
        Flux.zip(Flux.just("A", "B"), Flux.just("C", "D")).flatMap(objects -> Flux.fromIterable(objects.toList())).subscribe(System.out::println);
    }
}
