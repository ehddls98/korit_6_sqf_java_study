package com.study.java_study.ch17_컬렉션;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringHashMapMain {

    public static void main(String[] args) {

        HashMap<Integer, String> strMap = new HashMap<>(); //key 값이 Integer 자료형, value 값이 String 자료형인 Map 생성

        //추가
        //map은 collection 인터페이스를 상속받지 않았기 때문에 add()가 아닌 put(key, value) 메서드로 값을 추가한다.
        strMap.put(10, "김동인1"); //map에는 인덱스가 없기 때문에 key 값이 0부터 시작할 필요가 없다. 이때 키 값은 중복을 허용하지 않지만 value 값은 중복을 허용한다.
        strMap.put(11, "김동인2");
        strMap.put(12, "김동인3");
        strMap.put(13, "김동인4");

        System.out.println(strMap);

        //조회
        System.out.println(strMap.get(11)); //key 값이 11인 value 출력

        //추가
        Map<String, String> lang = Map.of( //of로 map을 생성하면 상수처럼 수정이 안됨. 원하는 값들을 넣은 새로운 List를 만들어야함.
                "java", "자바",
                "c", "C",
                "python", "파이썬",
                "js", "자바스크립트"
        );

        System.out.println(lang);

        //key값을 파라미터로 받아 그 키에 해당하는 value를 출력
        System.out.println(lang.get("java"));

        Set<Map.Entry<String, String>> entries = lang.entrySet();
        //key와 value의 묶음 = Entry, entrySet() 메소드를 이용해 key와 value 값을 묶은 값으로 변환, Entry를 Set으로 묶은 값을 entries라는 Set에 대입
        //Entry를 List가 아닌 Set으로 묶는 이유는 List는 중복값을 허용하지 않기 때문에 중복값들이 삭제될 수 있기 때문이다.

        for(Map.Entry<String, String> entry : entries) {
            //Entry들의 Set인 entries에서 Entry를 하나씩 꺼내서 entry에 대입하는 for : each문
            //for : each문은 하나의 변수에 데이터 묶음을 하나씩만 대입할 수 있기 때문에 Map의 key와 value값들을 하나의 데이터 묶음인 entry로 변환하는 것이다.
            System.out.println("key: " + entry.getKey()); //entry 안에 있는 key 값을 얻는 메소드
            System.out.println("value: " + entry.getValue()); //entry 안에 있는 value 값을 얻는 메소드
        }
    }
}
