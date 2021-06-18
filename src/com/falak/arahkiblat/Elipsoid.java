package com.falak.arahkiblat;
import com.falak.Mathf;

import static java.lang.Math.*;


/**
 * Perhitungan Arah kiblat menggunakan Segitiga Bola dengan koreksi dari koordinat geografik ke ke koordinat geosentrik.
 */
public class Elipsoid {
    /**
     * Utsb double.
     *
     * @param data data arh kiblat, meliputi koordinat kakbah dan lain-lain
     * @return arah kiblat UTSB
     */
    static double UTSB(ArahKiblat data){
        double A,B,C,e, lintangTempatTerkoreksi,lintangKabahTerkoreksi,sB,cB,Bb;
        e = 0.0066943800229;
        lintangKabahTerkoreksi=toDegrees(atan((1-e)*tan(toRadians(data.lintang_kb))));
        lintangTempatTerkoreksi=toDegrees(atan((1-e)*tan(toRadians(data.lintang))));

        A=toRadians(90-lintangTempatTerkoreksi);
        B=toRadians(90-lintangKabahTerkoreksi);
        C=toRadians(data.bujur-data.bujur_kb);

        sB=sin(B)*sin(C);
        cB=cos(B)*sin(A)-cos(A)*sin(B)*cos(C);
        Bb=atan2(sB,cB);
        return Mathf.modulo(360-toDegrees(Bb),360);

    }

}
