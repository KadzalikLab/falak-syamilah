package com.falak.app;

import com.falak.Konversi;
import com.falak.ephemeris.Ephem;

import java.util.Locale;
import static com.falak.Mathf.*;

import static com.falak.Print.*;
public class EphemerisApp {
    public static void main(String[] args) {
       int digit = 2;
        int tanggal = random(1,31);
        int bulan = random(1,12);
        int tahun = random(2000,2100);

        int jam = random(0,24);
        int menit = random(0,60);
        double detik = random(0,60);
        double mili = random(0,100);
        double jamDes = Konversi.dmsKeDesimal(jam,menit,detik+(mili/100));
        double jd = Konversi.masehiKeJd(tanggal,bulan,tahun,jamDes);

        Ephem ephem = new Ephem(jd);
        ephem.setDataBulan().elp2000();
        ephem.setDataMatahari().vsop87();
        ephem.gunakandeltaT().False();


        Ephem ephem2 = new Ephem(jd);
        ephem2.setDataBulan().elpMpp02();

        Ephem ephem3 = new Ephem(jd);
        ephem3.setDataBulan().elpMpp02Trunc();

        Ephem ephem4 = new Ephem(jd);
        ephem4.setDataBulan().astroAlgo();
        ephem4.setDataMatahari().astroAlgo();
        ephem4.gunakandeltaT().False();
        String dt = "\u0394T\u205A";

        print_ddd_ppp_DDMMMYYYY_hhmmss(jd);
        System.out.println("Matahari:");
        printDms("Vsop87 "+dt+ephem.isUseDeltaT,ephem.getSun_trueGeocentricLongitude(),digit);
        printDms("AstroAlgo "+dt+ephem4.isUseDeltaT,ephem4.getSun_trueGeocentricLongitude(),digit);


        System.out.println("\nBulan:");
        printDms("elp 2000 "+dt+ephem.isUseDeltaT,ephem.getMoon_apparentGeocentricLongitude(),digit);
        printDms("elpMpp02 "+dt+ephem2.isUseDeltaT,ephem2.getMoon_apparentGeocentricLongitude(),digit);
        printDms("elpMpp02 Trunc "+dt+ephem3.isUseDeltaT,ephem3.getMoon_apparentGeocentricLongitude(),digit);
        printDms("AstroAlgo "+dt+ephem4.isUseDeltaT,ephem4.getMoon_apparentGeocentricLongitude(),digit);

        //        System.out.printf(format2
//                , "Pukul"
//                , "Longitude"
//                , "Latitude"
//                , "Appr Right Asc"
//                , "Appr Declination"
//                , "Geo distance"
//                , "Semi diameter"
//                , "Obliquity"
//                , "EoT"
//        );
//        metodeAstroAlgo(jd);
//        metodeVsop87(jd);

//        System.out.println(System.lineSeparator());
//        System.out.printf(format2
//                , "Pukul"
//                , "Longitude"
//                , "Latitude"
//                , "Appr Right Asc"
//                , "Appr Declination"
//                , "Parallax"
//                , "Semi diameter"
//                , "Angle Bright"
//                , "Fib"
//        );

    }
}
