package com.study.java_study.주차등록;

//repository : 저장소 -> CRUD
public class CarRepository {
    private int carId;
    private CarEntity[] cars;

    public CarRepository() {
        cars = new CarEntity[0];
    }

    public int carIdAutoIncrement() {
        return ++carId;
    }

    public void extendCars() {

        CarEntity[] newCars = new CarEntity[cars.length + 1];

        for(int i = 0; i < cars.length; i++) {
            newCars[i] = cars[i];
        }
        cars = newCars;
    }

    private int getLastIndex() {
        return cars.length - 1;
    }

    public void saveCar(CarEntity car) {
        extendCars();
        cars[getLastIndex()] = car;
    }


}
