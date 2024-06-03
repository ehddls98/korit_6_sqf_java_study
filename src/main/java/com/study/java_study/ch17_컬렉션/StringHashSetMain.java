package com.study.java_study.ch17_컬렉션;

import java.util.*;

public class StringHashSetMain {

    public static void main(String[] args) {

        HashSet<String> strSet = new HashSet<>();

        // 추가
        strSet.add("김동인1"); //.add() 메소드로 값 추가
        strSet.add("김동인2");
        strSet.add("김동인3");
        strSet.add("김동인4");

        System.out.println(strSet);

        for(String name : strSet) {
            System.out.println(Objects.hash(name)); //strSet에 있는 값들의 주소값들을 차례대로 출력
        }

        strSet.addAll(List.of("김동인", "김동인", "김동인")); //set에는 중복된 값이 들어갈 수 없기 때문에 기존 strSet에 "김동인"이 하나만 들어감

        ArrayList<String> strList = new ArrayList<>();
        strList.addAll(strSet); //strSet(중복값 허용x)의 데이터를 strList(중복값 허용)에 옮긴 후 strSet에 "김동인"이 하나만 추가된것 확인


        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
            }
        };

        strList.sort(stringComparator);

        strList.sort((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1, o2));
        System.out.println(strList);
    }
}