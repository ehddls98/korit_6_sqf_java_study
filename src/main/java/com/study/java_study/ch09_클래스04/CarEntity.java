package com.study.java_study.ch09_클래스04;

public class CarEntity {

    private int carId;
    private String carNum;
    private String ownerName;
    private String carName;

    public CarEntity(int carId, String carNum, String ownerName, String carName) {
        this.carId = carId;
        this.carNum = carNum;
        this.ownerName = ownerName;
        this.carName = carName;
    }

    public CarEntity() {
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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
                ", carNum='" + carNum + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", carName='" + carName + '\'' +
                '}';
    }
}