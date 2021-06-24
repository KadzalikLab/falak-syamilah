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

    public static double moduloModif(double x, double y) {
        return x - (int) (x / y) * x;
    }

    /**
     * fungsi Mod yang mirip dengan fungsi di-Excel / Libre office
     */
    public static double mod(double a, double b){
        return (a%b+b)%b;
    }

    public static double abs360(double val) {
        if (val < 0) val += 360;
        return val;
    }

    public static double rad(double deg_v) {
        return Math.toRadians(deg_v);

    }

    public static int random(int min, int max){
        Random random = new Random();
        int range = max-min+1;
        return  random.nextInt(range)+min;

    }
    public static int random(){

        return (int)(Math.random()*1);

    }

    public  static  double random_jd(int tahun_min, int tahun_max){
        int tanggal = random(1,31);
        int bulan = random(1,12);
        int tahun = random(tahun_min,tahun_max);

        int jam = random(0,24);
//        int menit = random(0,60);
//        double detik = random(0,60);
         int menit = 0;
        double detik = 0;

        double jamDes = Konversi.dmsKeDesimal(jam,menit,detik);

        return Konversi.masehiKeJd(tanggal,bulan,tahun,jamDes);
    }


}
