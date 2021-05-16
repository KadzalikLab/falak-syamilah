package com.falak;

import com.falak.term.*;
import com.falak.term.elpmpp02.ElpMpp02;

public class Calculation {

    public static double[] astroAlgo(double jd) {

        double T = (jd - 2451545) / 36525;
        double tau = T / 10;

        double deltaPsi = Nutation.nutationInLongitude(T);

        double epsilon = Nutation.obliquityOfEcliptic(T);  //Obliquity / kemiringan bumi
        double epsilon_r = Math.toRadians(epsilon);

        // bujur rata-rata bulan
        double mean_longitude_moon = (218.3164591 + 481267.88134236 * T - 0.0013268 * T * T + T * T * T / 538841 - T * T * T * T / 65194000) % 360;


        //elongasi rata2 bulan
        double d = (297.8502042 + 445267.1115168 * T - 0.00163 * T * T + T * T * T / 545868 - T * T * T * T / 113065000) % 360;
        double d_r = Math.toRadians(d);

        //anomali rata2 matahari
        double m = (357.5291092 + 35999.0502909 * T - 0.0001536 * T * T + T * T * T / 24490000) % 360;
        double m_r = Math.toRadians(m);

        //anomali rata2 bulan
        double ma = (134.9634114 + 477198.8676313 * T + 0.008997 * T * T + T * T * T / 69699 - T * T * T * T / 14712000) % 360;
        double ma_r = Math.toRadians(ma);

        //Argumen bujur bulan
        double f = (93.2720993 + 483202.0175273 * T - 0.0034029 * T * T - T * T * T / 3526000 + T * T * T * T / 863310000) % 360;
        double f_r = Math.toRadians(f);

        //eksentrisitas orbit
        double e = 1 - 0.002516 * T - 0.0000074 * T * T;


        double argumenA1 = (119.75 + 131.849 * T) % 360;
        double argumenA2 = (53.09 + 479264.29 * T) % 360;
        double argumenA3 = (313.45 + 481266.484 * T) % 360;
        double aA1_r = Math.toRadians(argumenA1);
        double aA2_r = Math.toRadians(argumenA2);
        double aA3_r = Math.toRadians(argumenA3);

        double L_moon = AstroAlgo.moonGeocentricLongitude(T);//hasil dari penjumlahan suku periodik lon bulan
        double koreksibujurB = (L_moon + 3958 * Math.sin(aA1_r) + 1962 * Math.sin(Math.toRadians(mean_longitude_moon) - f_r) + 318 * Math.sin(aA2_r)) / 1000000;

        //Koreksi bujur bulan
        double true_longitude_moon = (mean_longitude_moon + koreksibujurB) % 360; // bujur bulan rata-rata yang sudah di koreksi
        double apparent_longitude_moon = (true_longitude_moon + deltaPsi) % 360; // bujur bulan yang nampak
        if (apparent_longitude_moon < 0) apparent_longitude_moon += 360;
        double bujurB_nampak_r = Math.toRadians(apparent_longitude_moon);

        //Koreksi lintang bulan
        double latitude_moon = AstroAlgo.moonGeocentricLatitude(e, d_r, m_r, ma_r, f_r, Math.toRadians(mean_longitude_moon), aA1_r, aA3_r);
        double latitude_moon_rad = Math.toRadians(latitude_moon);


        //Koreksi jarak bumi-bulan
        double koreksiJarakBumiBumi = AstroAlgo.moonGeocentricDistance(e, d_r, m_r, ma_r, f_r);
        double moonEarth_distance = 385000.56 + koreksiJarakBumiBumi; //KM

        double horizontalParallax_moon = Math.toDegrees(Math.asin(6378.14 / moonEarth_distance)); //EquatorialHorizontalParallax
        double semiDiameter_moon = 358473400 / (moonEarth_distance * 3600); //Angular Moon SemiDiameter

        //apparent right ascension
        double apparent_RightAscension_moon = (Math.toDegrees(Math.atan2(Math.sin(bujurB_nampak_r) * Math.cos(epsilon_r) - Math.tan(latitude_moon_rad) * Math.sin(epsilon_r), Math.cos(bujurB_nampak_r)))) % 360;
        if (apparent_RightAscension_moon < 0) apparent_RightAscension_moon = (apparent_RightAscension_moon + 360) % 360;


        //declination
        double apparent_Declination_moon = Math.toDegrees(Math.asin(Math.sin(latitude_moon_rad) * Math.cos(epsilon_r) + Math.cos(latitude_moon_rad) * Math.sin(epsilon_r) * Math.sin(bujurB_nampak_r)));
        double apparent_Declination_moon_rad = Math.toRadians(apparent_Declination_moon);


        //Matahari
        double L_sun = AstroAlgo.earthHeliocentricLongitude(tau); //hasil penjumlahan koreksi l0+l1+l2 dst
        double theta = (L_sun + 180) % 360;
        double deltaTheta = -0.09033 / 3600;
        double true_longitude_sun = (theta + deltaTheta) % 360; //theta terkoreksi //bujur matahari yang sudah terkoreksi
        if (true_longitude_sun<0)true_longitude_sun+=360;

        double sunEarth_distance = AstroAlgo.earthRadiusVector(tau);
        double jarakBm_Mat_AU = 149598000 * sunEarth_distance; //AU

        double lambda1 = (theta - 1.397 * koreksibujurB - 0.00031 * koreksibujurB * koreksibujurB) % 360; // Lambda'
        double lambda1_rad = Math.toRadians(lambda1);

        double B = AstroAlgo.earthHeliocentricLatitude(tau); // hasil total koreksi B
        double beta = -B;
        double deltaBeta = 0.03916 * (Math.cos(lambda1_rad) - Math.sin(lambda1_rad));
        double latitude_sun = beta + deltaBeta; //beta Terkoreksi //lintang matahari, apparent (?)
        double latitude_sun_r = Math.toRadians(latitude_sun / 3600);


        double abberration = -20.4898 / (3600 * sunEarth_distance);
        double apparent_longitude_sun = (true_longitude_sun + deltaPsi + abberration) % 360; //Lambda / bujur matahari yang sudah ditambah beda nampak
        if (apparent_longitude_sun < 0) apparent_longitude_sun += 360;
        double apparent_longitude_sun_r = Math.toRadians(apparent_longitude_sun);
        double semiDiameter_sun = (959.63 / 3600) / sunEarth_distance;

        double apparent_RightAscension_sun = (Math.toDegrees(Math.atan2(Math.sin(apparent_longitude_sun_r) * Math.cos(epsilon_r) - Math.tan(latitude_sun_r) * Math.sin(epsilon_r), Math.cos(apparent_longitude_sun_r)))) % 360;
        if (apparent_RightAscension_sun < 0) apparent_RightAscension_sun = (apparent_RightAscension_sun + 360) % 360;

        double apparent_Declination_sun = Math.toDegrees(Math.asin(Math.sin(latitude_sun_r) * Math.cos(epsilon_r) + Math.cos(latitude_sun_r) * Math.sin(epsilon_r) * Math.sin(apparent_longitude_sun_r)));
        double apparent_Declination_sun_r = Math.toRadians(apparent_Declination_sun);


        double y_num, x_num;
        y_num = Math.cos(apparent_Declination_sun_r) * Math.sin(Math.toRadians(apparent_RightAscension_sun - apparent_RightAscension_moon));
        x_num = Math.sin(apparent_Declination_sun_r) * Math.cos(Math.toRadians(apparent_Declination_moon)) - Math.cos(Math.toRadians(apparent_Declination_sun)) * Math.sin(Math.toRadians(apparent_Declination_moon)) * Math.cos(Math.toRadians(apparent_RightAscension_sun - apparent_RightAscension_moon));
        double chi = Math.toDegrees(Math.atan2(y_num, x_num));
        if (chi < 0) chi += 360;

        double sudutFai = Math.acos(Math.sin(apparent_Declination_moon_rad) * Math.sin(apparent_Declination_sun_r) + Math.cos(apparent_Declination_moon_rad) * Math.cos(apparent_Declination_sun_r) * Math.cos(Math.toRadians(apparent_RightAscension_moon - apparent_RightAscension_sun)));
        double sudutFase = Math.atan2(jarakBm_Mat_AU * Math.sin(sudutFai), moonEarth_distance - jarakBm_Mat_AU * Math.cos(sudutFai));
        //double sudutFase_d=Math.toDegrees(sudutFase);

        double moonDiskIlluminatedFraction = (1 + Math.cos(sudutFase)) / 2;


        return new double[]{0,
                true_longitude_sun//1
                , apparent_longitude_sun,//2
                latitude_sun,//3
                apparent_RightAscension_sun,//4
                apparent_Declination_sun,//5
                sunEarth_distance,//6
                semiDiameter_sun,//7
                tau,//8
                deltaPsi,//9
                epsilon//10
                , true_longitude_moon//11
                , apparent_longitude_moon//12
                , latitude_moon//13
                , apparent_RightAscension_moon//14
                , apparent_Declination_moon//15
                , moonEarth_distance//16
                , semiDiameter_moon//17
                , horizontalParallax_moon//18
                , moonDiskIlluminatedFraction//19
                , chi//20
        };

    }


