package com.study.java_study.ch18_빌더;

import lombok.Builder;

@Builder //DataEntity 클래스가 Builder 어노테이션의 내부 작동 원리
public class DataEntity2 {
    private String data1;
    private int data2;
    private double data3;
    private String data4;
}
