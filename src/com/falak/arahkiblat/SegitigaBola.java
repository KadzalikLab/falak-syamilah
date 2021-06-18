package com.falak.arahkiblat;

import static java.lang.Math.*;
import static java.lang.Math.atan;

public class SegitigaBola {

     static double UTSB(ArahKiblat data){
        double lintangT_Radian=Math.toRadians(data.lintang);
        double bujurT_Radian=Math.toRadians(data.bujur);

        double lintangKB_Radian=Math.toRadians(data.lintang_kb);
        double bujurKB_Radian=Math.toRadians(data.bujur_kb);

        double pembilang=Math.sin(bujurKB_Radian-bujurT_Radian);
        double penyebut=Math.cos(lintangT_Radian)*Math.tan(lintangKB_Radian)-Math.sin(lintangT_Radian)*Math.cos(bujurT_Radian-bujurKB_Radian);
        double arah_kiblat=Math.toDegrees(Math.atan2(pembilang,penyebut));
        double hasil;
        if (arah_kiblat<0)hasil=arah_kiblat+360;
        else hasil=arah_kiblat;
        return  hasil;
    }

    static double BU (ArahKiblat data){
        double A = toRadians(90-data.lintang);
        double B = toRadians(90-data.lintang_kb);
        double C = toRadians(data.bujur-data.bujur_kb);
        double D = sin(A)/tan(B)/sin(C)-cos(A)/tan(C);
        return toDegrees(atan(1/D));
    }

    static double UB (ArahKiblat data){
        double A = toRadians(90-data.lintang);
        double B = toRadians(90-data.lintang_kb);
        double C = toRadians(data.bujur-data.bujur_kb);
        double D = sin(A)/tan(B)/sin(C)-cos(A)/tan(C);
        double Hasil_UB= toDegrees(atan(1/D));
        double hasil_BU = 90-Hasil_UB;
        return hasil_BU;
    }


}
