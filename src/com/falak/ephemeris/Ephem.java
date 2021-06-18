package com.falak.ephemeris;

import com.falak.Konversi;

public class Ephem {
    double jd;

    public boolean isAstroAlgo_sun() {
        return astroAlgo_sun;
    }

    public boolean isVsop87_sun() {
        return vsop87_sun;
    }

    public boolean isAstroAlgo_moon() {
        return astroAlgo_moon;
    }

    public boolean isElp2000_moon() {
        return elp2000_moon;
    }

    public boolean isElpMpp02_moon() {
        return elpMpp02_moon;
    }

    public boolean isElpMpp02Trunc() {
        return elpMpp02Trunc;
    }

    private boolean astroAlgo_sun;
    private boolean vsop87_sun;
    private boolean astroAlgo_moon;
    private boolean elp2000_moon;
    private boolean elpMpp02_moon;
    private boolean elpMpp02Trunc;
    public  boolean isUseDeltaT;



    private double sun_trueGeocentricLongitude;
    private double sun_apparentGeocentricLongitude;
    private double sun_geocentricLatitude;
    private double sun_apparentRightAscension;
    private double sun_apparentDeclination;
    private double sun_trueGeocentricDistance;
    private double sun_angularSemiDiameter;
    private double sun_equationOfTime;
    private double sun_equatorialHorizontalParallax;
    private double earth_trueObliquity;

    private double moon_trueGeocentricLongitude;
    private double moon_apparentGeocentricLongitude;
    private double moon_apparentGeocentricLatitude;
    private double moon_apparentRightAscension;
    private double moon_apparentDeclination;
    private double moon_trueGeocentricDistance;
    private double moon_angularSemiDiameter;
    private double moon_equatorialHorizontalParallax;
    private double moon_diskIlluminatedFraction;
    private double moon_brightLimbAngle;
    private double moon_sunGeocentricElongation;

    public Ephem(double jd) {
        this.jd = jd;
        prosesHisabMatahari();
        prosesHisabBulan();
    }

    public Ephem(int tanggal, int bulan, int tahun, double jam_UT) {
        this.jd = Konversi.masehiKeJd(tanggal, bulan, tahun, jam_UT);
        prosesHisabMatahari();
        prosesHisabBulan();
    }

    Ephem(int tanggal, int bulan, int tahun, double jamdes, int zona_waktu) {
        this.jd = Konversi.masehiKeJd(tanggal, bulan, tahun, jamdes) - (zona_waktu / 24.0);
        prosesHisabMatahari();
        prosesHisabBulan();
    }

    private void prosesHisabMatahari() {
        if (astroAlgo_sun) {
            sun_trueGeocentricLongitude = Sun.astroAlgo.trueGeocentricLongitude(jd);
            sun_geocentricLatitude = Sun.astroAlgo.geocentricLatitude(jd);
            sun_apparentGeocentricLongitude = Sun.astroAlgo.apparentGeocentricLongitude(jd);
            sun_apparentRightAscension = Sun.astroAlgo.apparentRightAscension(jd);
            sun_apparentDeclination = Sun.astroAlgo.apparentDeclination(jd);
            sun_trueGeocentricDistance = Sun.astroAlgo.trueGeocentricDistance(jd);
            sun_angularSemiDiameter = Sun.astroAlgo.angularSemiDiameter(jd);
            earth_trueObliquity = Sun.astroAlgo.trueObliquity(jd);
            sun_equationOfTime = Sun.astroAlgo.equationOfTime(jd);
            sun_equatorialHorizontalParallax = Sun.astroAlgo.equatorialHorizontalParallax(jd);
        } else if (vsop87_sun) {
            fillVsop87();
        }
        else fillVsop87();
    }

