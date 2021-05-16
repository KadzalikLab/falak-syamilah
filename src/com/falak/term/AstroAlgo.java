package com.falak.term;

/**
 * calculate term in Astronomical Algorithms
 *
 * @see <a href=" "> </a>
 * another ref:
 * - Meeus, Astronomical Algorithms (2nd ed.)
 */

public class AstroAlgo {

    public static double earthHeliocentricLongitude(double tau) {
        double l0 = 0;
        l0 += 175347046 * Math.cos(0 + 0 * tau);
        l0 += 3341656 * Math.cos(4.6692568 + 6283.07585 * tau);
        l0 += 34896 * Math.cos(4.6261 + 12566.1517 * tau);
        l0 += 3497 * Math.cos(2.7441 + 5753.3849 * tau);
        l0 += 3418 * Math.cos(2.8289 + 3.5231 * tau);
        l0 += 3136 * Math.cos(3.6277 + 77713.7715 * tau);
        l0 += 2676 * Math.cos(4.4181 + 7860.4194 * tau);
        l0 += 2343 * Math.cos(6.1352 + 3930.2097 * tau);
        l0 += 1324 * Math.cos(0.7425 + 11506.7691 * tau);
        l0 += 1273 * Math.cos(2.0371 + 529.691 * tau);
        l0 += 1199 * Math.cos(1.1096 + 1577.3435 * tau);
        l0 += 990 * Math.cos(5.233 + 5884.927 * tau);
        l0 += 902 * Math.cos(2.045 + 26.298 * tau);
        l0 += 857 * Math.cos(3.508 + 398.149 * tau);
        l0 += 780 * Math.cos(1.179 + 5223.694 * tau);
        l0 += 753 * Math.cos(2.533 + 5507.553 * tau);
        l0 += 505 * Math.cos(4.583 + 18849.228 * tau);
        l0 += 492 * Math.cos(4.205 + 775.523 * tau);
        l0 += 357 * Math.cos(2.92 + 0.067 * tau);
        l0 += 317 * Math.cos(5.849 + 11790.629 * tau);
        l0 += 284 * Math.cos(1.899 + 796.298 * tau);
        l0 += 271 * Math.cos(0.315 + 10977.079 * tau);
        l0 += 243 * Math.cos(0.345 + 5486.778 * tau);
        l0 += 206 * Math.cos(4.806 + 2544.314 * tau);
        l0 += 205 * Math.cos(1.869 + 5573.143 * tau);
        l0 += 202 * Math.cos(2.458 + 6069.777 * tau);
        l0 += 156 * Math.cos(0.833 + 213.299 * tau);
        l0 += 132 * Math.cos(3.411 + 2942.463 * tau);
        l0 += 126 * Math.cos(1.083 + 20.775 * tau);
        l0 += 115 * Math.cos(0.645 + 0.98 * tau);
        l0 += 103 * Math.cos(0.636 + 4694.003 * tau);
        l0 += 102 * Math.cos(0.976 + 15720.839 * tau);
        l0 += 102 * Math.cos(4.267 + 7.114 * tau);
        l0 += 99 * Math.cos(6.21 + 2146.17 * tau);
        l0 += 98 * Math.cos(0.68 + 155.42 * tau);
        l0 += 86 * Math.cos(5.98 + 161000.69 * tau);
        l0 += 85 * Math.cos(1.3 + 6275.96 * tau);
        l0 += 85 * Math.cos(3.67 + 71430.7 * tau);
        l0 += 80 * Math.cos(1.81 + 17260 * tau);
        l0 += 79 * Math.cos(3.04 + 12036.46 * tau);
        l0 += 75 * Math.cos(1.76 + 5088.63 * tau);
        l0 += 74 * Math.cos(3.5 + 3154.69 * tau);
        l0 += 74 * Math.cos(4.68 + 801.82 * tau);
        l0 += 70 * Math.cos(0.83 + 9437.76 * tau);
        l0 += 62 * Math.cos(3.98 + 8827.39 * tau);
        l0 += 61 * Math.cos(1.82 + 7084.9 * tau);
        l0 += 57 * Math.cos(2.78 + 6286.6 * tau);
        l0 += 56 * Math.cos(4.39 + 14143.5 * tau);
        l0 += 56 * Math.cos(3.47 + 6279.55 * tau);
        l0 += 52 * Math.cos(0.19 + 12139.55 * tau);
        l0 += 52 * Math.cos(1.33 + 1748.02 * tau);
        l0 += 51 * Math.cos(0.28 + 5856.48 * tau);
        l0 += 49 * Math.cos(0.49 + 1194.45 * tau);
        l0 += 41 * Math.cos(5.37 + 8429.24 * tau);
        l0 += 41 * Math.cos(2.4 + 19651.05 * tau);
        l0 += 39 * Math.cos(6.17 + 10447.39 * tau);
        l0 += 37 * Math.cos(6.04 + 10213.29 * tau);
        l0 += 37 * Math.cos(2.57 + 1059.38 * tau);
        l0 += 36 * Math.cos(1.71 + 2352.87 * tau);
        l0 += 36 * Math.cos(1.78 + 6812.77 * tau);
        l0 += 33 * Math.cos(0.59 + 17789.85 * tau);
        l0 += 30 * Math.cos(0.44 + 83996.85 * tau);
        l0 += 30 * Math.cos(2.74 + 1349.87 * tau);
        l0 += 25 * Math.cos(3.16 + 4690.48 * tau);


        double l1 = 0;
        l1 += 628331966747L * Math.cos(0 + 0 * tau);
        l1 += 206059 * Math.cos(2.678235 + 6283.07585 * tau);
        l1 += 4303 * Math.cos(2.6351 + 12566.1517 * tau);
        l1 += 425 * Math.cos(1.59 + 3.523 * tau);
        l1 += 119 * Math.cos(5.796 + 26.298 * tau);
        l1 += 109 * Math.cos(2.966 + 1577.344 * tau);
        l1 += 93 * Math.cos(2.59 + 18849.23 * tau);
        l1 += 72 * Math.cos(1.14 + 529.69 * tau);
        l1 += 68 * Math.cos(1.87 + 398.15 * tau);
        l1 += 67 * Math.cos(4.41 + 5507.55 * tau);
        l1 += 59 * Math.cos(2.89 + 5223.69 * tau);
        l1 += 56 * Math.cos(2.17 + 155.42 * tau);
        l1 += 45 * Math.cos(0.4 + 796.3 * tau);
        l1 += 36 * Math.cos(0.47 + 775.52 * tau);
        l1 += 29 * Math.cos(2.65 + 7.11 * tau);
        l1 += 21 * Math.cos(5.34 + 0.98 * tau);
        l1 += 19 * Math.cos(1.85 + 5486.78 * tau);
        l1 += 19 * Math.cos(4.97 + 213.3 * tau);
        l1 += 17 * Math.cos(2.99 + 6275.96 * tau);
        l1 += 16 * Math.cos(0.03 + 2544.31 * tau);
        l1 += 16 * Math.cos(1.43 + 2146.17 * tau);
        l1 += 15 * Math.cos(1.21 + 10977.08 * tau);
        l1 += 12 * Math.cos(2.83 + 1748.02 * tau);
        l1 += 12 * Math.cos(3.26 + 5088.63 * tau);
        l1 += 12 * Math.cos(5.27 + 1194.45 * tau);
        l1 += 12 * Math.cos(2.08 + 4694 * tau);
        l1 += 11 * Math.cos(0.77 + 553.57 * tau);
        l1 += 10 * Math.cos(1.3 + 6286.6 * tau);
        l1 += 10 * Math.cos(4.24 + 1349.87 * tau);
        l1 += 9 * Math.cos(2.7 + 242.73 * tau);
        l1 += 9 * Math.cos(5.64 + 951.72 * tau);
        l1 += 8 * Math.cos(5.3 + 2352.87 * tau);
        l1 += 6 * Math.cos(2.65 + 9437.76 * tau);
        l1 += 6 * Math.cos(4.67 + 4690.48 * tau);
        l1 *= tau;

        double l2 = 0;
        l2 += 52919 * Math.cos(0 + 0 * tau);
        l2 += 8720 * Math.cos(1.0721 + 6283.0758 * tau);
        l2 += 309 * Math.cos(0.867 + 12566.152 * tau);
        l2 += 27 * Math.cos(0.05 + 3.52 * tau);
        l2 += 16 * Math.cos(5.19 + 26.3 * tau);
        l2 += 16 * Math.cos(3.68 + 155.42 * tau);
        l2 += 10 * Math.cos(0.76 + 18849 * tau);
        l2 += 9 * Math.cos(2.06 + 77713.77 * tau);
        l2 += 7 * Math.cos(0.83 + 775.52 * tau);
        l2 += 5 * Math.cos(4.66 + 1577.34 * tau);
        l2 += 4 * Math.cos(1.03 + 7.11 * tau);
        l2 += 4 * Math.cos(3.44 + 5573.14 * tau);
        l2 += 3 * Math.cos(5.14 + 796.3 * tau);
        l2 += 3 * Math.cos(6.05 + 5507.55 * tau);
        l2 += 3 * Math.cos(1.19 + 242.73 * tau);
        l2 += 3 * Math.cos(6.12 + 529.69 * tau);
        l2 += 3 * Math.cos(0.31 + 398.15 * tau);
        l2 += 3 * Math.cos(2.28 + 553.57 * tau);
        l2 += 2 * Math.cos(4.38 + 5223.69 * tau);
        l2 += 2 * Math.cos(3.75 + 0.98 * tau);
        l2 *= tau * tau;


        double l3 = 0;
        l3 += 289 * Math.cos(5.844 + 6283.076 * tau);
        l3 += 35 * Math.cos(0 + 0 * tau);
        l3 += 17 * Math.cos(5.49 + 12566.15 * tau);
        l3 += 3 * Math.cos(5.2 + 155.42 * tau);
        l3 += 1 * Math.cos(4.72 + 3.52 * tau);
        l3 += 1 * Math.cos(5.3 + 18849.23 * tau);
        l3 += 1 * Math.cos(5.97 + 242.73 * tau);
        l3 *= tau * tau * tau;

        double l4 = 0;
        l4 += 114 * Math.cos(3.142 + 0 * tau);
        l4 += 8 * Math.cos(4.13 + 6283.08 * tau);
        l4 += 1 * Math.cos(3.84 + 12566.15 * tau);
        l4 *= tau * tau * tau * tau;

        double l5 = 0;
        l5 += 1 * Math.cos(3.14 + 0 * tau);
        l5 *= tau * tau * tau * tau * tau;
        double l = (l0 + l1 + l2 + l3 + l4 + l5) / 100000000L;
        double l_d = Math.toDegrees(l) % 360;


        return l_d;
    }