    public static double[] vsop87(double jd) {

        double T = (jd - 2451545) / 36525;
        double tau = T / 10;

        double deltaPsi = Nutation.nutationInLongitude(T);

        double epsilon = Nutation.obliquityOfEcliptic(T);  //Obliquity / kemiringan bumi
        double epsilon_r = Math.toRadians(epsilon);

        //Matahari
        double L_sun = Vsop87.earthHeliocentricLongitude(tau); //hasil penumlahan koreksi l0+l1+l2 dst
        double theta = (L_sun + 180) % 360;
        double deltaTheta = -0.09033 / 3600;
        double true_longitude_sun = (theta + deltaTheta) % 360; //theta terkoreksi //bujur matahari yang sudah terkoreksi

        double sunEarth_distance = Vsop87.earthRadiusVector(tau);
        double sunEarth_distance_AU = 149598000 * sunEarth_distance; //AU

        double lambda1 = (theta - 1.397 * T - 0.00031 * T * T) % 360; // Lambda'
        double lambda1_rad = Math.toRadians(lambda1);

        double B = Vsop87.earthHeliocentricLatitude(tau); // hasil total koreksi B
        double beta = -B;
        double deltaBeta = 0.03916 * (Math.cos(lambda1_rad) - Math.sin(lambda1_rad));
        double latitude_sun = (beta + deltaBeta) / 3600; //beta Terkoreksi //lintang matahari, apparent (?)
        //System.out.println(latitude_sun);
        double latitude_sun_r = Math.toRadians(latitude_sun);


        double abberration = -20.4898 / (3600 * sunEarth_distance);
        double apparent_longitude_sun = (true_longitude_sun + deltaPsi + abberration) % 360; //Lambda / bujur matahari yang sudah ditambah beda nampak
        if (apparent_longitude_sun < 0) apparent_longitude_sun += 360;
        double apparent_longitude_sun_r = Math.toRadians(apparent_longitude_sun);
        double semiDiameter_sun = (959.63 / 3600) / sunEarth_distance;

        double apparent_RightAscension_sun = (Math.toDegrees(Math.atan2(Math.sin(apparent_longitude_sun_r) * Math.cos(epsilon_r) - Math.tan(latitude_sun_r) * Math.sin(epsilon_r), Math.cos(apparent_longitude_sun_r)))) % 360;
        if (apparent_RightAscension_sun < 0) apparent_RightAscension_sun = (apparent_RightAscension_sun + 360) % 360;

        double apparent_Declination_sun = Math.toDegrees(Math.asin(Math.sin(latitude_sun_r) * Math.cos(epsilon_r) + Math.cos(latitude_sun_r) * Math.sin(epsilon_r) * Math.sin(apparent_longitude_sun_r)));
        double apparent_Declination_sun_r = Math.toRadians(apparent_Declination_sun);


        return new double[]{0,
                true_longitude_sun//1
                , apparent_longitude_sun,//2
                latitude_sun,//3
                apparent_RightAscension_sun,//4
                apparent_Declination_sun,//5
                sunEarth_distance,//6
                semiDiameter_sun,//7
                tau,//8
                deltaPsi,//9
                epsilon,//10
                sunEarth_distance_AU//11
        };

    }