    private void prosesHisabBulan() {

        if (astroAlgo_moon){
            moon_trueGeocentricLongitude= Moon.astroAlgo.trueGeocentricLongitude(jd);
            moon_apparentGeocentricLongitude= Moon.astroAlgo.apparentGeocentricLongitude(jd);
            moon_apparentGeocentricLatitude= Moon.astroAlgo.apparentGeocentricLatitude(jd);
            moon_apparentRightAscension= Moon.astroAlgo.apparentRightAscension(jd);
            moon_apparentDeclination= Moon.astroAlgo.apparentDeclination(jd);
            moon_trueGeocentricDistance= Moon.astroAlgo.trueGeocentricDistance(jd);
            moon_angularSemiDiameter= Moon.astroAlgo.angularSemiDiameter(jd);
            moon_equatorialHorizontalParallax= Moon.astroAlgo.equatorialHorizontalParallax(jd);
            moon_diskIlluminatedFraction= Moon.astroAlgo.diskIlluminatedFraction(jd);
            moon_brightLimbAngle= Moon.astroAlgo.brightLimbAngle(jd);
            moon_sunGeocentricElongation= Moon.astroAlgo.sunGeocentricElongation(jd);

        } else if (elp2000_moon){
         fillElp2000();

        }else if (elpMpp02_moon){
            moon_trueGeocentricLongitude= Moon.elpmpp02.trueGeocentricLongitude(jd);
            moon_apparentGeocentricLongitude= Moon.elpmpp02.apparentGeocentricLongitude(jd);
            moon_apparentGeocentricLatitude= Moon.elpmpp02.apparentGeocentricLatitude(jd);
            moon_apparentRightAscension= Moon.elpmpp02.apparentRightAscension(jd);
            moon_apparentDeclination= Moon.elpmpp02.apparentDeclination(jd);
            moon_trueGeocentricDistance= Moon.elpmpp02.trueGeocentricDistance(jd);
            moon_angularSemiDiameter= Moon.elpmpp02.angularSemiDiameter(jd);
            moon_equatorialHorizontalParallax= Moon.elpmpp02.equatorialHorizontalParallax(jd);
            moon_diskIlluminatedFraction= Moon.elpmpp02.diskIlluminatedFraction(jd);
            moon_brightLimbAngle= Moon.elpmpp02.brightLimbAngle(jd);
            moon_sunGeocentricElongation= Moon.elpmpp02.sunGeocentricElongation(jd);

        }else if (elpMpp02Trunc){

            moon_trueGeocentricLongitude= Moon.elpmpp02Trunc.trueGeocentricLongitude(jd);
            moon_apparentGeocentricLongitude= Moon.elpmpp02Trunc.apparentGeocentricLongitude(jd);
            moon_apparentGeocentricLatitude= Moon.elpmpp02Trunc.apparentGeocentricLatitude(jd);
            moon_apparentRightAscension= Moon.elpmpp02Trunc.apparentRightAscension(jd);
            moon_apparentDeclination= Moon.elpmpp02Trunc.apparentDeclination(jd);
            moon_trueGeocentricDistance= Moon.elpmpp02Trunc.trueGeocentricDistance(jd);
            moon_angularSemiDiameter= Moon.elpmpp02Trunc.angularSemiDiameter(jd);
            moon_equatorialHorizontalParallax= Moon.elpmpp02Trunc.equatorialHorizontalParallax(jd);
            moon_diskIlluminatedFraction= Moon.elpmpp02Trunc.diskIlluminatedFraction(jd);
            moon_brightLimbAngle= Moon.elpmpp02Trunc.brightLimbAngle(jd);
            moon_sunGeocentricElongation= Moon.elpmpp02Trunc.sunGeocentricElongation(jd);
        }
        else fillElp2000();



    }

    private void fillVsop87() {
        sun_trueGeocentricLongitude = Sun.vsop87.trueGeocentricLongitude(jd);
        sun_geocentricLatitude = Sun.vsop87.geocentricLatitude(jd);
        sun_apparentGeocentricLongitude = Sun.vsop87.apparentGeocentricLongitude(jd);
        sun_apparentRightAscension = Sun.vsop87.apparentRightAscension(jd);
        sun_apparentDeclination = Sun.vsop87.apparentDeclination(jd);
        sun_trueGeocentricDistance = Sun.vsop87.trueGeocentricDistance(jd);
        sun_angularSemiDiameter = Sun.vsop87.angularSemiDiameter(jd);
        earth_trueObliquity = Sun.vsop87.trueObliquity(jd);
        sun_equationOfTime = Sun.vsop87.equationOfTime(jd);
        sun_equatorialHorizontalParallax = Sun.vsop87.equatorialHorizontalParallax(jd);

    }

    private void fillElp2000(){
        moon_trueGeocentricLongitude= Moon.elp2000.trueGeocentricLongitude(jd);
        moon_apparentGeocentricLongitude= Moon.elp2000.apparentGeocentricLongitude(jd);
        moon_apparentGeocentricLatitude= Moon.elp2000.apparentGeocentricLatitude(jd);
        moon_apparentRightAscension= Moon.elp2000.apparentRightAscension(jd);
        moon_apparentDeclination= Moon.elp2000.apparentDeclination(jd);
        moon_trueGeocentricDistance= Moon.elp2000.trueGeocentricDistance(jd);
        moon_angularSemiDiameter= Moon.elp2000.angularSemiDiameter(jd);
        moon_equatorialHorizontalParallax= Moon.elp2000.equatorialHorizontalParallax(jd);
        moon_diskIlluminatedFraction= Moon.elp2000.diskIlluminatedFraction(jd);
        moon_brightLimbAngle= Moon.elp2000.brightLimbAngle(jd);
        moon_sunGeocentricElongation= Moon.elp2000.sunGeocentricElongation(jd);
    }

    public double getSun_trueGeocentricLongitude() {
        return sun_trueGeocentricLongitude;
    }

