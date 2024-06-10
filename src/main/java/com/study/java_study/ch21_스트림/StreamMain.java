package com.study.java_study.ch21_스트림;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {

        /*스트림: 반복을 위해 사용, 스트림을 생성하여 다양한 가공 절차를 거쳐 새로운 스트림에 넣거나 변환할때 사용한다.

        생성(사용) 절차
        1. 배열 생성 -> 스트림으로 변환
        2. List 생성 -> 스트림으로 변환
        3. generate 메소드 -> 스트림 생성
        4. 범위 지정 -> 스트림 생성
        5. builder -> 스트림 생성

        중간(가공) 절차
        1. *map(Function) -> for : each 문처럼 배열 안의 값을 하나씩 꺼내어 변환한 뒤 새로운 스트림에 담는다.
        2. *filter(Predicate) -> 조건에 해당하는 값만 새로운 스트림에 담는다
        3. sorted(Comparator) -> 오름차순 또는 내림차순으로 정렬한다.

        최종(결과) 절차
        1. collect -> stream을 list 변환
        2. 반복자 -> forEach
         */

        Stream<Integer> st1 = Arrays.stream(new Integer[] {1, 2, 3, 4, 5}); //<생성> 배열을 스트림으로 변환하여 st1에 대입
        List<Integer> numberList = st1.map(n -> n * 2)
                //<가공> map : for : each 문 처럼 st1 안의 값을 하나씩 꺼내 *2 를 한다. 그리고 그 값들을 새로운 스트림에 담는다.
                //이때 기존의 스트림에 있던 데이터들은 하나씩 삭제된다.
                .peek(n -> System.out.println(n)) //<가공>(기타 스트림 메소드), peek: 스트림이 실행되는 동안 중간 중간에 결과를 확인하기 위해 사용.
                .collect(Collectors.toList()); //<최종> 가공을 마친 st1 스트림을 numberList 리스트에 대입한다.

        numberList.forEach(n -> System.out.println("n: " + n)); //numberList 안의 값들을 하나씩 출력한다.

        List<Integer> filteringNumberList = numberList.stream()
                //<생성> 위에서 만든 numberList를 스트림으로 변환하고 <가공>을 거쳐 .collect()메서드를 통해
                //list로 변환하여 filteringNumberList에 대입한다.
                .map(n -> n /2) //<가공> numberList 안의 값들을 하나씩 꺼내 /2를 하여 새로운 스트림에 넣는다.
                .filter(n -> n % 2 == 0) //<가공> 짝수인 값들만 새로운 스트림에 넣는다.
                .collect(Collectors.toList()); //<최종> 가공을 마친 값들로 이루어진 스트림을 리스트로 변환한다.

        System.out.println(filteringNumberList); //[2, 4]

        List<Integer> sortedNumberList = numberList.stream() //<생성> 위에서 만든 numberList를 스트림으로 변환한다.
                .sorted((o1, o2) -> o2 - o1) //<가공> 내림차순으로 정렬(오름차순으로 출력하려면 o1 - o2)
                .collect(Collectors.toList()); //<최종> sorted() 메소드로 가공된 스트림을 리스트로 변환한다.

        System.out.println(sortedNumberList); //[10, 8, 6, 4, 2]

        Stream<String> nameStream = Stream.<String>builder()
                .add("손경태")
                .add("최단비")
                .add("김지현")
                .add("정령우")
                .add("이성민")
                .build();

        //nameStream.sorted().forEach(name -> System.out.println(name));
        nameStream
                .sorted((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o2, o1)) //이름을 내림차순으로 정렬
                .forEach(name -> System.out.println(name)); //nameStream 안의 값들을 하나씩 거내어 출력

        List<Phone> phoneList = List.of( //빌더 패턴을 사용하여 phone 객체 3개를 생성하여 phoneList 리스트 안에 넣었다.
            Phone.builder().number(1).model("아이폰").build(),
            Phone.builder().number(2).model("갤럭시").build(),
            Phone.builder().number(3).model("샤오미").build()
        );

        phoneList.stream()
                .map(phone -> Phone.builder() //새로운 phone 객체 생성
                    .number(phone.getNumber() * 2)
                    .model(phone.getModel())
                    .build())
                .forEach(phone -> System.out.println(phone));

        phoneList.stream()
                .filter(phone -> phone.getNumber() % 2 != 0) //홀수인 번호만 추출
                .forEach(phone -> System.out.println(phone));

        phoneList.stream()
                .sorted((o1, o2) -> o2.getNumber() - o1.getNumber()) //번호 내림차순으로 정렬
                .forEach(phone -> System.out.println(phone));

        phoneList.stream()
                .sorted((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getModel(), o2.getModel())) //가나다 순으로 정렬
                .forEach(System.out :: println);
                //.forEach(phone -> System.out.println(phone));

    }
}
