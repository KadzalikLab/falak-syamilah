package com.falak.waktusalat;


import com.falak.Konversi;

public class Salat {

    private boolean makalahDepag;
    private boolean mekanikaBendaLangit;
    private boolean anwarulKawakib;
    private boolean irsyadulMurid;

    double sudutSubuh = -20;
    double sudutIsya = -18;
    double sudutDluha = 3.5;

    double lintang;
    double lintangRad;
    double bujur;

    double kwd;
    double zona_waktu;
    double tinggiLokasi;
    double dip;

    double tanggal;
    double bulan;
    double tahun;

    double ihtiyat;
    double ihtiyatTerbit;
    double imsak;



    // ini adalah constructor, sebuah method tang wajib dipanggil saat membuat object Salat
    public Salat(double tanggal, double bulan, double tahun, double lintang, double bujur, double zona_waktu, double tt) {


        this.tanggal = tanggal;
        this.bulan = bulan;
        this.tahun = tahun;
        this.lintang = lintang;
        this.lintangRad=Math.toRadians(this.lintang);
        this.bujur = bujur;
        this.zona_waktu = zona_waktu;
        this.tinggiLokasi=tt;
        this.dip = 1.76 * Math.sqrt(tt) / 60;
        kwd = ((zona_waktu * 15) - bujur) / 15;
    }
    // ini adalah constructor, sebuah method tang wajib dipanggil saat membuat object Salat
    public Salat(double jd, double lintang, double bujur, double zona_waktu, double tt) {
        double tanggalTemp= Konversi.jdKeMasehi(jd)[1];
        double bulanTemp=Konversi.jdKeMasehi(jd)[2];
        double tahunTemp=Konversi.jdKeMasehi(jd)[3];

        this.tanggal = tanggalTemp;
        this.bulan = bulanTemp;
        this.tahun = tahunTemp;
        this.lintang = lintang;
        this.lintangRad=Math.toRadians(this.lintang);
        this.bujur = bujur;
        this.zona_waktu = zona_waktu;
        this.tinggiLokasi=tt;
        this.dip = 1.76 * Math.sqrt(tt) / 60;
        kwd = ((zona_waktu * 15) - bujur) / 15;
    }



    public void setIhtiyat(double value_menit) {
        ihtiyat = value_menit;
    }

    public void setIhtiyatTerbit(double value_menit) {
        ihtiyatTerbit = value_menit/60;
    }

    public void setSudutSubuh(double value_deg) {
        sudutSubuh = value_deg;
    }

    public void setSudutIsya(double value_deg) {
        sudutIsya = value_deg;
    }

    public void setSudutDluha(double value_deg) {
        sudutDluha = value_deg;
    }

    public void setImsak(double imsak_menit) {
        this.imsak = imsak_menit/60;
    }

    public int getTanggal() {
        return (int)tanggal;
    }

    public int getBulan() {
        return (int)bulan;
    }

    public double getSubuh() {
         //bikin object dulu, biar construtornya terakses

         double waktu=0;
         if (makalahDepag)              waktu = MakalahKemenag.subuh(this);
         else if (mekanikaBendaLangit)  waktu =MekanikaBendaLangit.subuh(this);
         else if (irsyadulMurid)        waktu =IrsyadulMurid.subuh(this);
         else if (anwarulKawakib)       waktu =AnwarulKawakib.subuh(this);
         else                           waktu = MakalahKemenag.ashar(this);
         return waktu;
    }
    public double getImsak() {
         //bikin object dulu, biar construtornya terakses

         double waktu=0;
         if (makalahDepag)              waktu = MakalahKemenag.subuh(this)-imsak;
         else if (mekanikaBendaLangit)  waktu =MekanikaBendaLangit.subuh(this)-imsak;
         else if (irsyadulMurid)        waktu =IrsyadulMurid.subuh(this)-imsak;
         else if (anwarulKawakib)       waktu =AnwarulKawakib.subuh(this)-imsak;
         else                           waktu = MakalahKemenag.subuh(this)-imsak;
         return waktu;
    }

