package com.falak.arahkiblat;

import com.falak.Konversi;

import static com.falak.Print.*;
import static com.falak.Print.printHms;
import static java.lang.Math.*;
import static java.lang.Math.toRadians;

public class Dzirwah {

    public static void main(String[] args) {
        double jam_pukul=14;
        double menit_pukul=15;
        double detik_pukul=0;
        double pukul = Konversi.dmsKeDesimal(jam_pukul,menit_pukul,detik_pukul);
        int tanggal = 21;
        int bulan= 1;
        int tahun = 2023;

        double lintang_derajat=-4;
        double lintang_menit = 58;
        double lintang_detik= 0;

        double bujur_derajat=105;
        double bujur_menit=12;
        double bujur_detik=0;

        double lintang= Konversi.dmsKeDesimal(lintang_derajat,lintang_menit,lintang_detik);
        double bujur= Konversi.dmsKeDesimal(bujur_derajat,bujur_menit,bujur_detik);

        double tinggi=50;
        double zona_waktu=7;
        double ihtiyat =2/60.0;

        if (bulan<=2){
            bulan+=12;
            tahun-=1;
        }

        int A = (int) (tahun/100.0);
        int AX = (int)(A/4);
        double B = 2 + AX -A;
        int AA =(int)( 365.25*tahun);
        int BB = (int)(30.60001*(bulan+1));
        double julianday = 1720994.5+AA+BB+tanggal+B+(pukul/24.0);
        double jdl = julianday-zona_waktu/24;
        double sdl = 2 * 3.14159265359 * (jdl-2451545)/365.25;
        double dmo = 0.37877+23.264*sin(toRadians(57.297*sdl-79.547));
        double dmi = dmo+0.3812*sin(toRadians(2*57.297*sdl-82.682));
        double dm = dmi+0.17132*sin(toRadians(3*57.297*sdl-59.722));
        double u = (jdl-2451545)/36525;
//        double lo1 = ((280.46607+36000.7698*u));
        double lo = ((280.46607+36000.7698*u));
        lo=toRadians(lo);
        double e1=1789+237*u;
        double e2=7146-62*u;
        double e3=9934-14*u;
        double e4=-1*e1*sin(lo)-e2*cos(lo)+e3*sin(2*lo);
        double e5=e4-(29+5*u)*cos(2*lo)+(74+10*u)*sin(3*lo);
        double e6 = (320-4*u)*cos(3*lo)-212*sin(4*lo);
        double dmr = toRadians(dm);
        double ltr = toRadians(lintang);


        double pw = ((e5+e6)/1000)/60;
        double dz = 12+zona_waktu-bujur/15 - pw;

        print("jd",julianday);
        print("jdl",jdl);
        print("Sudut Tanggal",sdl);
        printDms("Sudut Tanggal",sdl);
        print("U",u);
        printDms("U",u);

        print("LO",toDegrees(lo));
        printDms("dmo",dmo);
        printDms("dmi",dmi);
        print("Deklinasi Matahari",dm);
        printDms("Deklinasi Matahari",dm);
        print("E1",e1);
        print("E2",e2);
        print("E3",e3);
        print("E4",e4);
        printDms("E4",e4);
        print("E5",e5);
        print("E6",e6);
        print("Perata Waktu",pw);
        printDms("Perata Waktu",pw);

        printHms("Dzuhur",dz);


    }
}
