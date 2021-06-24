package com.falak.app;

import com.falak.Konversi;
import com.falak.ephemeris.Sun;
import com.falak.waktusalat.Salat;

import static com.falak.Print.*;

public class WaktuSalatApp {
    public static void main(String[] args) {
        double tanggal=12;
        double bulan =6;
        double tahun=2009;

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




        //bikin object dari class Salat, dengan parameter spt dibawah
        System.out.println("Makalah Kemenag / Ephemeris");
        Salat ws =new Salat(tanggal,bulan,tahun,lintang,bujur,zona_waktu,tinggi);
        ws.setMetodeHisab().makalahKemenag();
        printHms("Imsak",ws.getSubuh()-(10/60.0));
        printHms("Subuh",ws.getSubuh());
        printHms("Terbit",ws.getTerbit());
        printHms("Dluha",ws.getDluha());
        printHms("Dzuhur",ws.getDzuhur());
        printHms("Ashar",ws.getAshar());
        printHms("Maghrib",ws.getMaghrib());
        printHms("Isya",ws.getIsya());



        System.out.println(System.lineSeparator());
        System.out.println("Mekanika Benda Langit");
        Salat ws2 =new Salat(tanggal,bulan,tahun,lintang,bujur,zona_waktu,tinggi);
        ws2.setMetodeHisab().mekanikaBendaLangit();
        printHms("Imsak",ws2.getSubuh()-(10/60.0));
        printHms("Subuh",ws2.getSubuh());
        printHms("Terbit",ws2.getTerbit());
        printHms("Dluha",ws2.getDluha());
        printHms("Dzuhur",ws2.getDzuhur());
        printHms("Ashar",ws2.getAshar());
        printHms("Maghrib",ws2.getMaghrib());
        printHms("Isya",ws2.getIsya());


        System.out.println(System.lineSeparator());
        System.out.println("Metode Irsyadul Murid");
        Salat irmu = new Salat(tanggal,bulan,tahun,lintang,bujur,zona_waktu,tinggi);
        irmu.setMetodeHisab().irsyadulMurid();
        printHms("Imsak",irmu.getSubuh()-(10/60.0));
        printHms("Subuh",irmu.getSubuh());
        printHms("Terbit",irmu.getTerbit());
        printHms("Dluha",irmu.getDluha());
        printHms("Dzuhur",irmu.getDzuhur());
        printHms("Ashar",irmu.getAshar());
        printHms("Maghrib",irmu.getMaghrib());
        printHms("Isya",irmu.getIsya());


        System.out.println(System.lineSeparator());
        System.out.println("Metode Anwarul Kawakib");
        Salat kwk = new Salat(tanggal,bulan,tahun,lintang,bujur,zona_waktu,tinggi);
        kwk.setMetodeHisab().anwarulKawakib();
        printHms("Imsak",kwk.getSubuh()-(10/60.0));
        printHms("Subuh",kwk.getSubuh());
        printHms("Terbit",kwk.getTerbit());
        printHms("Dluha",kwk.getDluha());
        printHms("Dzuhur",kwk.getDzuhur());
        printHms("Ashar",kwk.getAshar());
        printHms("Maghrib",kwk.getMaghrib());
        printHms("Isya",kwk.getIsya());





        // cara menggunakan library ini
        // 1. buat objek Salat dahulu:
        Salat ws1 = new Salat(tanggal,bulan,tahun,lintang,bujur,zona_waktu,tinggi);

        // 2. setting metode hisab dan data pendukung lain, mis ihtiyath
        ws1.setMetodeHisab().makalahKemenag();
        ws1.setIhtiyat(2);
        ws1.setSudutSubuh(-18);
        ws1.setSudutIsya(-19);

        // 3. mendapatkan nilai waktu sholat tertentu dengan variabel yg sudah ditentukan diatas
        double sbh = ws1.getSubuh();
        double terbit = ws1.getTerbit();


        System.out.println();
        Salat th21 = new Salat(21,6,2021,lintang,bujur,zona_waktu,tinggi);
        th21.setMetodeHisab().makalahKemenag();
        Salat th31 = new Salat(21,6,2031,lintang,bujur,zona_waktu,tinggi);
        th31.setMetodeHisab().makalahKemenag();
        Salat th51 = new Salat(21,6,2051,lintang,bujur,zona_waktu,tinggi);
        th51.setMetodeHisab().makalahKemenag();

        printHms("Zuhur 21 6 2021",th21.getDzuhur());
        printHms("Zuhur 21 6 2031",th31.getDzuhur());
        printHms("Zuhur 21 6 2051",th51.getDzuhur());


        System.out.println();
        System.out.println();
        System.out.println();
        double tahunL=2021;
        for (int i = 0; i<11;i++){
            Salat th = new Salat(21,6,tahunL,lintang,bujur,zona_waktu,tinggi);
            th.setMetodeHisab().makalahKemenag();
            printHms("Zuhur 21 6 "+(int)tahunL,th.getDzuhur());
            tahunL+=10;

        }







    }
}
