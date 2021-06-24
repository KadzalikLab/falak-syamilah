package com.falak;

public class Konversi {

    //Fungsi pengubah tanggal ke julian day
    //parameter yang harus diisi: tahun, bulan, tanggal, jam, menit, detik
    public static double masehiKeJd(double tanggal, double bulan, double tahun, double jamDes) {

        if (bulan <= 2) {
            bulan += 12;
            tahun -= 1;
        }
        //bila bulan januari atau februari maka dianggap bulan ke 13/14 tahun sebelunmya

        //bila periode Julian
        //A dan B = 0
        int A;
        int B = 0;

        //bila masuk periode Gregorian
        if ((tahun + bulan / 100 + tanggal / 10000) >= 1582.1015) {
            A = (int) (tahun / 100);
            B = 2 + (A / 4) - A;

        }

        double julian_day = 1720994.5 + (int) (365.25 * tahun) + (int) (30.60001 * (bulan + 1)) + tanggal + B + jamDes / 24;

        return julian_day;

    }

    //Fungsi pengubah  julian day  ke tanggal dan pukul
    //parameter yang harus diisi: julian day
    public static int[] jdKeMasehi(double julian_day) {

        double jd1 = julian_day + 0.5;
        int Z = (int) jd1;
        double F = jd1 - Z;
        double A;
        int AA;
        if (Z < 2299161) A = Z;
        else {
            AA = (int) ((Z - 1867216.25) / 36524.25);
            A = Z + 1 + AA - (int) (AA / 4);
        }
        double B = A + 1524;
        int C = (int) ((B - 122.1) / 365.25);
        int D = (int) (365.25 * C);
        int E = (int) ((B - D) / 30.60001);

        double tanggal = (B - D - (int) (30.6001 * E) + F);
        int bulan;
        if (E == 14 || E == 15) bulan = E - 13;
        else bulan = E - 1;
        int tahun;
        if (bulan <= 2) tahun = C - 4715;
        else tahun = C - 4716;

        //pecahan hari / pukul
        double pecahan_hari = tanggal - (int) tanggal;
        int jam = (int) (24 * pecahan_hari);
        int menit = (int) (60 * (pecahan_hari * 24 - jam));
        double detik = 86400 * pecahan_hari - 3600 * jam - 60 * menit;

        int nomor_hari = (int) ((julian_day + 1.5) % 7 + 1);
        int nomor_pasaran = (int) ((julian_day + 1.5) % 5);

        return new int[]{0, (int) tanggal, bulan, tahun, jam, menit, (int) detik, nomor_hari, nomor_pasaran};


        //Daftar kembalian/return dalam bentuk Array yang berupa:
        //1:Tanggal
        //2:Bulan
        //3:Tahun
        //4:Jam
        //5:Menit
        //6:Detik
        //7:Nomor hari
        //8:Nomor Pasaran

    }

    public static double jdPukul(double julian_day) {

        double jd1 = julian_day + 0.5;
        int Z = (int) jd1;
        double F = jd1 - Z;
        double A;
        int AA;
        if (Z < 2299161) A = Z;
        else {
            AA = (int) ((Z - 1867216.25) / 36524.25);
            A = Z + 1 + AA - (int) (AA / 4);
        }
        double B = A + 1524;
        int C = (int) ((B - 122.1) / 365.25);
        int D = (int) (365.25 * C);
        int E = (int) ((B - D) / 30.60001);

        double tanggal = (B - D - (int) (30.6001 * E) + F);
        //pecahan hari / pukul
        double pecahan_hari = tanggal - (int) tanggal;
        return (24 * pecahan_hari);


    }