    public static double earthHeliocentricLatitude(double tau) {
        double b0 = 0;
        b0 += 280 * Math.cos(3.199 + 84334.662 * tau);
        b0 += 102 * Math.cos(5.422 + 5507.553 * tau);
        b0 += 80 * Math.cos(3.88 + 5223.69 * tau);
        b0 += 44 * Math.cos(3.7 + 2352.87 * tau);
        b0 += 32 * Math.cos(4 + 1577.34 * tau);
        double b1 = 0;
        b1 += 9 * Math.cos(3.9 + 5507.55 * tau);
        b1 += 6 * Math.cos(1.73 + 5223.69 * tau);
        b1 *= tau;

        double B = (b0 + b1) / 100000000;

        return Math.toDegrees(B) * 3600;
    }

    public static double earthRadiusVector(double tau) {
        // double Dim R0, R1, R2, R3, R4, Earth_RV
        double r0 = 0;
        r0 += 100013989 * Math.cos(0 + 0 * tau);
        r0 += 1670700 * Math.cos(3.0984635 + 6283.07585 * tau);
        r0 += 13956 * Math.cos(3.05525 + 12566.1517 * tau);
        r0 += 3084 * Math.cos(5.1985 + 77713.7715 * tau);
        r0 += 1628 * Math.cos(1.1739 + 5753.3849 * tau);
        r0 += 1576 * Math.cos(2.8469 + 7860.4194 * tau);
        r0 += 925 * Math.cos(5.453 + 11506.77 * tau);
        r0 += 542 * Math.cos(4.564 + 3930.21 * tau);
        r0 += 472 * Math.cos(3.661 + 5884.927 * tau);
        r0 += 346 * Math.cos(0.964 + 5507.553 * tau);
        r0 += 329 * Math.cos(5.9 + 5223.694 * tau);
        r0 += 307 * Math.cos(0.299 + 5573 * tau);
        r0 += 243 * Math.cos(4.273 + 11790.629 * tau);
        r0 += 212 * Math.cos(5.847 + 1577.344 * tau);
        r0 += 186 * Math.cos(5.022 + 10977.079 * tau);
        r0 += 175 * Math.cos(3.012 + 18849.228 * tau);
        r0 += 110 * Math.cos(5.055 + 5486.778 * tau);
        r0 += 98 * Math.cos(0.89 + 6069.78 * tau);
        r0 += 86 * Math.cos(5.69 + 15720.84 * tau);
        r0 += 86 * Math.cos(1.27 + 161000.69 * tau);
        r0 += 65 * Math.cos(0.27 + 17260.15 * tau);
        r0 += 63 * Math.cos(0.92 + 529.69 * tau);
        r0 += 57 * Math.cos(2.01 + 83996.85 * tau);
        r0 += 56 * Math.cos(5.24 + 71430.7 * tau);
        r0 += 49 * Math.cos(3.25 + 2544.31 * tau);
        r0 += 47 * Math.cos(2.58 + 775.52 * tau);
        r0 += 45 * Math.cos(5.54 + 9437.76 * tau);
        r0 += 43 * Math.cos(6.01 + 6275.96 * tau);
        r0 += 39 * Math.cos(5.36 + 4694 * tau);
        r0 += 38 * Math.cos(2.39 + 8827.39 * tau);
        r0 += 37 * Math.cos(0.83 + 19651.05 * tau);
        r0 += 37 * Math.cos(4.9 + 12139.55 * tau);
        r0 += 36 * Math.cos(1.67 + 12036.46 * tau);
        r0 += 35 * Math.cos(1.84 + 2942.46 * tau);
        r0 += 33 * Math.cos(0.24 + 7084.9 * tau);
        r0 += 32 * Math.cos(0.18 + 5088.63 * tau);
        r0 += 32 * Math.cos(1.78 + 398.15 * tau);
        r0 += 28 * Math.cos(1.21 + 6286.6 * tau);
        r0 += 28 * Math.cos(1.9 + 6279.55 * tau);
        r0 += 26 * Math.cos(4.59 + 10447.39 * tau);

        double r1 = 0;
        r1 += 103019 * Math.cos(1.10749 + 6283.07585 * tau);
        r1 += 1721 * Math.cos(1.0644 + 12566.1517 * tau);
        r1 += 702 * Math.cos(3.142 + 0 * tau);
        r1 += 32 * Math.cos(1.02 + 18849.23 * tau);
        r1 += 31 * Math.cos(2.84 + 5507.55 * tau);
        r1 += 25 * Math.cos(1.32 + 5223.69 * tau);
        r1 += 18 * Math.cos(1.42 + 1577.34 * tau);
        r1 += 10 * Math.cos(5.91 + 10977.08 * tau);
        r1 += 9 * Math.cos(1.42 + 6275.96 * tau);
        r1 += 9 * Math.cos(0.27 + 5486.78 * tau);
        r1 *= tau;

        double r2 = 0;
        r2 += 4359 * Math.cos(5.7846 + 6283.0758 * tau);
        r2 += 124 * Math.cos(5.579 + 12566.152 * tau);
        r2 += 12 * Math.cos(3.14 + 0 * tau);
        r2 += 9 * Math.cos(3.63 + 77713.77 * tau);
        r2 += 6 * Math.cos(1.87 + 5573.14 * tau);
        r2 += 3 * Math.cos(5.47 + 18849.23 * tau);
        r2 *= tau * tau;

        double r3 = 0;
        r3 += 145 * Math.cos(4.273 + 6283.076 * tau);
        r3 += 7 * Math.cos(3.92 + 12566.15 * tau);
        r3 *= tau * tau * tau;

        double r4 = 0;
        r4 += 4 * Math.cos(2.56 + 6283.08 * tau);
        r4 *= tau * tau * tau * tau;


        return (r0 + r1 + r2 + r3 + r4) / 100000000;
    }


