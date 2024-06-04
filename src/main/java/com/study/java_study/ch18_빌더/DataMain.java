package com.study.java_study.ch18_빌더;

public class DataMain {

    public static void main(String[] args) {

        Data data = new Data("a", 10, 10.5, "b");

        Data data2 = new Data();
        data2.setData1("a");
        data2.setData3(3.14);

        //Builder 클래스에서 작성한 메서드로 객체 생성
        DataEntity dataEntity = DataEntity.builder()
                .data1("a")
                .data2(10)
                .data4("b")
                .build();

        //@Builder 어노테이션을 사용한 클래스의 객체 생성
    DataEntity2 dataEntity2 = DataEntity2.builder()
            .data1("a")
            .data2(20)
            .data3(3.14)
            .data4("b")
            .build();
    }
}
