package com.falak.term.elpmpp02;


public class ElpMpp02 {

    public static  double koreksiLongitude(double t1,double t2,double t3,double t4 ){

        double p,p1,p2,p3,p4,p0;
        p0=0; p1=5029.0966; p2=1.112;p3=0.000077;p4=-0.00002353;
        p=p0+p1*t1+p2*t2+p3*t3+p4*t4;

        double  l0 = SeriesL.l0_term(t1,t2,t3,t4);
        double l1 =SeriesL.l1_term(t1,t2,t3,t4);
        double l2 = SeriesL.l2_term(t1,t2,t3,t4);
        double l3 = SeriesL.l3_term(t1,t2,t3,t4);
        double L = l0+l1*t1+l2*t2+l3*t3+0*t4;



        double koreksi_longitude = L/3600+p/3600;

        return koreksi_longitude;
    }
    public static  double meanLongitude(double t1,double t2,double t3,double t4){

        double w,w0,w1,w2,w3,w4;
        w0 =3.81034409083088; w1=8399.68473007193; w2=0.0000331895204255009; w3=3.11024944910606E-08; w4=-2.03282376489228E-10;
        w = w0+w1*t1+w2*t2+w3*t3+w4*t4; // hasil = Rad



        double mean_longitude = Math.toDegrees(w)%360;
        return mean_longitude;
    }
    public static  double latitude(double t1,double t2,double t3,double t4){


        double b0 = SeriesB.b0_term(t1,t2,t3,t4);
        double b1 = SeriesB.b1_term(t1,t2,t3,t4);
        double b2 = SeriesB.b2_term(t1,t2,t3,t4);
        double B = b0+b1*t1+b2*t2+0*t3+0*t4;
        double latitude = B/3600;

        return   latitude  ;
    }
    public static  double range(double t1,double t2,double t3,double t4){

        double r0 = SeriesR.r0_term(t1,t2,t3,t4);
        double r1 =  SeriesR.r1_term(t1,t2,t3,t4);
        double r2 = SeriesR.r2_term(t1,t2,t3,t4);
        double r3 = SeriesR.r3_term(t1,t2,t3,t4);

        return  r0+r1*t1+r2*t2+r3*t3+0*t4;
    }

}
