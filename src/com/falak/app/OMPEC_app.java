package com.falak.app;
import com.falak.Konversi;
import com.falak.ephemeris.DynamicalTime;

import static java.lang.Math.*;
import static com.falak.Mathf.*;
import static  com.falak.Print.*;
public class OMPEC_app {
    public static void main(String[] args) {
        int tanggal;
        int bulan;
        int tahun;
        int jam=0;
        int menit=0;
        double detik=0;
        int zona_waktu=7;
        int typeCal =random(1,4);
        tanggal = 1; bulan = 1; tahun = 2019;
        double decimalHour = tanggal+(Konversi.dmsKeDesimal(jam,menit,detik)-zona_waktu)/24;
        double deltaT = DynamicalTime.delta_t(tanggal,bulan,tahun);
        double geographichal_longitude = Konversi.dmsKeDesimal(109,54,8.4);
        double geographical_latitude =       Konversi.dmsKeDesimal(-7,21,23.1);
        double height_of_observer = 854.5; // above sea level
        int m =bulan; // Auxiliary quantity month
        int y=tahun; // Auxiliary quantity year
        if (bulan<=2) {
            m = bulan + 12;
            y = tahun-1;
        }
        int A;
        int B = 0;

        //bila masuk periode Gregorian
        if ((tahun + bulan / 100.0 + tanggal / 10000.0) >= 1582.1015) {
            B=(int)(y/400)-(int)(y/100);
        }
        else B=-2;

        double jd = (int)(365.25*y)+(int)(30.6001*(m+1))+B+1720996.5+decimalHour;
        double aq_a = (int)(jd+0.5+0/24); // Auxiliary quantity A
        double aq_b=0,aq_c,aq_d,aq_e,aq_f ;
        if (typeCal==2||typeCal==1&&aq_a>=2299161){
            aq_b=aq_a+(int)((aq_a-1867216.25)/36524.25)-(int)((aq_a-1867216.25)/(4*36524.25))+1525;
            System.out.println(true);
        }else aq_b=aq_a+1524;
        aq_c=(int)((aq_b-122.1)/365.25);


        aq_d = (int)(365.25*aq_c);
        aq_e = (int)((aq_b-aq_d)/30.6001);
        print("aqA",aq_a);
        print("aqB",aq_b);
        print("aqC",aq_c);
        print("aqD",aq_d);
        print("aqE",aq_e);
        double ccald =  (aq_b-aq_d-(int)(30.6001*aq_e));
        double ccalm = aq_e-1-12*(int)(aq_e/14);
        double ccaly = aq_c-4715-(int)((7+ccalm)/10);
        int dcHrs = (int) (24*((jd+0.5+0/24.0)%1));
        print("CcaLD",ccald);
        print("Ccalm",ccalm);
        print("Ccaly",ccaly);
        print("DcHrs",dcHrs);
        double jd_1_jan = (int)(365.25*(ccaly-1))+(int)(30.6001*14)+B+1720996.5+1;
        double jd_31_des = (int)(365.25*ccaly)+(int)(30.6001*13)+B+1720996.5+32;
        double diy = jd_31_des-jd_1_jan;
        double doy = jd-jd_1_jan;
        double dcy = ccaly+doy/diy;

        print("J Day 0 UT 1 Jan "+(int)ccaly,jd_1_jan);
        print("J Day 24 UT 1 Jan "+(int)ccaly,jd_31_des);
        print("Day of Year",doy);
        print("Days in the Year",diy);
        print("Decimla Year",dcy);
        deltaT=71.0584318501444 /86400;
        double jde = jd+deltaT;
        double t = (jde-2451545)/36525;

        print("Julian Day",jd,5);
        print("Julian Ephemeris Day",jde,5);
        print("JD from 2000 1.5 ET",t);

        double mean_long_moon = mod(218.316+481267.881*t,360);
        double mean_anomaly_moon = mod(134.963+477198.867*t,360);
        double mean_long_node_moon = mod(125.045-1934.136*t,360);
        mean_long_node_moon = mod(mean_long_node_moon,360);
        double mean_long_sun = mod(280.466+36000.77*t,360);
        double mean_anomaly_sun = mod(357.528+35999.05*t,360);
        printDms("mean_long_moon",mean_long_moon);
        printDms("mean_anomaly_moon",mean_anomaly_moon);
        printDms("mean_long_node_moon",mean_long_node_moon);
        printDms("mean_long_sun",mean_long_sun);
        printDms("mean_anomaly_sun",mean_anomaly_sun);
        double nutation_long = (-17.2*sin(rad(mean_long_node_moon))+0.206*sin(rad(2*mean_long_node_moon))-1.319*sin(rad(2*mean_long_sun))+0.143*sin(rad(mean_anomaly_sun))-0.227*sin(rad(2*mean_long_moon))+0.071*sin(rad(mean_anomaly_moon)))/3600;
        double nutation_obliquity = (9.203*cos(rad(mean_long_node_moon))-0.09*cos(rad(2*mean_long_node_moon))+0.574*cos(rad(2*mean_long_sun))+0.022*cos(rad(2*mean_long_sun+mean_anomaly_sun))+0.098*cos(rad(2*mean_long_moon))+0.02*cos(rad(2*mean_long_moon-mean_long_node_moon)))/3600;
        double obliquity_ecl_mean =23+(26/60.0)+(21.45/3600)-((46.82*t)/3600); // mean_obliquity of ecliptic
        double obliquity_ecl_true = obliquity_ecl_mean+nutation_obliquity; //true_obliquity of ecliptic
        printDms("Nutation in Longitude",nutation_long);
        printDms("Nutation in Obliquity",nutation_obliquity);
        printDms("Mean Obliquity of Ecl",obliquity_ecl_mean);
        printDms("True Obliquity of Ecl",obliquity_ecl_true);

        double jd_00_UT = (int)(jd+0.5)-0.5;
        double decimal_hour_UT = 24*mod(jd+0.5+0/24.0,1);
        double gmst = mod(6.656306+0.0657098242*(jd_00_UT-2445700.5)+1.0027379093*decimal_hour_UT,24); // Greenwich Mean Sidereal Time
        double gast = mod(gmst+nutation_long*cos(rad(obliquity_ecl_true))/15,24); //Greenwich Apparent Sidereal Time
        double lmst = mod(gmst+geographichal_longitude/15,24); //Local Mean Sidereal Time
        double last = mod(lmst+nutation_long*cos(rad(obliquity_ecl_true))/15,24); // Local Apparent Sidereal Time
        printHms("GMST",gmst);
        printHms("GAST",gast);
        printHms("LMST",lmst);
        printHms("LAST",last);

        //Geocentric Ecliptic Coordinates of the Sun (this is an abridged version of Simon Newcomb’s Theory of the Solar Motion)
        double t19 = (jde-2415020)/36525; //Julian Century from J1900.0

        // The Mean Longitudes
        double dlp = (+(1.882-0.016*t19)*sin(rad(57.24+150.27*t19))+(6.4)*sin(rad(231.19+20.2*t19))+(0.266)*sin(rad(31.8+119*t19)))/3600; // Long period pertubation of the sun's mean longitude and it's mean anomaly
        double LO = mod(279.6966778+36000*t19+(2768.13*t19+1.089*pow(t19,2)+0.202*sin(rad(315.6+893.3*t19)))/3600+dlp,360);// Mean Longitude of the sun
        double g = mod(358.4758333+35999*t19+(179.1*t19-0.54*pow(t19,2))/3600+dlp,360); // Mean Anomaly of Sun
        double g2 = mod(212.45+58517.493*t19,360); // Mean Anomaly of Venus
        double g4 = mod(319.58+19139.977*t19,360); // Mean Anomaly of Mars
        double g5 = mod(225.28+3034.583*t19+(1300*sin(rad(133.775+39.804*t19)))/3600,360); // Mean Anomaly of Jupiter
        double g6 = mod(175.6+1221.794*t19,360);  // Mean Anomaly of saturn
        double d = mod(350.737486+445267.114217*t19,360); // Mean Angular distance of the moon from sun
        double a = mod(296.104608+477198.849108*t19,360); // Mean Nomaly of the Moon
        double u = mod(11.250889+483202.02515*t19,360); // Mean Argument of the latitude of the moon

        print("J Century from J1900",t19);
        printDms("Long Period Pertubation",dlp);
        printDms("Mean Longitudec Sun",LO);
        printDms("Mean Anomaly Sun",g);
        printDms("Mean Anomaly Venus",g2);
        printDms("Mean Anomaly Mars",g4);
        printDms("Mean Anomaly Jupiter",g5);
        printDms("Mean  Anomaly Saturn",g6);
        printDms("Mean Angular Dis moon-sun",d);
        printDms("Mean Anomaly Moon",a);
        printDms("Mean Argument lat Moon",u);




        // Terms of the Two-Body Motion
        double dl  = (+(6910.057-17.24*t19)*sin(rad(g))+(72.338-0.361*t19)*sin(rad(2*g))+(1.054)*sin(rad(3*g)))/3600; // Diffrence between true an mean longitudes of the sun
        double r0 = +(0.00003057-0.00000015*t19)+(-0.00727412+0.00001814*t19)*cos(rad(g))+
                (-0.00009138+0.00000046*t19)*cos(rad(2*g))+(-0.00000145)*cos(rad(3*g)); // logarithm to base ten of the radius in AU
        printDms("Diffrence true - mean", dl);
        printDms("Logarithm to b10 AU",r0);

        double dl2 = (4.838*cos(rad(299.102+g2-g))+0.116*cos(rad(148.9+2*g2-g))+5.526*cos(rad(148.313+2*g2-2*g))+2.497*cos(rad(315.943+2*g2-3*g))+
                0.66*cos(rad(177.71+3*g2-3*g))+1.559*cos(rad(345.253+3*g2-4*g))+1.024*cos(rad(318.15+3*g2-5*g))+0.21*cos(rad(206.2+4*g2-4*g))+
                0.144*cos(rad(195.4+4*g2-5*g))+0.152*cos(rad(343.8+4*g2-6*g))+0.123*cos(rad(195.3+5*g2-7*g))+0.154*cos(rad(359.6+5*g2-8*g)))/3600; // Longitude perturbation by Venus
        double dl4 = (0.273*cos(rad(217.7-g4+g))+2.043*cos(rad(343.888-2*g4+2*g))+1.77*cos(rad(200.402-2*g4+g))+0.129*cos(rad(294.2-3*g4+3*g))+
                0.425*cos(rad(338.88-3*g4+2*g))+0.5*cos(rad(105.18-4*g4+3*g))+0.585*cos(rad(334.06-4*g4+2*g))+0.204*cos(rad(100.8-5*g4+3*g))+
                0.154*cos(rad(227.4-6*g4+4*g))+0.101*cos(rad(96.3-6*g4+3*g))+0.106*cos(rad(222.7-7*g4+4*g)))/3600; // Longitude perturbation by Mars
        double dl5 = (0.163*cos(rad(198.6-g5+2*g))+7.208*cos(rad(179.532-g5+g))+2.6*cos(rad(263.217-g5))+2.731*cos(rad(87.145-2*g5+2*g))+
                1.61*cos(rad(109.493-2*g5+g))+0.164*cos(rad(170.5-3*g5+3*g))+0.556*cos(rad(82.65-3*g5+2*g))+0.21*cos(rad(98.5-3*g5+g)))/3600; // Longitude perturbation by Jupiter
        double dl6 = (0.419*cos(rad(100.58-g6+g))+0.32*cos(rad(269.46-g6))+0.108*cos(rad(290.6-2*g6+2*g))+0.112*cos(rad(293.6-2*g6+g)))/3600; // Longitude perturbation by Saturn
        double dlm = (6.454*sin(rad(d))+0.177*sin(rad(d+a))-0.424*sin(rad(d-a))+0.172*sin(rad(d-g)))/3600; //Longitude perturbation by the Moon

        // The True Longitude
        double ecl_long_sun_true = mod(LO+dl+dl2+dl4+dl5+dl6+dlm,360);
//        double l_appr = l+(-20.496/)

        // Pertubations of the Radius Vector
        double dr2 = (2359*cos(rad(209.08+g2-g))+160*cos(rad(58.4+2*g2-g))+6842*cos(rad(58.318+2*g2-2*g))+869*cos(rad(226.7+2*g2-3*g))+1045*cos(rad(87.57+3*g2-3*g))+
                1497*cos(rad(255.25+3*g2-4*g))+194*cos(rad(49.5+3*g2-5*g))+376*cos(rad(116.28+4*g2-4*g))+196*cos(rad(105.2+4*g2-5*g))+
                163*cos(rad(145.4+5*g2-5*g))+141*cos(rad(105.4+5*g2-7*g)))/1000000000;
        double dr4 = (150*cos(rad(127.7-g4+g))+2057*cos(rad(253.828-2*g4+2*g))+151*cos(rad(295-2*g4+g))+168*cos(rad(203.5-3*g4+3*g))+
                215*cos(rad(249-3*g4+2*g))+478*cos(rad(15.17-4*g4+3*g))+105*cos(rad(65.9-4*g4+2*g))+107*cos(rad(324.6-5*g4+4*g))+
                139*cos(rad(137.3-6*g4+4*g)))/1000000000;
        double dr5=(208*cos(rad(112-g5+2*g))+7067*cos(rad(89.545-g5+g))+244*cos(rad(338.6-g5))+103*cos(rad(350.5-2*g5+3*g))+
                4026*cos(rad(357.108-2*g5+2*g))+1459*cos(rad(19.467-2*g5+g))+
                281*cos(rad(81.2-3*g5+3*g))+803*cos(rad(352.56-3*g5+2*g))+
                174*cos(rad(8.6-3*g5+g))+113*cos(rad(347.7-4*g5+2*g)))/1000000000;
        double dr6 = (429*cos(rad(10.6-g6+g))+162*cos(rad(200.6-2*g6+2*g))+112*cos(rad(203.1-2*g6+g)))/1000000000;
        double drm = (13360*cos(rad(d))+370*cos(rad(d+a))-1330*cos(rad(d-a))-140*cos(rad(d+g))+360*cos(rad(d-g)))/1000000000;
        double r = pow(10,r0+dr2+dr4+dr5+dr6+drm);
        double ecl_long_sun_appr = ecl_long_sun_true+(-20.496/r)/3600+nutation_long;



        System.out.println("Pertubation");
        printDms("- in log(R) by Venus ",dr2,7);
        printDms("- in log(R) by Mars",dr4,7);
        printDms("- in log(R) by Jupiter",dr5,7);
        printDms("- in log(R) by Saturn",dr6,7);
        printDms("- in log(R) by the Moon",drm,7);
        //The radius Vector
        printDigit("Radius Vector Sun AU",r,9);

        printDms("Appr Longitude Sun",ecl_long_sun_appr);

        //The ecliptic Latitude of the Sun
        double ecl_lat_sun = (-0.21*cos(rad(151.8+3*g2-4*g))-0.166*cos(rad(265.5-2*g5+g))+0.576*sin(rad(u)))/3600;
        printDms("ecliptic Latitude Sun",ecl_lat_sun);
        double appr_semi_diameter_sun = toDegrees(atan(1/r*tan(rad(15/60.0+59.63/3600)))); //Apparent Angular semi diameter of the sun
        double hp_sun = toDegrees(asin(sin(rad(8.794/3600))/r)); //Equatorial-horizontal parallax of the sun
        printDms("Appr  Sdiameter Sun",appr_semi_diameter_sun,4);
        printDms("Equa-Horz parallax Sun",hp_sun,4);

        // The mean Longitude
        double f34 = mod(270.434164+481267.883142*t19-0.001133*pow(t19,2),360); // Mean longitude of the moon
        double f35 = mod(296.104608+477198.849108*t19+0.009192*pow(t19,2),360); // Mean anomaly of the moon
        double f36 = mod(259.183275-1934.142008*t19+0.002078*pow(t19,2),360); // Mean longitude of the ascending node of the lunar orbit
        double f37 = mod(279.696678+36000.768925*t19+0.000303*pow(t19,2),360); // Mean longitude of the sun
        double f38 = mod(358.475833+35999.04975*t19-0.00015*pow(t19,2),360); //Mean Anomaly of the sun
//             double l_mm = mod(270.434164+481267.883142*t19-0.001133*pow(t19,2),360); // Mean longitude of the moon
//        double m_mm = mod(296.104608+477198.849108*t19+0.009192*pow(t19,2),360); // Mean anomaly of the moon
//        double o_mm = mod(259.183275-1934.142008*t19+0.002078*pow(t19,2),360); // Mean longitude of the ascending node of the lunar orbit
//        double l_sm = mod(279.696678+36000.768925*t19+0.000303*pow(t19,2),360); // Mean longitude of the sun
//        double m_sm = mod(358.475833+35999.04975*t19-0.00015*pow(t19,2),360); //Mean Anomaly of the sun
//


        printDms("Mean long Moon",f34);
        printDms("Mean anomaly Moon",f35);
        printDms("Long asc lunar orbit",f36);
        printDms("Mean long Sun",f37);
        printDms("Mean Anomaly Sun",f38);
        double ecl_long_moon_true = mod(f34+(22640*sin(rad(f35))+769*sin(rad(2*f35))+36*sin(rad(3*f35))-125*sin(rad(f34-f37))+2370*sin(rad(2*(f34-f37)))- 668*
                sin(rad(f38))-412*sin(rad(2*(f34-f36)))+212*sin(rad(2*(f34-f37-f35)))+4586*sin(rad(2*(f34-f37)-f35))+192*sin(rad(2*(f34-f37)+f35))+165*
                sin(rad(2*(f34-f37)-f38))+206*sin(rad(2*(f34-f37)-f35-f38))-110*sin(rad(f35+f38))+148*sin(rad(f35-f38)))/3600,360);
        double ecl_long_moon_appr = ecl_long_moon_true+nutation_long/3600+(0.018*cos(rad(f35-2*(f34-f37)))+0.007*cos(rad(2*(f34-f37))))/3600;
        double hp_moon = (3423+187*cos(rad(f35))+10*cos(rad(2*f35))+34*cos(rad(2*(f34-f37)-f35))+28*cos(rad(2*(f34-f37)))+3*cos(rad(2*(f34-f37)+f35)))/3600;
        double appr_sdc = toDegrees(asin(0.272493*sin(rad(hp_moon))));// Apparent angular semi-diameter of the moon
        double rt_EM_radii = 1/sin(rad(hp_moon));
        double r_EM_KM = 6378.14/sin(rad(hp_moon));
        double r_EM_AU = r_EM_KM/149597870;
        printDms("True ecl Long Moon",ecl_long_moon_true);
        printDms("Appr ecl Long Moon",ecl_long_moon_appr);
        printDms("Equa-Horz Parallax Moon",hp_moon);
        print("Dist E-M in Earth Radii",rt_EM_radii);
        print("Dist E-M in KM",r_EM_KM);
        print("Dist E-M in AU",r_EM_AU);

        // The ecliptic latitude of the Moon
        double ecl_lat_moon=(18520*sin(rad(ecl_long_moon_true-f36+0.114*sin(rad(2*(f34-f36)))+0.15*sin(rad(f38))))-526*sin(rad(2*f37-f34-f36))+44*sin(rad(2*f37-f34-f36+f35))-
                31*sin(rad(2*f37-f34-f36-f35))-23*sin(rad(2*f37-f34-f36+f38))+11*sin(rad(2*f37-f34-f36-f38))-25*sin(rad(f34-f36-2*f35))+
                21*sin(rad(f34-f36-f35)))/3600;
        printDms("Ecl Latitude Moon",ecl_lat_moon);

        // Geocentric Equatorial Coordinates of the sun and the Moon
        //Sun
        double alpha_sun_true = mod(toDegrees(atan2(+cos(rad(obliquity_ecl_mean))*cos(rad(ecl_lat_sun))*sin(rad(ecl_long_sun_true))-sin(rad(obliquity_ecl_mean))*sin(rad(ecl_lat_sun)),+cos(rad(ecl_lat_sun))*cos(rad(ecl_long_sun_true)))),360); // True Equatorial Right Ascension of the Sun
        double dec_sun_true = toDegrees(asin(+sin(rad(obliquity_ecl_mean))*cos(rad(ecl_lat_sun))*sin(rad(ecl_long_sun_true))+cos(rad(obliquity_ecl_mean))*sin(rad(ecl_lat_sun)))); // True Equatorial Declination of the Sun
        double alpha_sun_appr = mod(toDegrees(atan2(+cos(rad(obliquity_ecl_true))*cos(rad(ecl_lat_sun))*sin(rad(ecl_long_sun_appr))-sin(rad(obliquity_ecl_true))*sin(rad(ecl_lat_sun)),+cos(rad(ecl_lat_sun))*cos(rad(ecl_long_sun_appr)))),360);
        double dec_sun_appr = toDegrees(asin(+sin(rad(obliquity_ecl_true))*cos(rad(ecl_lat_sun))*sin(rad(ecl_long_sun_appr))+cos(rad(obliquity_ecl_true))*sin(rad(ecl_lat_sun)))); // True Equatorial Declination of the Sun

        printDms("True Right Asc Sun",alpha_sun_true,4);
        printDms("Appr Rigth Asc Sun",alpha_sun_appr,4);
        printDms("True Declination Sun",dec_sun_true,4);
        printDms("Appr Declination Sun",dec_sun_appr,3);
        double alpha_moon_true = mod(toDegrees(atan2(+cos(rad(obliquity_ecl_mean))*cos(rad(ecl_lat_moon))*sin(rad(ecl_long_moon_true))-sin(rad(obliquity_ecl_mean))*sin(rad(ecl_lat_moon)),+cos(rad(ecl_lat_moon))*cos(rad(ecl_long_moon_true)))),360); // True Equatorial Right Ascension of the Sun
        double alpha_moon_appr = mod(toDegrees(atan2(+cos(rad(obliquity_ecl_true))*cos(rad(ecl_lat_moon))*sin(rad(ecl_long_moon_appr))-sin(rad(obliquity_ecl_true))*sin(rad(ecl_lat_moon)),+cos(rad(ecl_lat_moon))*cos(rad(ecl_long_moon_appr)))),360); // True Equatorial Right Ascension of the Sun
        double dec_moon_true = toDegrees(asin(+sin(rad(obliquity_ecl_mean))*cos(rad(ecl_lat_moon))*sin(rad(ecl_long_moon_true))+cos(rad(obliquity_ecl_mean))*sin(rad(ecl_lat_moon)))); // True Equatorial Declination of the Sun
        double dec_moon_appr = toDegrees(asin(+sin(rad(obliquity_ecl_true))*cos(rad(ecl_lat_moon))*sin(rad(ecl_long_moon_appr))+cos(rad(obliquity_ecl_true))*sin(rad(ecl_lat_moon)))); // True Equatorial Declination of the Sun

        printDms("True Right Asc Moon",alpha_moon_true,4);
        printDms("Appr Right Asc Moon",alpha_moon_appr,4);
        printDms("True Declination Moon",dec_moon_true,4);
        printDms("Appr Declination Moon",dec_moon_appr,3);

        double angle_brigth_limb_moon =  toDegrees(atan2(cos(rad(dec_sun_appr))*sin(rad(alpha_sun_appr-alpha_moon_appr)),sin(rad(dec_sun_appr))*cos(rad(dec_moon_appr))-cos(rad(dec_sun_appr))*sin(rad(dec_moon_appr))*cos(rad(alpha_sun_appr-alpha_moon_appr)))); //Position Angle of the Sun / angle of the moon's bright limb
        double elongation = toDegrees(acos(sin(rad(dec_sun_appr))*sin(rad(dec_moon_appr))+cos(rad(dec_sun_appr))*cos(rad(dec_moon_appr))*cos(rad(alpha_sun_appr-alpha_moon_appr)))); // Elongation of the moon / geocentric elongation of the moon from the sun
        printDms("Angle Bright Limb M",angle_brigth_limb_moon);
        printDms("Elongation Moon-Sun",elongation);

        // Equation of time
        double eccentricity = 0.01675104-0.0000418*t19-0.000000126*pow(t19,2);
        double auxi_y = pow(tan(rad(obliquity_ecl_mean/2)),2);
        double eot = toDegrees(+auxi_y*sin(rad(2*LO))-2*eccentricity*sin(rad(g))+4*eccentricity*auxi_y*sin(rad(g))*cos(rad(2*LO))-1/2.0*pow(auxi_y,2)*sin(rad(4*LO))-5/4.0*pow(eccentricity,2)*sin(rad(2*g)))/15;
        print("Eccentricity Earth orbit",eccentricity);
        print("Auxiliary",auxi_y,9);
        printDms("Equation of Time",eot,2);

        // Geocentric Horizontal Coordinates of the Sun and the Moon
        double gmt_sun_HA = mod(gast-alpha_sun_appr/15,24);
        double lmt_sun_HA = mod(last-alpha_sun_appr/15,24);
        double az_sun = mod(toDegrees(atan2(cos(rad(dec_sun_appr))*sin(rad(15*lmt_sun_HA)),sin(rad(geographical_latitude))*cos(rad(dec_sun_appr))*cos(rad(15*lmt_sun_HA))-cos(rad(geographical_latitude))*sin(rad(dec_sun_appr))))+180,360);
        double alt_sun =toDegrees(asin(cos(rad(geographical_latitude))*cos(rad(dec_sun_appr))*cos(rad(15*lmt_sun_HA))+sin(rad(geographical_latitude))*sin(rad(dec_sun_appr))));

        double gmt_moon_HA = mod(gast-alpha_moon_appr/15,24);
        double lmt_moon_HA = mod(last-alpha_moon_appr/15,24);
        double az_moon = mod(toDegrees(atan2(cos(rad(dec_moon_appr))*sin(rad(15*lmt_moon_HA)),sin(rad(geographical_latitude))*cos(rad(dec_moon_appr))*cos(rad(15*lmt_moon_HA))-cos(rad(geographical_latitude))*sin(rad(dec_moon_appr))))+180,360);
        double alt_moon =toDegrees(asin(cos(rad(geographical_latitude))*cos(rad(dec_moon_appr))*cos(rad(15*lmt_moon_HA))+sin(rad(geographical_latitude))*sin(rad(dec_moon_appr))));

        printDms("GMT Hour Angle Sun",gmt_sun_HA);
        printDms("LMT Hour Angle Sun",lmt_sun_HA);
        printDms("Azimuth Sun",az_sun);
        printDms("Altitude Sun", alt_sun);

        printDms("GMT Hour Angle Moon",gmt_moon_HA);
        printDms("LMT Hour Angle Moon",lmt_moon_HA);
        printDms("Azimuth Moon",az_moon);
        printDms("Altitude Moon", alt_moon);

        //Topocentric coordinate of the sun and the moon (based on Jean Meeus, Astronomical formulae for calculator and Astronomical Algorithms)
        //Geocentric Rectangular Coordinates of the observer
        double flattening = 1/298.257; // the flattening of earth
        double equatorial_radius = 6378.14;
        double earth_polar_radius = equatorial_radius*(1-flattening);
        double auxi_u = toDegrees(atan(earth_polar_radius/equatorial_radius*tan(rad(geographical_latitude))));
        double gr_y = earth_polar_radius/equatorial_radius*sin(rad(auxi_u))+height_of_observer/6378140*sin(rad(geographical_latitude)); //Geocentric Rectangular Coordinates of the Observer y
        double gr_x = cos(rad(auxi_u))+height_of_observer/6378140*cos(rad(geographical_latitude)); // Geocentric Rectngular Coordinates of the Observer x
        print("Flattening Earth",flattening,9);
        print("Earth Equatorial Radius",equatorial_radius);
        print("Earth Polar Radius",earth_polar_radius);
        print("Rect Coor Observer y",gr_y);
        print("Rect Coor Observer x",gr_x);
        //Topocentric coordinate of the sun
        //Topocentric Ecliptical Coordinate of the Sun
        double auxi_n = cos(rad(ecl_long_sun_appr))*cos(rad(ecl_lat_sun))-gr_x*sin(rad(hp_sun))*cos(rad(15*last));
        double topo_ecl_long_sun = mod(toDegrees(atan2((sin(rad(ecl_long_sun_appr))*cos(rad(ecl_lat_sun))-sin(rad(hp_sun))*(gr_y*sin(rad(obliquity_ecl_true))+gr_x*cos(rad(obliquity_ecl_true))*sin(rad(15*last)))),auxi_n)),360);
        double topo_ecl_lat_sun = toDegrees(atan((cos(rad(topo_ecl_long_sun))*(sin(rad(ecl_lat_sun))-sin(rad(hp_sun))*(gr_y*cos(rad(obliquity_ecl_true))-gr_x*sin(rad(obliquity_ecl_true))*sin(rad(15*last)))))/auxi_n));
        double topo_semidiameter_sun = toDegrees(asin((cos(rad(topo_ecl_long_sun))*cos(rad(topo_ecl_lat_sun))*sin(rad(appr_semi_diameter_sun)))/auxi_n));



        double parallax_in_RA = mod(toDegrees(atan2((-gr_x*sin(rad(hp_sun))*sin(rad(15*lmt_sun_HA))),(cos(rad(dec_sun_appr))-gr_x*sin(rad(hp_sun))*cos(rad(15*lmt_sun_HA))))),360);
        double topo_eqr_RA_sun = mod(alpha_sun_appr+parallax_in_RA,360);
        double topo_eqr_dec_sun = toDegrees(atan2(((sin(rad(dec_sun_appr))-gr_y*sin(rad(hp_sun)))*cos(rad(parallax_in_RA))),(cos(rad(dec_sun_appr))-gr_x*sin(rad(hp_sun))*cos(rad(15*lmt_sun_HA)))));
        double topo_local_HA_sun = mod(lmt_sun_HA-parallax_in_RA/15,24);
        double parallax_in_altitude_sun = toDegrees(asin(1*sin(rad(hp_sun))*cos(rad(alt_sun))));
        double topo_horz_altitude_sun = alt_sun-parallax_in_altitude_sun; //without atmospheric refraction
        double topo_horz_azimuth_sun = az_sun;

        print("Auxiliary Quantity N",auxi_n);
        printDms("Auxiliary Quantity N",auxi_n,7);
        printDms("Topo Ecl Long Sun",topo_ecl_long_sun);
        printDms("Topo Ecl Lat Sun",topo_ecl_lat_sun);
        printDms("Topo Semidiameter Sun",topo_semidiameter_sun);
        printDms("Parallax in Right Asc",parallax_in_RA);
        printDms("Topo Eqr Right Asc",topo_eqr_RA_sun);
        printDms("Topo Eqr Declintaion",topo_eqr_dec_sun);
        printDms("Topo local HA sun",topo_local_HA_sun);
        printDms("Parallax in altitude sun", parallax_in_altitude_sun);
        printDms("Topo Horiz Altitude Sun",topo_horz_altitude_sun);
        printDms("Topo Horiz Azimuth Sun", topo_horz_azimuth_sun);


        //Topocentric Ecliptical Coordinate of the Moon
        double auxi_n_moon = cos(rad(ecl_long_moon_appr))*cos(rad(ecl_lat_moon))-gr_x*sin(rad(hp_moon))*cos(rad(15*last));
        double topo_ecl_long_moon = mod(toDegrees(atan2((sin(rad(ecl_long_moon_appr))*cos(rad(ecl_lat_moon))-sin(rad(hp_moon))*(gr_y*sin(rad(obliquity_ecl_true))+gr_x*cos(rad(obliquity_ecl_true))*sin(rad(15*last)))),auxi_n_moon)),360);
        double topo_ecl_lat_moon = toDegrees(atan((cos(rad(topo_ecl_long_moon))*(sin(rad(ecl_lat_moon))-sin(rad(hp_moon))*(gr_y*cos(rad(obliquity_ecl_true))-gr_x*sin(rad(obliquity_ecl_true))*sin(rad(15*last)))))/auxi_n_moon));
       // double topo_semidiameter_moon = toDegrees(asin((cos(rad(topo_ecl_long_moon))*cos(rad(topo_ecl_lat_moon))*sin(rad(appr_sdc)))/auxi_n_moon));
        double parallax_in_RA_moon = mod(toDegrees(atan2((-gr_x*sin(rad(hp_moon))*sin(rad(15*lmt_moon_HA))),(cos(rad(dec_moon_appr))-gr_x*sin(rad(hp_moon))*cos(rad(15*lmt_moon_HA))))),360);
        double topo_eqr_RA_moon = mod(alpha_moon_appr+parallax_in_RA_moon,360);
        double topo_eqr_dec_moon = toDegrees(atan2(((sin(rad(dec_moon_appr))-gr_y*sin(rad(hp_moon)))*cos(rad(parallax_in_RA_moon))),(cos(rad(dec_moon_appr))-gr_x*sin(rad(hp_moon))*cos(rad(15*lmt_moon_HA)))));
        double topo_local_HA_moon = mod(lmt_moon_HA-parallax_in_RA_moon/15,24);
        double parallax_in_altitude_moon = toDegrees(asin(1*sin(rad(hp_moon))*cos(rad(alt_moon))));
        double topo_horz_altitude_moon = alt_moon-parallax_in_altitude_moon; //without atmospheric refraction
        double topo_horz_azimuth_moon = az_moon;

        print("Auxiliary Quantity N Moon",auxi_n_moon);
        printDms("Auxiliary Quantity N",auxi_n_moon,7);
        printDms("Topo Ecl Long Moon Moon",topo_ecl_long_moon);
        printDms("Topo Ecl Lat Moon",topo_ecl_lat_moon);
       // printDms("Topo Semidiameter Moon",topo_semidiameter_moon);
        printDms("Parallax in Right Asc Moon",parallax_in_RA_moon);
        printDms("Topo Eqr Right Asc Moon",topo_eqr_RA_moon);
        printDms("Topo Eqr Declintaion Moon",topo_eqr_dec_moon);
        printDms("Topo local HA Moon",topo_local_HA_moon);
        printDms("Parallax in altitude Moon", parallax_in_altitude_moon);
        printDms("Topo Horiz Altitude Moon",topo_horz_altitude_moon);
        printDms("Topo Horiz Azimuth Moon", topo_horz_azimuth_moon);


        //SUMBER:
        // disadur dari aplikasi Spredsheet Algoritma_OMPEC, M. Sahlan Rosydi, catatan belajar ilmu hisab falak , circa 2013















    }

    static double mod(double a, double b){
        return (a%b+b)%b;
    }
}
