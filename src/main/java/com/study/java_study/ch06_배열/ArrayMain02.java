package com.study.java_study.ch06_배열;

public class ArrayMain02 {

    public static void main(String[] args) {

        // "김준일"의 주소값은 999
        String a = "김준일"; // 999 -> a
        String b = new String("김준일"); // b <- new String(주소값 200) <- 999("김준일")

        System.out.println(a);
        System.out.println(b);

        System.out.println(a == "김준일");
        System.out.println(b == "김준일");


        String[] names = new String[2];
        names[0] = "김준일";
        names[1] = new String("김준일");

        String[] names2 = new String[] {"김준일", new String("김준일")}; // new String[]은 생략가능하다.

        System.out.println(names[0] == names2[0]);
        System.out.println(names[1] == names2[1]);
        System.out.println(names == names2);

        System.out.println(new String[2]);
        System.out.println(new String[] {"a", "b"});

    }
}
