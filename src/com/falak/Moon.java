package com.falak;


public class Moon {


    public static class AstroAlgo {
        public static double trueGeocentricLongitude(double jd){
            return  Calculation.astroAlgo(jd)[11];
        }

        public static double apparentGeocentricLongitude (double jd){
            return  Calculation.astroAlgo(jd)[12]; }

        public static double apparentGeocentricLatitude(double jd){
            return  Calculation.astroAlgo(jd)[13];
        }



        public static double apparentRightAscension (double jd){
            return  Calculation.astroAlgo(jd)[14];
        }


        public static double apparentDeclination(double jd){
            return  Calculation.astroAlgo(jd)[15];
        }


        public static double trueGeocentricDistance(double jd){
            return  Calculation.astroAlgo(jd)[16];
        }


        public static double angularSemiDiameter (double jd){
            return  Calculation.astroAlgo(jd)[17];
        }


        public static double equatorialHorizontalParallax (double jd){
            return  Calculation.astroAlgo(jd)[18];
        }

        public static double diskIlluminatedFraction (double jd){
            return  Calculation.astroAlgo(jd)[19];
        }


        public static double brightLimbAngle(double jd){
            return  Calculation.astroAlgo(jd)[20];
        }


        public static double sunGeocentricElongation(double jd){
            double deltaSun,alphaSun,deltaMoon,alphaMoon,psi;
            deltaSun = Sun.AstroAlgo.apparentDeclination(jd);
            alphaSun = Sun.AstroAlgo.apparentRightAscension(jd);
            deltaMoon = apparentDeclination(jd);
            alphaMoon = apparentRightAscension(jd);
            psi = Math.toDegrees(Math.acos(Math.sin(Math.toRadians(deltaSun))*Math.sin(Math.toRadians(deltaMoon))+Math.cos(Math.toRadians(deltaSun))*Math.cos(Math.toRadians(deltaMoon))*Math.cos(Math.toRadians(alphaSun-alphaMoon))));
            return  psi;
        }


    }





    public static class Elpmpp02{

        public static double trueGeocentricLongitude(double jd){
            return  Calculation.elpMpp02(jd)[1];
        }

        public static double apparentGeocentricLongitude (double jd){
            return Calculation.elpMpp02(jd)[2];
        }



        public static double apparentGeocentricLatitude(double jd){
            return  Calculation.elpMpp02(jd)[3];
        }



        public static double apparentRightAscension (double jd){
            return  Calculation.elpMpp02(jd)[4];
        }


        public static double apparentDeclination(double jd){
            return  Calculation.elpMpp02(jd)[5];
        }


        public static double trueGeocentricDistance(double jd){
            return  Calculation.elpMpp02(jd)[6];
        }


        public static double angularSemiDiameter (double jd){
            return  Calculation.elpMpp02(jd)[7];
        }


        public static double equatorialHorizontalParallax (double jd){
            return  Calculation.elpMpp02(jd)[8];
        }

        public static double diskIlluminatedFraction (double jd){
            //kombinasi dengan data matahari dari Vsop87
            return  Calculation.elpMpp02(jd)[10]; }


        public static double brightLimbAngle(double jd){
            return  Calculation.elpMpp02(jd)[9];
        }


        public static double sunGeocentricElongation(double jd){
            double deltaSun,alphaSun,deltaMoon,alphaMoon,psi;
            deltaSun = Calculation.vsop87(jd)[5];
            alphaSun = Calculation.vsop87(jd)[4];
            deltaMoon = Calculation.vsop87(jd)[15];
            alphaMoon = Calculation.vsop87(jd)[14];
            psi = Math.toDegrees(Math.acos(Math.sin(Math.toRadians(deltaSun))*Math.sin(Math.toRadians(deltaMoon))+Math.cos(Math.toRadians(deltaSun))*Math.cos(Math.toRadians(deltaMoon))*Math.cos(Math.toRadians(alphaSun-alphaMoon))));
            return  psi;
        }


    }



