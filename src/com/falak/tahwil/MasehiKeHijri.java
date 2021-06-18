package com.falak.tahwil;
import com.falak.Konversi;
import com.falak.Mathf;

import static  com.falak.Print.*;

public class MasehiKeHijri {
    public static void main(String[] args) {
        int tanggal = 8;
        int bulan = 8;
        int tahun = 2021;
        boolean kabisat = Mathf.isLeapYear(tahun);
        System.out.println(kabisat);
        int mo = bulan-1;
        double ma = (tahun-1)/4.0;
        int mb = (int)ma;
        double mc = ma-mb;
        int a = mb*1461;
        int b = (int)(mc*4*365);
        int c =jumlahHariMasehi(mo,kabisat);
        int e = -13;
        int f = -227016;
        int jth = a+b+c+tanggal+e+f;
        print("MO",mo);
        print("MA",ma);
        print("MB",mb);
        print("MC",mc);
        print("A",a);
        print("B",b);
        print("C",c);
        print("E",e);
        print("F",f);
        print("JTH",jth);

        double me = jth/10631.0;
        int mf = (int)me;
        double mg = me-mf;
        int i = mf*30;
        double j = (mg*10631)/354;
        int mh = (int)j;
        double mi = j-mh;
        int k = (int)Math.round(mi*354);
        int l = kabisatTerlewati(mh);
        int jh = k-l;
        boolean isLeapYearHijri;
        int tahun_naqish=mh+i;
        isLeapYearHijri= Mathf.isLeapYearHijri(tahun_naqish);
        if (jh<=0) {
            System.out.println("Negatif"+true);
            if (isLeapYearHijri) jh += 355;
            else jh+=354;
            mh-=1;
        }

        print("ME",me);
        print("MF",mf);
        print("MG",mg);
        print("I",i);
        print("J",j);
        print("K",k);
        print("L",l);
        print("JH",jh);
        int op = jumlahHariBulanHijri(jh);
        int or = nomorBulanHijri(op);
        int tahunHijri = i+mh+1;
        int bulanHijri = or+1;
        int tanggalHijri = jh-op;


        print("OP",op);
        print("OR",or);
        print("Tahun Hijri",tahunHijri);
        print("Bulan Hijri",bulanHijri);
        print("Tanggal Hijri",tanggalHijri);
        System.out.println(tanggalHijri+" "+ bulanHijri +" "+tahunHijri+" H");
        System.out.println(tanggalHijri+" "+ Konversi.namaBulanHijri(bulanHijri)+" "+tahunHijri+" H");

    }

    static int jumlahHariMasehi( int mo,boolean kabisat){
        int umurHari=0; // if (mo==0) umurHari = 0;

        if (mo==1) umurHari = 31;
        if (kabisat){
            if (mo==2)umurHari=60;
            else if (mo==3) umurHari = 91;
            else if (mo==4) umurHari = 121;
            else if (mo==5) umurHari = 152;
            else if (mo==6) umurHari = 182;
            else if (mo==7) umurHari = 213;
            else if (mo==8) umurHari = 244;
            else if (mo==9) umurHari = 274;
            else if (mo==10) umurHari = 305;
            else if (mo==11) umurHari = 335;
            else if (mo==12) umurHari = 366;

        }else {
            if (mo==2)umurHari=59;
            else if (mo==3) umurHari = 90;
            else if (mo==4) umurHari = 120;
            else if (mo==5) umurHari = 151;
            else if (mo==6) umurHari = 181;
            else if (mo==7) umurHari = 212;
            else if (mo==8) umurHari = 243;
            else if (mo==9) umurHari = 273;
            else if (mo==10) umurHari = 304;
            else if (mo==11) umurHari = 334;
            else if (mo==12) umurHari = 365;
        }

        return umurHari;
    }

    static int jumlahHariBulanHijri(int jh){
        int hasil = 0;
        if (jh>=0&&jh<=30)hasil=0;
        else if (jh>=31&&jh<=59)hasil=30;
        else if (jh>=60&&jh<=89)hasil=59;
        else if (jh>=90&&jh<=118)hasil=89;
        else if (jh>=119&&jh<=148)hasil=118;
        else if (jh>=149&&jh<=177)hasil=148;
        else if (jh>=178&&jh<=207)hasil=177;
        else if (jh>=208&&jh<=236)hasil=207;
        else if (jh>=237&&jh<=266)hasil=236;
        else if (jh>=267&&jh<=295)hasil=266;
        else if (jh>=296&&jh<=325)hasil=295;
        else if (jh>=326&&jh<=355)hasil=325;

//        if (jh>=0&&jh<=30) {
//            if (kabisatHijri) hasil = 355;
//            else hasil = 354;
//        }

//        else if (jh>=&&jh<=)hasil=;

        return hasil;
    }

    static  int nomorBulanHijri(int op){
        int hasil = 0;

        if (op==0)hasil=0;
        else if (op==30)hasil=1;
        else if (op==59)hasil=2;
        else if (op==89)hasil=3;
        else if (op==118)hasil=4;
        else if (op==148)hasil=5;
        else if (op==177)hasil=6;
        else if (op==207)hasil=7;
        else if (op==236)hasil=8;
        else if (op==266)hasil=9;
        else if (op==295)hasil=10;
        else if (op==325)hasil=11;
        else if (op==354||op==355)hasil=12;
        return hasil;
    }

    static  int kabisatTerlewati(int mh){
        int hasil =0;
        switch (mh) {
            case 1:
                hasil = 0;
                break;

            case 2:
            case 3:
            case 4:
                hasil = 1;
                break;

            case 5:
            case 6:
                hasil = 2;
                break;

            case 7:
            case 8:
            case 9:
                hasil = 3;
                break;

            case 10:
            case 11:
            case 12:
                hasil = 4;
                break;

            case 13:
            case 14:
                hasil =5 ;
                break;

            case 15:
            case 16:
            case 17:
                hasil = 6;
                break;

            case 18:
            case 19:
            case 20:
                hasil = 7;
                break;
            case 21:
            case 22:
            case 23:
                hasil = 8;
                break;

            case 24:
            case 25:
                hasil = 9;
                break;
            case 26:
            case 27:
            case 28:
                hasil = 10;
                break;
            case 29:
            case 30:
                hasil = 11;
                break;
        }
        return hasil;
    }








}
