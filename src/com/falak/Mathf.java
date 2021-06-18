package com.falak;

import java.util.Random;

//library matematika falak yang sebagian tidak ada di library default Java.lang
public class Mathf {

    public static boolean isLeapYearHijri(int year) {
        boolean hasil;
        int x = year % 30;
        hasil = x == 2 || x == 5 || x == 7 || x == 10 || x == 13 || x == 15 || x == 18 || x == 21 || x == 24 || x == 26 || x == 29;
        return hasil;
    }

    public static boolean isLeapYear(double year) {

        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    public static double modulo(double x, double y) {
        return x - (int) (x / y) * x;
    }

    public static double abs360(double val) {
        if (val < 0) val += 360;
        return val;
    }

    public static double rad(double deg_value) {
        return Math.toRadians(deg_value);

    }

    public static int random(int min, int max){
        Random random = new Random();
        int range = max-min+1;
        return  random.nextInt(range)+min;

    }
    public static int random(){

        return (int)(Math.random()*1);

    }


}