    public static double moonGeocentricLongitude(double t) {
        //elongsi rata2 bulan
        double d = (297.8502042 + 445267.1115168 * t - 0.00163 * t * t + t * t * t / 545868 - t * t * t * t / 113065000) % 360;
        double d_r = Math.toRadians(d);

        //anomali rata2 matahari
        double m = (357.5291092 + 35999.0502909 * t - 0.0001536 * t * t + t * t * t / 24490000) % 360;
        double m_r = Math.toRadians(m);

        //anomali rata2 bulan
        double ma = (134.9634114 + 477198.8676313 * t + 0.008997 * t * t + t * t * t / 69699 - t * t * t * t / 14712000) % 360;
        double ma_r = Math.toRadians(ma);

        //Argumen bujur bulan
        double f = (93.2720993 + 483202.0175273 * t - 0.0034029 * t * t - t * t * t / 3526000 + t * t * t * t / 863310000) % 360;
        double f_r = Math.toRadians(f);

        //eksentrisitas orbit
        double e = 1 - 0.002516 * t - 0.0000074 * t * t;

        //koreksi suku periodik bujur ekliptika bulan (sinus)
        double bujur_bulan = 0;

        double D1 = 0, M1 = 0, MA1 = 1, F1 = 0, koefisien1 = 6288774;
        double D2 = 2, M2 = 0, MA2 = -1, F2 = 0, koefisien2 = 1274027;
        double D3 = 2, M3 = 0, MA3 = 0, F3 = 0, koefisien3 = 658314;
        double D4 = 0, M4 = 0, MA4 = 2, F4 = 0, koefisien4 = 213618;
        double D5 = 0, M5 = 1, MA5 = 0, F5 = 0, koefisien5 = -185116;
        double D6 = 0, M6 = 0, MA6 = 0, F6 = 2, koefisien6 = -114332;
        double D7 = 2, M7 = 0, MA7 = -2, F7 = 0, koefisien7 = 58793;
        double D8 = 2, M8 = -1, MA8 = -1, F8 = 0, koefisien8 = 57066;
        double D9 = 2, M9 = 0, MA9 = 1, F9 = 0, koefisien9 = 53322;
        double D10 = 2, M10 = -1, MA10 = 0, F10 = 0, koefisien10 = 45758;
        double D11 = 0, M11 = 1, MA11 = -1, F11 = 0, koefisien11 = -40923;
        double D12 = 1, M12 = 0, MA12 = 0, F12 = 0, koefisien12 = -34720;
        double D13 = 0, M13 = 1, MA13 = 1, F13 = 0, koefisien13 = -30383;
        double D14 = 2, M14 = 0, MA14 = 0, F14 = -2, koefisien14 = 15327;
        double D15 = 0, M15 = 0, MA15 = 1, F15 = 2, koefisien15 = -12528;
        double D16 = 0, M16 = 0, MA16 = 1, F16 = -2, koefisien16 = 10980;
        double D17 = 4, M17 = 0, MA17 = -1, F17 = 0, koefisien17 = 10675;
        double D18 = 0, M18 = 0, MA18 = 3, F18 = 0, koefisien18 = 10034;
        double D19 = 4, M19 = 0, MA19 = -2, F19 = 0, koefisien19 = 8548;
        double D20 = 2, M20 = 1, MA20 = -1, F20 = 0, koefisien20 = -7888;
        double D21 = 2, M21 = 1, MA21 = 0, F21 = 0, koefisien21 = -6766;
        double D22 = 1, M22 = 0, MA22 = -1, F22 = 0, koefisien22 = -5163;
        double D23 = 1, M23 = 1, MA23 = 0, F23 = 0, koefisien23 = 4987;
        double D24 = 2, M24 = -1, MA24 = 1, F24 = 0, koefisien24 = 4036;
        double D25 = 2, M25 = 0, MA25 = 2, F25 = 0, koefisien25 = 3994;
        double D26 = 4, M26 = 0, MA26 = 0, F26 = 0, koefisien26 = 3861;
        double D27 = 2, M27 = 0, MA27 = -3, F27 = 0, koefisien27 = 3665;
        double D28 = 0, M28 = 1, MA28 = -2, F28 = 0, koefisien28 = -2689;
        double D29 = 2, M29 = 0, MA29 = -1, F29 = 2, koefisien29 = -2602;
        double D30 = 2, M30 = -1, MA30 = -2, F30 = 0, koefisien30 = 2390;
        double D31 = 1, M31 = 0, MA31 = 1, F31 = 0, koefisien31 = -2348;
        double D32 = 2, M32 = -2, MA32 = 0, F32 = 0, koefisien32 = 2236;
        double D33 = 0, M33 = 1, MA33 = 2, F33 = 0, koefisien33 = -2120;
        double D34 = 0, M34 = 2, MA34 = 0, F34 = 0, koefisien34 = -2069;
        double D35 = 2, M35 = -2, MA35 = -1, F35 = 0, koefisien35 = 2048;
        double D36 = 2, M36 = 0, MA36 = 1, F36 = -2, koefisien36 = -1773;
        double D37 = 2, M37 = 0, MA37 = 0, F37 = 2, koefisien37 = -1595;
        double D38 = 4, M38 = -1, MA38 = -1, F38 = 0, koefisien38 = 1215;
        double D39 = 0, M39 = 0, MA39 = 2, F39 = 2, koefisien39 = -1110;
        double D40 = 3, M40 = 0, MA40 = -1, F40 = 0, koefisien40 = -892;
        double D41 = 2, M41 = 1, MA41 = 1, F41 = 0, koefisien41 = -810;
        double D42 = 4, M42 = -1, MA42 = -2, F42 = 0, koefisien42 = 759;
        double D43 = 0, M43 = 2, MA43 = -1, F43 = 0, koefisien43 = -713;
        double D44 = 2, M44 = 2, MA44 = -1, F44 = 0, koefisien44 = -700;
        double D45 = 2, M45 = 1, MA45 = -2, F45 = 0, koefisien45 = 691;
        double D46 = 2, M46 = -1, MA46 = 0, F46 = -2, koefisien46 = 596;
        double D47 = 4, M47 = 0, MA47 = 1, F47 = 0, koefisien47 = 549;
        double D48 = 0, M48 = 0, MA48 = 4, F48 = 0, koefisien48 = 537;
        double D49 = 4, M49 = -1, MA49 = 0, F49 = 0, koefisien49 = 520;
        double D50 = 1, M50 = 0, MA50 = -2, F50 = 0, koefisien50 = -487;
        double D51 = 2, M51 = 1, MA51 = 0, F51 = -2, koefisien51 = -399;
        double D52 = 0, M52 = 0, MA52 = 2, F52 = -2, koefisien52 = -381;
        double D53 = 1, M53 = 1, MA53 = 1, F53 = 0, koefisien53 = 351;
        double D54 = 3, M54 = 0, MA54 = -2, F54 = 0, koefisien54 = -340;
        double D55 = 4, M55 = 0, MA55 = -3, F55 = 0, koefisien55 = 330;
        double D56 = 2, M56 = -1, MA56 = 2, F56 = 0, koefisien56 = 327;
        double D57 = 0, M57 = 2, MA57 = 1, F57 = 0, koefisien57 = -323;
        double D58 = 1, M58 = 1, MA58 = -1, F58 = 0, koefisien58 = 299;
        double D59 = 2, M59 = 0, MA59 = 3, F59 = 0, koefisien59 = 294;

        bujur_bulan += koefisien1 * (Math.pow(e, Math.abs(M1))) * Math.sin(D1 * d_r + M1 * m_r + MA1 * ma_r + F1 * f_r);
        bujur_bulan += koefisien2 * (Math.pow(e, Math.abs(M2))) * Math.sin(D2 * d_r + M2 * m_r + MA2 * ma_r + F2 * f_r);
        bujur_bulan += koefisien3 * (Math.pow(e, Math.abs(M3))) * Math.sin(D3 * d_r + M3 * m_r + MA3 * ma_r + F3 * f_r);
        bujur_bulan += koefisien4 * (Math.pow(e, Math.abs(M4))) * Math.sin(D4 * d_r + M4 * m_r + MA4 * ma_r + F4 * f_r);
        bujur_bulan += koefisien5 * (Math.pow(e, Math.abs(M5))) * Math.sin(D5 * d_r + M5 * m_r + MA5 * ma_r + F5 * f_r);
        bujur_bulan += koefisien6 * (Math.pow(e, Math.abs(M6))) * Math.sin(D6 * d_r + M6 * m_r + MA6 * ma_r + F6 * f_r);
        bujur_bulan += koefisien7 * (Math.pow(e, Math.abs(M7))) * Math.sin(D7 * d_r + M7 * m_r + MA7 * ma_r + F7 * f_r);
        bujur_bulan += koefisien8 * (Math.pow(e, Math.abs(M8))) * Math.sin(D8 * d_r + M8 * m_r + MA8 * ma_r + F8 * f_r);
        bujur_bulan += koefisien9 * (Math.pow(e, Math.abs(M9))) * Math.sin(D9 * d_r + M9 * m_r + MA9 * ma_r + F9 * f_r);
        bujur_bulan += koefisien10 * (Math.pow(e, Math.abs(M10))) * Math.sin(D10 * d_r + M10 * m_r + MA10 * ma_r + F10 * f_r);
        bujur_bulan += koefisien11 * (Math.pow(e, Math.abs(M11))) * Math.sin(D11 * d_r + M11 * m_r + MA11 * ma_r + F11 * f_r);
        bujur_bulan += koefisien12 * (Math.pow(e, Math.abs(M12))) * Math.sin(D12 * d_r + M12 * m_r + MA12 * ma_r + F12 * f_r);
        bujur_bulan += koefisien13 * (Math.pow(e, Math.abs(M13))) * Math.sin(D13 * d_r + M13 * m_r + MA13 * ma_r + F13 * f_r);
        bujur_bulan += koefisien14 * (Math.pow(e, Math.abs(M14))) * Math.sin(D14 * d_r + M14 * m_r + MA14 * ma_r + F14 * f_r);
        bujur_bulan += koefisien15 * (Math.pow(e, Math.abs(M15))) * Math.sin(D15 * d_r + M15 * m_r + MA15 * ma_r + F15 * f_r);
        bujur_bulan += koefisien16 * (Math.pow(e, Math.abs(M16))) * Math.sin(D16 * d_r + M16 * m_r + MA16 * ma_r + F16 * f_r);
        bujur_bulan += koefisien17 * (Math.pow(e, Math.abs(M17))) * Math.sin(D17 * d_r + M17 * m_r + MA17 * ma_r + F17 * f_r);
        bujur_bulan += koefisien18 * (Math.pow(e, Math.abs(M18))) * Math.sin(D18 * d_r + M18 * m_r + MA18 * ma_r + F18 * f_r);
        bujur_bulan += koefisien19 * (Math.pow(e, Math.abs(M19))) * Math.sin(D19 * d_r + M19 * m_r + MA19 * ma_r + F19 * f_r);
        bujur_bulan += koefisien20 * (Math.pow(e, Math.abs(M20))) * Math.sin(D20 * d_r + M20 * m_r + MA20 * ma_r + F20 * f_r);
        bujur_bulan += koefisien21 * (Math.pow(e, Math.abs(M21))) * Math.sin(D21 * d_r + M21 * m_r + MA21 * ma_r + F21 * f_r);
        bujur_bulan += koefisien22 * (Math.pow(e, Math.abs(M22))) * Math.sin(D22 * d_r + M22 * m_r + MA22 * ma_r + F22 * f_r);
        bujur_bulan += koefisien23 * (Math.pow(e, Math.abs(M23))) * Math.sin(D23 * d_r + M23 * m_r + MA23 * ma_r + F23 * f_r);
        bujur_bulan += koefisien24 * (Math.pow(e, Math.abs(M24))) * Math.sin(D24 * d_r + M24 * m_r + MA24 * ma_r + F24 * f_r);
        bujur_bulan += koefisien25 * (Math.pow(e, Math.abs(M25))) * Math.sin(D25 * d_r + M25 * m_r + MA25 * ma_r + F25 * f_r);
        bujur_bulan += koefisien26 * (Math.pow(e, Math.abs(M26))) * Math.sin(D26 * d_r + M26 * m_r + MA26 * ma_r + F26 * f_r);
        bujur_bulan += koefisien27 * (Math.pow(e, Math.abs(M27))) * Math.sin(D27 * d_r + M27 * m_r + MA27 * ma_r + F27 * f_r);
        bujur_bulan += koefisien28 * (Math.pow(e, Math.abs(M28))) * Math.sin(D28 * d_r + M28 * m_r + MA28 * ma_r + F28 * f_r);
        bujur_bulan += koefisien29 * (Math.pow(e, Math.abs(M29))) * Math.sin(D29 * d_r + M29 * m_r + MA29 * ma_r + F29 * f_r);
        bujur_bulan += koefisien30 * (Math.pow(e, Math.abs(M30))) * Math.sin(D30 * d_r + M30 * m_r + MA30 * ma_r + F30 * f_r);
        bujur_bulan += koefisien31 * (Math.pow(e, Math.abs(M31))) * Math.sin(D31 * d_r + M31 * m_r + MA31 * ma_r + F31 * f_r);
        bujur_bulan += koefisien32 * (Math.pow(e, Math.abs(M32))) * Math.sin(D32 * d_r + M32 * m_r + MA32 * ma_r + F32 * f_r);
        bujur_bulan += koefisien33 * (Math.pow(e, Math.abs(M33))) * Math.sin(D33 * d_r + M33 * m_r + MA33 * ma_r + F33 * f_r);
        bujur_bulan += koefisien34 * (Math.pow(e, Math.abs(M34))) * Math.sin(D34 * d_r + M34 * m_r + MA34 * ma_r + F34 * f_r);
        bujur_bulan += koefisien35 * (Math.pow(e, Math.abs(M35))) * Math.sin(D35 * d_r + M35 * m_r + MA35 * ma_r + F35 * f_r);
        bujur_bulan += koefisien36 * (Math.pow(e, Math.abs(M36))) * Math.sin(D36 * d_r + M36 * m_r + MA36 * ma_r + F36 * f_r);
        bujur_bulan += koefisien37 * (Math.pow(e, Math.abs(M37))) * Math.sin(D37 * d_r + M37 * m_r + MA37 * ma_r + F37 * f_r);
        bujur_bulan += koefisien38 * (Math.pow(e, Math.abs(M38))) * Math.sin(D38 * d_r + M38 * m_r + MA38 * ma_r + F38 * f_r);
        bujur_bulan += koefisien39 * (Math.pow(e, Math.abs(M39))) * Math.sin(D39 * d_r + M39 * m_r + MA39 * ma_r + F39 * f_r);
        bujur_bulan += koefisien40 * (Math.pow(e, Math.abs(M40))) * Math.sin(D40 * d_r + M40 * m_r + MA40 * ma_r + F40 * f_r);
        bujur_bulan += koefisien41 * (Math.pow(e, Math.abs(M41))) * Math.sin(D41 * d_r + M41 * m_r + MA41 * ma_r + F41 * f_r);
        bujur_bulan += koefisien42 * (Math.pow(e, Math.abs(M42))) * Math.sin(D42 * d_r + M42 * m_r + MA42 * ma_r + F42 * f_r);
        bujur_bulan += koefisien43 * (Math.pow(e, Math.abs(M43))) * Math.sin(D43 * d_r + M43 * m_r + MA43 * ma_r + F43 * f_r);
        bujur_bulan += koefisien44 * (Math.pow(e, Math.abs(M44))) * Math.sin(D44 * d_r + M44 * m_r + MA44 * ma_r + F44 * f_r);
        bujur_bulan += koefisien45 * (Math.pow(e, Math.abs(M45))) * Math.sin(D45 * d_r + M45 * m_r + MA45 * ma_r + F45 * f_r);
        bujur_bulan += koefisien46 * (Math.pow(e, Math.abs(M46))) * Math.sin(D46 * d_r + M46 * m_r + MA46 * ma_r + F46 * f_r);
        bujur_bulan += koefisien47 * (Math.pow(e, Math.abs(M47))) * Math.sin(D47 * d_r + M47 * m_r + MA47 * ma_r + F47 * f_r);
        bujur_bulan += koefisien48 * (Math.pow(e, Math.abs(M48))) * Math.sin(D48 * d_r + M48 * m_r + MA48 * ma_r + F48 * f_r);
        bujur_bulan += koefisien49 * (Math.pow(e, Math.abs(M49))) * Math.sin(D49 * d_r + M49 * m_r + MA49 * ma_r + F49 * f_r);
        bujur_bulan += koefisien50 * (Math.pow(e, Math.abs(M50))) * Math.sin(D50 * d_r + M50 * m_r + MA50 * ma_r + F50 * f_r);
        bujur_bulan += koefisien51 * (Math.pow(e, Math.abs(M51))) * Math.sin(D51 * d_r + M51 * m_r + MA51 * ma_r + F51 * f_r);
        bujur_bulan += koefisien52 * (Math.pow(e, Math.abs(M52))) * Math.sin(D52 * d_r + M52 * m_r + MA52 * ma_r + F52 * f_r);
        bujur_bulan += koefisien53 * (Math.pow(e, Math.abs(M53))) * Math.sin(D53 * d_r + M53 * m_r + MA53 * ma_r + F53 * f_r);
        bujur_bulan += koefisien54 * (Math.pow(e, Math.abs(M54))) * Math.sin(D54 * d_r + M54 * m_r + MA54 * ma_r + F54 * f_r);
        bujur_bulan += koefisien55 * (Math.pow(e, Math.abs(M55))) * Math.sin(D55 * d_r + M55 * m_r + MA55 * ma_r + F55 * f_r);
        bujur_bulan += koefisien56 * (Math.pow(e, Math.abs(M56))) * Math.sin(D56 * d_r + M56 * m_r + MA56 * ma_r + F56 * f_r);
        bujur_bulan += koefisien57 * (Math.pow(e, Math.abs(M57))) * Math.sin(D57 * d_r + M57 * m_r + MA57 * ma_r + F57 * f_r);
        bujur_bulan += koefisien58 * (Math.pow(e, Math.abs(M58))) * Math.sin(D58 * d_r + M58 * m_r + MA58 * ma_r + F58 * f_r);
        bujur_bulan += koefisien59 * (Math.pow(e, Math.abs(M59))) * Math.sin(D59 * d_r + M59 * m_r + MA59 * ma_r + F59 * f_r);


        return bujur_bulan;
    }

