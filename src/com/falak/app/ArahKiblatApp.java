package com.falak.app;

import com.falak.Konversi;
import com.falak.arahkiblat.ArahKiblat;
import com.falak.arahkiblat.BayangKiblatTahunan;

import static com.falak.Print.*;

public class ArahKiblatApp {
    public static void main(String[] args) {
        double derajat_lintang=-4;
        double menit_lintang=58;
        double detik_lintang=0;
        double lintang= Konversi.dmsKeDesimal(derajat_lintang,menit_lintang,detik_lintang);

        double derajat_bujur=105;
        double menit_bujur=12;
        double detik_bujur=0;
        double bujur=Konversi.dmsKeDesimal(derajat_bujur,menit_bujur,detik_bujur);


        //KOORDINAT KA'BAH DIAMBIL DARI PERSATUAN DATABASE GNSS (GLOBAL NAVIGATION SATELLITE SYSTEM) internasional bukan hanya Gps saja!
        double derajat_lintangKB=21;
        double menit_lintangKB=25;
        double detik_lintangKB=21.08;
        double lintangKB=Konversi.dmsKeDesimal(derajat_lintangKB,menit_lintangKB,detik_lintangKB);

        double derajat_bujurKB=39;
        double menit_bujurKB=49;
        double detik_bujurKB=34.25;
        double bujurKB=Konversi.dmsKeDesimal(derajat_bujurKB,menit_bujurKB,detik_bujurKB);


        ArahKiblat arahKiblat = new ArahKiblat(lintang,bujur);
        arahKiblat.setMetodeHisab().segitigaBola();
        double UTSB = arahKiblat.getHasil_UTSB();
        printDms("SegitigaBola",UTSB);

        ArahKiblat arahKiblat2 = new ArahKiblat(lintang,bujur);
        arahKiblat2.setMetodeHisab().vincenty();
        printDms("Vincenty", arahKiblat2.getHasil_UTSB());

        ArahKiblat arahKiblat3 = new ArahKiblat(lintang,bujur);
        arahKiblat3.setMetodeHisab().elipsoid();
        printDms("Elipsoid", arahKiblat3.getHasil_UTSB());


        // MENCARI PERISTIWA ISTIWA' A'DZOM DALAM SUATU TAHUN MASEHI
        System.out.println();

        int tahun = 2022;
        int zona_waktu=7;
        ArahKiblat kb = new ArahKiblat(zona_waktu);
        BayangKiblatTahunan by = new BayangKiblatTahunan(kb, tahun);
        by.setDataMatahari().astroAlgo();
        System.out.println("Istiwa' A'dzom I Terjadi Pada:");
        print_ddd_ppp_DDMMMYYYY_hhmmss(by.getJd_WD_I());
        printHms("Transit Syamsi MKH ", by.getPukul_transit_MKT_I());
        printHms("Transit Syamsi WD ",by.getPukul_transit_WD_I());
        printHms("Perata Waktu",by.getPerata_waktu_I());
        printDms("Deklinasi Syamsi",by.getDeklinasi_I());
        printDms("Selisih Dek - LT Kbh",by.getSelisih_I());
        System.out.println();

        System.out.println("Istiwa' A'dzom II Terjadi Pada:");
        print_ddd_ppp_DDMMMYYYY_hhmmss(by.getJd_WD_II());
        printHms("Transit Syamsi MKH ", by.getPukul_transit_MKT_II());
        printHms("Transit Syamsi WD ",by.getPukul_transit_WD_II());
        printHms("Perata Waktu",by.getPerata_waktu_II());
        printDms("Deklinasi Syamsi",by.getDeklinasi_II());
        printDms("Selisih Dek - LT Kbh",by.getSelisih_II());
        System.out.println();

        System.out.println("Data Matahari mengunakan Vsop87");



    }
}
