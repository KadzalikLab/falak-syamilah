package com.falak.waktusalat;

import com.falak.Konversi;
import com.falak.ephemeris.Sun;

import static java.lang.Math.toRadians;

public class MakalahKemenag {
    static double gmt_shubuh,gmt_terbit,gmt_dluha, gmt_dzuhur,gmt_ashar,gmt_maghrib,gmt_isya;

    static double subuh(Salat data){
        gmt_shubuh = 28 - data.zona_waktu;

        double jd_shubuh = (Konversi.masehiKeJd(data.tanggal, data.bulan, data.tahun, gmt_shubuh) - 1);

        double dec_subuh = Sun.astroAlgo.apparentDeclination(jd_shubuh);
        double eot_sub = Sun.astroAlgo.equationOfTime(jd_shubuh);

        dec_subuh = Math.toRadians(dec_subuh);


        double sudut_waktu_s = Math.acos(-Math.tan(data.lintangRad) * Math.tan(dec_subuh) + Math.sin(toRadians(data.sudutSubuh)) / Math.cos(data.lintangRad) / Math.cos(dec_subuh));

        sudut_waktu_s = Math.toDegrees(sudut_waktu_s);

        return (12 - eot_sub) - (sudut_waktu_s / 15) + data.kwd + data.ihtiyat;

    }
    static double terbit(Salat data){
        gmt_terbit = 29 - data.zona_waktu;

        double jd_terbit = (Konversi.masehiKeJd(data.tanggal, data.bulan, data.tahun, gmt_terbit) - 1);
        double deklinasi_t = Sun.astroAlgo.apparentDeclination(jd_terbit);
        double eot_t = Sun.astroAlgo.equationOfTime(jd_terbit);
        double sdo_t = Sun.astroAlgo.angularSemiDiameter(jd_terbit);
        double irtifak_t = 0 - 0.575 - sdo_t - data.dip;


        deklinasi_t = Math.toRadians(deklinasi_t);
        irtifak_t = Math.toRadians(irtifak_t);

        double sudut_waktu_ter = Math.acos(-Math.tan(data.lintangRad) * Math.tan(deklinasi_t) + Math.sin(irtifak_t) / Math.cos(data.lintangRad) / Math.cos(deklinasi_t));
        sudut_waktu_ter = Math.toDegrees(sudut_waktu_ter);

        return  (12 - eot_t) - (sudut_waktu_ter / 15) + data.kwd - data.ihtiyatTerbit;
    }
    static double dluha(Salat data){
        gmt_dluha = 30 - data.zona_waktu;


        double jd_dluha = (Konversi.masehiKeJd(data.tanggal, data.bulan, data.tahun,gmt_dluha) - 1);
        double deklinasi_dl = Sun.astroAlgo.apparentDeclination(jd_dluha);
        double eot_dl = Sun.astroAlgo.equationOfTime(jd_dluha);
        deklinasi_dl = Math.toRadians(deklinasi_dl);

        double sudut_waktu_dl = Math.acos(-Math.tan(data.lintangRad) * Math.tan(deklinasi_dl) + Math.sin(toRadians(data.sudutDluha)) / Math.cos(data.lintangRad) / Math.cos(deklinasi_dl));
        sudut_waktu_dl = Math.toDegrees(sudut_waktu_dl);

        return (12 - eot_dl) - (sudut_waktu_dl / 15) + data.kwd + data.ihtiyat;

    }
    static double dzuhur(Salat data){
        gmt_dzuhur = 12 - data.zona_waktu;

        double jd_dzuhur = Konversi.masehiKeJd(data.tanggal, data.bulan, data.tahun, gmt_dzuhur);

        double eot_dz = Sun.astroAlgo.equationOfTime(jd_dzuhur);
        return (12 - eot_dz) + data.kwd + data.ihtiyat;

    }
    static double ashar(Salat data){
        gmt_ashar = 15 - data.zona_waktu;
        double jd_ashar = Konversi.masehiKeJd(data.tanggal, data.bulan, data.tahun, gmt_ashar);
        double deklinasi_a = Sun.astroAlgo.apparentDeclination(jd_ashar);
        double eot_a = Sun.astroAlgo.equationOfTime(jd_ashar);

        double irtifak_a;
        deklinasi_a = Math.toRadians(deklinasi_a);
        irtifak_a = Math.atan(1 / (Math.tan(Math.abs(data.lintangRad - deklinasi_a)) + 1));


        double sudut_waktu_a = Math.acos(-Math.tan(data.lintangRad) * Math.tan(deklinasi_a) + Math.sin(irtifak_a) / Math.cos(data.lintangRad) / Math.cos(deklinasi_a));
        sudut_waktu_a = Math.toDegrees(sudut_waktu_a);
        return (12 - eot_a) + (sudut_waktu_a / 15) + data.kwd + data.ihtiyat;



    }
    static double maghrib(Salat data){
        gmt_maghrib = 18 - data.zona_waktu;


        double jd_magrib = Konversi.masehiKeJd(data.tanggal, data.bulan, data.tahun, gmt_maghrib);

        double deklinasi_m = Sun.astroAlgo.apparentDeclination(jd_magrib);
        double eot_m = Sun.astroAlgo.equationOfTime(jd_magrib);
        double sdo_m = Sun.astroAlgo.angularSemiDiameter(jd_magrib);

        double irtifak_m = 0 - 0.575 - sdo_m - data.dip;

        deklinasi_m = Math.toRadians(deklinasi_m);
        irtifak_m = Math.toRadians(irtifak_m);

        double sudut_waktu_m = Math.acos(-Math.tan(data.lintangRad) * Math.tan(deklinasi_m) + Math.sin(irtifak_m) / Math.cos(data.lintangRad) / Math.cos(deklinasi_m));
        sudut_waktu_m = Math.toDegrees(sudut_waktu_m);

        return (12 - eot_m) + (sudut_waktu_m / 15) + data.kwd + data.ihtiyat;


    }
    static double isya(Salat data){
        gmt_isya = 19 - data.zona_waktu;
        double jd_isya = Konversi.masehiKeJd(data.tanggal, data.bulan, data.tahun,gmt_isya);
        double deklinasi_i = Sun.astroAlgo.apparentDeclination(jd_isya);
        double eot_i = Sun.astroAlgo.equationOfTime(jd_isya);

        deklinasi_i = Math.toRadians(deklinasi_i);

        double sudut_waktu_i = Math.acos(-Math.tan(data.lintangRad) * Math.tan(deklinasi_i) + Math.sin(toRadians(data.sudutIsya)) / Math.cos(data.lintangRad) / Math.cos(deklinasi_i));
        sudut_waktu_i = Math.toDegrees(sudut_waktu_i);

        return  (12 - eot_i) + (sudut_waktu_i / 15) + data.kwd + data.ihtiyat;

    }




}
