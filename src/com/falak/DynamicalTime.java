package com.falak;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import static java.lang.Math.pow;

public class DynamicalTime {
    /**
     * Mendapatkan nilai perkiraan delta T menggunakan rumus POLYNOMIAL EXPRESSIONS FOR DELTA T (ΔT)
     * dalam rentang tahun 1986 - diatas 2150
     *
     *
     *
     * @return          delta T
     *
     * @author
     * @see <a href="https://eclipse.gsfc.nasa.gov/SEcat5/deltatpoly.html">https://eclipse.gsfc.nasa.gov/SEcat5/deltatpoly.html</a>
     */


    public static double delta_t(double tglM_UT,double blnM_UT,double thnM_UT){
//        double nilai_tahun=tahun+((bulan-1)/12)+tanggal/365;
//        double delta_t=0;

        double KB, NoDY, yF, uF, tF, DltT=0;
        if ( ((thnM_UT > 1582) && ((thnM_UT -  (int)(thnM_UT / 100) * 100 == 0) && (thnM_UT - (int) (thnM_UT / 400) * 400 == 0) || (thnM_UT - (int)(thnM_UT / 100) * 100 != 0) && (thnM_UT - (int)(thnM_UT / 4) * 4 == 0))) || ((thnM_UT <= 1582) && (thnM_UT - (int)(thnM_UT / 4) * 4 == 0))) KB = 1; else KB = 2;
        NoDY =  (int)(275 * blnM_UT / 9) - KB *  (int)((blnM_UT + 9) / 12) + tglM_UT - 30;
        if( KB == 1)  yF = thnM_UT + NoDY / 366; else yF = thnM_UT + NoDY / 365;
        if (yF <= -500) {
            uF = (yF - 1820) / 100;
            DltT = -20 + 32 * pow(uF, 2);
        }
        if (yF > -500 && yF <= 500) {
            uF = yF / 100;
            DltT = 10583.6 - 1014.41 * uF + 33.78311 * pow(uF, 2) - 5.952053 * pow(uF, 3) - 0.1798452 * pow(uF, 4) + 0.022174192 * pow(uF, 5) + 0.0090316521 * pow(uF, 6);
        }
        if (yF > 500 && yF <= 1600) {
            uF = (yF - 1000) / 100;
            DltT = 1574.2 - 556.01 * uF + 71.23472 * pow(uF, 2) + 0.319781 * pow(uF, 3) - 0.8503463 * pow(uF, 4) - 0.005050998 * pow(uF, 5) + 0.0083572073 * pow(uF,6 );
        }
        if (yF > 1600 && yF <= 1700) {
            tF = yF - 1600;
            DltT = 120 - 0.9808 * tF - 0.01532 * pow(tF, 2) + pow(tF, 3) / 7129;
        }
        if (yF > 1700 && yF <= 1800) {
            tF = yF - 1700;
            DltT = 8.83 + 0.1603 * tF - 0.0059285 * pow(tF, 2) + 0.00013336 * pow(tF, 3) - pow(tF, 4) / 1174000;
        }
        if (yF > 1800 && yF <= 1860) {
            tF = yF - 1800;
            DltT = 13.72 - 0.332447 * tF + 0.0068612 * pow(tF, 2) + 0.0041116 * pow(tF, 3) - 0.00037436 * pow(tF, 4) + 0.0000121272 * pow(tF,5) - 0.0000001699 * pow(tF,6) + 0.000000000875 * pow(tF,7);
        }
        if (yF > 1860 && yF <= 1900) {
            tF = yF - 1860;
            DltT = 7.62 + 0.5737 * tF - 0.251754 * pow(tF, 2) + 0.01680668 * pow(tF, 3) - 0.0004473624 * pow(tF, 4) + pow(tF,5) / 233174;
        }
        if( yF > 1900 && yF <= 1920) {
            tF = yF - 1900;
            DltT = -2.79 + 1.494119 * tF - 0.0598939 * pow(tF, 2) + 0.0061966 * pow(tF, 3) - 0.000197 * pow(tF, 4);
        }
        if (yF > 1920 && yF <= 1941) {
            tF = yF - 1920;
            DltT = 21.2 + 0.84493 * tF - 0.0761 * pow(tF, 2) + 0.0020936 * pow(tF, 3);
        }
        if (yF > 1941 && yF <= 1961) {
            tF = yF - 1950;
            DltT = 29.07 + 0.407 * tF - pow(tF, 2) / 233 + pow(tF, 3) / 2547;
        }
        if (yF > 1961 && yF <= 1986) {
            tF = yF - 1975;
            DltT = 45.45 + 1.067 * tF - pow(tF, 2) / 260 - pow(tF, 3) / 718;
        }
        if (yF > 1986 && yF <= 2005) {
            tF = yF - 2000;
            DltT = 63.86 + 0.3345 * tF - 0.060374 * pow(tF, 2) + 0.0017275 * pow(tF, 3) + 0.000651814 * pow(tF, 4) + 0.00002373599 * pow(tF,5);
        }
        if (yF > 2005 && yF <= 2050) {
            tF = yF - 2000;
            DltT = 62.92 + 0.32217 * tF + 0.005589 * pow(tF, 2);
        }
        if( yF > 2050 && yF <= 2150)  DltT = -20 + 32 * pow( ((yF - 1820) / 100),2)- 0.5628 * (2150 - yF);
        if (yF > 2150) {
            uF = (yF - 1820) / 100;
            DltT = -20 + 32 * pow(uF, 2);
        }


        return DltT;
    }


