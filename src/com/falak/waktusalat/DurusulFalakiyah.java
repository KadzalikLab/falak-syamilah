package com.falak.waktusalat;

import com.falak.Konversi;
import static com.falak.Print.*;
import static java.lang.Math.*;


// SEDANG DALAM PROSES PEMBUATAN!!!!! (belum selesai)
public class DurusulFalakiyah {
    static  double subuh(Salat data){

        return 0;
    }
    static  double terbit(Salat data){

        return 0;
    }
    static  double dluha(Salat data){

        return 0;
    }
    static  double dzuhur(Salat data){

        return 0;
    }
    static  double asar(Salat data){

        return 0;
    }
    static  double maghrib(Salat data){

        return 0;
    }
    static  double isya(Salat data){

        return 0;
    }

    private static double[] hisabUtama(Salat data){
        int tanggal,bulan;
        tanggal =(int) data.tanggal;
        bulan = (int)data.bulan;
        int tafawut = tafawut(bulan);
        int nomorBuruj= nomorBuruj(bulan);
        int ds= tanggal+tafawut;
        if (ds>30){
            ds%=30;
            bulan+=1;
        }
        int bukduDarojat = (tanggal+tafawut+nomorBuruj*30)%360;
        double mailKulli = Konversi.dmsKeDesimal(23,27,0);
        double mailAwal = sin(toRadians(bukduDarojat))*sin(toRadians(mailKulli));
        double lintangR= toRadians(data.lintang);
        double bqutri = sin(lintangR)*sin((mailAwal));
//        mailAwal*=60;


        return new double[]{0,ds,bulan,mailAwal};

    }

    public static void main(String[] args) {
        double tanggal=1;
        double bulan =4;
        double tahun=2021;
        double lintang_derajat=6;
        double lintang_menit = 59;
        double lintang_detik= 0;

        double bujur_derajat=112;
        double bujur_menit=0;
        double bujur_detik=0;
        double lintang= Konversi.dmsKeDesimal(lintang_derajat,lintang_menit,lintang_detik);
        double bujur= Konversi.dmsKeDesimal(bujur_derajat,bujur_menit,bujur_detik);

        double tinggi=65;
        double zona_waktu=7;
        Salat ws =new Salat(tanggal,bulan,tahun,lintang,bujur,zona_waktu,tinggi);
        print("Darojatusyamsi",hisabUtama(ws)[1]);
        printDms("Val Lastest",hisabUtama(ws)[3]);

    }

    private static int tafawut(double bulan){
        int hasil=0;
        switch ((int)bulan){
            case 1:
            case 5:
            case 6:
                hasil=9; // jan, mei, juni tafawut = 9
                break;
            case 2:
            case 4:
                hasil=10;  // feb, apr,  tafawut = 10
                break;
            case 3:
                hasil=8; // maret,   tafawut = 8
                break;
            case 7:
            case 11:
            case 8:
            case 9:
            case 12:
                hasil=7; // juli, nov, agus, sept, desember,   tafawut = 7
                break;
            case 10:
                hasil=6; // oktober,   tafawut = 6
                break;

        }



        return hasil;
    }

    private static int nomorBuruj(double bulan){
        int hasil=0;
        switch ((int)bulan){
            case 1:
                hasil=9;
                break;
            case 2:
                hasil=10;
                break;
            case 3:
                hasil=11; // jan, mei, juni tafawut = 9
                break;
            case 4:
                hasil=0;
                break;
            case 5:
                hasil=1;  // feb, apr,  tafawut = 10
                break;
            case 6:
                hasil=2; // maret,   tafawut = 8
                break;
            case 7:
                hasil=3;
                break;
            case 8:
                hasil=4;
                break;
            case 9:
                hasil=5;
                break;
            case 10:
                hasil=6;
                break;
            case 11:
                hasil=7; // juli, nov, agus, sept, desember,   tafawut = 7
                break;
            case 12:
                hasil=8; // oktober,   tafawut = 6
                break;

        }



        return hasil;
    }
}
