package com.falak.astrologi;

// Java program to generate odd sized magic squares

import java.util.Scanner;

public class Aufaq {
    static  int a1,b1,c1	,d1;
    static  int a2,b2,c2	,d2;
    static  int a3,b3,c3	,d3;
    static  int a4,b4,c4	,d4;
    static  String format = "%5s%5s%5s%5s%n";

    static  int[] wifik_a=new int[3];
    static  int[] wifik_b=new int[3];
    static  int[] wifik_c=new int[3];

    public  static void main(String[] args) {
        System.out.println("Wifiq Generator Kadzalik Lab");
        System.out.println("Based on : Al Aufaq - Imam Ghazali");
        System.out.println("Masukan angka ....");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        a1=n-20;
        a2=11;
        a3 = 5 ;
        a4=4;

        b1=1;
        b2=8;
        b3=10;
        b4=n-19;

        c1=12;
        c2=n-21;
        c3=3;
        c4=6;

        d1=7;
        d2=2;
        d3=n-18;
        d4=9;
        System.out.printf(format,a1,b1,c1,d1);
        System.out.printf(format,a2,b2,c2,d2);
        System.out.printf(format,a3,b3,c3,d3);
        System.out.printf(format,a4,b4,c4,d4);

    }


}
