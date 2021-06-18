package com.falak.arahkiblat.bayangmatahari;


import com.falak.Konversi;
import com.falak.ephemeris.Sun;
import static java.lang.Math.*;

/**
 * Mencari arah mata angin sejati (Timur & Barat) menggunakan bayangan suatu benda pada waktu yang telah ditentukan.
 * bayangan tersebut akan membentuk sebuah segitiga
 */
public class SegitigaTimBar {
    double jd;
    double panjangGarisBenda;
    double lintang;
    double bujur;
    double zonaWaktu;

    private  boolean astroAlgo;
    private boolean vsop87;

    /**
     * bila method ini tidak di-set maka secara otomatis akan memeilih metode hisab default yaitu metode astroAlgo.
     */
    public MetodeHisab setMetodeHisab(){ //Methods
        return new MetodeHisab();
    }
    public class MetodeHisab { //class in a class
        void astroAlgo(){
            astroAlgo=true;
            vsop87=false;
        }
        void  vsop87(){
            vsop87=true;
            astroAlgo=false;
        }
    }

    SegitigaTimBar( double julianday,double zonaWaktu, double lintang,double bujur,double panjangGarisBenda){
        jd = julianday;
        this.zonaWaktu=zonaWaktu;
        this.lintang = lintang;
        this.bujur = bujur;
        this.panjangGarisBenda = panjangGarisBenda;
    }

    double perataWaktu(boolean AA,boolean vsop){
        double hasil;
        if (AA){
            hasil= Sun.astroAlgo.equationOfTime(this.jd);
        }else if(vsop){
            hasil= Sun.vsop87.equationOfTime(this.jd);
        }else hasil= Sun.astroAlgo.equationOfTime(this.jd);

        return  hasil;
    }
    double deklinasiMatahari(boolean AA,boolean vsop){
        double hasil;
        if (AA){
            hasil= Sun.astroAlgo.apparentDeclination(this.jd);
        }else if(vsop){
            hasil= Sun.vsop87.apparentDeclination(this.jd);
        }else hasil= Sun.astroAlgo.apparentDeclination(this.jd);

        return  hasil;
    }

    double get_LocalMeanTime(){
        double pukul = Konversi.jdPukul(this.jd);
        double hasil;
        double pw = perataWaktu(this.astroAlgo,this.vsop87);
        hasil = (pukul+pw)-(((zonaWaktu*15)-bujur)/15);
        return  hasil;
    }

    double get_TO(){
        double hasil;
        double lmt = get_LocalMeanTime();
        hasil = (lmt-12)*15;
        return hasil;
    }
    double get_SunAltitude(){
        double hasil;
        double to = get_TO();
        double dm = deklinasiMatahari(this.astroAlgo,this.vsop87);
        to=toRadians(to);
        dm = toRadians(dm);
        double lt = toRadians(lintang);
        hasil = asin((sin(lt)*sin(dm))+(cos(lt)*cos(dm)*cos(to)));
        hasil=toDegrees(hasil);
        return hasil;
    }

    double get_SunAzimuth(){
        double hasil;
        double to = get_TO();
        double dm = deklinasiMatahari(this.astroAlgo,this.vsop87);
        to=toRadians(to);
        dm = toRadians(dm);
        double lt = toRadians(lintang);
        hasil = atan(1/((-sin(lt)/tan(to))+(cos(lt)*tan(dm)/sin(to))));
        hasil = toDegrees(hasil);
        return  hasil;

    }



}
