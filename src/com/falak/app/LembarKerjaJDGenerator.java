package com.falak.app;

import com.falak.Konversi;
import com.falak.Mathf;

public class LembarKerjaJDGenerator {
    public static void main(String[] args) {
        for (int i = 1; i<=14;i++){
            double jd = Mathf.random_jd(1950,2099);
            System.out.println(Konversi.jdTo_DDMMMYYYY(jd)+", "+Konversi.jdTo_hhmmss(jd)+", "+jd+", "+ Konversi.ddd_ppp(jd));
        }
    }
}
