package com.falak;

public class Sun {

    /**
     * Mendapatkan data-data matahari menggunakan metode buku Astonomy Algorithms - Jean Meeus
     * dimana perhitunganya ada di class: {@link Calculation#astroAlgo(double jd)}}
     * @version 1.0
     * @see <a href="http://www.agopax.it/Libri_astronomia/pdf/Astronomical%20Algorithms.pdf">Astronomical Algorithms.pdf</a>
     * @since 2021-03-31
     */
    public static class AstroAlgo {


        //nilai sebenarnya Bujur Matahari Koordinat Ekliptika Geosentrik
        public static double trueGeocentricLongitude(double jd) {
            return Calculation.astroAlgo(jd)[1];
        }
        //nilai nampak Bujur Matahari Koordinat Ekliptika Geosentrik
        public static double apparentGeocentricLongitude(double jd) {
            return Calculation.astroAlgo(jd)[2];
        }

        //nilai sebenarnya Lintang Matahari Koordinat Ekliptika Geosentrik
        public static double geocentricLatitude(double jd) {
            return Calculation.astroAlgo(jd)[3];
        }

        //nilai nampak Asensio rekta / Panjatan tegak / Bujur Matahari Koordinat Ekuator Geosentrik
        public static double apparentRightAscension(double jd) {
            return Calculation.astroAlgo(jd)[4];
        }

        //nilai nampak Deklinasi / lintang Matahari Koordinat Ekuator Geosentrik
        public static double apparentDeclination(double jd) {
            return Calculation.astroAlgo(jd)[5];
        }

        //Jarak Bumi - Matahari Vector
        public static double trueGeocentricDistance(double jd) {
            return Calculation.astroAlgo(jd)[6];
        }

        //Semi diameter / piringan Matahari
        public static double angularSemiDiameter(double jd) {
            return Calculation.astroAlgo(jd)[7];
        }
        //Perata waktu
        public static double equationOfTime(double jd) {

            double tau, alpha, deltaPsi, epsilon, L0, e;
            tau = Calculation.astroAlgo(jd)[8];
            alpha = apparentRightAscension(jd);
            deltaPsi = Calculation.astroAlgo(jd)[9];
            epsilon = Calculation.astroAlgo(jd)[10];
            L0 = 280.4664567 + 360007.6982779 * tau + 0.03032028 * Math.pow(tau, 2) + Math.pow(tau, 3) / 49931 - Math.pow(tau, 4) / 15300 - Math.pow(tau, 5) / 2000000;
            L0 %= 360;
            e = L0 - 0.0057183 - alpha + deltaPsi * Math.cos(Math.toRadians(epsilon));

            if (Math.abs(e) * 4 < 20) e = e / 15;
            else if (Math.abs(e) * 4 >= 20 && e > 0) e = e / 15 - 24;
            else if (Math.abs(e) * 4 >= 20 && e < 0) e = e / 15 + 24;
            else e = e / 15;

            return e;
        }

        //Horizontal paralaks
        public static double equatorialHorizontalParallax(double jd) {
            double R = trueGeocentricDistance(jd);
            double phi = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(8.794 / 3600d)) / R));

            return phi;
        }

        //Kemiringan sumbu bumi
        public  static double trueObliquity(double jd) {
            return Calculation.astroAlgo(jd)[10];
        }

    }


    public static class Vsop87 {

        public static double trueGeocentricLongitude(double jd) {
            return Calculation.vsop87(jd)[1];
        }

        public static double apparentGeocentricLongitude(double jd) {
            return Calculation.vsop87(jd)[2];
        }

//
//        static double (double jd){
//            return  Calculation.meeus(jd)[]; }

        public   static double geocentricLatitude(double jd) {
            return Calculation.vsop87(jd)[3];
        }


        public  static double apparentRightAscension(double jd) {
            return Calculation.vsop87(jd)[4];
        }


        public  static double apparentDeclination(double jd) {
            return Calculation.vsop87(jd)[5];
        }


        public static double trueGeocentricDistance(double jd) {
            return Calculation.vsop87(jd)[6];
        }


        public static double angularSemiDiameter(double jd) {
            return Calculation.vsop87(jd)[7];
        }

        public  static double equationOfTime(double jd) {

            double tau, alpha, deltaPsi, epsilon, L0, e;
            tau = Calculation.vsop87(jd)[8];
            alpha = apparentRightAscension(jd);
            deltaPsi = Calculation.vsop87(jd)[9];
            epsilon = Calculation.vsop87(jd)[10];
            L0 = 280.4664567 + 360007.6982779 * tau + 0.03032028 * Math.pow(tau, 2) + Math.pow(tau, 3) / 49931 - Math.pow(tau, 4) / 15300 - Math.pow(tau, 5) / 2000000;
            L0 %= 360;
            e = L0 - 0.0057183 - alpha + deltaPsi * Math.cos(Math.toRadians(epsilon));

            if (Math.abs(e) * 4 < 20) e = e / 15;
            else if (Math.abs(e) * 4 >= 20 && e > 0) e = e / 15 - 24;
            else if (Math.abs(e) * 4 >= 20 && e < 0) e = e / 15 + 24;
            else e = e / 15;

            return e;
        }

        public  static double equatorialHorizontalParallax(double jd) {
            double R = trueGeocentricDistance(jd);
            double phi = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(8.794 / 3600d)) / R));

            return phi;
        }

        public  static double trueObliquity(double jd) {
            return Calculation.astroAlgo(jd)[10];
        }

    }


}


