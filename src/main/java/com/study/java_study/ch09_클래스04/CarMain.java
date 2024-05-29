package com.study.java_study.ch09_클래스04;

public class CarMain {

    public static void main(String[] args) {

        CarService carService = new CarService();

        System.out.println("프로그램을 실행합니다.");

        while(carService.run()) {}

        System.out.println("프로그램을 종료합니다.");
    }
}