    //Fungsi pengubah Masehi ke Hijri
    //parameter yang harus diisi: tahun, bulan, tanggal
    public static int[] masehiKeHijri(double tanggal, double bulan, double tahun) {

        //tanggal diatas dijadikan julian day dulu melalui fungsi Konversi
        double julian_day = Konversi.masehiKeJd(tanggal, bulan, tahun, 0);

        double selisih_hari = julian_day - 1948438.5; //selisih hari tanggal masehi dengan epoch/tahun nol kalender hijri
        int siklus = (int) ((selisih_hari - 1) / 10631);//kelipatan 30 tahun atau berapakah siklus kabisat yang terjadi selama "selisih hari"
        if (selisih_hari < 0) siklus = (int) Math.floor((selisih_hari - 1) / 10631);
        int tahun_siklus = siklus * 30;//jumlah siklus dijadikan tahun
        double sisahari1 = (selisih_hari - (siklus * 10631));//  total selisih hari yang masih sisa setelah sebelumya dijadikan satuan siklus


        //rentang hari (satuan hari dari "sisahari1" dijadikan satuan tahun dan masih berapa sisa hari)
        int tambahan_tahun = 0;
        int sisahari2 = 0;//ini nilai hari
        if (sisahari1 >= 1 && sisahari1 <= 354) {
            tambahan_tahun = 1;
            sisahari2 = (int) (sisahari1);
        } else if (sisahari1 >= 355 && sisahari1 <= 709) {
            tambahan_tahun = 2;
            sisahari2 = (int) (sisahari1 - 354);
        } else if (sisahari1 >= 710 && sisahari1 <= 1063) {
            tambahan_tahun = 3;
            sisahari2 = (int) (sisahari1 - 709);
        } else if (sisahari1 >= 1064 && sisahari1 <= 1417) {
            tambahan_tahun = 4;
            sisahari2 = (int) (sisahari1 - 1063);
        } else if (sisahari1 >= 1418 && sisahari1 <= 1772) {
            tambahan_tahun = 5;
            sisahari2 = (int) (sisahari1 - 1417);
        } else if (sisahari1 >= 1772 && sisahari1 <= 2126) {
            tambahan_tahun = 6;
            sisahari2 = (int) (sisahari1 - 1772);
        } else if (sisahari1 >= 2127 && sisahari1 <= 2481) {
            tambahan_tahun = 7;
            sisahari2 = (int) (sisahari1 - 2126);
        } else if (sisahari1 >= 2482 && sisahari1 <= 2835) {
            tambahan_tahun = 8;
            sisahari2 = (int) (sisahari1 - 2481);
        } else if (sisahari1 >= 2836 && sisahari1 <= 3189) {
            tambahan_tahun = 9;
            sisahari2 = (int) (sisahari1 - 2835);
        } else if (sisahari1 >= 3190 && sisahari1 <= 3544) {
            tambahan_tahun = 10;
            sisahari2 = (int) (sisahari1 - 3189);
        } else if (sisahari1 >= 3545 && sisahari1 <= 3898) {
            tambahan_tahun = 11;
            sisahari2 = (int) (sisahari1 - 3544);
        } else if (sisahari1 >= 3899 && sisahari1 <= 4252) {
            tambahan_tahun = 12;
            sisahari2 = (int) (sisahari1 - 3898);
        } else if (sisahari1 >= 4253 && sisahari1 <= 4607) {
            tambahan_tahun = 13;
            sisahari2 = (int) (sisahari1 - 4252);
        } else if (sisahari1 >= 4608 && sisahari1 <= 4961) {
            tambahan_tahun = 14;
            sisahari2 = (int) (sisahari1 - 4607);
        } else if (sisahari1 >= 4962 && sisahari1 <= 5315) {
            tambahan_tahun = 15;
            sisahari2 = (int) (sisahari1 - 4691);
        } else if (sisahari1 >= 5316 && sisahari1 <= 5670) {
            tambahan_tahun = 16;
            sisahari2 = (int) (sisahari1 - 5315);
        } else if (sisahari1 >= 5671 && sisahari1 <= 6024) {
            tambahan_tahun = 17;
            sisahari2 = (int) (sisahari1 - 5670);
        } else if (sisahari1 >= 6025 && sisahari1 <= 6379) {
            tambahan_tahun = 18;
            sisahari2 = (int) (sisahari1 - 6024);
        } else if (sisahari1 >= 6380 && sisahari1 <= 6733) {
            tambahan_tahun = 19;
            sisahari2 = (int) (sisahari1 - 6379);
        } else if (sisahari1 >= 6734 && sisahari1 <= 7087) {
            tambahan_tahun = 20;
            sisahari2 = (int) (sisahari1 - 6733);
        } else if (sisahari1 >= 7088 && sisahari1 <= 7442) {
            tambahan_tahun = 21;
            sisahari2 = (int) (sisahari1 - 7087);
        } else if (sisahari1 >= 7443 && sisahari1 <= 7796) {
            tambahan_tahun = 22;
            sisahari2 = (int) (sisahari1 - 7445);
        } else if (sisahari1 >= 7797 && sisahari1 <= 8150) {
            tambahan_tahun = 23;
            sisahari2 = (int) (sisahari1 - 7796);
        } else if (sisahari1 >= 8150 && sisahari1 <= 8505) {
            tambahan_tahun = 24;
            sisahari2 = (int) (sisahari1 - 8150);
        } else if (sisahari1 >= 8506 && sisahari1 <= 8859) {
            tambahan_tahun = 25;
            sisahari2 = (int) (sisahari1 - 8505);
        } else if (sisahari1 >= 8860 && sisahari1 <= 9214) {
            tambahan_tahun = 26;
            sisahari2 = (int) (sisahari1 - 8859);
        } else if (sisahari1 >= 9215 && sisahari1 <= 9568) {
            tambahan_tahun = 27;
            sisahari2 = (int) (sisahari1 - 9214);
        } else if (sisahari1 >= 9569 && sisahari1 <= 9922) {
            tambahan_tahun = 28;
            sisahari2 = (int) (sisahari1 - 9568);
        } else if (sisahari1 >= 9923 && sisahari1 <= 10277) {
            tambahan_tahun = 29;
            sisahari2 = (int) (sisahari1 - 9922);
        } else if (sisahari1 >= 10277 && sisahari1 <= 10631) {
            tambahan_tahun = 30;
            sisahari2 = (int) (sisahari1 - 10277);
        }

        int bulan_utuh_tamm;// proses menjadikan satuan hari ke satuan bulan
        if (sisahari2 == 355) bulan_utuh_tamm = 11;
        else bulan_utuh_tamm = (int) ((sisahari2 - 1) / 29.5);

        double jumlah_hari_bulan_tamm;// jumlah hari yang terdapat pada bulan sebelumnya
        if ((bulan_utuh_tamm % 2) == 0) jumlah_hari_bulan_tamm = 29.5 * bulan_utuh_tamm;
        else jumlah_hari_bulan_tamm = 29.5 * (bulan_utuh_tamm - 1) + 30;

        int tanggal_hijri = (int) (sisahari2 - jumlah_hari_bulan_tamm);//tnggal diambil dari jumlah total hari yang tersisa diambil umur bulan sebelumnya
        int bulan_hijri = bulan_utuh_tamm + 1;// ditambah satu karna masih berupa bulan yang telah berlalu, bukan yang sedang dijalani
        int tahun_hijri = tahun_siklus + tambahan_tahun;


        return new int[]{0, tanggal_hijri, bulan_hijri, tahun_hijri};
    }


