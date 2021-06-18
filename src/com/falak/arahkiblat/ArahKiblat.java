package com.falak.arahkiblat;

import com.falak.Konversi;
import com.falak.waktusalat.Salat;

import static java.lang.Math.*;

public class ArahKiblat {
     double lintang;
     double bujur;
     double lintang_kb;
     double bujur_kb;
     int zona_waktu;

    private double derajat_lintangKB=21;
    private double menit_lintangKB=25;
    private double detik_lintangKB=21.08;

    private double derajat_bujurKB=39;
    private double menit_bujurKB=49;
    private double detik_bujurKB=34.25;

    //KOORDINAT KA'BAH DIAMBIL DARI PERSATUAN DATABASE GNSS (GLOBAL NAVIGATION SATELLITE SYSTEM) internasional, bukan hanya Gps saja!


    private  boolean segitigaBola;
    private  boolean vincenty;
    private  boolean elipsoid;


    public ArahKiblat(double lintang_tempat, double bujur_tempat){
        this.lintang= lintang_tempat;
        this.bujur= bujur_tempat;
        bujur_kb=Konversi.dmsKeDesimal(derajat_bujurKB,menit_bujurKB,detik_bujurKB);
        lintang_kb=Konversi.dmsKeDesimal(derajat_lintangKB,menit_lintangKB,detik_lintangKB);
    }
    public ArahKiblat(double lintang_tempat, double bujur_tempat,int zona_waktu){
        this.lintang= lintang_tempat;
        this.bujur= bujur_tempat;
        this.zona_waktu=zona_waktu;
        bujur_kb=Konversi.dmsKeDesimal(derajat_bujurKB,menit_bujurKB,detik_bujurKB);
        lintang_kb=Konversi.dmsKeDesimal(derajat_lintangKB,menit_lintangKB,detik_lintangKB);
    }

    public ArahKiblat(int zona_waktu){
        this.zona_waktu=zona_waktu;
        bujur_kb=Konversi.dmsKeDesimal(derajat_bujurKB,menit_bujurKB,detik_bujurKB);
        lintang_kb=Konversi.dmsKeDesimal(derajat_lintangKB,menit_lintangKB,detik_lintangKB);
    }
    public ArahKiblat(){
        bujur_kb=Konversi.dmsKeDesimal(derajat_bujurKB,menit_bujurKB,detik_bujurKB);
        lintang_kb=Konversi.dmsKeDesimal(derajat_lintangKB,menit_lintangKB,detik_lintangKB);
    }

    void setKoordinat_kakbah(double lintang_kb,double bujur_kb){
        this.lintang_kb=lintang_kb;
        this.bujur_kb = bujur_kb;
    }

    void  setLintang(int D, int M , double S){
        lintang=Konversi.dmsKeDesimal(D,M,S);
    }
    void  setBujur(int D, int M , double S){
        bujur=Konversi.dmsKeDesimal(D,M,S);
    }

    void  setLintang_kb(int D, int M , double S){
        lintang_kb=Konversi.dmsKeDesimal(D,M,S);
    }
    void  setBujur_kb(int D, int M , double S){
        bujur_kb=Konversi.dmsKeDesimal(D,M,S);
    }

    public double getHasil_UTSB(){
        double hasil=0;
        if (segitigaBola){
            hasil= SegitigaBola.UTSB(this);
        }else if(vincenty){
            hasil=Vincenty.UTSB(this);

        }else if(elipsoid){
            hasil= Elipsoid.UTSB(this);
        }else hasil= SegitigaBola.UTSB(this);

        return hasil;
    }
    double getHasil_UB(){
        double hasil=0;
        if (segitigaBola){
            hasil= SegitigaBola.UB(this);
        }else if(vincenty){
            hasil= Double.NaN;
        }else if(elipsoid){
            hasil= Double.NaN;
        }

        return hasil;


    }
    double getHasil_BU(){
        double hasil=0;
        if (segitigaBola){
            hasil= SegitigaBola.BU(this);
        }else if(vincenty){
            hasil= Double.NaN;
        }else if(elipsoid){
            hasil= Double.NaN;
        }

        return hasil;

    }

    /**
     * bila method ini tidak di-set maka secara otomatis akan memeilih metode hisab default yaitu metode segitiga bola.
     */
    public MetodeHisab setMetodeHisab(){ //Methods
        return new MetodeHisab();
    }

    public class MetodeHisab { //class in a class
        public void segitigaBola(){
            segitigaBola=true;
            vincenty=false;
            elipsoid=false;
        }
        public void  vincenty(){
            segitigaBola=false;
            vincenty=true;
            elipsoid=false;
        }
        public void  elipsoid(){
            segitigaBola=false;
            vincenty=false;
            elipsoid=true;
        }

    }






}
