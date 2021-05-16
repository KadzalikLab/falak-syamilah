package com.falak.arahkiblat;

import com.falak.Konversi;
import com.falak.Sun;

import java.util.Scanner;

import static com.falak.Print.*;

public class RashdulKiblatTahunan {
    static double jd_terdekat;
    static double interval_perjam=1,interval_permenit=(1/60.0),interval_perdetik=(1/3600.0), interval_perMilidetik =(interval_perdetik/1000);

    public static void main(String[] args) {
        double tgl,bln,thn,jam,mnt,dtk,jamDes;
        tgl=16;
        bln=7;
        thn=2022;
        jam=0;
        mnt=0;
        dtk=0;
        jamDes= Konversi.dmsKeDesimal(jam,mnt,dtk);
//        double jd = Konversi.kmJd(tgl,bln,thn,jamDes);
        double zona_waktu=7;

        double derajat_lintangKB=21;
        double menit_lintangKB=25;
        double detik_lintangKB=22;
        double lintangKB=Konversi.dmsKeDesimal(derajat_lintangKB,menit_lintangKB,detik_lintangKB);

        double derajat_bujurKB=39;
        double menit_bujurKB=49;
        double detik_bujurKB=34;
        double bujurKB=Konversi.dmsKeDesimal(derajat_bujurKB,menit_bujurKB,detik_bujurKB);
        double bujur_refrensi = 3*15;

        double derajat_lintang=-4;
        double menit_lintang=58;
        double detik_lintang=3.42;
        double lintang=Konversi.dmsKeDesimal(derajat_lintang,menit_lintang,detik_lintang);

        double derajat_bujur=105;
        double menit_bujur=12;
        double detik_bujur=10.12;
        double bujur=Konversi.dmsKeDesimal(derajat_bujur,menit_bujur,detik_bujur);

        Scanner scanner = new Scanner(System.in);
        int tahun= scanner.nextInt();
        double jd_mei=Konversi.masehiKeJd(28,5,tahun,0);
        double jd_juli = Konversi.masehiKeJd(16,7,tahun,0);
        boolean kabisat = ((tahun % 4 == 0) && (tahun % 100 != 0)) || (tahun % 400 == 0);
        if (kabisat){
            jd_juli-=1;
            jd_mei-=1;
        }
        double pukul12=(12-3)/24.0;
        double eot_mei = Sun.Vsop87.equationOfTime(jd_mei+pukul12);
        double eot_juli = Sun.Vsop87.equationOfTime(jd_juli+pukul12);
        double dec_mei = Sun.Vsop87.apparentDeclination(jd_mei+pukul12);
        double dec_juli = Sun.Vsop87.apparentDeclination(jd_juli+pukul12);

        double pergeseran_waktu_mei = (4*(bujur_refrensi-bujurKB)-(eot_mei*60))/60;
        double pergeseran_waktu_juli = (4*(bujur_refrensi-bujurKB)-(eot_juli*60))/60;
        double waktu_wib_mei = (12+pergeseran_waktu_mei)+(zona_waktu-3);
        double waktu_wib_juli = (12+pergeseran_waktu_juli)+(zona_waktu-3);
        System.out.println("Yaum Rashdul Kiblat");
        System.out.println("Pada tahun "+tahun);
        System.out.println("Kabisat = "+kabisat);
        printDms("Eot Mei Pk 9 ut",eot_mei);
        printDms("Deklinasi Mei",dec_mei);
        printDms("Eot Juli Pk 9 ut",eot_juli);
        printDms("Deklinasi Juli",dec_juli);
        printDms("Lintang Ka'bah",lintangKB);
        printHmssss("Pergeseran Waktu Mei",pergeseran_waktu_mei);
        printHmssss("Pergeseran Waktu Juni",pergeseran_waktu_juli);

        print_ddd_ppp_DDMMMYYYY_hhmmss(jd_mei+(waktu_wib_mei/24));
        print_ddd_ppp_DDMMMYYYY_hhmmss(jd_juli+(waktu_wib_juli/24));

//        jd_terdekat=Konversi.kmJd(1,1,tahun,12-3);
//        print_ddd_ppp_DDMMMYYYY_hhmmss(jd_terdekat);
//        selisikDeklinasi(1,lintangKB);
////        selisikDeklinasi(interval_perjam/24,lintangKB);
//        print_ddd_ppp_DDMMMYYYY_hhmmss(jd_terdekat);

    }

    static void selisikDeklinasi(double interval,double lintang) {

        while (true) {
            double jd_sebelum = jd_terdekat - interval;
            double jd = jd_terdekat;
            double jd_sesudah = jd_terdekat + interval;

            double sebelum_kontak = Sun.AstroAlgo.apparentDeclination(jd_sebelum);
            double saat_kontak = Sun.AstroAlgo.apparentDeclination(jd); // nilai lintang  gerhana saat kontak
            double sesudah_kontak = Sun.AstroAlgo.apparentDeclination(jd_sesudah);
            double val1=lintang-sebelum_kontak;
            double val2=lintang-saat_kontak;
            double val3=lintang-sesudah_kontak;


            if (saat_kontak>0){
                printDms("val1",val1);
                printDms("val2",val2);
                printDms("val3",val3);
              //  System.out.println(jd_km(jd)+"\t"+"Deklinasi= "+dmsMili(saat_kontak)+"\t"+"Lintang= "+dmsMili(lintang)+"\t"+"Selisih= "+String.format(Locale.JAPAN,"%.9f",val2));
                if (!isNegative(val1)&&isNegative(val2)&&isNegative(val3)) {
                jd_terdekat = jd_sebelum;
                if (isMilisecond(interval)) jd_terdekat = jd; //bila fase trackingya sepserseribu detik maka yang diambil bukan jd sebelum tapi jd saat terjadi kontak
                break;
//                System.out.printf(format,jd_km(jd_sebelum),dmsMiliElo(calcKontak(jd_sebelum)[2]));
//                System.out.printf(format,jd_km(jd),dmsMiliElo(calcKontak(jd)[2]));
//                System.out.printf(format,jd_km(jd_sesudah),dmsMiliElo(calcKontak(jd_sesudah)[2]));
            }
            }
            jd_terdekat += interval;
        }
    }

    static  boolean isMilisecond(double val){
        return val <= interval_perMilidetik / 24;

    }

    static  boolean isNegative(double val){
        return val<0;
    }


}