    //Fungsi pengubah Masehi ke Hijri
    //parameter yang harus diisi: tahun, bulan, tanggal
    public static int[] hijriKeMasehi(double tahun, double bulan, double tanggal) {

        int siklus = (int) ((tahun - 1) / 30);//berapa siklus kabisat yang terjadi selama "tahun" diatas
        int sisa_siklus = (int) (tahun - (siklus * 30));//sisa siklus yang berupa tahun
        double banyaknya_hari = 30 * (bulan - 1) - (int) ((bulan - 1) / 2) + tanggal;// umur hari dihitung sejak 1 Muharram sampai bulan yang dicari. 1 Muharram juga ikut dihitung

        int jumlah_hari = 0;//total hari yang terjadi dari epoch kalender hijri sampai ke tanggal yang dicari
        if (sisa_siklus <= 2) jumlah_hari = 354 * (sisa_siklus - 1);
        else if (sisa_siklus > 2 && sisa_siklus <= 5) jumlah_hari = 354 * (sisa_siklus - 1) + 1;
        else if (sisa_siklus > 5 && sisa_siklus <= 7) jumlah_hari = 354 * (sisa_siklus - 1) + 2;
        else if (sisa_siklus > 7 && sisa_siklus <= 10) jumlah_hari = 354 * (sisa_siklus - 1) + 3;
        else if (sisa_siklus > 10 && sisa_siklus <= 13) jumlah_hari = 354 * (sisa_siklus - 1) + 4;
        else if (sisa_siklus > 13 && sisa_siklus <= 16) jumlah_hari = 354 * (sisa_siklus - 1) + 5;
        else if (sisa_siklus > 16 && sisa_siklus <= 18) jumlah_hari = 354 * (sisa_siklus - 1) + 6;
        else if (sisa_siklus > 18 && sisa_siklus <= 21) jumlah_hari = 354 * (sisa_siklus - 1) + 7;
        else if (sisa_siklus > 21 && sisa_siklus <= 24) jumlah_hari = 354 * (sisa_siklus - 1) + 8;
        else if (sisa_siklus > 24 && sisa_siklus <= 26) jumlah_hari = 354 * (sisa_siklus - 1) + 9;
        else if (sisa_siklus > 26 && sisa_siklus <= 29) jumlah_hari = 354 * (sisa_siklus - 1) + 10;
        else if (sisa_siklus == 30) jumlah_hari = 354 * (sisa_siklus - 1) + 11;

        double total_hari = siklus * 10631 + jumlah_hari + banyaknya_hari;
        double julian_day = 1948438.5 + total_hari;
        //nomor hari / hari ke
        double Z = julian_day + 0.5;

        int AA = (int) ((Z - 1867216.25) / 36524.25);
        int A;
        if (Z < 2299161) A = (int) Z;
        else A = (int) (Z + 1 + AA - (AA / 4));

        int B = A + 1524;
        int C = (int) ((B - 122.1) / 365.25);
        int D = (int) (365.25 * C);
        int E = (int) ((B - D) / 30.6001);
        int tanggal_masehi = B - D - (int) (30.6001 * E);
        int bulan_masehi;
        if (E < 14) bulan_masehi = E - 1;
        else bulan_masehi = E - 13;
        int tahun_masehi;
        if (bulan_masehi > 2) tahun_masehi = C - 4716;
        else tahun_masehi = C - 4715;

        return new int[]{0, tanggal_masehi, bulan_masehi, tahun_masehi};

    }


