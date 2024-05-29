package com.study.java_study.ch09_클래스04;

public class CarRepository {
    private int carId;
    private CarEntity[] cars;

    public CarRepository() {
        cars = new CarEntity[0];
    }

    public int autoIncrementCarId() {
        return ++carId;
    }

    private void extendCars() {
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

    public CarEntity findCarByCarId(int carId) {
        CarEntity findCar = null;
        for(CarEntity car : cars) {
            if(car.getCarId() == carId) {
                findCar = car;
                break;
            }
        }
        return findCar;
    }

    public CarEntity findCarByCarName(String carName) {

    }

    public int getNewArraySize(int option, String searchText) {

    }

    public CarEntity[] searchCars(int option, String searchText) {

    }

    private int indexOfCarId(int carId) {

    }

    public void deleteCarByCarId(int carId) {

    }
}
