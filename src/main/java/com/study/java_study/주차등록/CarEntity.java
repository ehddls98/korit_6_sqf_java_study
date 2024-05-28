package com.study.java_study.주차등록;

public class CarEntity {

    private int carId;
    private int carNum;
    private String owner;
    private String carName;

    public CarEntity(int carId, int carNum, String owner, String carName) {
        this.carId = carId;
        this.carNum = carNum;
        this.owner = owner;
        this.carName = carName;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCarNum() {
        return carNum;
    }

    public void setCarNum(int carNum) {
        this.carNum = carNum;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "carId=" + carId +
                ", carNum=" + carNum +
                ", owner='" + owner + '\'' +
                ", carName='" + carName + '\'' +
                '}';
    }
}
