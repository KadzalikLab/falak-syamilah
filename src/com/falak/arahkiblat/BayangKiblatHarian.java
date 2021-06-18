package com.falak.arahkiblat;

import com.falak.Konversi;
import com.falak.ephemeris.Sun;

import static java.lang.Math.*;
import static com.falak.Print.*;
import static com.falak.Mathf.*;
// SEDANG DALAM PROSES PENYELESAIAN!!!!! (butuh koreksi)
public class BayangKiblatHarian {
    private static boolean astroAlgo;
    private static boolean vsop87;

    static int tahun;
    static int bulan;
    static int tanggal;

    static double lintang;
    static double bujur;
    static double zona_waktu;
    static double jd;
    static ArahKiblat data;

    BayangKiblatHarian(ArahKiblat data, double jd) {
        lintang = data.lintang;
        bujur = data.bujur;
        zona_waktu = data.zona_waktu;
        this.jd = jd;
        this.data = data;
    }

    /**
     * bila method ini tidak di-set maka secara otomatis akan memeilih metode hisab default yaitu metode astroAlgo.
     */
    public dataMatahari setDataMatahari() { //Methods
        return new dataMatahari();
    }

    public class dataMatahari { //class in a class
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

    void prosesHisab() {
        double deklinasi = deklinasi(jd+(9/24.0));
        double pw = peratawaktu(jd+(9/24.0));

        double a = bujur - data.bujur_kb; //selisihBujur
        double b = -sin(rad(lintang)) / tan(rad(a));
        double c = cos(rad(lintang)) * tan(rad(data.lintang_kb)) / sin(rad(a));
        double m = toDegrees(atan(b + c))+270; //aimuth kiblat
        double f = 90 - deklinasi;
        double y = 90 - lintang;
        double a2 = 1 / (cos(rad(y)) * tan(rad(m)));
        double b2 = toDegrees(abs(atan(a2)));
        double b3 = (( 1 /tan(rad(f))) * tan(rad(y)) * cos(rad(b2)));
        double aa = toDegrees(abs(acos(b3))); // sudut waktu
        double transit = 12 - pw + ((zona_waktu * 15) - bujur) / 15;
        double perkiraan_I = transit + (aa - b2) / 15;
        if (perkiraan_I < 0) perkiraan_I += 24;
        else if (perkiraan_I >= 24) perkiraan_I -= 24;

        double perkiraan_II = transit - (aa + b2) / 15;
        if (perkiraan_II < 0) perkiraan_II += 24;
        else if (perkiraan_II >= 24) perkiraan_II -= 24;
        System.out.println();

        double koreksiPukul = perkiraan_I-12+7-zona_waktu;
        double deklinasi_new = deklinasi(((int)jd +0.5)+((perkiraan_I-zona_waktu)/24.0));
        double perataWaktu_new = peratawaktu(((int)jd +0.5)+((perkiraan_I-zona_waktu)/24.0));
        double m3 = 90-deklinasi_new;
        double m4 = 90-lintang;
        double m5 = 1/(cos(rad(m4))*tan(rad(m)));
        double m6 = toDegrees(abs(atan(m5)));
        double m7 = (( 1 /tan(rad(m3))) * tan(rad(m4)) * cos(rad(m6)));
        double sudutWaktu = toDegrees(abs(acos(m7)));
        double transit_hakiki = 12-perataWaktu_new+((zona_waktu*15)-bujur)/15;
        double transit_hakiki_W= transit_hakiki+((sudutWaktu-m6)/15);
        double roshdu_hakiki;
        if (transit_hakiki < 0) roshdu_hakiki = transit_hakiki_W+24;
        else if (perkiraan_II >= 24)  roshdu_hakiki = transit_hakiki_W-24;
        else roshdu_hakiki = transit_hakiki_W;








        System.out.println("Perkiraan Roshdu Kiblat");
        print_ddd_ppp_DDMMMYYYY(jd);
        printHms("imkan I", perkiraan_I);
        printHms("imkan II", perkiraan_II);
        printHms("Transit Perkiraan",transit);
        printHms("Koreksi Waktu",koreksiPukul);
        System.out.println("Roshdu Kiblat Hakiki");
        printHms("Transit hakiki",transit_hakiki);
        printHms("Hakiki WD",transit_hakiki_W);
        printHms("Roshdu Kiblat Hakiki",roshdu_hakiki);



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


    public static void main(String[] args) {
        ArahKiblat kb = new ArahKiblat(7);
        kb.setBujur(105, 12, 0);
        kb.setLintang(-4, 58, 0);
        double tanggal, bulan, tahun, ihtiyat, zona_waktu, tinggi, jd;
        tanggal = 18;
        bulan = 6;
        tahun = 2021;
        jd = Konversi.masehiKeJd(tanggal, bulan, tahun, 0);

        BayangKiblatHarian by = new BayangKiblatHarian(kb, jd);
        by.prosesHisab();


    }
}
