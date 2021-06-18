package com.falak.waktusalat;

import static java.lang.Math.*;

public class IrsyadulMurid {
    static double subuh(Salat data) {

        return mainHIsab(data)[1];
    }

    static double terbit(Salat data) {

        return mainHIsab(data)[2];
    }

    static double dluha(Salat data) {

        return mainHIsab(data)[3];
    }

    static double dzuhur(Salat data) {

        return mainHIsab(data)[4];
    }

    static double asar(Salat data) {

        return mainHIsab(data)[5];
    }

    static double maghrib(Salat data) {

        return mainHIsab(data)[6];
    }

    static double isya(Salat data) {

        return mainHIsab(data)[7];
    }

    private static double[] mainHIsab(Salat data) {
        double tanggal, bulan, tahun;
        tanggal = data.tanggal;
        bulan = data.bulan;
        tahun = data.tahun;
        double lintang = data.lintangRad;
        int y100 = (int) (tahun / 100);
        int y4 =  (y100 / 4);
        double b = 2 - y100 + y4;
        if (bulan <= 2) {
            bulan += -12;
            tahun -= 1;
        }
        double jd = (int) (365.25 * (tahun + 4716)) + (int) (30.6001 * (bulan + 1)) + tanggal + b - 1524.5;
        //System.out.println(tanggal+" "+bulan+" "+tahun);
        double t = (jd - 2451545) / 36525;
        double s = 280.46645 + 36000.76983 * t;
        double m = 357.5291 + 35999.0503 * t;
        double n = 125.04 - 1934.136 * t;
        double k1 = (17.264 / 3600) * sin(toRadians(n)) + (0.206 / 3600) * sin(toRadians(2 * n));
        double k2 = (-1.264 / 3600) * sin(toRadians(2 * s));
        double r1 = (9.23 / 3600) * cos(toRadians(n)) - (0.09 / 3600) * cos(toRadians(2 * n));
        double r2 = (0.548 / 3600) * cos(toRadians(2 * s));
        double q = 23.43929111 + r1 + r2 - (46.815 / 3600) * t;
        double e = (6898.06 / 3600) * sin(toRadians(m)) + (72.095 / 3600) * sin(toRadians(2 * m)) + (0.966 / 3600) * sin(toRadians(3 * m));
        s = s + e + k1 + k2 - (20.47 / 3600);
        double d = toDegrees(asin(sin(toRadians(s)) * sin(toRadians(q))));
        e = (-1.915 * sin(toRadians(m)) + -0.02 * sin(toRadians(2 * m)) + 2.466 * sin(toRadians(2 * s)) + -0.053 * sin(toRadians(4 * s))) / 15;
        double sd = 0.267 / (1 - 0.017 * cos(toRadians(m)));


        double tw = e - ((data.zona_waktu * 15) - data.bujur) / 15;
        double dzuhur = 12 - tw + (data.ihtiyat / 60.0);
        double h = toDegrees(atan(1 / (tan(abs(lintang - toRadians(d))) + 1)));
        double f = -tan(lintang) * tan(toRadians(d));
        double g = cos(lintang) * cos(toRadians(d));
        double asar = dzuhur + toDegrees(acos(f + sin(toRadians(h)) / g)) / 15;
        double dip = (1.76 / 60) * sqrt(data.tinggiLokasi);
        h = -(sd + (34.5 / 60) + dip) - 0.0024;
        double maghrib = dzuhur + toDegrees(acos(f + sin(toRadians(h)) / g)) / 15;
        double isya = dzuhur + toDegrees(acos(f + sin(toRadians(data.sudutIsya)) / g)) / 15;
        double subuh = dzuhur - toDegrees(acos(f + sin(toRadians(data.sudutSubuh)) / g)) / 15;
        double terbit = dzuhur - toDegrees(acos(f + sin(toRadians(h)) / g)) / 15;
        double dluha = dzuhur - toDegrees(acos(f + sin(toRadians(data.sudutDluha)) / g)) / 15;
        return new double[]{0, subuh, terbit, dluha, dzuhur, asar, maghrib, isya};
    }

}
