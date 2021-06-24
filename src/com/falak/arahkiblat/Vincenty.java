package com.falak.arahkiblat;
import com.falak.Mathf;

import static java.lang.Math.*;

/**
 * menghitung Arah suatu Tempat ke ka'bah berdasarkan rumus Vincenty (Geodetic Approach) Vincenty.
 */
public class Vincenty {

    /**
     * Utsb double.
     *
     * @param data data arh kiblat, meliputi koordinat kakbah dan lain-lain
     * @return arah kiblat UTSB
     */
    static double UTSB(ArahKiblat data){
        double S,A,B,C,F,
                lintangTempatTerkoreksi,lintangKabahTerkoreksi,c2SigmaM = 0,dSigma,
                sigma = 0,sAlpha,cAlpha,c2Alpha = 0,c2Sigma = 0,Bb,
                ae,be,u1,u2,L,lambda0,lambda,sSigma = 0,cSigma,
                up2,alpha1,alpha2,hasil;
        int iterlimit;

        F=1d/298.257223563;
        ae=6378137;
        be=6356752.314;

//         Koreksi koordinat dari geografik (sistem bumi sebagai ellipsoid) ke koordinat geosentrik (sistem bumi sebagai bola).
//         Koreksi dilakukan dengan menggunakan parameter WGS-84.
//         Parameter ini biasa dipakai dalam pengukuran GNSS (Global Navigation Satellite System  )
//         excentrisitas (e) =   6.6943800229e-3

        u1=atan((1d-F)*tan(toRadians(data.lintang_kb)));
        u2=atan((1d-F)*tan(toRadians(data.lintang)));
        L=toRadians(data.bujur-data.bujur_kb);

        lambda=L;
        lambda0=500;
        iterlimit=0;
        while (true){
            iterlimit++;
            lambda0=lambda;

            sSigma=sqrt(
                    pow(cos(u2)*sin(lambda),2)+
                            pow(cos(u1)*sin(u2)-sin(u1)*cos(u2)*cos(lambda),2));
            cSigma=sin(u1)*sin(u2)+cos(u1)*cos(u2)*cos(lambda);
            sigma=atan2(sSigma,cSigma);


            sAlpha=cos(u1)*cos(u2)*sin(lambda)/sSigma;
            c2Alpha=1-pow(sAlpha,2);
            c2SigmaM=cSigma-2*sin(u1)*sin(u2)/c2Alpha;
            C=F/16*c2Alpha*(4+F*(4-3*c2Alpha));
            lambda=L+(1-C)*F*sAlpha*(sigma+C*sSigma*(c2SigmaM+C*sSigma*(-1+2*pow(c2SigmaM,2))));

            if (abs(lambda0-lambda)<0.000000000001||iterlimit>100)break;
        }

        up2=c2Alpha*(pow(ae,2)-pow(be,2))/pow(ae,2);
        A=1+up2/16384*(4096+up2*(-768+up2*(320-175*up2)));
        B=up2/1024*(256+up2*(-128+up2*(74-47*up2)));

        dSigma=B*sSigma*(c2SigmaM+0.25*B*(c2Sigma*(-1+2*pow(c2SigmaM,2))-1d/6*B*c2SigmaM*(-3+4*pow(sSigma,2))*(-3+4*pow(c2SigmaM,2))));
        S=be*A*(sigma-dSigma);
        alpha1=atan2(cos(u2)*sin(lambda),cos(u1)*sin(u2)-sin(u1)*cos(u2)*cos(lambda));
        alpha2=atan2(cos(u1)*sin(lambda),-sin(u1)*cos(u2)+cos(u1)*sin(u2)*cos(lambda));
        hasil=180+toDegrees(alpha2);
        return Mathf.moduloModif(hasil, 360);
    }


}
