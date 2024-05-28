package com.study.java_study.주차등록;

import com.study.java_study.ch09_클래스04.BookEntity;

import java.util.Scanner;

public class CarService {

    private Scanner scanner;
    private CarRepository carRepository;

    public String selectMenu() {
        String menus = "1234q";
        String selectedMenu = null;

        while (true) {
            System.out.println("메뉴 선택: ");
            selectedMenu = scanner.nextLine();
            if(menus.contains(selectedMenu)) {
                break;
            }
            System.out.println("잘못된 입력입니다. 다시 입력하세요.");
        }
        return selectedMenu;
    }

    public boolean run() {
        boolean isRun = true;

        System.out.println(" [ 주차 등록 프로그램 ] ");
        System.out.println("1. 차량 등록");
        System.out.println("2. 차량 검색");
        System.out.println("3. 차량 수정");
        System.out.println("4. 차량 삭제");
        System.out.println("q. 프로그램 종료");

        String selectedMenu = selectMenu(); //selectMenu() 메서드의 리턴값을 selectedMenu에 대입한다.

        switch (selectedMenu) { //selectedMenu의 값에 따라 case를 실행한다
            case"q" :
                isRun = false;
                break;
            case"1" :
                registerCar();
                break;
            case"2" :
                search();
                break;
            case"3" :
                break;
            case"4" :
                break;
            default:
                System.out.println("입력 오류");
        }
        System.out.println();
        return isRun;
    }

    private String validateValue(String value) {
        String value = null;
        while(true) {
            System.out.print(title + "명 입력: ");
            value = scanner.nextLine();
            if(!value.isBlank()) {
                break;
            }
            System.out.println(title + "명은 공백일 수 없습니다. 다시 입력하세요.");
        }
        return value; //scanner 입력값이 공백이 아닐때의 입력값을 리턴
    }

    private String duplicateCarNum() {
        String carNum = null;
        while(true) {
            carNum = validateValue("차량");
            if(carRepository.findBookByBookName(carNum) == null) { //findBookByBookName 메서드를 통해 리포지토리에 같은 제목의 도서가 있는지 확인
                break;
            }
            System.out.println("해당 도서명이 이미 존재합니다. 다시 입력하세요.");
        }
        return bookName; //findBookByBookName 메서드를 통해 같은 제목의 도서가 없는 것이 확인 되었을때 입력된 책 제목을 리턴
    }

    private void registerCar() {
        System.out.println("[ 차량 등록 ]");
        int carId = carRepository.carIdAutoIncrement();
        String carNum = duplicateCarNum();
        String owner = validateValue("차주");
        String carName = validateValue("차량");

        CarEntity car = new CarEntity(carId, carNum, owner, carName);
        carRepository.saveCar(car);
        System.out.println("새로운 차량이 입고되었습니다.");
    }

    private void search() {
        System.out.println(" [ 도서 검색 ]");
        System.out.println("1. 통합 검색");
        System.out.println("2. 도서명 검색");
        System.out.println("3. 저자명 검색");
        System.out.println("4. 출판사명 검색");
        System.out.print("옵션 선택: ");
        int option = scanner.nextInt(); //scanner 입력값을 option에 대입한다.
        scanner.nextLine(); //nextInt의 버퍼에 Enter입력이 저장되지 않기 때문에 그 입력을 대신 받기 위한 코드
        System.out.print("검색어 입력: ");
        String searchText = scanner.nextLine(); //scanner 입력값을 searchText에 대입한다.
        BookEntity[] searchBooks = bookRepository.searchBooks(option, searchText); //searchBooks 메서드를 통해 리턴된 배열을 searchBooks 배열에 대입한다.

        System.out.println(" [ 검색 결과 ]");
        if(searchBooks.length == 0) { //searchBooks 메스드를 통해 리턴된 배열이 비어있으면 true
            System.out.println("검색 결과가 없습니다.");
            return;
        }
        for(BookEntity book : searchBooks) {
            System.out.println(book.toString()); //searchBooks 메서드를 통해 리턴된 배열을 출력
        }
    }


}