     public double getTerbit() {
         double waktu=0;
         if (makalahDepag)              waktu = MakalahKemenag.terbit(this);
         else if (mekanikaBendaLangit)  waktu=MekanikaBendaLangit.terbit(this);
         else if (irsyadulMurid)        waktu=IrsyadulMurid.terbit(this);
         else if (anwarulKawakib)       waktu=AnwarulKawakib.terbit(this);
         else                           waktu = MakalahKemenag.terbit(this);
         return waktu;

    }

    public double getDluha() {
         double waktu=0;
         if (makalahDepag)              waktu = MakalahKemenag.dluha(this);
         else if (mekanikaBendaLangit)  waktu=MekanikaBendaLangit.dluha(this);
         else if (irsyadulMurid)        waktu=IrsyadulMurid.dluha(this);
         else if (anwarulKawakib)       waktu=AnwarulKawakib.dluha(this);
         else                           waktu = MakalahKemenag.dluha(this);
         return waktu;

    }

    public double getDzuhur() {
         double waktu=0;
         if (makalahDepag)              waktu =MakalahKemenag.dzuhur(this);
         else if (mekanikaBendaLangit)  waktu=MekanikaBendaLangit.dzuhur(this);
         else if (irsyadulMurid)        waktu=IrsyadulMurid.dzuhur(this);
         else if (anwarulKawakib)       waktu=AnwarulKawakib.dzuhur(this);
         else                           waktu = MakalahKemenag.dzuhur(this);
         return waktu;


    }

    public  double getAshar() {
         double waktu=0;
         if (makalahDepag)              waktu = MakalahKemenag.ashar(this);
         else if (mekanikaBendaLangit)  waktu=MekanikaBendaLangit.ashar(this);
         else if (irsyadulMurid)        waktu=IrsyadulMurid.asar(this);
         else if (anwarulKawakib)       waktu=AnwarulKawakib.asar(this);
         else                           waktu = MakalahKemenag.ashar(this);
         return waktu;

    }

    public double getMaghrib() {
         double waktu=0;
         if (makalahDepag)              waktu = MakalahKemenag.maghrib(this);
         else if (mekanikaBendaLangit)  waktu=MekanikaBendaLangit.maghrib(this);
         else if (irsyadulMurid)        waktu=IrsyadulMurid.maghrib(this);
         else if (anwarulKawakib)       waktu=AnwarulKawakib.maghrib(this);
         else                           waktu = MakalahKemenag.maghrib(this);
         return waktu;

    }

    public double getIsya() {
         double waktu=0;
         if (makalahDepag)              waktu = MakalahKemenag.isya(this);
         else if (mekanikaBendaLangit)  waktu=MekanikaBendaLangit.isya(this);
         else if (irsyadulMurid)        waktu=IrsyadulMurid.isya(this);
         else if (anwarulKawakib)       waktu=AnwarulKawakib.isya(this);
         else                           waktu = MakalahKemenag.isya(this);
         return waktu;

    }

















    /**
     * bila method ini tidak di-set maka secara otomatis akan memeilih metode hisab default yaitu metode makalah Kemenag.
     */
    public MetodeHisab setMetodeHisab(){ //Methods
        return new MetodeHisab();
    }

    public class MetodeHisab { //class in a class
        public void makalahKemenag(){
            makalahDepag=true;
            mekanikaBendaLangit=false;
            irsyadulMurid=false;
            anwarulKawakib =false;
        }
        public void  mekanikaBendaLangit(){
            makalahDepag=false;
            mekanikaBendaLangit=true;
            irsyadulMurid=false;
            anwarulKawakib =false;
        }

        public void irsyadulMurid(){
            makalahDepag=false;
            mekanikaBendaLangit=false;
            irsyadulMurid=true;
            anwarulKawakib =false;
        }
        public void  anwarulKawakib(){
            makalahDepag=false;
            mekanikaBendaLangit=false;
            irsyadulMurid=false;
            anwarulKawakib =true;
        }
    }





}
