package com.study.java_study.주차등록;

//repository : 저장소 -> CRUD
public class CarRepository {

    private CarEntity[] cars;
    private int carId;

    public CarRepository() {
        cars = new CarEntity[0];
    }

    public int carIdIncrement() {
        return ++carId;
    }

    public CarEntity[] extendCars() {

        CarEntity[] newCars = new CarEntity[cars.length + 1];

        for(int i = 0; i < cars.length; i++) {
            newCars[i] = cars[i];
        }
        cars = newCars;

        return cars;
    }
}
