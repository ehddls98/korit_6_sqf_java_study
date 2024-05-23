package com.study.java_study.ch04_제어;

public class Star {

    public static void main(String[] args) {

        /*
        *
        **
        ***
        ****
        *****
         */

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 1 + i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        /*
        *****
        ****
        ***
        **
        *
         */

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        /*
             *
            **
           ***
          ****
         *****
         */

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 4 - i ; j++) {
                System.out.print(" ");
            }
            for(int k = 0; k < 1 + i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        /*
        *****
         ****
          ***
           **
            *
         */

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for(int k = 0; k < 5 - i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        /*
          *
         ***
        *****
       *******
      *********
         */

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            for(int k = 0; k < 5; k++) {
                int num = 0;
                for(int l = 0; l < k + num; l++) {
                    System.out.print("*");
                }
            }
            for(int m = 0; m < 4 - i; m++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}



