package com.study.java_study.ch08_클래스03;

public class ColorMain {

    public static void main(String[] args) {

        /*
        문제)
        Color 객체 5개를 담을 수 있는 배열을 생성하여
        #CA848A, Brandied Apricot
        #FFBE98, Peach Fuzz
        #964F4C, Marsala
        #A78C78, Almondine
        #D8C88D, Almond peach
        색상 데이터를 저장 한 후에 for 문을 사용하여 배열에 들어있는 모든 색상 정보를 printInfo()로 호출하여 출력한다.
        이후에 모든 code와 name의 값을 null로 바꾸어 다시 출력한다.
        이때 null로 바꿀때에는 반복문을 사용한다.
         */

        Color[] colors = new Color[5];

        colors[0] = new Color("#CA848A", "Brandied Apricot");
        colors[1] = new Color("#FFBE98", "Peach Fuzz");
        colors[2] = new Color("#964F4C", "Marsala");
        colors[3] = new Color("#A78C78", "Almondine");
        colors[4] = new Color("#D8C88D", "Almond peach");

//        Color[] colors = new Color[] {
//                new Color("#CA848A", "Brandied Apricot"),
//                new Color("#FFBE98", "Peach Fuzz"),
//                new Color("#964F4C", "Marsala"),
//                new Color("#A78C78", "Almondine"),
//                new Color("#D8C88D", "Almond peach")
//        };

        for(Color color : colors) {
            color.printInfo();
            System.out.println();
        }

        for(Color color : colors) {
            color.setCode(null);
            color.setName(null);
        }

        for(Color color : colors) {
            color.printInfo();
            System.out.println();
        }
    }
}