    public static double[] elpMpp02(double jd) {


        double T = (jd - 2451545) / 36525;



        double epsilon = Nutation.obliquityOfEcliptic(T); //Obliquity / kemiringan bumi
        double epsilon_r = Math.toRadians(epsilon);


        double t0,t1,t2,t3,t4;
        t0=1; t1=t0*T; t2=t1*T; t3=t2*T; t4=t3*T;
        double mean_longitude_moon = ElpMpp02.meanLongitude(t1,t2,t3,t4);

        double koreksibujurB = ElpMpp02.koreksiLongitude(t1,t2,t3,t4);
        double deltaPsi = Nutation.nutationInLongitude(T);

        //Koreksi bujur bulan
        double true_longitude_moon = (mean_longitude_moon + koreksibujurB) % 360;
        double apparent_longitude_moon = (true_longitude_moon + deltaPsi) % 360;
        if (apparent_longitude_moon < 0) apparent_longitude_moon += 360;

        double bujurB_nampak_r = Math.toRadians(apparent_longitude_moon);

        //Koreksi lintang bulan
        double latitude_moon = ElpMpp02.latitude(t1,t2,t3,t4);
        double lintangB_r = Math.toRadians(latitude_moon);

        //Koreksi jarak bumi-bulan
        double moonEarth_distance = ElpMpp02.range(t1,t2,t3,t4);


        double horizontalParallax_moon = Math.toDegrees(Math.asin(6378.14 / moonEarth_distance));
        double semiDiameter_moon = 358473400 / (moonEarth_distance * 3600);

        double apparent_RightAscension_moon = (Math.toDegrees(Math.atan2(Math.sin(bujurB_nampak_r) * Math.cos(epsilon_r) - Math.tan(lintangB_r) * Math.sin(epsilon_r), Math.cos(bujurB_nampak_r)))) % 360;
        if (apparent_RightAscension_moon < 0) apparent_RightAscension_moon = (apparent_RightAscension_moon + 360) % 360;


        double apparent_Declination_moon = Math.toDegrees(Math.asin(Math.sin(lintangB_r) * Math.cos(epsilon_r) + Math.cos(lintangB_r) * Math.sin(epsilon_r) * Math.sin(bujurB_nampak_r)));
        double deltaBulan_r = Math.toRadians(apparent_Declination_moon);


        double deltaM_r = Math.toRadians(Sun.Vsop87.apparentDeclination(jd));
        double alphaMatahari = (Sun.Vsop87.apparentRightAscension(jd));
        double jarakBm_M = (vsop87(jd)[11]);//AU


        double y_num, x_num;
        y_num = Math.cos(deltaM_r) * Math.sin(Math.toRadians(alphaMatahari - apparent_RightAscension_moon));
        x_num = Math.sin(deltaM_r) * Math.cos(deltaBulan_r) - Math.cos(deltaM_r) * Math.sin(deltaBulan_r) * Math.cos(Math.toRadians(alphaMatahari - apparent_RightAscension_moon));
        double chi = Math.toDegrees(Math.atan2(y_num, x_num));
        if (chi < 0) chi += 360;

        double sudutFai = Math.acos(Math.sin(deltaBulan_r) * Math.sin(deltaM_r) + Math.cos(deltaBulan_r) * Math.cos(deltaM_r) * Math.cos(Math.toRadians(apparent_RightAscension_moon - alphaMatahari)));
        double sudutFase = Math.atan2(jarakBm_M * Math.sin(sudutFai), moonEarth_distance - jarakBm_M * Math.cos(sudutFai));
        // double sudutFase_d=Math.toDegrees(sudutFase);

        double iluminasiB = (1 + Math.cos(sudutFase)) / 2;


        return new double[]{0
                , true_longitude_moon//1
                , apparent_longitude_moon//2
                , latitude_moon//3
                , apparent_RightAscension_moon//4
                , apparent_Declination_moon//5
                , moonEarth_distance//6
                , semiDiameter_moon//7
                , horizontalParallax_moon//8
                , chi//9
                , iluminasiB//10
        };
    }

