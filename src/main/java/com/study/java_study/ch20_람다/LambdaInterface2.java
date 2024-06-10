package com.study.java_study.ch20_람다;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaInterface2 {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("안녕하세요.");
                System.out.println("안녕히가세요.");
            }
        };

        runnable.run();

        //Runnable 람다
        Runnable runnable1 = () -> {
            System.out.println("어서오세요.");
            System.out.println("조심히 가세요.");
        };

        runnable1.run();
        System.out.println();

//        Function<String, Integer> f = new Function<String, Integer>() {
//
//            }
//        };

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s + "출력1");
                System.out.println(s + "출력2");
            }
        };

        consumer.accept("test");

        //Consumer 람다
        Consumer<String> consumer1 = s -> {
            System.out.println(s + "출력1");
            System.out.println(s + "출력2");
        };

        consumer1.accept("test2");
        System.out.println();

        Supplier<Integer> role = new Supplier<Integer>() {  //매개변수 x, 리턴 0

            @Override
            public Integer get() {
                Integer number = 999;
                return number;
            }
        };

        System.out.println(role.get());

        //Supplier 람다
        Supplier<Integer> role2 = () -> {
            Integer number2 = 1000;
            return number2;
        };
    }
}
