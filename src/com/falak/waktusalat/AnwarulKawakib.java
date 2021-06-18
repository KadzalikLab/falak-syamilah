package com.falak.waktusalat;

import static java.lang.Math.*;

public class AnwarulKawakib {
    static  double subuh(Salat data){

        return mainHIsab(data)[1];
    }
    static  double terbit(Salat data){

        return mainHIsab(data)[2];
    }
    static  double dluha(Salat data){

        return mainHIsab(data)[3];
    }
    static  double dzuhur(Salat data){

        return mainHIsab(data)[4];
    }
    static  double asar(Salat data){

        return mainHIsab(data)[5];
    }
    static  double maghrib(Salat data){

        return mainHIsab(data)[6];
    }
    static  double isya(Salat data){

        return mainHIsab(data)[7];
    }

    private static double[] mainHIsab(Salat data) {
        double tanggal, bulan, tahun,ihtiyat,zona_waktu,tinggi,bujur;
        tanggal = data.tanggal;
        bulan = data.bulan;
        tahun = data.tahun;
        ihtiyat=data.ihtiyat;
        double ihtiyatTerbit = data.ihtiyatTerbit;
        zona_waktu = data.zona_waktu;
        tinggi = data.tinggiLokasi;
        bujur=data.bujur;
        double lintang = data.lintang;
        int A = (int) (tahun/100.0);
        double B = 2 + (A/4.0)-A;
        int AA =(int)( 365.25*tahun);
        int BB = (int)(30.60001*(bulan+1));
        double julianday12 = 1720994.5+AA+BB+tanggal+B+(12/24.0);
        double jdl = julianday12-zona_waktu/24;
        double sdl = 2 * 3.14159265359 * (jdl-2451545)/365.25;
        double dmo = 0.37877+23.264*sin(toRadians(57.297*sdl-79.547));
        double dmi = dmo+0.3812*sin(toRadians(2*57.297*sdl-82.682));
        double dm = dmi+0.17132*sin(toRadians(3*57.297*sdl-59.722));
        double u = (jdl-2451545)/36525;
        double lo = ((280.46607+36000.7698*u));
        lo=toRadians(lo);
        double e1=1789+237*u;
        double e2=7146-62*u;
        double e3=9934-14*u;
        double e4=-1*e1*sin(lo)-e2*cos(lo)+e3*sin(2*lo);
        double e5=e4-(29+5*u)*cos(2*lo)+(74+10*u)*sin(3*lo);
        double e6 = (320-4*u)*cos(3*lo)-212*sin(4*lo);
        double dmr = toRadians(dm);
        double ltr = toRadians(lintang);


        double pw = ((e5+e6)/1000)/60;
        double mw = cos(dmr)*cos(ltr);
        double sa2 = abs(lintang-dm);
        double sa1 = sin((atan(1/(1+tan(toRadians(sa2))))));
        double sa = toDegrees(acos((sa1-sin(dmr)*sin(ltr))/mw));
        double sm1 = sin(toRadians(-0.8333-0.0347*sqrt(tinggi)));
        double swm = toDegrees(acos((sm1-sin(dmr)*sin(ltr))/mw));
        double swi = toDegrees(acos((sin(toRadians(data.sudutIsya))-sin(ltr)*sin(dmr))/mw));
        double sws =toDegrees(acos((sin(toRadians(data.sudutSubuh))-sin(ltr)*sin(dmr))/mw));
        double swd = toDegrees(acos((-tan(ltr)*tan(dmr)+sin(toRadians(data.sudutDluha))/mw)));

        double dz = 12+zona_waktu-bujur/15 - pw;
        double dzuhur = dz+(4/60.0);
        double asar = dz + (sa/15)+ihtiyat;
        double  maghrib= dz + (swm/15)+ihtiyat;
        double  isya = dz + (swi/15)+ihtiyat;
        double  subuh= dz - (sws/15)+ihtiyat;
        double  terbit= dz - (swm/15)-ihtiyatTerbit;
        double  dluha = dz - (swd/15)+ihtiyat;

        return new double[]{0, subuh, terbit, dluha, dzuhur, asar, maghrib, isya};
    }
}