    /**
     * Estimate Delta T for the given Calendar. This is based on Espenak && Meeus, "Five Millennium Canon of
     * Solar Eclipses: -1999 to +3000" (NASA/TP-2006-214141).
     *
     * Mendapatkan nilai perkiraan delta T menggunakan rumus POLYNOMIAL EXPRESSIONS FOR DELTA T (ΔT)
     * dalam rentang tahun 1986 - diatas 2150
     * @param tanggal    Masehi
     * @param bulan      Masehi
     * @param tahun      Masehi
     *
     * @return estimated delta T value (seconds)
     * @author           faizin @kadzaliklab
     * @see <a href="https://eclipse.gsfc.nasa.gov/SEcat5/deltatpoly.html">https://eclipse.gsfc.nasa.gov/SEcat5/deltatpoly.html</a>
     */
    public static double estimate(int tanggal, int bulan, int tahun) {
        GregorianCalendar forDate = new GregorianCalendar();
        forDate.set(GregorianCalendar.YEAR,  tahun);
        forDate.set(GregorianCalendar.MONTH,  bulan );
        forDate.set(GregorianCalendar.DATE, tanggal);

        final double year = decimalYear(forDate);
        final double deltaT;

        if (year < -500) {
            double u = (year - 1820) / 100;
            deltaT = -20 + 32 * pow(u, 2);
        } else if (year < 500) {
            double u = year / 100;
            deltaT = 10583.6 - 1014.41 * u + 33.78311 * pow(u, 2) - 5.952053 * pow(u, 3)
                    - 0.1798452 * pow(u, 4) + 0.022174192 * pow(u, 5) + 0.0090316521 * pow(u, 6);
        } else if (year < 1600) {
            double u = (year - 1000) / 100;
            deltaT = 1574.2 - 556.01 * u + 71.23472 * pow(u, 2) + 0.319781 * pow(u, 3)
                    - 0.8503463 * pow(u, 4) - 0.005050998 * pow(u, 5) + 0.0083572073 * pow(u, 6);
        } else if (year < 1700) {
            double t = year - 1600;
            deltaT = 120 - 0.9808 * t - 0.01532 * pow(t, 2) + pow(t, 3) / 7129;
        } else if (year < 1800) {
            double t = year - 1700;
            deltaT = 8.83 + 0.1603 * t - 0.0059285 * pow(t, 2) + 0.00013336 * pow(t, 3) - pow(t, 4) / 1174000;
        } else if (year < 1860) {
            double t = year - 1800;
            deltaT = 13.72 - 0.332447 * t + 0.0068612 * pow(t, 2) + 0.0041116 * pow(t, 3) - 0.00037436 * pow(t, 4)
                    + 0.0000121272 * pow(t, 5) - 0.0000001699 * pow(t, 6) + 0.000000000875 * pow(t, 7);
        } else if (year < 1900) {
            double t = year - 1860;
            deltaT = 7.62 + 0.5737 * t - 0.251754 * pow(t, 2) + 0.01680668 * pow(t, 3)
                    - 0.0004473624 * pow(t, 4) + pow(t, 5) / 233174;
        } else if (year < 1920) {
            double t = year - 1900;
            deltaT = -2.79 + 1.494119 * t - 0.0598939 * pow(t, 2) + 0.0061966 * pow(t, 3) - 0.000197 * pow(t, 4);
        } else if (year < 1941) {
            double t = year - 1920;
            deltaT = 21.20 + 0.84493 * t - 0.076100 * pow(t, 2) + 0.0020936 * pow(t, 3);
        } else if (year < 1961) {
            double t = year - 1950;
            deltaT = 29.07 + 0.407 * t - pow(t, 2) / 233 + pow(t, 3) / 2547;
        } else if (year < 1986) {
            double t = year - 1975;
            deltaT = 45.45 + 1.067 * t - pow(t, 2) / 260 - pow(t, 3) / 718;
        } else if (year < 2005) {
            double t = year - 2000;
            deltaT = 63.86 + 0.3345 * t - 0.060374 * pow(t, 2) + 0.0017275 * pow(t, 3) + 0.000651814 * pow(t, 4)
                    + 0.00002373599 * pow(t, 5);
        } else if (year < 2050) {
            double t = year - 2000;
            deltaT = 62.92 + 0.32217 * t + 0.005589 * pow(t, 2);
        } else if (year < 2150) {
            deltaT = -20 + 32 * pow(((year - 1820) / 100), 2) - 0.5628 * (2150 - year);
        } else {
            double u = (year - 1820) / 100;
            deltaT = -20 + 32 * pow(u, 2);
        }


        return deltaT;

    }

    private static double decimalYear(GregorianCalendar forDate) {
        double rawYear = forDate.get(Calendar.YEAR);
        if (forDate.get(Calendar.ERA) == GregorianCalendar.BC) {
            rawYear = -rawYear;
        }

        return rawYear + (forDate.get(Calendar.MONTH) + 1 - 0.5) / 12;
    }




}
