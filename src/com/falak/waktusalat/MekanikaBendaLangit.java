package com.falak.waktusalat;

import com.falak.Konversi;
import com.falak.ephemeris.Sun;
import static java.lang.Math.*;

public class MekanikaBendaLangit{


    static double subuh(Salat data){

        //shubuh
        
        double jdl=Konversi.masehiKeJd(data.tanggal, data.bulan, data.tahun, 12)-(data.zona_waktu/24);
        double sudut_tanggal= 2*PI*(jdl-2451545)/365.25;
        double deklinasijam12= 0.37877+23.264* sin(toRadians(57.297*sudut_tanggal-79.547))+0.3812*sin(toRadians(2*57.297*sudut_tanggal-82.682))+0.17132*sin(toRadians(3*57.297*sudut_tanggal-59.722));

        double ha_subuh= toDegrees(acos((sin(toRadians(data.sudutSubuh))-sin(toRadians(deklinasijam12))*sin(data.lintangRad))/(cos(toRadians(deklinasijam12))*cos(data.lintangRad))));
        double jdl_subuh=jdl-ha_subuh/360;
        double sudut_tanggal_s= 2*PI*(jdl_subuh-2451545)/365.25;
        double U_s =((jdl_subuh-2451545)/36525);
        double LO_s =toRadians((280.46607+36000.7698*U_s)%360);
        double deklinasi_s= 0.37877+23.264* sin(toRadians(57.297*sudut_tanggal_s-79.547))+0.3812*sin(toRadians(2*57.297*sudut_tanggal_s-82.682))+0.17132*sin(toRadians(3*57.297*sudut_tanggal_s-59.722));
        double EoT_s=(-1*(1789+237*U_s)*sin(LO_s)-(7146-62*U_s)*cos(LO_s)+(9934-14*U_s)*sin(2*LO_s)-(29+5*U_s)*cos(2*LO_s)+(74+10*U_s)*sin(3*LO_s)+(320-4*U_s)*cos(3*LO_s)-212*sin(4*LO_s))/1000;
        double deklinasi_s_r=toRadians(deklinasi_s);
        double cosSudutwaktu_s= (sin(toRadians(data.sudutSubuh))-sin(deklinasi_s_r)*sin(data.lintangRad))/(cos(deklinasi_s_r)*cos(data.lintangRad));
        double sudutwaktu_s=toDegrees(acos(cosSudutwaktu_s));
        double subuh = (12+data.zona_waktu-data.bujur/15-EoT_s/60-sudutwaktu_s/15)+data.ihtiyat;
        return subuh;

    }
    static double terbit(Salat data){
        double jdl=Konversi.masehiKeJd(data.tanggal, data.bulan, data.tahun, 12)-(data.zona_waktu/24);
        double sudut_tanggal= 2*PI*(jdl-2451545)/365.25;
        double deklinasijam12= 0.37877+23.264* sin(toRadians(57.297*sudut_tanggal-79.547))+0.3812*sin(toRadians(2*57.297*sudut_tanggal-82.682))+0.17132*sin(toRadians(3*57.297*sudut_tanggal-59.722));

        double perkiraan_terbit=toDegrees(acos((sin(toRadians(-0.8333-0.0347*sqrt(data.tinggiLokasi)))-sin(toRadians(deklinasijam12))*sin(data.lintangRad))/(cos(toRadians(deklinasijam12))*cos(data.lintangRad))));
        double jdl_terbit=jdl-perkiraan_terbit/360;
        double sudut_tanggal_t= 2*PI*(jdl_terbit-2451545)/365.25;
        double U_t =((jdl_terbit-2451545)/36525);
        double LO_t =toRadians((280.46607+36000.7698*U_t)%360);
        double deklinasi_t= 0.37877+23.264* sin(toRadians(57.297*sudut_tanggal_t-79.547))+0.3812*sin(toRadians(2*57.297*sudut_tanggal_t-82.682))+0.17132*sin(toRadians(3*57.297*sudut_tanggal_t-59.722));
        double deklinasi_t_r=toRadians(deklinasi_t);
        double EoT_t=(-1*(1789+237*U_t)*sin(LO_t)-(7146-62*U_t)*cos(LO_t)+(9934-14*U_t)*sin(2*LO_t)-(29+5*U_t)*cos(2*LO_t)+(74+10*U_t)*sin(3*LO_t)+(320-4*U_t)*cos(3*LO_t)-212*sin(4*LO_t))/1000;
        double cosSudutwaktu_t=(sin(toRadians(-0.8333-0.0347*sqrt(data.tinggiLokasi)))-sin(deklinasi_t_r)*(sin(data.lintangRad)))/(cos(deklinasi_t_r)*cos(data.lintangRad));
        double sudutwaktu_t=toDegrees(acos(cosSudutwaktu_t));
        double terbit= (12+data.zona_waktu-data.bujur/15-EoT_t/60-sudutwaktu_t/15)-data.ihtiyat;
        return terbit;
    }