    public static double moonGeocentricLatitude(double e, double d_r, double m_r, double ma_r, double f_r, double l1_r, double aA1_r, double aA3_r) {

        double D1 = 0, M1 = 0, MA1 = 0, F1 = 1, koefisien1 = 5128122;
        double D2 = 0, M2 = 0, MA2 = 1, F2 = 1, koefisien2 = 280602;
        double D3 = 0, M3 = 0, MA3 = 1, F3 = -1, koefisien3 = 277693;
        double D4 = 2, M4 = 0, MA4 = 0, F4 = -1, koefisien4 = 173237;
        double D5 = 2, M5 = 0, MA5 = -1, F5 = 1, koefisien5 = 55413;
        double D6 = 2, M6 = 0, MA6 = -1, F6 = -1, koefisien6 = 46271;
        double D7 = 2, M7 = 0, MA7 = 0, F7 = 1, koefisien7 = 32573;
        double D8 = 0, M8 = 0, MA8 = 2, F8 = 1, koefisien8 = 17198;
        double D9 = 2, M9 = 0, MA9 = 1, F9 = -1, koefisien9 = 9266;
        double D10 = 0, M10 = 0, MA10 = 2, F10 = -1, koefisien10 = 8822;
        double D11 = 2, M11 = -1, MA11 = 0, F11 = -1, koefisien11 = 8216;
        double D12 = 2, M12 = 0, MA12 = -2, F12 = -1, koefisien12 = 4324;
        double D13 = 2, M13 = 0, MA13 = 1, F13 = 1, koefisien13 = 4200;
        double D14 = 2, M14 = 1, MA14 = 0, F14 = -1, koefisien14 = -3359;
        double D15 = 2, M15 = -1, MA15 = -1, F15 = 1, koefisien15 = 2463;
        double D16 = 2, M16 = -1, MA16 = 0, F16 = 1, koefisien16 = 2211;
        double D17 = 2, M17 = -1, MA17 = -1, F17 = -1, koefisien17 = 2065;
        double D18 = 0, M18 = 1, MA18 = -1, F18 = -1, koefisien18 = -1870;
        double D19 = 4, M19 = 0, MA19 = -1, F19 = -1, koefisien19 = 1828;
        double D20 = 0, M20 = 1, MA20 = 0, F20 = 1, koefisien20 = -1794;
        double D21 = 0, M21 = 0, MA21 = 0, F21 = 3, koefisien21 = -1749;
        double D22 = 0, M22 = 1, MA22 = -1, F22 = 1, koefisien22 = -1565;
        double D23 = 1, M23 = 0, MA23 = 0, F23 = 1, koefisien23 = -1491;
        double D24 = 0, M24 = 1, MA24 = 1, F24 = 1, koefisien24 = -1475;
        double D25 = 0, M25 = 1, MA25 = 1, F25 = -1, koefisien25 = -1410;
        double D26 = 0, M26 = 1, MA26 = 0, F26 = -1, koefisien26 = -1344;
        double D27 = 1, M27 = 0, MA27 = 0, F27 = -1, koefisien27 = -1335;
        double D28 = 0, M28 = 0, MA28 = 3, F28 = 1, koefisien28 = 1107;
        double D29 = 4, M29 = 0, MA29 = 0, F29 = -1, koefisien29 = 1021;
        double D30 = 4, M30 = 0, MA30 = -1, F30 = 1, koefisien30 = 833;
        double D31 = 0, M31 = 0, MA31 = 1, F31 = -3, koefisien31 = 777;
        double D32 = 4, M32 = 0, MA32 = -2, F32 = 1, koefisien32 = 671;
        double D33 = 2, M33 = 0, MA33 = 0, F33 = -3, koefisien33 = 607;
        double D34 = 2, M34 = 0, MA34 = 2, F34 = -1, koefisien34 = 596;
        double D35 = 2, M35 = -1, MA35 = 1, F35 = -1, koefisien35 = 491;
        double D36 = 2, M36 = 0, MA36 = -2, F36 = 1, koefisien36 = -451;
        double D37 = 0, M37 = 0, MA37 = 3, F37 = -1, koefisien37 = 439;
        double D38 = 2, M38 = 0, MA38 = 2, F38 = 1, koefisien38 = 422;
        double D39 = 2, M39 = 0, MA39 = -3, F39 = -1, koefisien39 = 421;
        double D40 = 2, M40 = 1, MA40 = -1, F40 = 1, koefisien40 = -366;
        double D41 = 2, M41 = 1, MA41 = 0, F41 = 1, koefisien41 = -351;
        double D42 = 4, M42 = 0, MA42 = 0, F42 = 1, koefisien42 = 331;
        double D43 = 2, M43 = -1, MA43 = 1, F43 = 1, koefisien43 = 315;
        double D44 = 2, M44 = -2, MA44 = 0, F44 = -1, koefisien44 = 302;
        double D45 = 0, M45 = 0, MA45 = 1, F45 = 3, koefisien45 = -283;
        double D46 = 2, M46 = 1, MA46 = 1, F46 = -1, koefisien46 = -229;
        double D47 = 1, M47 = 1, MA47 = 0, F47 = -1, koefisien47 = 223;
        double D48 = 1, M48 = 1, MA48 = 0, F48 = 1, koefisien48 = 223;
        double D49 = 0, M49 = 1, MA49 = -2, F49 = -1, koefisien49 = -220;
        double D50 = 2, M50 = 1, MA50 = -1, F50 = -1, koefisien50 = -220;
        double D51 = 1, M51 = 0, MA51 = 1, F51 = 1, koefisien51 = -185;
        double D52 = 2, M52 = -1, MA52 = -2, F52 = -1, koefisien52 = 181;
        double D53 = 0, M53 = 1, MA53 = 2, F53 = 1, koefisien53 = -177;
        double D54 = 4, M54 = 0, MA54 = -2, F54 = -1, koefisien54 = 176;
        double D55 = 4, M55 = -1, MA55 = -1, F55 = -1, koefisien55 = 166;
        double D56 = 1, M56 = 0, MA56 = 1, F56 = -1, koefisien56 = -164;
        double D57 = 4, M57 = 0, MA57 = 1, F57 = -1, koefisien57 = 132;
        double D58 = 1, M58 = 0, MA58 = -1, F58 = -1, koefisien58 = -119;
        double D59 = 4, M59 = -1, MA59 = 0, F59 = -1, koefisien59 = 115;
        double D60 = 2, M60 = -2, MA60 = 0, F60 = 1, koefisien60 = 107;

        double lintang_bulan = 0;
        lintang_bulan += koefisien1 * (Math.pow(e, Math.abs(M1))) * Math.sin(D1 * d_r + M1 * m_r + MA1 * ma_r + F1 * f_r);
        lintang_bulan += koefisien2 * (Math.pow(e, Math.abs(M2))) * Math.sin(D2 * d_r + M2 * m_r + MA2 * ma_r + F2 * f_r);
        lintang_bulan += koefisien3 * (Math.pow(e, Math.abs(M3))) * Math.sin(D3 * d_r + M3 * m_r + MA3 * ma_r + F3 * f_r);
        lintang_bulan += koefisien4 * (Math.pow(e, Math.abs(M4))) * Math.sin(D4 * d_r + M4 * m_r + MA4 * ma_r + F4 * f_r);
        lintang_bulan += koefisien5 * (Math.pow(e, Math.abs(M5))) * Math.sin(D5 * d_r + M5 * m_r + MA5 * ma_r + F5 * f_r);
        lintang_bulan += koefisien6 * (Math.pow(e, Math.abs(M6))) * Math.sin(D6 * d_r + M6 * m_r + MA6 * ma_r + F6 * f_r);
        lintang_bulan += koefisien7 * (Math.pow(e, Math.abs(M7))) * Math.sin(D7 * d_r + M7 * m_r + MA7 * ma_r + F7 * f_r);
        lintang_bulan += koefisien8 * (Math.pow(e, Math.abs(M8))) * Math.sin(D8 * d_r + M8 * m_r + MA8 * ma_r + F8 * f_r);
        lintang_bulan += koefisien9 * (Math.pow(e, Math.abs(M9))) * Math.sin(D9 * d_r + M9 * m_r + MA9 * ma_r + F9 * f_r);
        lintang_bulan += koefisien10 * (Math.pow(e, Math.abs(M10))) * Math.sin(D10 * d_r + M10 * m_r + MA10 * ma_r + F10 * f_r);
        lintang_bulan += koefisien11 * (Math.pow(e, Math.abs(M11))) * Math.sin(D11 * d_r + M11 * m_r + MA11 * ma_r + F11 * f_r);
        lintang_bulan += koefisien12 * (Math.pow(e, Math.abs(M12))) * Math.sin(D12 * d_r + M12 * m_r + MA12 * ma_r + F12 * f_r);
        lintang_bulan += koefisien13 * (Math.pow(e, Math.abs(M13))) * Math.sin(D13 * d_r + M13 * m_r + MA13 * ma_r + F13 * f_r);
        lintang_bulan += koefisien14 * (Math.pow(e, Math.abs(M14))) * Math.sin(D14 * d_r + M14 * m_r + MA14 * ma_r + F14 * f_r);
        lintang_bulan += koefisien15 * (Math.pow(e, Math.abs(M15))) * Math.sin(D15 * d_r + M15 * m_r + MA15 * ma_r + F15 * f_r);
        lintang_bulan += koefisien16 * (Math.pow(e, Math.abs(M16))) * Math.sin(D16 * d_r + M16 * m_r + MA16 * ma_r + F16 * f_r);
        lintang_bulan += koefisien17 * (Math.pow(e, Math.abs(M17))) * Math.sin(D17 * d_r + M17 * m_r + MA17 * ma_r + F17 * f_r);
        lintang_bulan += koefisien18 * (Math.pow(e, Math.abs(M18))) * Math.sin(D18 * d_r + M18 * m_r + MA18 * ma_r + F18 * f_r);
        lintang_bulan += koefisien19 * (Math.pow(e, Math.abs(M19))) * Math.sin(D19 * d_r + M19 * m_r + MA19 * ma_r + F19 * f_r);
        lintang_bulan += koefisien20 * (Math.pow(e, Math.abs(M20))) * Math.sin(D20 * d_r + M20 * m_r + MA20 * ma_r + F20 * f_r);
        lintang_bulan += koefisien21 * (Math.pow(e, Math.abs(M21))) * Math.sin(D21 * d_r + M21 * m_r + MA21 * ma_r + F21 * f_r);
        lintang_bulan += koefisien22 * (Math.pow(e, Math.abs(M22))) * Math.sin(D22 * d_r + M22 * m_r + MA22 * ma_r + F22 * f_r);
        lintang_bulan += koefisien23 * (Math.pow(e, Math.abs(M23))) * Math.sin(D23 * d_r + M23 * m_r + MA23 * ma_r + F23 * f_r);
        lintang_bulan += koefisien24 * (Math.pow(e, Math.abs(M24))) * Math.sin(D24 * d_r + M24 * m_r + MA24 * ma_r + F24 * f_r);
        lintang_bulan += koefisien25 * (Math.pow(e, Math.abs(M25))) * Math.sin(D25 * d_r + M25 * m_r + MA25 * ma_r + F25 * f_r);
        lintang_bulan += koefisien26 * (Math.pow(e, Math.abs(M26))) * Math.sin(D26 * d_r + M26 * m_r + MA26 * ma_r + F26 * f_r);
        lintang_bulan += koefisien27 * (Math.pow(e, Math.abs(M27))) * Math.sin(D27 * d_r + M27 * m_r + MA27 * ma_r + F27 * f_r);
        lintang_bulan += koefisien28 * (Math.pow(e, Math.abs(M28))) * Math.sin(D28 * d_r + M28 * m_r + MA28 * ma_r + F28 * f_r);
        lintang_bulan += koefisien29 * (Math.pow(e, Math.abs(M29))) * Math.sin(D29 * d_r + M29 * m_r + MA29 * ma_r + F29 * f_r);
        lintang_bulan += koefisien30 * (Math.pow(e, Math.abs(M30))) * Math.sin(D30 * d_r + M30 * m_r + MA30 * ma_r + F30 * f_r);
        lintang_bulan += koefisien31 * (Math.pow(e, Math.abs(M31))) * Math.sin(D31 * d_r + M31 * m_r + MA31 * ma_r + F31 * f_r);
        lintang_bulan += koefisien32 * (Math.pow(e, Math.abs(M32))) * Math.sin(D32 * d_r + M32 * m_r + MA32 * ma_r + F32 * f_r);
        lintang_bulan += koefisien33 * (Math.pow(e, Math.abs(M33))) * Math.sin(D33 * d_r + M33 * m_r + MA33 * ma_r + F33 * f_r);
        lintang_bulan += koefisien34 * (Math.pow(e, Math.abs(M34))) * Math.sin(D34 * d_r + M34 * m_r + MA34 * ma_r + F34 * f_r);
        lintang_bulan += koefisien35 * (Math.pow(e, Math.abs(M35))) * Math.sin(D35 * d_r + M35 * m_r + MA35 * ma_r + F35 * f_r);
        lintang_bulan += koefisien36 * (Math.pow(e, Math.abs(M36))) * Math.sin(D36 * d_r + M36 * m_r + MA36 * ma_r + F36 * f_r);
        lintang_bulan += koefisien37 * (Math.pow(e, Math.abs(M37))) * Math.sin(D37 * d_r + M37 * m_r + MA37 * ma_r + F37 * f_r);
        lintang_bulan += koefisien38 * (Math.pow(e, Math.abs(M38))) * Math.sin(D38 * d_r + M38 * m_r + MA38 * ma_r + F38 * f_r);
        lintang_bulan += koefisien39 * (Math.pow(e, Math.abs(M39))) * Math.sin(D39 * d_r + M39 * m_r + MA39 * ma_r + F39 * f_r);
        lintang_bulan += koefisien40 * (Math.pow(e, Math.abs(M40))) * Math.sin(D40 * d_r + M40 * m_r + MA40 * ma_r + F40 * f_r);
        lintang_bulan += koefisien41 * (Math.pow(e, Math.abs(M41))) * Math.sin(D41 * d_r + M41 * m_r + MA41 * ma_r + F41 * f_r);
        lintang_bulan += koefisien42 * (Math.pow(e, Math.abs(M42))) * Math.sin(D42 * d_r + M42 * m_r + MA42 * ma_r + F42 * f_r);
        lintang_bulan += koefisien43 * (Math.pow(e, Math.abs(M43))) * Math.sin(D43 * d_r + M43 * m_r + MA43 * ma_r + F43 * f_r);
        lintang_bulan += koefisien44 * (Math.pow(e, Math.abs(M44))) * Math.sin(D44 * d_r + M44 * m_r + MA44 * ma_r + F44 * f_r);
        lintang_bulan += koefisien45 * (Math.pow(e, Math.abs(M45))) * Math.sin(D45 * d_r + M45 * m_r + MA45 * ma_r + F45 * f_r);
        lintang_bulan += koefisien46 * (Math.pow(e, Math.abs(M46))) * Math.sin(D46 * d_r + M46 * m_r + MA46 * ma_r + F46 * f_r);
        lintang_bulan += koefisien47 * (Math.pow(e, Math.abs(M47))) * Math.sin(D47 * d_r + M47 * m_r + MA47 * ma_r + F47 * f_r);
        lintang_bulan += koefisien48 * (Math.pow(e, Math.abs(M48))) * Math.sin(D48 * d_r + M48 * m_r + MA48 * ma_r + F48 * f_r);
        lintang_bulan += koefisien49 * (Math.pow(e, Math.abs(M49))) * Math.sin(D49 * d_r + M49 * m_r + MA49 * ma_r + F49 * f_r);
        lintang_bulan += koefisien50 * (Math.pow(e, Math.abs(M50))) * Math.sin(D50 * d_r + M50 * m_r + MA50 * ma_r + F50 * f_r);
        lintang_bulan += koefisien51 * (Math.pow(e, Math.abs(M51))) * Math.sin(D51 * d_r + M51 * m_r + MA51 * ma_r + F51 * f_r);
        lintang_bulan += koefisien52 * (Math.pow(e, Math.abs(M52))) * Math.sin(D52 * d_r + M52 * m_r + MA52 * ma_r + F52 * f_r);
        lintang_bulan += koefisien53 * (Math.pow(e, Math.abs(M53))) * Math.sin(D53 * d_r + M53 * m_r + MA53 * ma_r + F53 * f_r);
        lintang_bulan += koefisien54 * (Math.pow(e, Math.abs(M54))) * Math.sin(D54 * d_r + M54 * m_r + MA54 * ma_r + F54 * f_r);
        lintang_bulan += koefisien55 * (Math.pow(e, Math.abs(M55))) * Math.sin(D55 * d_r + M55 * m_r + MA55 * ma_r + F55 * f_r);
        lintang_bulan += koefisien56 * (Math.pow(e, Math.abs(M56))) * Math.sin(D56 * d_r + M56 * m_r + MA56 * ma_r + F56 * f_r);
        lintang_bulan += koefisien57 * (Math.pow(e, Math.abs(M57))) * Math.sin(D57 * d_r + M57 * m_r + MA57 * ma_r + F57 * f_r);
        lintang_bulan += koefisien58 * (Math.pow(e, Math.abs(M58))) * Math.sin(D58 * d_r + M58 * m_r + MA58 * ma_r + F58 * f_r);
        lintang_bulan += koefisien59 * (Math.pow(e, Math.abs(M59))) * Math.sin(D59 * d_r + M59 * m_r + MA59 * ma_r + F59 * f_r);
        lintang_bulan += koefisien60 * (Math.pow(e, Math.abs(M60))) * Math.sin(D60 * d_r + M60 * m_r + MA60 * ma_r + F60 * f_r);

        lintang_bulan = (lintang_bulan - 2235 * Math.sin(l1_r) + 382 * Math.sin(aA3_r) + 175 * Math.sin(aA1_r - f_r) + 175 * Math.sin(aA1_r + f_r) + 127 * Math.sin(l1_r - ma_r) - 115 * Math.sin(l1_r + ma_r)) / 1000000;


        return lintang_bulan;

    }