    public static double dmsKeDesimal(double derajat, double menit, double detik) {
        if (derajat < 0 || menit < 0 || detik < 0)
            return derajat - (Math.abs(menit) / 60) - (Math.abs(detik) / 3600);//Bila salah satu nilainya negatif
        else return derajat + (menit / 60) + (detik / 3600);
    }

    public static int[] desimalKeDms(double desimal) {

        //cek nilai negatif atau bukan
        boolean negatif = false;
        if (desimal < 0) negatif = true;

        //ini menghitungnya mengabaikan nilai negatif
        desimal = Math.abs(desimal);
        int derajat = (int) desimal;
        double menit = (desimal % 1) * 60;
        double detik = Math.round((menit % 1) * 60);
        //ini pembulatan
        if ((int) detik > 59) {
            detik -= 60;
            menit += 1;
        }
        if ((int) menit > 59) {
            menit -= 60;
            derajat += 1;
        }


        //bila negatif
        if (negatif) {
            if (derajat == 0) {
                if ((int) menit == 0) return new int[]{0, -derajat, -(int) menit, (int) -detik};
                else return new int[]{0, -derajat, -(int) menit, (int) detik};
            } else return new int[]{0, -derajat, (int) menit, (int) detik};
        }

        //bila positif
        else return new int[]{0, derajat, (int) menit, (int) detik};
    }

    public static double[] desimalKeDmsMili(double desimal) {

        desimal = Math.abs(desimal);
        int derajat = (int) (desimal);
        // set desimal value here
        double menit = (int) ((desimal - derajat) * 60);
        double detik = (desimal - derajat - menit / 60) * 3600.00;
        double milidetik = (detik - Math.floor(detik)) * 10.0;

        if (detik > 59.99) {
            detik = 0;
            menit += 1;
        }
        if ((int) menit > 59) {
            menit = 0;
            derajat += 1;
        }


        return new double[]{0, derajat, menit, detik, milidetik};
    }

    public static String dms(double desimal) {

        return Konversi.desimalKeDms(desimal)[1] + "\u00B0" + Konversi.desimalKeDms(desimal)[2] + "\u2032" + Konversi.desimalKeDms(desimal)[3] + "\u2033";
    }

