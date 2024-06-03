package com.study.java_study.ch16_제네릭;

import lombok.ToString;

@ToString
public class Sender<T, T2, T3> {
    private T data;
    private T2 data2;
    private T3 data3;

    public Sender(T data, T2 data2, T3 data3) {
        this.data = data;
        this.data2 = data2;
        this.data3 = data3;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T2 getData2() {
        return data2;
    }

    public void setData2(T2 data2) {
        this.data2 = data2;
    }

    public T3 getData3() {
        return data3;
    }

    public void setData3(T3 data3) {
        this.data3 = data3;
    }
}