    static double dluha(Salat data){

        double jdl=Konversi.masehiKeJd(data.tanggal, data.bulan, data.tahun, 12)-(data.zona_waktu/24);
        double U =((jdl-2451545)/36525);
        double LO =toRadians((280.46607+36000.7698*U)%360);
        double EoT_jam12=(-1*(1789+237*U)*sin(LO)-(7146-62*U)*cos(LO)+(9934-14*U)*sin(2*LO)-(29+5*U)*cos(2*LO)+(74+10*U)*sin(3*LO)+(320-4*U)*cos(3*LO)-212*sin(4*LO))/1000;
        double sudut_tanggal= 2*PI*(jdl-2451545)/365.25;
        double deklinasijam12= 0.37877+23.264* sin(toRadians(57.297*sudut_tanggal-79.547))+0.3812*sin(toRadians(2*57.297*sudut_tanggal-82.682))+0.17132*sin(toRadians(3*57.297*sudut_tanggal-59.722));
        double transit =(12+data.zona_waktu-data.bujur/15-EoT_jam12/60);
        double dluha= transit-(12/PI)*acos((sin(toRadians(data.sudutDluha))-sin(toRadians(deklinasijam12))*sin(data.lintangRad))/(cos(toRadians(deklinasijam12))*cos(data.lintangRad)));
        dluha+=data.ihtiyat;
        return dluha;

    }

