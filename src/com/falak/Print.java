package com.falak;

import com.falak.Konversi;

import java.util.Locale;

public class Print {
    static String format = "%-25s%5s%n";
    public static void printDms(String teks, double dms_value){
        System.out.printf(format,teks,":"+ Konversi.dmsMili(dms_value));

    }
    public static void printDms( double dms_value){
        System.out.println(Konversi.dmsMili(dms_value));

    }


    public  static void printHms(String teks, double hms_value){
        System.out.printf(format,teks,":"+Konversi.hmsMili(hms_value));

    }
    public  static void printHmssss(String teks, double hms_value){
        System.out.printf(format,teks,":"+Konversi.hmsMili(hms_value));

    }

    public  static void printHms(String teks, double hms_value,String iterator){
        System.out.printf(format,teks,":"+Konversi.hms(hms_value)+" "+ iterator);

    }

    public static void printDigit(String teks, double value,int digit){
        System.out.printf(format,teks,":"+String.format(Locale.JAPAN,"%."+digit+"f",value));

    }
    public static String printDigit(double value,int digit){
        return  String.format(Locale.JAPAN,"%."+digit+"f",value);

    }

    public  static void print_ddd_ppp_DDMMMYYYY_hhmmss(double jd){

        System.out.println(Konversi.ddd_ppp_DDMMMYYYY_hhmmss(jd));
    }

    public  static void print_ddd_ppp_DDMMMYYYY(double jd){
        System.out.println(Konversi.ddd_ppp_DDMMMYYYY(jd));
    }



     public  static void print_ddd_DDMMMYYYY(double jd){
         System.out.println( Konversi.ddd_DDMMMYYYY(jd));
    }

    public  static void print_hhmmss(double jd){
        double jam_des = Konversi.jdPukul(jd);
        System.out.println( Konversi.hmsMili(jam_des));
    }



}
