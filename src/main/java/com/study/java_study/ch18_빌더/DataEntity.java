package com.study.java_study.ch18_빌더;

public class DataEntity {

    //빌더(@Builder) 클래스
    private String data1;
    private int data2;
    private double data3;
    private String data4;

    public DataEntity(String data1, int data2, double data3, String data4) {
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
    }

    //DataEntityBuilder 객체를 생성해주는 스태틱 메서드, 스태틱이기 때문에 DataEntity 클래스를 생성하지 않아도 사용할 수 있다.
    public static DataEntityBuilder builder() {
        return new DataEntityBuilder();
    }

    public static class DataEntityBuilder {
        private String data1;
        private int data2;
        private double data3;
        private String data4;

        //data1, data2, data3, data4를 파라미터로 받는 DataEntity 객체를 생성하고 리턴하는 메서드.
        // 각 파라미터는 아래의 data1, data2, data3, data4 메서드를 통해 값을 전달받는다.
        public DataEntity build() {
            return new DataEntity(data1, data2, data3, data4);
        }

        public DataEntityBuilder data1(String data1) { //파라미터로 data1 값을 받아 이 값을 필드변수에 넣어 리턴한다.
            this.data1 = data1;
            return this;
        }

        public DataEntityBuilder data2(int data2) {
            this.data2 = data2;
            return this;
        }

        public DataEntityBuilder data3(double data3) {
            this.data3 = data3;
            return this;
        }

        public DataEntityBuilder data4(String data4) {
            this.data4 = data4;
            return this;
        }
    }
}