    static double dzuhur(Salat data){
        double jdl=Konversi.masehiKeJd(data.tanggal, data.bulan, data.tahun, 12)-(data.zona_waktu/24);
        double U =((jdl-2451545)/36525);
        double LO =toRadians((280.46607+36000.7698*U)%360);
        double EoT_jam12=(-1*(1789+237*U)*sin(LO)-(7146-62*U)*cos(LO)+(9934-14*U)*sin(2*LO)-(29+5*U)*cos(2*LO)+(74+10*U)*sin(3*LO)+(320-4*U)*cos(3*LO)-212*sin(4*LO))/1000;

        double perkiraan_dzuhur =(12+data.zona_waktu-data.bujur/15-EoT_jam12/60)+data.ihtiyat;
        //jdl dzuhur
        double jdl_dzuhur=jdl+ perkiraan_dzuhur /24-0.5;
        double sudut_tanggal_d= 2*PI*(jdl_dzuhur-2451545)/365.25;
        double U_d =((jdl_dzuhur-2451545)/36525);
        double LO_d =toRadians((280.46607+36000.7698*U_d)%360);
        double deklinasi_d= 0.37877+23.264* sin(toRadians(57.297*sudut_tanggal_d-79.547))+0.3812*sin(toRadians(2*57.297*sudut_tanggal_d-82.682))+0.17132*sin(toRadians(3*57.297*sudut_tanggal_d-59.722));
        double EoT_d=(-1*(1789+237*U_d)*sin(LO_d)-(7146-62*U_d)*cos(LO_d)+(9934-14*U_d)*sin(2*LO_d)-(29+5*U_d)*cos(2*LO_d)+(74+10*U_d)*sin(3*LO_d)+(320-4*U_d)*cos(3*LO_d)-212*sin(4*LO_d))/1000;
        double dzuhur=12+data.zona_waktu-data.bujur/15-EoT_d/60;
        return dzuhur;

    }
    static double ashar(Salat data){
        double jdl=Konversi.masehiKeJd(data.tanggal, data.bulan, data.tahun, 12)-(data.zona_waktu/24);
        double sudut_tanggal= 2*PI*(jdl-2451545)/365.25;
        double deklinasijam12= 0.37877+23.264* sin(toRadians(57.297*sudut_tanggal-79.547))+0.3812*sin(toRadians(2*57.297*sudut_tanggal-82.682))+0.17132*sin(toRadians(3*57.297*sudut_tanggal-59.722));
        double deklinasijam12_r=toRadians(deklinasijam12);
        double sudutwaktu_a1=sin(atan(1/(1+tan(abs(data.lintangRad-deklinasijam12_r)))));
        double sudutwaktu_a2=sin(deklinasijam12_r)*sin(data.lintangRad);
        double sudutwaktu_a3=cos(deklinasijam12_r)*cos(data.lintangRad);
        double sudutwaktu_a4=(sudutwaktu_a1-sudutwaktu_a2)/sudutwaktu_a3;
        double perkiraan_ashar=toDegrees(acos(sudutwaktu_a4));

        //jdl ashar
        double jdl_ashar=jdl+perkiraan_ashar/360;
        double sudut_tanggal_a= 2*PI*(jdl_ashar-2451545)/365.25;
        double U_a =((jdl_ashar-2451545)/36525);
        double LO_a =toRadians((280.46607+36000.7698*U_a)%360);
        double deklinasi_a= 0.37877+23.264* sin(toRadians(57.297*sudut_tanggal_a-79.547))+0.3812*sin(toRadians(2*57.297*sudut_tanggal_a-82.682))+0.17132*sin(toRadians(3*57.297*sudut_tanggal_a-59.722));
        double deklinasi_a_r=toRadians(deklinasi_a);
        double EoT_a=(-1*(1789+237*U_a)*sin(LO_a)-(7146-62*U_a)*cos(LO_a)+(9934-14*U_a)*sin(2*LO_a)-(29+5*U_a)*cos(2*LO_a)+(74+10*U_a)*sin(3*LO_a)+(320-4*U_a)*cos(3*LO_a)-212*sin(4*LO_a))/1000;
        double alt_nampak=toDegrees(atan(1/(1+tan(abs(data.lintangRad-deklinasi_a_r)))));
        double koreksi_alt=(1/(60*tan(toRadians(alt_nampak+7.31/(alt_nampak+4.4)))));
        double alt_sejati=alt_nampak-koreksi_alt;
        double cosSudutwaktu_a=(sin(toRadians(alt_sejati))-sin(deklinasi_a_r)*sin(data.lintangRad))/(cos(deklinasi_a_r)*cos(data.lintangRad));
        double sudutwaktu_a=toDegrees(acos(cosSudutwaktu_a));
        double ashar=(12+data.zona_waktu-data.bujur/15-EoT_a/60+sudutwaktu_a/15)+data.ihtiyat;
        return ashar;


    }
    static double maghrib(Salat data){

        double jdl=Konversi.masehiKeJd(data.tanggal, data.bulan, data.tahun, 12)-(data.zona_waktu/24);
        double sudut_tanggal= 2*PI*(jdl-2451545)/365.25;
        double deklinasijam12= 0.37877+23.264* sin(toRadians(57.297*sudut_tanggal-79.547))+0.3812*sin(toRadians(2*57.297*sudut_tanggal-82.682))+0.17132*sin(toRadians(3*57.297*sudut_tanggal-59.722));
        //maghrib
        double perkiraan_cosSudutW_m=(sin(toRadians(-0.8333-0.0347*sqrt(data.tinggiLokasi)))-sin(toRadians(deklinasijam12))*(sin(data.lintangRad)))/(cos(toRadians(deklinasijam12))*cos(data.lintangRad));
        double perkiraan_SudutW_m=toDegrees(acos(perkiraan_cosSudutW_m));

        //jdl maghrib
        double jdl_maghrib=jdl+perkiraan_SudutW_m/360;
        double sudut_tanggal_m= 2*PI*(jdl_maghrib-2451545)/365.25;
        double U_m =((jdl_maghrib-2451545)/36525);
        double LO_m =toRadians((280.46607+36000.7698*U_m)%360);
        double deklinasi_m= 0.37877+23.264* sin(toRadians(57.297*sudut_tanggal_m-79.547))+0.3812*sin(toRadians(2*57.297*sudut_tanggal_m-82.682))+0.17132*sin(toRadians(3*57.297*sudut_tanggal_m-59.722));
        double deklinasi_m_r=toRadians(deklinasi_m);
        double EoT_m=(-1*(1789+237*U_m)*sin(LO_m)-(7146-62*U_m)*cos(LO_m)+(9934-14*U_m)*sin(2*LO_m)-(29+5*U_m)*cos(2*LO_m)+(74+10*U_m)*sin(3*LO_m)+(320-4*U_m)*cos(3*LO_m)-212*sin(4*LO_m))/1000;
        double cosSudutwaktu_m=(sin(toRadians(-0.8333-0.0347*sqrt(data.tinggiLokasi)))-sin(deklinasi_m_r)*(sin(data.lintangRad)))/(cos(deklinasi_m_r)*cos(data.lintangRad));
        double sudutwaktu_m=toDegrees(acos(cosSudutwaktu_m));

        double maghrib=(12+data.zona_waktu-data.bujur/15-EoT_m/60+sudutwaktu_m/15)+data.ihtiyat;
        return maghrib;


    }
    static double isya(Salat data){
        double jdl=Konversi.masehiKeJd(data.tanggal, data.bulan, data.tahun, 12)-(data.zona_waktu/24);
        double sudut_tanggal= 2*PI*(jdl-2451545)/365.25;
        double deklinasijam12= 0.37877+23.264* sin(toRadians(57.297*sudut_tanggal-79.547))+0.3812*sin(toRadians(2*57.297*sudut_tanggal-82.682))+0.17132*sin(toRadians(3*57.297*sudut_tanggal-59.722));

        //isya
        double ha_isya=toDegrees(acos((sin(toRadians(data.sudutIsya))-sin(data.lintangRad)*sin(toRadians(deklinasijam12)))/(cos(data.lintangRad)*cos(toRadians(deklinasijam12)))));
        double jdl_isya=jdl+ha_isya/360;
        double sudut_tanggal_i= 2*PI*(jdl_isya-2451545)/365.25;
        double U_i =((jdl_isya-2451545)/36525);
        double LO_i =toRadians((280.46607+36000.7698*U_i)%360);
        double deklinasi_i= 0.37877+23.264* sin((57.297*sudut_tanggal_i-79.547)*PI/180)+0.3812*sin((2*57.297*sudut_tanggal_i-82.682)*PI/180)+0.17132*sin((3*57.297*sudut_tanggal_i-59.722)*PI/180);
        double deklinasi_i_r=toRadians(deklinasi_i);
        double EoT_i=(-1*(1789+237*U_i)*sin(LO_i)-(7146-62*U_i)*cos(LO_i)+(9934-14*U_i)*sin(2*LO_i)-(29+5*U_i)*cos(2*LO_i)+(74+10*U_i)*sin(3*LO_i)+(320-4*U_i)*cos(3*LO_i)-212*sin(4*LO_i))/1000;
        double cosSudutwaktu_i= (sin(toRadians(data.sudutIsya))-sin(deklinasi_i_r)*sin(data.lintangRad))/(cos(deklinasi_i_r)*cos(data.lintangRad));
        double sudutwaktu_i=toDegrees(acos(cosSudutwaktu_i));
        double isya=(12+data.zona_waktu-data.bujur/15-EoT_i/60+sudutwaktu_i/15)+data.ihtiyat;
        return isya;

    }



}
