package com.study.java_study.ch17_컬렉션;

import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StringArrayListMain {

    public static void main(String[] args) {

        //List는 인터페이스이기 때문에 생성자로 생성 불가능하다.
        //ArrayList는 클래스이기 때문에 생성자로 생성 가능하다.

        String[] strArray = new String[10];
        ArrayList<String> strList = new ArrayList<>();
        strList.add("test1");

        // 배열 <-> 리스트 변환
        List<String> list = Arrays.asList(strArray); //strArray 배열을 Arrays클래스의 asList 메소드를 사용하여 list에 대입
        ArrayList<String> list2 = new ArrayList<>();
        list2.addAll(list); //ArrayList list2에 List인 list를 대입
        String[] strArray2 = strList.toArray(new String[strList.size()]); //ArrayList의 toArray 메소드를 사용하여 strList를 strArray2 배열에 대입

        // 리스트 값 조회
        System.out.println(strList);

        // contatins 포함 조회
        System.out.println(strList.contains("test1"));

        //리스트 바로 생성
        List<Integer> nums = List.of(1, 2, 3, 4, 5); //of로 List를 생성하면 상수처럼 수정이 안됨. 원하는 값을 넣은 새로운 List를 만들어야함.
        System.out.println(nums);

        //제거
        strList.add("김준일");
        strList.add("김준이");
        strList.add("김준삼");
        System.out.println(strList);
        System.out.println(strList.remove("test1"));
        System.out.println(strList);
        System.out.println(strList.remove(1));
        System.out.println(strList);

        System.out.println(nums);
        List<Integer> nums2 = List.of(1, 3, 5);
        ArrayList<Integer> nums3 = new ArrayList<>();
        nums3.addAll(nums);
        System.out.println(nums3.removeAll(nums2));
        System.out.println(nums3);

        //수정
        nums3.set(0, 10);
        System.out.println(nums3);

        nums3.addAll(List.of(1, 2, 3));
        System.out.println(nums3);

        //반복
        for(int i = 0; i < nums3.size(); i++) {
            System.out.println(nums3.get(i));
        }

        for(Integer num : nums3) {
            System.out.println(num);
        }

        Iterator<Integer> ir = nums3.iterator();
        while(ir.hasNext()) {
            System.out.println(ir.next());
        }

    }
}