    public static String hms(double desimal) {
        return Konversi.desimalKeDms(desimal)[1] + ":" + Konversi.desimalKeDms(desimal)[2] + ":" + Konversi.desimalKeDms(desimal)[3];
    }


    public static String hmsMili(double desimal) {
        if (desimal < 0)
            return "-" + (int) Konversi.desimalKeDmsMili(desimal)[1] + ":" + (int) Konversi.desimalKeDmsMili(desimal)[2] + ":" + String.format("%.2f", Konversi.desimalKeDmsMili(desimal)[3]);
        else
            return (int) Konversi.desimalKeDmsMili(desimal)[1] + ":" + (int) Konversi.desimalKeDmsMili(desimal)[2] + ":" + String.format("%.2f", Konversi.desimalKeDmsMili(desimal)[3]);
    }

    //test
    public static String dmsMili(double desimal) {

        if (desimal < 0)
            return "-" + (int) Konversi.desimalKeDmsMili(desimal)[1] + "\u00B0" + (int) Konversi.desimalKeDmsMili(desimal)[2] + "\u2032" + String.format("%.2f", Konversi.desimalKeDmsMili(desimal)[3]) + "\u2033";
        else
            return (int) Konversi.desimalKeDmsMili(desimal)[1] + "\u00B0" + (int) Konversi.desimalKeDmsMili(desimal)[2] + "\u2032" + String.format("%.2f", Konversi.desimalKeDmsMili(desimal)[3]) + "\u2033";
    }
    public static String dmsMili(double desimal,int digit) {

        if (desimal < 0)
            return "-" + (int) Konversi.desimalKeDmsMili(desimal)[1] + "\u00B0" + (int) Konversi.desimalKeDmsMili(desimal)[2] + "\u2032" + String.format("%."+digit+"f", Konversi.desimalKeDmsMili(desimal)[3]) + "\u2033";
        else
            return (int) Konversi.desimalKeDmsMili(desimal)[1] + "\u00B0" + (int) Konversi.desimalKeDmsMili(desimal)[2] + "\u2032" + String.format("%."+digit+"f", Konversi.desimalKeDmsMili(desimal)[3]) + "\u2033";
    }


    public static String ddd_ppp_DDMMMYYYY_hhmmss(double jd) {
        int tanggal = Konversi.jdKeMasehi(jd)[1];
        int bulan = Konversi.jdKeMasehi(jd)[2];
        int tahun = Konversi.jdKeMasehi(jd)[3];
        double jam_des = Konversi.jdPukul(jd);
        int nomor_hari = Konversi.jdKeMasehi(jd)[7];
        int nomor_pasaran = Konversi.jdKeMasehi(jd)[8];
        return Konversi.namahari(nomor_hari) + " " + Konversi.namapasaran(nomor_pasaran) + ", " + tanggal + " " + Konversi.namaBulanMasehi(bulan) + " " + tahun + " | " + Konversi.hmsMili(jam_des);
    }
    public static String jdTo_DDMMMYYYY(double jd) {
        int tanggal = Konversi.jdKeMasehi(jd)[1];
        int bulan = Konversi.jdKeMasehi(jd)[2];
        int tahun = Konversi.jdKeMasehi(jd)[3];
        return tanggal + " " + Konversi.namaBulanMasehi(bulan) + " " + tahun;
    }

    public static String jdTo_hhmmss(double jd) {
        double jam_des = Konversi.jdPukul(jd);
        return Konversi.hmsMili(jam_des);
    }


    public static String ddd_ppp(double jd) {
        int nomor_hari = Konversi.jdKeMasehi(jd)[7];
        int nomor_pasaran = Konversi.jdKeMasehi(jd)[8];
        return Konversi.namahari(nomor_hari) + " " + Konversi.namapasaran(nomor_pasaran);
    }

    public static String DDMMMYYYY_hhmmss(double jd) {
        int tanggal = Konversi.jdKeMasehi(jd)[1];
        int bulan = Konversi.jdKeMasehi(jd)[2];
        int tahun = Konversi.jdKeMasehi(jd)[3];
        double jam_des = Konversi.jdPukul(jd);
        return tanggal + " " + Konversi.namaBulanMasehi(bulan) + " " + tahun + " | " + Konversi.hmsMili(jam_des);
    }