    public static double moonGeocentricDistance(double e, double d_r, double m_r, double ma_r, double f_r) {
        double D1 = 0, M1 = 0, MA1 = 1, F1 = 0, koefisien1 = -20905355;
        double D2 = 2, M2 = 0, MA2 = -1, F2 = 0, koefisien2 = -3699111;
        double D3 = 2, M3 = 0, MA3 = 0, F3 = 0, koefisien3 = -2955968;
        double D4 = 0, M4 = 0, MA4 = 2, F4 = 0, koefisien4 = -569925;
        double D5 = 2, M5 = 0, MA5 = -2, F5 = 0, koefisien5 = 246158;
        double D6 = 2, M6 = -1, MA6 = 0, F6 = 0, koefisien6 = -204586;
        double D7 = 2, M7 = 0, MA7 = 1, F7 = 0, koefisien7 = -170733;
        double D8 = 2, M8 = -1, MA8 = -1, F8 = 0, koefisien8 = -152138;
        double D9 = 0, M9 = 1, MA9 = -1, F9 = 0, koefisien9 = -129620;
        double D10 = 1, M10 = 0, MA10 = 0, F10 = 0, koefisien10 = 108743;
        double D11 = 0, M11 = 1, MA11 = 1, F11 = 0, koefisien11 = 104755;
        double D12 = 0, M12 = 0, MA12 = 1, F12 = -2, koefisien12 = 79661;
        double D13 = 0, M13 = 1, MA13 = 0, F13 = 0, koefisien13 = 48888;
        double D14 = 4, M14 = 0, MA14 = -1, F14 = 0, koefisien14 = -34782;
        double D15 = 2, M15 = 1, MA15 = 0, F15 = 0, koefisien15 = 30824;
        double D16 = 2, M16 = 1, MA16 = -1, F16 = 0, koefisien16 = 24208;
        double D17 = 0, M17 = 0, MA17 = 3, F17 = 0, koefisien17 = -23210;
        double D18 = 4, M18 = 0, MA18 = -2, F18 = 0, koefisien18 = -21636;
        double D19 = 1, M19 = 1, MA19 = 0, F19 = 0, koefisien19 = -16675;
        double D20 = 2, M20 = 0, MA20 = -3, F20 = 0, koefisien20 = 14403;
        double D21 = 2, M21 = -1, MA21 = 1, F21 = 0, koefisien21 = -12831;
        double D22 = 4, M22 = 0, MA22 = 0, F22 = 0, koefisien22 = -11650;
        double D23 = 2, M23 = 0, MA23 = 2, F23 = 0, koefisien23 = -10445;
        double D24 = 2, M24 = 0, MA24 = 0, F24 = -2, koefisien24 = 10321;
        double D25 = 2, M25 = -1, MA25 = -2, F25 = 0, koefisien25 = 10056;
        double D26 = 2, M26 = -2, MA26 = 0, F26 = 0, koefisien26 = -9884;
        double D27 = 2, M27 = 0, MA27 = -1, F27 = -2, koefisien27 = 8752;
        double D28 = 1, M28 = 0, MA28 = -1, F28 = 0, koefisien28 = -8379;
        double D29 = 0, M29 = 1, MA29 = -2, F29 = 0, koefisien29 = -7003;
        double D30 = 1, M30 = 0, MA30 = 1, F30 = 0, koefisien30 = 6322;
        double D31 = 0, M31 = 1, MA31 = 2, F31 = 0, koefisien31 = 5751;
        double D32 = 2, M32 = -2, MA32 = -1, F32 = 0, koefisien32 = -4950;
        double D33 = 0, M33 = 0, MA33 = 2, F33 = -2, koefisien33 = -4421;
        double D34 = 2, M34 = 0, MA34 = 1, F34 = -2, koefisien34 = 4130;
        double D35 = 4, M35 = -1, MA35 = -1, F35 = 0, koefisien35 = -3958;
        double D36 = 3, M36 = 0, MA36 = -1, F36 = 0, koefisien36 = 3258;
        double D37 = 0, M37 = 0, MA37 = 0, F37 = 2, koefisien37 = -3149;
        double D38 = 2, M38 = 1, MA38 = 1, F38 = 0, koefisien38 = 2616;
        double D39 = 2, M39 = 2, MA39 = -1, F39 = 0, koefisien39 = 2354;
        double D40 = 0, M40 = 2, MA40 = -1, F40 = 0, koefisien40 = -2117;
        double D41 = 4, M41 = -1, MA41 = -2, F41 = 0, koefisien41 = -1897;
        double D42 = 1, M42 = 0, MA42 = -2, F42 = 0, koefisien42 = -1739;
        double D43 = 4, M43 = -1, MA43 = 0, F43 = 0, koefisien43 = -1571;
        double D44 = 4, M44 = 0, MA44 = 1, F44 = 0, koefisien44 = -1423;
        double D45 = 0, M45 = 2, MA45 = 1, F45 = 0, koefisien45 = 1165;
        double D46 = 0, M46 = 0, MA46 = 4, F46 = 0, koefisien46 = -1117;

        double jarakBulan = 0;
        jarakBulan += koefisien1 * (Math.pow(e, Math.abs(M1))) * Math.cos(D1 * d_r + M1 * m_r + MA1 * ma_r + F1 * f_r);
        jarakBulan += koefisien2 * (Math.pow(e, Math.abs(M2))) * Math.cos(D2 * d_r + M2 * m_r + MA2 * ma_r + F2 * f_r);
        jarakBulan += koefisien3 * (Math.pow(e, Math.abs(M3))) * Math.cos(D3 * d_r + M3 * m_r + MA3 * ma_r + F3 * f_r);
        jarakBulan += koefisien4 * (Math.pow(e, Math.abs(M4))) * Math.cos(D4 * d_r + M4 * m_r + MA4 * ma_r + F4 * f_r);
        jarakBulan += koefisien5 * (Math.pow(e, Math.abs(M5))) * Math.cos(D5 * d_r + M5 * m_r + MA5 * ma_r + F5 * f_r);
        jarakBulan += koefisien6 * (Math.pow(e, Math.abs(M6))) * Math.cos(D6 * d_r + M6 * m_r + MA6 * ma_r + F6 * f_r);
        jarakBulan += koefisien7 * (Math.pow(e, Math.abs(M7))) * Math.cos(D7 * d_r + M7 * m_r + MA7 * ma_r + F7 * f_r);
        jarakBulan += koefisien8 * (Math.pow(e, Math.abs(M8))) * Math.cos(D8 * d_r + M8 * m_r + MA8 * ma_r + F8 * f_r);
        jarakBulan += koefisien9 * (Math.pow(e, Math.abs(M9))) * Math.cos(D9 * d_r + M9 * m_r + MA9 * ma_r + F9 * f_r);
        jarakBulan += koefisien10 * (Math.pow(e, Math.abs(M10))) * Math.cos(D10 * d_r + M10 * m_r + MA10 * ma_r + F10 * f_r);
        jarakBulan += koefisien11 * (Math.pow(e, Math.abs(M11))) * Math.cos(D11 * d_r + M11 * m_r + MA11 * ma_r + F11 * f_r);
        jarakBulan += koefisien12 * (Math.pow(e, Math.abs(M12))) * Math.cos(D12 * d_r + M12 * m_r + MA12 * ma_r + F12 * f_r);
        jarakBulan += koefisien13 * (Math.pow(e, Math.abs(M13))) * Math.cos(D13 * d_r + M13 * m_r + MA13 * ma_r + F13 * f_r);
        jarakBulan += koefisien14 * (Math.pow(e, Math.abs(M14))) * Math.cos(D14 * d_r + M14 * m_r + MA14 * ma_r + F14 * f_r);
        jarakBulan += koefisien15 * (Math.pow(e, Math.abs(M15))) * Math.cos(D15 * d_r + M15 * m_r + MA15 * ma_r + F15 * f_r);
        jarakBulan += koefisien16 * (Math.pow(e, Math.abs(M16))) * Math.cos(D16 * d_r + M16 * m_r + MA16 * ma_r + F16 * f_r);
        jarakBulan += koefisien17 * (Math.pow(e, Math.abs(M17))) * Math.cos(D17 * d_r + M17 * m_r + MA17 * ma_r + F17 * f_r);
        jarakBulan += koefisien18 * (Math.pow(e, Math.abs(M18))) * Math.cos(D18 * d_r + M18 * m_r + MA18 * ma_r + F18 * f_r);
        jarakBulan += koefisien19 * (Math.pow(e, Math.abs(M19))) * Math.cos(D19 * d_r + M19 * m_r + MA19 * ma_r + F19 * f_r);
        jarakBulan += koefisien20 * (Math.pow(e, Math.abs(M20))) * Math.cos(D20 * d_r + M20 * m_r + MA20 * ma_r + F20 * f_r);
        jarakBulan += koefisien21 * (Math.pow(e, Math.abs(M21))) * Math.cos(D21 * d_r + M21 * m_r + MA21 * ma_r + F21 * f_r);
        jarakBulan += koefisien22 * (Math.pow(e, Math.abs(M22))) * Math.cos(D22 * d_r + M22 * m_r + MA22 * ma_r + F22 * f_r);
        jarakBulan += koefisien23 * (Math.pow(e, Math.abs(M23))) * Math.cos(D23 * d_r + M23 * m_r + MA23 * ma_r + F23 * f_r);
        jarakBulan += koefisien24 * (Math.pow(e, Math.abs(M24))) * Math.cos(D24 * d_r + M24 * m_r + MA24 * ma_r + F24 * f_r);
        jarakBulan += koefisien25 * (Math.pow(e, Math.abs(M25))) * Math.cos(D25 * d_r + M25 * m_r + MA25 * ma_r + F25 * f_r);
        jarakBulan += koefisien26 * (Math.pow(e, Math.abs(M26))) * Math.cos(D26 * d_r + M26 * m_r + MA26 * ma_r + F26 * f_r);
        jarakBulan += koefisien27 * (Math.pow(e, Math.abs(M27))) * Math.cos(D27 * d_r + M27 * m_r + MA27 * ma_r + F27 * f_r);
        jarakBulan += koefisien28 * (Math.pow(e, Math.abs(M28))) * Math.cos(D28 * d_r + M28 * m_r + MA28 * ma_r + F28 * f_r);
        jarakBulan += koefisien29 * (Math.pow(e, Math.abs(M29))) * Math.cos(D29 * d_r + M29 * m_r + MA29 * ma_r + F29 * f_r);
        jarakBulan += koefisien30 * (Math.pow(e, Math.abs(M30))) * Math.cos(D30 * d_r + M30 * m_r + MA30 * ma_r + F30 * f_r);
        jarakBulan += koefisien31 * (Math.pow(e, Math.abs(M31))) * Math.cos(D31 * d_r + M31 * m_r + MA31 * ma_r + F31 * f_r);
        jarakBulan += koefisien32 * (Math.pow(e, Math.abs(M32))) * Math.cos(D32 * d_r + M32 * m_r + MA32 * ma_r + F32 * f_r);
        jarakBulan += koefisien33 * (Math.pow(e, Math.abs(M33))) * Math.cos(D33 * d_r + M33 * m_r + MA33 * ma_r + F33 * f_r);
        jarakBulan += koefisien34 * (Math.pow(e, Math.abs(M34))) * Math.cos(D34 * d_r + M34 * m_r + MA34 * ma_r + F34 * f_r);
        jarakBulan += koefisien35 * (Math.pow(e, Math.abs(M35))) * Math.cos(D35 * d_r + M35 * m_r + MA35 * ma_r + F35 * f_r);
        jarakBulan += koefisien36 * (Math.pow(e, Math.abs(M36))) * Math.cos(D36 * d_r + M36 * m_r + MA36 * ma_r + F36 * f_r);
        jarakBulan += koefisien37 * (Math.pow(e, Math.abs(M37))) * Math.cos(D37 * d_r + M37 * m_r + MA37 * ma_r + F37 * f_r);
        jarakBulan += koefisien38 * (Math.pow(e, Math.abs(M38))) * Math.cos(D38 * d_r + M38 * m_r + MA38 * ma_r + F38 * f_r);
        jarakBulan += koefisien39 * (Math.pow(e, Math.abs(M39))) * Math.cos(D39 * d_r + M39 * m_r + MA39 * ma_r + F39 * f_r);
        jarakBulan += koefisien40 * (Math.pow(e, Math.abs(M40))) * Math.cos(D40 * d_r + M40 * m_r + MA40 * ma_r + F40 * f_r);
        jarakBulan += koefisien41 * (Math.pow(e, Math.abs(M41))) * Math.cos(D41 * d_r + M41 * m_r + MA41 * ma_r + F41 * f_r);
        jarakBulan += koefisien42 * (Math.pow(e, Math.abs(M42))) * Math.cos(D42 * d_r + M42 * m_r + MA42 * ma_r + F42 * f_r);
        jarakBulan += koefisien43 * (Math.pow(e, Math.abs(M43))) * Math.cos(D43 * d_r + M43 * m_r + MA43 * ma_r + F43 * f_r);
        jarakBulan += koefisien44 * (Math.pow(e, Math.abs(M44))) * Math.cos(D44 * d_r + M44 * m_r + MA44 * ma_r + F44 * f_r);
        jarakBulan += koefisien45 * (Math.pow(e, Math.abs(M45))) * Math.cos(D45 * d_r + M45 * m_r + MA45 * ma_r + F45 * f_r);
        jarakBulan += koefisien46 * (Math.pow(e, Math.abs(M46))) * Math.cos(D46 * d_r + M46 * m_r + MA46 * ma_r + F46 * f_r);

        jarakBulan = jarakBulan / 1000;

        return jarakBulan;

    }


}