    public static double[] elpMpp02Trunc(double jd) {


        double T = (jd - 2451545) / 36525;
        double epsilon = Nutation.obliquityOfEcliptic(T); //Obliquity / kemiringan bumi
        double epsilon_r = Math.toRadians(epsilon);


        double mean_longitude_moon = ElpMpp02Trunc.meanLongitude(T);
        double koreksibujurB = ElpMpp02Trunc.koreksiLongitude(T);
        double deltaPsi = Nutation.nutationInLongitude(T);

        //Koreksi bujur bulan
        double true_longitude_moon = (mean_longitude_moon + koreksibujurB) % 360;
        double apparent_longitude_moon = (true_longitude_moon + deltaPsi) % 360;
        if (apparent_longitude_moon < 0) apparent_longitude_moon += 360;

        double bujurB_nampak_r = Math.toRadians(apparent_longitude_moon);

        //Koreksi lintang bulan
        double latitude_moon = ElpMpp02Trunc.latitude(T);
        double lintangB_r = Math.toRadians(latitude_moon);

        //Koreksi jarak bumi-bulan
        double moonEarth_distance = ElpMpp02Trunc.range(T);


        double horizontalParallax_moon = Math.toDegrees(Math.asin(6378.14 / moonEarth_distance));
        double semiDiameter_moon = 358473400 / (moonEarth_distance * 3600);

        double apparent_RightAscension_moon = (Math.toDegrees(Math.atan2(Math.sin(bujurB_nampak_r) * Math.cos(epsilon_r) - Math.tan(lintangB_r) * Math.sin(epsilon_r), Math.cos(bujurB_nampak_r)))) % 360;
        if (apparent_RightAscension_moon < 0) apparent_RightAscension_moon = (apparent_RightAscension_moon + 360) % 360;


        double apparent_Declination_moon = Math.toDegrees(Math.asin(Math.sin(lintangB_r) * Math.cos(epsilon_r) + Math.cos(lintangB_r) * Math.sin(epsilon_r) * Math.sin(bujurB_nampak_r)));
        double deltaBulan_r = Math.toRadians(apparent_Declination_moon);


        double deltaM_r = Math.toRadians(Sun.Vsop87.apparentDeclination(jd));
        double alphaMatahari = (Sun.Vsop87.apparentRightAscension(jd));
        double jarakBm_M = (vsop87(jd)[11]);//AU


        double y_num, x_num;
        y_num = Math.cos(deltaM_r) * Math.sin(Math.toRadians(alphaMatahari - apparent_RightAscension_moon));
        x_num = Math.sin(deltaM_r) * Math.cos(deltaBulan_r) - Math.cos(deltaM_r) * Math.sin(deltaBulan_r) * Math.cos(Math.toRadians(alphaMatahari - apparent_RightAscension_moon));
        double chi = Math.toDegrees(Math.atan2(y_num, x_num));
        if (chi < 0) chi += 360;

        double sudutFai = Math.acos(Math.sin(deltaBulan_r) * Math.sin(deltaM_r) + Math.cos(deltaBulan_r) * Math.cos(deltaM_r) * Math.cos(Math.toRadians(apparent_RightAscension_moon - alphaMatahari)));
        double sudutFase = Math.atan2(jarakBm_M * Math.sin(sudutFai), moonEarth_distance - jarakBm_M * Math.cos(sudutFai));
        // double sudutFase_d=Math.toDegrees(sudutFase);

        double iluminasiB = (1 + Math.cos(sudutFase)) / 2;


        return new double[]{0
                , true_longitude_moon//1
                , apparent_longitude_moon//2
                , latitude_moon//3
                , apparent_RightAscension_moon//4
                , apparent_Declination_moon//5
                , moonEarth_distance//6
                , semiDiameter_moon//7
                , horizontalParallax_moon//8
                , chi//9
                , iluminasiB//10
        };
    }