    public static String ddd_ppp_DDMMMYYYY(double jd) {
        int tanggal = Konversi.jdKeMasehi(jd)[1];
        int bulan = Konversi.jdKeMasehi(jd)[2];
        int tahun = Konversi.jdKeMasehi(jd)[3];
        int nomor_hari = Konversi.jdKeMasehi(jd)[7];
        int nomor_pasaran = Konversi.jdKeMasehi(jd)[8];
        return Konversi.namahari(nomor_hari) + " " + Konversi.namapasaran(nomor_pasaran) + ", " + tanggal + " " + Konversi.namaBulanMasehi(bulan) + " " + tahun;
    }


    public static String ddd_DDMMMYYYY(double jd) {
        int tanggal = Konversi.jdKeMasehi(jd)[1];
        int bulan = Konversi.jdKeMasehi(jd)[2];
        int tahun = Konversi.jdKeMasehi(jd)[3];
        double jam_des = Konversi.jdPukul(jd);
        int nomor_hari = Konversi.jdKeMasehi(jd)[7];
        return Konversi.namahari(nomor_hari) + ", " + tanggal + " " + Konversi.namaBulanMasehi(bulan) + " " + tahun + " | " + Konversi.hmsMili(jam_des);
    }


    public static String namahari(int nomor_hari) {

        String namahari = "";

        switch (nomor_hari) {
            case 1:
                namahari = "Ahad";
                break;
            case 2:
                namahari = "Senin";
                break;
            case 3:
                namahari = "Selasa";
                break;
            case 4:
                namahari = "Rabu";
                break;
            case 5:
                namahari = "Kamis";
                break;
            case 6:
                namahari = "Jum´at";
                break;
            case 7:
            case 0:
                namahari = "Sabtu";
                break;
        }


        return namahari;


    }


    public static String namapasaran(int nomor_pasaran) {

        String namapasaran = "";

        switch (nomor_pasaran) {
            case 1:
                namapasaran = "Legi";
                break;
            case 2:
                namapasaran = "Pahing";
                break;
            case 3:
                namapasaran = "Pon";
                break;
            case 4:
                namapasaran = "Wage";
                break;
            case 5:
            case 0:
                namapasaran = "Kliwon";
                break;
        }


        return namapasaran;


    }

    public static String namaBulanHijri(int nomor_bulan) {

        String namabulan = "";

        switch (nomor_bulan) {
            case 1:
                namabulan = "Muharram";
                break;
            case 2:
                namabulan = "Safar";
                break;
            case 3:
                namabulan = "Rabiul Awal";
                break;
            case 4:
                namabulan = "Rabiu Tsani";
                break;
            case 5:
                namabulan = "Jumadil Awal";
                break;
            case 6:
                namabulan = "Jumadil Akhir";
                break;
            case 7:
                namabulan = "Rajab";
                break;
            case 8:
                namabulan = "Sya'ban";
                break;
            case 9:
                namabulan = "Ramadhan";
                break;
            case 10:
                namabulan = "Syawal";
                break;
            case 11:
                namabulan = "Dzulqo'dah";
                break;
            case 12:
            case 0:
                namabulan = "Dzulhijjah";
                break;
        }


        return namabulan;


    }

    public static String namaBulanMasehi(int nomor_bulan) {

        String namabulan = "";

        switch (nomor_bulan) {
            case 1:
                namabulan = "Januari";
                break;
            case 2:
                namabulan = "Februari";
                break;
            case 3:
                namabulan = "Maret";
                break;
            case 4:
                namabulan = "April";
                break;
            case 5:
                namabulan = "Mei";
                break;
            case 6:
                namabulan = "Juni";
                break;
            case 7:
                namabulan = "Juli";
                break;
            case 8:
                namabulan = "Agustus";
                break;
            case 9:
                namabulan = "September";
                break;
            case 10:
                namabulan = "Oktober";
                break;
            case 11:
                namabulan = "November";
                break;
            case 12:
            case 0:
                namabulan = "Desember";
                break;
        }


        return namabulan;


    }


}