    public double getSun_apparentGeocentricLongitude() {
        return sun_apparentGeocentricLongitude;
    }

    public double getSun_geocentricLatitude() {
        return sun_geocentricLatitude;
    }

    public double getSun_apparentRightAscension() {
        return sun_apparentRightAscension;
    }

    public double getSun_apparentDeclination() {
        return sun_apparentDeclination;
    }

    public double getSun_trueGeocentricDistance() {
        return sun_trueGeocentricDistance;
    }

    public double getSun_angularSemiDiameter() {
        return sun_angularSemiDiameter;
    }

    public double getSun_equationOfTime() {
        return sun_equationOfTime;
    }

    public double getSun_equatorialHorizontalParallax() {
        return sun_equatorialHorizontalParallax;
    }

    public double getEarth_trueObliquity() {
        return earth_trueObliquity;
    }

    public double getMoon_trueGeocentricLongitude() {
        return moon_trueGeocentricLongitude;
    }

    public double getMoon_apparentGeocentricLongitude() {
        return moon_apparentGeocentricLongitude;
    }

    public double getMoon_apparentGeocentricLatitude() {
        return moon_apparentGeocentricLatitude;
    }

    public double getMoon_apparentRightAscension() {
        return moon_apparentRightAscension;
    }

    public double getMoon_apparentDeclination() {
        return moon_apparentDeclination;
    }

    public double getMoon_trueGeocentricDistance() {
        return moon_trueGeocentricDistance;
    }

    public double getMoon_angularSemiDiameter() {
        return moon_angularSemiDiameter;
    }

    public double getMoon_equatorialHorizontalParallax() {
        return moon_equatorialHorizontalParallax;
    }

    public double getMoon_diskIlluminatedFraction() {
        return moon_diskIlluminatedFraction;
    }

    public double getMoon_brightLimbAngle() {
        return moon_brightLimbAngle;
    }

    public double getMoon_sunGeocentricElongation() {
        return moon_sunGeocentricElongation;
    }

    /**
     * bila method ini tidak di-set maka secara otomatis akan memeilih metode hisab default yaitu metode elp2000.
     */
    public MetodeHisabBulan setTerm_moon() { //Methods
        return new MetodeHisabBulan();
    }

    public MetodeHisabBulan setDataBulan() { //Nama lain dari yang atas, dikawatirkan kebingungan
        return new MetodeHisabBulan();
    }

    public class MetodeHisabBulan { //class in a class
        public void elp2000() {
            elp2000_moon = true;
            elpMpp02_moon = false;
            elpMpp02Trunc = false;
            astroAlgo_moon = false;
            prosesHisabBulan();

        }

        public void elpMpp02() {
            elp2000_moon = false;
            elpMpp02_moon = true;
            elpMpp02Trunc = false;
            astroAlgo_moon = false;
            prosesHisabBulan();

        }

        public void elpMpp02Trunc() {
            elp2000_moon = false;
            elpMpp02_moon = false;
            elpMpp02Trunc = true;
            astroAlgo_moon = false;
            prosesHisabBulan();

        }

        public void astroAlgo() {
            elp2000_moon = false;
            elpMpp02_moon = false;
            elpMpp02Trunc = false;
            astroAlgo_moon = true;
            prosesHisabBulan();

        }

    }

    /**
     * bila method ini tidak di-set maka secara otomatis akan memeilih metode hisab default yaitu metode Vsop87.
     */
    public MetodeHisabMatahari setTerm_sun() { //Methods
        return new MetodeHisabMatahari();
    }

    public MetodeHisabMatahari setDataMatahari() { //Nama lain dari yang atas, dikawatirkan kebingungan
        return new MetodeHisabMatahari();
    }

    public class MetodeHisabMatahari { //class in a class
        public void vsop87() {
            vsop87_sun = true;
            astroAlgo_sun = false;
            prosesHisabMatahari();

        }

        public void astroAlgo() {
            vsop87_sun = false;
            astroAlgo_sun = true;
            prosesHisabMatahari();

        }

    }

    public deltaT gunakandeltaT() { //Nama lain dari yang atas, dikawatirkan kebingungan
        return new deltaT();
    }

    public class deltaT { //class in a class
        double tgl=Konversi.jdKeMasehi(jd)[1];
        double bln=Konversi.jdKeMasehi(jd)[2];
        double thn=Konversi.jdKeMasehi(jd)[3];
        public void True() {

            double delta_T= DynamicalTime.delta_t(tgl,bln,thn); // mau pakai delta T atau tidak?
             jd +=(delta_T/86400);
             isUseDeltaT=true;
            prosesHisabMatahari();
            prosesHisabBulan();

        }

        public void False() {
            isUseDeltaT=false;
            prosesHisabMatahari();
            prosesHisabBulan();
        }

    }

}
