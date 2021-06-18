package com.falak.app;

import com.falak.Konversi;
import com.falak.waktusalat.Salat;

import static java.lang.Math.*;

public class JadwalSholatApp {

    public static void main(String[] args) {

        int tanggal = 1;
        int bulan = 1;
        int tahun = 2021;

        double lintang_derajat = -4;
        double lintang_menit = 58;
        double lintang_detik = 0;

        double bujur_derajat = 105;
        double bujur_menit = 12;
        double bujur_detik = 0;

        double lintang = Konversi.dmsKeDesimal(lintang_derajat, lintang_menit, lintang_detik);
        double bujur = Konversi.dmsKeDesimal(bujur_derajat, bujur_menit, bujur_detik);

        double tinggi = 50;
        double zona_waktu = 7;
        double ihtiyat = 1.5 / 60.0;
        System.out.println("Tanggal, Bulan, Imsak, Subuh, Terbit, Dluha, Dzuhur, Ashar, Maghrib, Isya");
        double jd = Konversi.masehiKeJd(tanggal, bulan, tahun, 0);
        String imsakS, subuhS, terbitS, dluhaS, dzuhurS, asarS, maghribS, isyaS;
        double imsak, subuh, terbit, dluha, dzuhur, asar, maghrib, isya;

        for (int i = 0; i <= 365; i++) {
            Salat salat = new Salat(jd + i, lintang, bujur, zona_waktu, tinggi);
            salat.setIhtiyat(ihtiyat);
            salat.setIhtiyatTerbit(1);
            salat.setImsak(10);
            salat.setMetodeHisab().makalahKemenag();
            imsak = salat.getImsak();
            subuh = salat.getSubuh();
            terbit = salat.getTerbit();
            dluha = salat.getDluha();
            dzuhur = salat.getDzuhur();
            asar = salat.getAshar();
            maghrib = salat.getMaghrib();
            isya = salat.getIsya();




            imsakS = String.format("%01d:%02d", Konversi.desimalKeDms(imsak)[1], Konversi.desimalKeDms(imsak)[2]);
           // String.format("%02d:%02d", Konversi.desimalKeDms()[1], Konversi.desimalKeDms()[2]);
            subuhS =  String.format("%01d:%02d", Konversi.desimalKeDms(subuh)[1], Konversi.desimalKeDms(subuh)[2]);
            terbitS =  String.format("%01d:%02d", Konversi.desimalKeDms(terbit)[1], Konversi.desimalKeDms(terbit)[2]);
            dluhaS = String.format("%01d:%02d", Konversi.desimalKeDms(dluha)[1], Konversi.desimalKeDms(dluha)[2]);
            dzuhurS =  String.format("%02d:%02d", Konversi.desimalKeDms(dzuhur)[1], Konversi.desimalKeDms(dzuhur)[2]);
            asarS =  String.format("%02d:%02d", Konversi.desimalKeDms(asar)[1], Konversi.desimalKeDms(asar)[2]);
            maghribS =  String.format("%02d:%02d", Konversi.desimalKeDms(maghrib)[1], Konversi.desimalKeDms(maghrib)[2]);
            isyaS =  String.format("%02d:%02d", Konversi.desimalKeDms(isya)[1], Konversi.desimalKeDms(isya)[2]);

            switch (salat.getTanggal())
            {
                case 1:
                case 5:
                case 9:
                case 13:
                case 17:
                case 19:
                case 21:
                case 24:
                case 27:
                case 30:
                    System.out.println(salat.getTanggal() + ", " + Konversi.namaBulanMasehi(salat.getBulan()) + ", "
                            + imsakS + ", " + subuhS + ", " + terbitS + ", "+ dluhaS + ", "
                            + dzuhurS + ", " + asarS + ", " + maghribS + ", " + isyaS);
                    break;

                }

            }


    }


}