    public static class Elpmpp02Trunc{


        public static double trueGeocentricLongitude(double jd){
            return  Calculation.elpMpp02Trunc(jd)[1];
        }

        public static double apparentGeocentricLongitude (double jd){
            return Calculation.elpMpp02Trunc(jd)[2];
        }



        public static double apparentGeocentricLatitude(double jd){
            return  Calculation.elpMpp02Trunc(jd)[3];
        }



        public static double apparentRightAscension (double jd){
            return  Calculation.elpMpp02Trunc(jd)[4];
        }


        public static double apparentDeclination(double jd){
            return  Calculation.elpMpp02Trunc(jd)[5];
        }


        public static double trueGeocentricDistance(double jd){
            return  Calculation.elpMpp02Trunc(jd)[6];
        }


        public static double angularSemiDiameter (double jd){
            return  Calculation.elpMpp02Trunc(jd)[7];
        }


        public static double equatorialHorizontalParallax (double jd){
            return  Calculation.elpMpp02Trunc(jd)[8];
        }

        public static double diskIlluminatedFraction (double jd){
            //kombinasi dengan data matahari dari Vsop87
            return  Calculation.elpMpp02Trunc(jd)[10]; }


        public static double brightLimbAngle(double jd){
            return  Calculation.elpMpp02Trunc(jd)[9];
        }


        public static double sunGeocentricElongation(double jd){
            double deltaSun,alphaSun,deltaMoon,alphaMoon,psi;
            deltaSun = Calculation.vsop87(jd)[5];
            alphaSun = Calculation.vsop87(jd)[4];
            deltaMoon = Calculation.vsop87(jd)[15];
            alphaMoon = Calculation.vsop87(jd)[14];
            psi = Math.toDegrees(Math.acos(Math.sin(Math.toRadians(deltaSun))*Math.sin(Math.toRadians(deltaMoon))+Math.cos(Math.toRadians(deltaSun))*Math.cos(Math.toRadians(deltaMoon))*Math.cos(Math.toRadians(alphaSun-alphaMoon))));
            return  psi;
        }


    }

    public static class Elp2000{


        public static double trueGeocentricLongitude(double jd){
            return  Calculation.elp2000(jd)[1];
        }

        public static double apparentGeocentricLongitude (double jd){
            return Calculation.elp2000(jd)[2];
        }



        public static double apparentGeocentricLatitude(double jd){
            return  Calculation.elp2000(jd)[3];
        }



        public static double apparentRightAscension (double jd){
            return  Calculation.elp2000(jd)[4];
        }


        public static double apparentDeclination(double jd){
            return  Calculation.elp2000(jd)[5];
        }


        public static double trueGeocentricDistance(double jd){
            return  Calculation.elp2000(jd)[6];
        }


        public static double angularSemiDiameter (double jd){
            return  Calculation.elp2000(jd)[7];
        }


        public static double equatorialHorizontalParallax (double jd){
            return  Calculation.elp2000(jd)[8];
        }

        public static double diskIlluminatedFraction (double jd){
            //kombinasi dengan data matahari dari Vsop87
            return  Calculation.elp2000(jd)[10]; }


        public static double brightLimbAngle(double jd){
            return  Calculation.elp2000(jd)[9];
        }


        public static double sunGeocentricElongation(double jd){
            double deltaSun,alphaSun,deltaMoon,alphaMoon,psi;
            deltaSun = Calculation.vsop87(jd)[5];
            alphaSun = Calculation.vsop87(jd)[4];
            deltaMoon = Calculation.vsop87(jd)[15];
            alphaMoon = Calculation.vsop87(jd)[14];
            psi = Math.toDegrees(Math.acos(Math.sin(Math.toRadians(deltaSun))*Math.sin(Math.toRadians(deltaMoon))+Math.cos(Math.toRadians(deltaSun))*Math.cos(Math.toRadians(deltaMoon))*Math.cos(Math.toRadians(alphaSun-alphaMoon))));
            return  psi;
        }


    }



}