    public static double[] elp2000(double jd) {


        double T = (jd - 2451545) / 36525;
        double epsilon = Nutation.obliquityOfEcliptic(T); //Obliquity / kemiringan bumi
        double epsilon_r = Math.toRadians(epsilon);

        double mean_longitude_moon = (218.3164591+481267.88134236*T-0.0013268*T*T+T*T*T/538841-T*T*T*T/65194000)%360;
        double koreksibujurB = Elp2000.longitude(T);
        double deltaPsi = Nutation.nutationInLongitude(T);

        //Koreksi bujur bulan
        double true_longitude_moon = (mean_longitude_moon + koreksibujurB) % 360;
        double apparent_longitude_moon = (true_longitude_moon + deltaPsi) % 360;
        if (apparent_longitude_moon < 0) apparent_longitude_moon += 360;

        double bujurB_nampak_r = Math.toRadians(apparent_longitude_moon);

        //Koreksi lintang bulan
        double aberasiLat = -0.00001754 * Math.sin(Math.toRadians(183.3 + 483202 * T));
        double latitude_moon = Elp2000.latitude(T)+aberasiLat;
        double lintangB_r = Math.toRadians(latitude_moon);

        //Koreksi jarak bumi-bulan
        double aberasiRadius = 0.0708 * Math.cos(Math.toRadians(225 + 477199 * T));
        double moonEarth_distance = Elp2000.radius(T)+aberasiRadius;

        double horizontalParallax_moon = Math.toDegrees(Math.asin(6378.14 / moonEarth_distance));
        double semiDiameter_moon = 358473400 / (moonEarth_distance * 3600);

        double apparent_RightAscension_moon = (Math.toDegrees(Math.atan2(Math.sin(bujurB_nampak_r) * Math.cos(epsilon_r) - Math.tan(lintangB_r) * Math.sin(epsilon_r), Math.cos(bujurB_nampak_r)))) % 360;
        if (apparent_RightAscension_moon < 0) apparent_RightAscension_moon = (apparent_RightAscension_moon + 360) % 360;


        double apparent_Declination_moon = Math.toDegrees(Math.asin(Math.sin(lintangB_r) * Math.cos(epsilon_r) + Math.cos(lintangB_r) * Math.sin(epsilon_r) * Math.sin(bujurB_nampak_r)));
        double deltaBulan_r = Math.toRadians(apparent_Declination_moon);


        double deltaM_r = Math.toRadians(Sun.Vsop87.apparentDeclination(jd));
        double alphaMatahari = (Sun.Vsop87.apparentRightAscension(jd));
        double jarakBm_M = (vsop87(jd)[11]);//AU


        double y_num, x_num;
        y_num = Math.cos(deltaM_r) * Math.sin(Math.toRadians(alphaMatahari - apparent_RightAscension_moon));
        x_num = Math.sin(deltaM_r) * Math.cos(deltaBulan_r) - Math.cos(deltaM_r) * Math.sin(deltaBulan_r) * Math.cos(Math.toRadians(alphaMatahari - apparent_RightAscension_moon));
        double chi = Math.toDegrees(Math.atan2(y_num, x_num));
        if (chi < 0) chi += 360;

        double sudutFai = Math.acos(Math.sin(deltaBulan_r) * Math.sin(deltaM_r) + Math.cos(deltaBulan_r) * Math.cos(deltaM_r) * Math.cos(Math.toRadians(apparent_RightAscension_moon - alphaMatahari)));
        double sudutFase = Math.atan2(jarakBm_M * Math.sin(sudutFai), moonEarth_distance - jarakBm_M * Math.cos(sudutFai));
        // double sudutFase_d=Math.toDegrees(sudutFase);

        double iluminasiB = (1 + Math.cos(sudutFase)) / 2;


        return new double[]{0
                , true_longitude_moon//1
                , apparent_longitude_moon//2
                , latitude_moon//3
                , apparent_RightAscension_moon//4
                , apparent_Declination_moon//5
                , moonEarth_distance//6
                , semiDiameter_moon//7
                , horizontalParallax_moon//8
                , chi//9
                , iluminasiB//10
        };
    }



}
