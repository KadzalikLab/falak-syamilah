package com.falak.gerhana.bulan;

import com.falak.Konversi;
import com.falak.Moon;
import com.falak.Sun;
import static java.lang.Math.*;

import java.util.Locale;

public class EphemerisDepag {
    public static void main(String[] args) {
        double tanggal=15;
        double bulan=6;
        int tahun=2011;
        double timezone=7;

        double jam=0;
        double menit=0;
        double detik=0;
        int jam_fibMax=0;

        double fibMax=0;

        for (int i=0; i<=24;i++){
            double jd0= Konversi.masehiKeJd(tanggal,bulan,tahun,i-1);
            double jd1= Konversi.masehiKeJd(tanggal,bulan,tahun,i);
            double jd2= Konversi.masehiKeJd(tanggal,bulan,tahun,i+1);

            double fib0= Moon.AstroAlgo.diskIlluminatedFraction(jd0);
            double fib1= Moon.AstroAlgo.diskIlluminatedFraction(jd1);
            double fib2= Moon.AstroAlgo.diskIlluminatedFraction(jd2);
            // System.out.println("Jam "+i+" | Fib: "+String.format(Locale.JAPAN,"%.5f",fib1));
            if(fib1>fib0&&fib1>fib2){
                fibMax=fib1;
                jam_fibMax=i;
                System.out.println("Jam "+jam_fibMax+"\nFib: "+String.format(Locale.JAPAN,"%.5f",fibMax));
                break;
            }


        }

        double jd_jamFibMax=Konversi.masehiKeJd(tanggal,bulan,tahun,jam_fibMax);
        double jd_jamFibMaxS2=Konversi.masehiKeJd(tanggal,bulan,tahun,jam_fibMax+1);


//        double alb_jamFibS1=Moon.AstroAlgo.apparentGeocentricLongitude(jd_jamFibMax);
//        double alb_jamFibS2=Moon.AstroAlgo.apparentGeocentricLongitude(jd_jamFibMaxS2);
//        double sb=abs(alb_jamFibS1-alb_jamFibS2);
//
//        double elm_jamFibS1=Sun.AstroAlgo.apparentGeocentricLongitude(jd_jamFibMax);
//        double elm_jamFibS2=Sun.AstroAlgo.apparentGeocentricLongitude(jd_jamFibMaxS2);
//        double sm=abs(elm_jamFibS1-elm_jamFibS2);

        double alb_jamFibS1=Konversi.dmsKeDesimal(264,14,59);
        double alb_jamFibS2=Konversi.dmsKeDesimal(264,49,38);
        double sb=abs(alb_jamFibS1-alb_jamFibS2);

        double elm_jamFibS1=Konversi.dmsKeDesimal(84,22,56);
        double elm_jamFibS2=Konversi.dmsKeDesimal(84,25,19);
        double sm=abs(elm_jamFibS1-elm_jamFibS2);

        printDms("Alb "+jam_fibMax,alb_jamFibS1);
        printDms("Alb "+(jam_fibMax+1),alb_jamFibS2);
        printDms("Sabaq Bulan ",sb);

        printDms("ELM "+jam_fibMax,elm_jamFibS1);
        printDms("ELM "+(jam_fibMax+1),elm_jamFibS2);
        printDms("Sabaq Matahari ",sm);

        double var_temp;
        if (alb_jamFibS1<180)var_temp=alb_jamFibS1+360;
        else var_temp=alb_jamFibS1-180;
        double waktu_istiqbal=(elm_jamFibS1-var_temp)/(sb-sm)+jam_fibMax;
        printDms("Waktu Istiqbal",waktu_istiqbal);

        double bcS1=Konversi.dmsKeDesimal(0,4,24);
        double bcS2=Konversi.dmsKeDesimal(0,7,36);
//        double bcS1=Moon.AstroAlgo.apparentGeocentricLatitude(jd_jamFibMax);
//        double bcS2=Moon.AstroAlgo.apparentGeocentricLatitude(jd_jamFibMaxS2);

        double pecahamJamIstiqbal=waktu_istiqbal%1;
        double bc = bcS1-(bcS1-bcS2)*pecahamJamIstiqbal;
        printDms("lat bulan "+jam_fibMax,bcS1);
        printDms("lat bulan "+(jam_fibMax+1),bcS2);
        printDms("Men,Det Istiqbal",pecahamJamIstiqbal);
        printDms("Appr lat Bulan",bc);

        String kondisi="";
        double batas3=Konversi.dmsKeDesimal(1,36,38);
        double batas2=Konversi.dmsKeDesimal(1,26,19);
        double batas1=Konversi.dmsKeDesimal(1,3,46);
        double batas0=Konversi.dmsKeDesimal(0,53,26);

        if (bc>batas3)kondisi="Tidak akan terjadi gerhana Bulan";
        else  if(bc<batas3&&bc>batas2)kondisi="Mungkin terjadi gerhana Bulan";
        else if(bc<batas2&&bc>batas1)kondisi="Terjadi gerhana bulan Penumbra";
        else if(bc<batas1&&bc>batas0)kondisi="Terjadi gerhana Bulan Penumbra & mungkin Umbra";
        else if (bc<batas0)kondisi="Terjadi gerhana Bulan Umbra";

        System.out.println("\nKarena nilai beta c "+Konversi.dmsMili(bc)+" Maka "+ kondisi);

        double sdoS1=Sun.AstroAlgo.angularSemiDiameter(jd_jamFibMax);
        double sdoS2=Sun.AstroAlgo.angularSemiDiameter(jd_jamFibMaxS2);
        double sdo= sdoS1-(sdoS1-sdoS2)*pecahamJamIstiqbal;
        printDms("sdo"+jam_fibMax,sdoS1);
        printDms("sdo"+(jam_fibMax+1),sdoS2);
        printDms("sdo",sdo);

//        printDms(" "+jam_fibMax,);
//        printDms(""+jam_fibMax+1,);
//        printDms("",);


        double hpcS1=Moon.AstroAlgo.equatorialHorizontalParallax(jd_jamFibMax);
        double hpcS2=Moon.AstroAlgo.equatorialHorizontalParallax(jd_jamFibMaxS2);
        double hpc= hpcS1-(hpcS1-hpcS2)*pecahamJamIstiqbal;
        double pbk=hpc*0.998340;

        printDms("hpc"+jam_fibMax,hpcS1);
        printDms("hpc"+(jam_fibMax+1),hpcS2);
        printDms("hpc",hpc);
        printDms("pbk",pbk);

        double sdck=asin((0.2725076*sin(hpc)));
        printDms("Sdck",sdck);

        double tgdoS1=Sun.AstroAlgo.trueGeocentricDistance(jd_jamFibMax);
        double tgdoS2=Sun.AstroAlgo.trueGeocentricDistance(jd_jamFibMaxS2);
        double tgdo= tgdoS1-(tgdoS1-tgdoS2)*pecahamJamIstiqbal;

        print7digit("Tgdo"+jam_fibMax,tgdoS1);
        print7digit("Tgdo"+(jam_fibMax+1),tgdoS2);
        print7digit("Tgdo",tgdo);

        double hpo= (8.794/3600)/tgdo; //horizontal parallax matahari
        double f1 = 1.02*(pbk+sdo+hpo); // jari-jari bayangan semu bumi
        double f2 = 1.02*(pbk-sdo+hpo); // jari-jari bayangan inti bumi
        printDms("Hpo",hpo);
        printDms("f1",f1);
        printDms("f1",f2);

        String jenisGerhana="";
        double bcAbs=abs(bc);
        if (f1>(bcAbs+sdck)&&bcAbs>(f2+sdck))jenisGerhana="Gerhana bulan semu total";
        if (bcAbs<(f1+sdck)&&f1<(bcAbs+sdck))jenisGerhana="Gerhana semu sebagian";
        if (bcAbs<(f2+sdck))jenisGerhana+="\ntidak terjadi Gerhana bulan umbra";
        if (f2>(bc+sdck))jenisGerhana="Gerhana bulan total";
        if (bcAbs<(f2+sdck)&&f2<(bcAbs+sdck))jenisGerhana="Gerhana bulan umbra sebagian";
        System.out.println(jenisGerhana);

        bc=0.086388888;
        double h=toDegrees(asin(sin(toRadians(bc))/sin(toRadians(5))));
        printDms("H",h);
        double u = toDegrees(atan(tan(toRadians(bc)/sin(toRadians(h)))));
        printDms("U",u);
        double z = toDegrees(asin(sin(toRadians(u))*sin(toRadians(h))));
        printDms("Z",z);
        double k = cos(toRadians(z))*(sb-sm)/cos(toRadians(u));
        double p = f1+sdck;
        double q = f2+sdck;
        double r = f2-sdck;
        double b = toDegrees(acos(cos(toRadians(bc))/cos(toRadians(z))));
        double c = toDegrees(acos(cos(toRadians(p))/cos(toRadians(z))));
        double d = toDegrees(acos(cos(toRadians(q))/cos(toRadians(z))));
        double e = toDegrees(acos(cos(toRadians(r))/cos(toRadians(z))));
        printDms("K",k);
        printDms("P",p);
        printDms("Q",q);
        printDms("R",r);
        printDms("B",b);
        printDms("C",c);
        printDms("D",d);
        printDms("E",e);
//        printDms("",);

        if (r<z)e = 0;
        double t,t1,t2,t3;
        t = b/k; t1 = c/k; t2 = d/k; t3 = e/k;
        double awal_penumbra,akhir_penumbra,awal_umbra,akhir_umbra,awal_total,akhir_total,puncak_gerhana;
        double gmt=7;
        double to;
        double jdToPlus1Menit=jd_jamFibMax+((1/60.0)/24);
        double alUtkTo = Moon.AstroAlgo.apparentGeocentricLatitude(jdToPlus1Menit);
        boolean mengecil=abs(alUtkTo)<abs(alb_jamFibS1);
        if (mengecil)to=jam_fibMax+t+Konversi.dmsKeDesimal(0,1,7);
        else to=(jam_fibMax-t)+Konversi.dmsKeDesimal(0,1,7);
        System.out.println(mengecil);
        System.out.println(jam_fibMax);
        System.out.println(t);
        awal_penumbra=to-t1;
        awal_umbra = to-t2;
        awal_total = to-t3;
        puncak_gerhana=to;
        akhir_total = to+t3;
        akhir_umbra = to+t2;
        akhir_penumbra=to+t1;

        printHms("awal_penumbra",awal_penumbra);
        printHms("awal_umbra",awal_umbra);
        printHms("awal_total",awal_total);
        printHms("puncak_gerhana",puncak_gerhana);
        printHms("akhir_total",akhir_total);
        printHms("akhir_umbra",akhir_umbra);
        printHms("akhir_penumbra",akhir_penumbra);


    }
    static void printDms(String teks, double dms_value){
        String format = "%-17s%5s%n";
        System.out.printf(format,teks,":"+ Konversi.dmsMili(dms_value));

    }
    static void printHms(String teks, double dms_value){
        String format = "%-17s%5s%n";
        System.out.printf(format,teks,":"+ Konversi.hmsMili(dms_value));

    }


    static void print7digit(String teks, double value){
        String format = "%-17s%5s%n";
        System.out.printf(format,teks,":"+String.format(Locale.JAPAN,"%.7f",value));

    }




}

