package com.falak.gerhana.bulan;

import static com.falak.Print.*;
import static java.lang.Math.*;

public class IrsyadulMurid {
    public static void main(String[] args) {
        double bulan_hijri=4, tahun_hijri=1444;
        double y7 =tahun_hijri+(bulan_hijri*29.53)/354.3671;
        double y8 =(int)((y7-1410)*12)+0.5;
        double y9 = y8/1200;
        double y10=2447740.652+29.53058868*y8+0.0001178*(y9*y9);

        double u11 =(((207.9587074+29.10535608*y8+-0.0000333*(y9*y9))/360)-((int)((207.9587074+29.10535608*y8+-0.0000333*(y9*y9))/360)))*360;
        double u12 =(((111.1791307+385.81691806*y8+0.0107306*(y9*y9))/360)-((int)((111.1791307+385.81691806*y8+0.0107306*(y9*y9))/360)))*360;
        double u13 =(((164.2162296+390.67050646*y8+-0.0016528*(y9*y9))/360)-((int)((164.2162296+390.67050646*y8+-0.0016528*(y9*y9))/360)))*360;
        double u14  =(0.1734-0.000393*y9)*sin(toRadians(u11));
        double u15 = 0.0021*sin(toRadians(2*u11));
        double u16 = -0.4068*sin(toRadians(u12));
        double u17 =  0.0161*sin(toRadians(2*u12));
        double u18 = -0.0051*sin(toRadians(u11+u12));
        double u19 = -0.0074*sin(toRadians(u11-u12));
        double u20 = -0.0104*sin(toRadians(2*u13));
        double u21 = u14+u15+u16+u17+u18+u19+u20;

        printDms(u11);
        printDms(u12);
        printDms(u13);
        printDms(u14);
        printDms(u15);
        printDms(u16);
        printDms(u17);
        printDms(u18);
        printDms(u19);
        printDms(u20);
        printDms(u21);
        double y22 = y10+0.5 + u21;
        double y22_WD = y22;
        double u23 = (int)((y22-(int)(y22))*1000)/1000.0*24;
        double u24 = u23+7;
        if (u24>=24) {
            y22_WD += 1;
            u24%=24;
        }

        printHms("Pukul Istiqbal UT",u23);
        printHms("Pukul Istiqbal WD",u24);
        print_ddd_ppp_DDMMMYYYY(y22);
        print_ddd_ppp_DDMMMYYYY(y22_WD);

        double u38 = -0.0048*cos(toRadians(u11));
        double u39 = 0.002*cos(toRadians(2*u11));
        double u40 = -0.3283*cos(toRadians(u12));
        double u41 = -0.006*cos(toRadians(u11+u12));
        double u42 = 0.0041*cos(toRadians(u11-u12));
        double u43 = 5.19595+(u38+u39+u40+u41+u42);
        printDms(u43);

        double u44 = 0.0024*sin(toRadians(2*u11));
        double u45 = -0.039*sin(toRadians(u12));
        double u46 =0.0115*sin(toRadians(2*u12));
        double u47 = -0.0073*sin(toRadians(u11+u12));
        double u48 = -0.0067*sin(toRadians(u11-u12));
        double u49 = 0.0117*sin(toRadians(2*u13));
        double u50 = 0.207*sin(toRadians(u11))+(u44+u45+u46+u47+u48+u49);
        printDms(u44);
        printDms(u45);
        printDms(u46);
        printDms(u47);
        printDms(u48);
        printDms(u49);
        printDms(u50);
        double u51 = u43*sin(toRadians(u13))+u50*cos(toRadians(u13));
        double u52 = 0.0046*cos(toRadians(u11));
        double u53 = -0.0182*cos(toRadians(u12));
        double u54 = 0.0004*cos(toRadians(2*u12));
        double u55 = -0.0005*cos(toRadians(u11+u12));
        double u56 = 0.0059+(u52+u53+u54+u55);
        printDms(u56);

        double u57 = 1.0129-u56;
        double u58 = 0.4679-u56;
        double u59 = 0.5458+0.04*cos(toRadians(u12));
        double u60 = 60/u59*((sqrt((u57*u57)-(u51*u51))))/60;
        double u61 = 60/u59*((sqrt((u58*u58)-(u51*u51))))/60;
        double u62 = u24-u60;
        double u63 = u24-u61;
        double u64=0;
        double u65 = u24+u61;
        double u66 = u24+u60;
        double y67 = (1.0129-u56-abs(u51))/0.545;
        double u68 = (1.0129-u56-abs(u51))/0.545*12;


        printDms(u57);
        printDms(u58);
        printDms(u59);
        printDms(u60);
        printDms(u61);
        printDms(u62);
        printDms(u63);
        printDms(u64);
        printDms(u65);
        printDms(u66);
        System.out.println(y67);
        printDms(u68);




//        System.out.println(System.lineSeparator());
//        for (int i = 57; i<69;i++){
//            System.out.println("printDms(u"+i+");");
//        }

        System.out.println("Kadzalik Lab \nGerhana Bulan Metode Irsyadul Murid\n");
        print_ddd_ppp_DDMMMYYYY(y22_WD);

        printHms("Awal Gerhana",u62%24,"WIB");
        printHms("Awal Total",u63%24,"WIB");
        printHms("Puncak Gerhana",u24%24,"WIB");
        printHms("Akhir Total",u65%24,"WIB");
        printHms("Akhir Gerhana",u66%24,"WIB");
        printDigit("Magnitudo",y67,9);



    }



}
