package com.study.java_study.ch20_람다;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaInterface {
    public static void main(String[] args) {
        Runnable runnable = () -> {             //Runnable: 매개변수 x, 리턴 x
            System.out.println("프로그램 실행");
            System.out.println("프로그램 종료");
            };

        runnable.run();

        Function<String, Integer> fx = s -> Integer.parseInt(s); //Function: 매게변수 0, 리턴 0
        //Function<T, R> : T -> 매개변수의 자료형, R -> 리턴값의 자료형
        Integer num = fx.apply("10");
        System.out.println("num: " + num);

        Integer num2 = fx.andThen(result -> result + 100).apply("10"); //fx.apply의 실행 결과가 result에 대입된다.
        System.out.println("num2: " + num2);

        Consumer<String> transform = s -> {             //매게변수 0, 리턴 x
            System.out.println(s + "서버에 접속하였음.");
            System.out.println(s + "님 환영합니다.");
            };

        transform.accept("김동인");

        Supplier<Integer> role = () -> {    //매개변수 x, 리턴 0
            Integer result = num + 999;
            return result;
        };

        System.out.println(role.get());


        Predicate<Integer> even = n -> n % 2 == 0;

        System.out.println(even.test(10));
    }
}
