package com.study.java_study.ch06_배열;

public class ArrayMain01 {

    public static void main(String[] args) {
        int[] nums = new int[100];

        for(int i = 0; i < 100; i++) {
            nums[i] = (i + 1) * 10;
        }

        for(int num : nums) {           //for each : for(변수 선언 : 배열) 배열의 0번 인덱스부터 마지막 인덱스까지 차례대로 변수에 대입
            System.out.println(num);
        }

        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                continue;
            }
            int num = nums[i];
            System.out.println(num);
        }
    }
}
