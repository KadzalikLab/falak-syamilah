package com.falak;



import com.falak.ephemeris.Sun;

import  static  com.falak.Print.*; // ini untuk meng-impor semua fungsi yg ada di Print, spaya lebih simpel daripada pake System.out.println

/**
 * class ini adalah contoh-contoh penggunaan library falak-syamilah, Dokumentasi.
 */
public class MainApp {
    public static void main(String[] args) {
        int tanggal=21;
        int bulan=12;
        int tahun = 1998;
        double pukul = 0;
        double jd = Konversi.masehiKeJd(tanggal,bulan,tahun,pukul);

        //CONTOH PENGGUNAAN EPHEMERIS
        double dec_sun = Sun.vsop87.apparentDeclination(jd); // mengambil data apparent declination sun metode Vsop87 pada jd tertentu
        double dec_sun2 = Sun.astroAlgo.apparentDeclination(jd);// mengambil data apparent declination sun metode AstroAlgo (Meeus) pada jd tertentu
        print_ddd_ppp_DDMMMYYYY_hhmmss(jd); // ngeprint jd ke format hari - pasaran - tanggal - bulan - tahun - hms
        printDms("Deklinasi Matahari Vsop87",dec_sun);
        printDms("Deklinasi Matahari AA",dec_sun2);


    }
}
