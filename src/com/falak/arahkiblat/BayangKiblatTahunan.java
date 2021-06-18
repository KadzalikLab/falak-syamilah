package com.falak.arahkiblat;

import com.falak.Konversi;
import com.falak.ephemeris.Sun;

import static com.falak.Print.printDms;

public class BayangKiblatTahunan {
    private static boolean astroAlgo;
    private static boolean vsop87;
    static ArahKiblat data;
    static int tahun;
    static int gmtMakah = 3;

    private static double perata_waktu_I,perata_waktu_II;
    private static double deklinasi_I,deklinasi_II;
    private static double selisih_I,selisih_II;
    private static double pukul_transit_UT_I,pukul_transit_UT_II ;
    private static double pukul_transit_MKT_I, pukul_transit_MKT_II;
    private static double pukul_transit_WD_I, pukul_transit_WD_II ;
    private static double jd_WD_I,jd_WD_II;






    public BayangKiblatTahunan(ArahKiblat dataKiblat, int tahun_yg_dicari) {
        data = dataKiblat;
        tahun = tahun_yg_dicari;
        prosesHisab();
    }


    /**
     * bila method ini tidak di-set maka secara otomatis akan memeilih metode hisab default yaitu metode astroAlgo.
     */
    public dataMatahari setDataMatahari() { //Methods
        return new dataMatahari();
    }

    public static class dataMatahari { //class in a class
        public void astroAlgo() {
            astroAlgo = true;
            vsop87 = false;
            prosesHisab();

        }

        public void vsop87() {
            vsop87 = true;
            astroAlgo = false;
            prosesHisab();

        }
    }

    public static void setGmtMakah(int gmt) {
        gmtMakah = gmt;
    }


    public static void prosesHisab() {
        double pukul12JD = (12 - gmtMakah); //9 GMT
        double jdAwalTahun = Konversi.masehiKeJd(1, 1, tahun, pukul12JD);
        double jdAkhirTahun = Konversi.masehiKeJd(31, 12, tahun, pukul12JD);
        double jdTemp=jdAwalTahun,jdSebelum,jdSesudah;
        double jd_transit;
        int i =-1;
        double []jdIstiwa_adzom_UT = new double[2];


       // double jdHasil=0,deklinasiHasil=0,perataWaktuHasil=0,transitHasil=0;

        while (true){
            jdSebelum=jdTemp-1;
            jdSesudah=jdTemp+1;

            double pw = peratawaktu(jdTemp);
//            double pwSebelum = peratawaktu(jdSebelum);
//            double pwSesudah = peratawaktu(jdSesudah);

            double deklinasi = deklinasi(jdTemp);
            double deklinasiSebelum = deklinasi(jdSebelum);
            double deklinasiSesudah = deklinasi(jdSesudah);

            double transit = 12-pw+((gmtMakah*15)-data.bujur_kb)/15;
//            double transitSebelum = 12-pwSebelum+((gmtMakah*15)-data.bujur_kb)/15;
//            double transitSesudah = 12-pwSesudah+((gmtMakah*15)-data.bujur_kb)/15;
            jd_transit=((int)jdTemp+0.5)+(transit/24);
//            jd_transitSebelum=((int)jdSebelum+0.5)+(transitSebelum/24);
//            jd_transitSesudah=((int)jdSesudah+0.5)+(transitSesudah/24);

            double selisih = Math.abs(data.lintang_kb-deklinasi);
            double selisihSebelum = Math.abs(data.lintang_kb-deklinasiSebelum);
            double selisihSesudah = Math.abs(data.lintang_kb-deklinasiSesudah);

//            System.out.println(Konversi.ddd_ppp_DDMMMYYYY_hhmmss(jd_transitSebelum)+" | " +Konversi.dmsMili(selisihSebelum));
//            System.out.println(Konversi.ddd_ppp_DDMMMYYYY_hhmmss(jd_transit)+" | " +Konversi.dmsMili(selisih));
//            System.out.println(Konversi.ddd_ppp_DDMMMYYYY_hhmmss(jd_transitSesudah)+" | " +Konversi.dmsMili(selisihSesudah));
//            System.out.println();

            if (selisih<selisihSebelum&&selisih<selisihSesudah) {
//                jdHasil=jd_transit;
//                transitHasil=transit;
//                deklinasiHasil=deklinasi;
//                perataWaktuHasil = pw;
                i+=1;
                jdIstiwa_adzom_UT[i] = jd_transit-(gmtMakah/24.0);


            }
            jdTemp++;
            if (jdTemp>=jdAkhirTahun)break;
        }



        double jd_hasil_I = jdIstiwa_adzom_UT[0];
        double jd_hasil_II = jdIstiwa_adzom_UT[1];

         perata_waktu_I = peratawaktu(jd_hasil_I);
         deklinasi_I = deklinasi(jd_hasil_I);
         selisih_I = Math.abs(data.lintang_kb-deklinasi_I);
         pukul_transit_UT_I = Konversi.jdPukul(jd_hasil_I);
         pukul_transit_MKT_I = pukul_transit_UT_I+gmtMakah;
         pukul_transit_WD_I = pukul_transit_MKT_I +(data.zona_waktu-gmtMakah);
         jd_WD_I = jd_hasil_I+(data.zona_waktu/24.0);

         perata_waktu_II = peratawaktu(jd_hasil_II);
         deklinasi_II = deklinasi(jd_hasil_II);
         selisih_II = Math.abs(data.lintang_kb-deklinasi_II);
         pukul_transit_UT_II = Konversi.jdPukul(jd_hasil_II);
         pukul_transit_MKT_II = pukul_transit_UT_II+gmtMakah;
         pukul_transit_WD_II = pukul_transit_MKT_II +(data.zona_waktu-gmtMakah);
         jd_WD_II = jd_hasil_II+(data.zona_waktu/24.0);





    }

    private static double peratawaktu(double jd) {
        double nilai = 0;
        if (astroAlgo) nilai = Sun.astroAlgo.equationOfTime(jd);
        else if (vsop87) nilai = Sun.vsop87.equationOfTime(jd);
        else nilai = Sun.astroAlgo.equationOfTime(jd);
        return nilai;
    }

    private static double deklinasi(double jd) {
        double nilai = 0;
        if (astroAlgo) nilai = Sun.astroAlgo.apparentDeclination(jd);
        else if (vsop87) nilai = Sun.vsop87.apparentDeclination(jd);
        else nilai = Sun.astroAlgo.apparentDeclination(jd);
        return nilai;
    }







    public double getJd_WD_I(){
        return this.jd_WD_I;
    }
     public double getJd_WD_II(){
        return this.jd_WD_II;
    }

    public double getPerata_waktu_I(){
        return this.perata_waktu_I;
    }
    public double getPerata_waktu_II() {
        return perata_waktu_II;
    }

    public double getPukul_transit_WD_I() {
        return pukul_transit_WD_I;
    }

    public double getPukul_transit_WD_II() {
        return pukul_transit_WD_II;
    }

    public double getDeklinasi_I() {
        return deklinasi_I;
    }

    public double getDeklinasi_II() {
        return deklinasi_II;
    }

    public double getSelisih_I() {
        return selisih_I;
    }

    public double getSelisih_II() {
        return selisih_II;
    }

    public double getPukul_transit_MKT_I() {
        return pukul_transit_MKT_I;
    }

    public double getPukul_transit_MKT_II() {
        return pukul_transit_MKT_II;
    }
}
