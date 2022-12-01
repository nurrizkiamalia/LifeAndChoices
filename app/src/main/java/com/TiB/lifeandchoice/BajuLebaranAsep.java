package com.TiB.lifeandchoice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class BajuLebaranAsep extends AppCompatActivity {

    Button pil1,pil2,pil3,kluar;
    ImageView gmbr1,gmbr2;
    TextView lur;
    ConstraintLayout bg;
    FirebaseAuth fAuth;

    int poin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story2);
        pil1 = findViewById(R.id.pilihan1);
        pil2 = findViewById(R.id.pilihan2);
        pil3 = findViewById(R.id.pilihan3);
        lur = findViewById(R.id.alur);
        kluar = findViewById(R.id.keluar1);
        bg = findViewById(R.id.background);

        gmbr1 = findViewById(R.id.gambar1);
        gmbr2 = findViewById(R.id.gambar2);

        terbangun();

        kluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder keluar = new AlertDialog.Builder(v.getContext());
                keluar.setTitle("Keluar");
                keluar.setMessage("Apa anda yakin ingin keluar dari cerita?");

                keluar.setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(BajuLebaranAsep.this,"Anda keluar dari cerita",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        finish();
                    }
                });
                keluar.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                keluar.create().show();
            }
        });
    }

    public void terbangun(){
        poin = 0;
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.INVISIBLE);
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        lur.setText("Minggu pagi pada bulan puasa, suasana terasa asri dan sejuk. Budi yang masih berada dikamarnya terbangun sejenak dan duduk dipinggir kasurnya, " +
                " sambil mengumpulkan nyawa. Sesaat nyawanya telah terkumpul, Budi pun membuka hpnya, lalu berpikir sejenak. 'Hmmmm Aku ada janji sama Asep jam 1 nanti'. " +
                "Karena jam 1 masih sangat lama, Budi memutuskan untuk... ");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.tempattidur2);

        pil1.setHint("Tidur lagi, kelamaan");
        pil1.getHint().toString();
        pil2.setHint("Mandi pagi biar segar");
        pil2.getHint().toString();

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=3;
                terlewat();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                mandipagi();
            }
        });
    }

    public void mandipagi(){
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        pil3.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        lur.setText("Dingin air membuat sisa-sisa nyawa Budi saat tidur terkumpul semuanya. 'SEGARRRR!', celoteh Budi. " +
                "Selesai mandi, ia bergegas melakukan rutinitasnya. " +
                "Jam 1 sebentar lagi, Budi pun berpikir cara untuk membunuh waktu sebelum ke rumah asep... ");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.tempattidur2);
        gmbr1.setImageResource(R.drawable.budi2);

        pil1.setHint("Bermain video game di ponselnya");
        pil1.getHint().toString();
        pil2.setHint("Lanjut tidur agar waktu cepat berlalu");
        pil2.getHint().toString();
        pil3.setHint("Telponan dengan pacarnya");
        pil3.getHint().toString();

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=3;
                kerumahasep();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=3;
                terlewat();
            }
        });
        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=0;
                ketemupacar();
            }
        });
    }

    public void kerumahasep(){
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.INVISIBLE);
        pil2.setVisibility(View.INVISIBLE);
        pil3.setVisibility(View.INVISIBLE);
        lur.setText("Saat jam 1 kurang Budi bergegas untuk ke rumah Asep agar ia tidak telat. " +
                " Sesampainya di rumah Asep, Asep yang memang sudah menunggu Budi langsung " +
                " menaiki motor, Budi pun langsung tancap gas.");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.rumah2);
        gmbr1.setImageResource(R.drawable.asep);
        gmbr2.setImageResource(R.drawable.budi2);

        lur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perjalanankemall();
            }
        });
    }

    public void terlewat(){
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);
        lur.setText("Karena tidur terlalu lelap, Budi malah terbangun jam 3 sore. " +
                "'WADUH, UDAH JAM 3?! WALAH GIMANA INI JANJIKU NEMENIN ASEP?!'. Budi dengan cepat berganti baju, mengambil kunci motor,  " +
                "dan bergegas ke rumah asep. Sesampainya di rumah asep...");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.rumah2);

        pil1.setHint("Meminta maaf karena tidak tepat waktu");
        pil1.getHint().toString();
        pil2.setHint("Terus-terusan klakson hingga Asep naik ke motor");
        pil2.getHint().toString();
        pil3.setHint("Membatalkan janjinya");
        pil3.getHint().toString();

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=3;
                perjalanankemall();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=1;
                perjalanankemall();
            }
        });
        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=5;
                ending();
            }
        });
    }

    public void perjalanankemall(){
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        pil3.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        lur.setText("Siang itu cuaca sangat terik, saat diperjalanan mereka berdua tak henti mengeluh kepanasan, Budi dan Asep ingin sekali membela es untuk melepas dahaga. " +
                "Padahal ini sedang puasa. Budi berpikir sejenak... ");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.jalanrayasiang);
        gmbr1.setImageResource(R.drawable.budi);

        pil1.setHint("Berteduh dan minum es campur");
        pil1.getHint().toString();
        pil2.setHint("Pergi ke mall untuk tanpa beli es");
        pil2.getHint().toString();
        pil3.setHint("Pergi ke mall dan berniat mencari makanan dan minuman");
        pil3.getHint().toString();

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=3;
                belies();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                masukmall();
            }
        });
        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=3;
                masukmall();
            }
        });
    }

    public void belies(){
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        lur.setText("Budi melihat penjual seorang kakek dan cucunya yang sedang berjualan es, lalu Budi mengasut Asep untuk...");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.tukanges);
        gmbr1.setImageResource(R.drawable.budi);
        gmbr2.setImageResource(R.drawable.asep2);

        pil1.setHint("Beli es untuk diminum saat buka puasa");
        pil1.getHint().toString();
        pil2.setHint("Beli dan langsung meminum es ditempat");
        pil2.getHint().toString();
        pil3.setHint("Minum sedikit untuk menghilangkan haus dan dahaga");
        pil3.getHint().toString();

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                masukmall();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=5;
                masukmall();
            }
        });
        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=3;
                masukmall();
            }
        });
    }

    public void masukmall(){
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.INVISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        lur.setText("Sesampainya di mall, budi merasa sangat kelaparan, ia memutuskan untuk... ");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.luarmall);
        gmbr1.setImageResource(R.drawable.budi2);
        gmbr2.setImageResource(R.drawable.asep);

        pil1.setHint("Langsung ke toko pakaian");
        pil1.getHint().toString();
        pil2.setHint("Mengajak Asep untuk makan bakso Ynos baru mencari pakaian");
        pil2.getHint().toString();

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                tokopakaian();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=5;
                tokopakaian();
            }
        });
    }

    public void tokopakaian(){
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        pil3.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        lur.setText("Asep memilih-milih pakaian mana yang ia inginkan, Budi hanya mengitari toko sambil melihat-lihat saja. " +
                "Mata Budi menangkap tangan seorang lelaki pencuri yang dengan cepat menyembunyikan beberapa baju ke tasnya. " +
                "Budi yang melihat hal tersebut pun mengambil tindakan...");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.tokobaju);

        pil1.setHint("Mengadukan apa yang dia lihat pada satpam");
        pil1.getHint().toString();
        pil2.setHint("Berpura-pura tidak melihat");
        pil2.getHint().toString();
        pil3.setHint("Memberikan semangat pada pencuri");
        pil3.getHint().toString();

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                selesaibelanja();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=5;
                pulangkerumah();
            }
        });
        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=5;
                pulangkerumah();
            }
        });
    }

    public void selesaibelanja(){
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        pil3.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        lur.setText("Pak satpam pun langsung berlari dan menangkap pencuri tersebut. " +
                "Pencuri tersebut terlihat ampun-ampunan, Pak satpam mengacungkan jempol kepada Budi. " +
                "Pemilik toko juga ikut berterimakasih pada Budi, lalu...");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.mall2);
        gmbr1.setImageResource(R.drawable.budi2);

        pil1.setHint("Budi meminta diskon pada pemilik toko");
        pil1.getHint().toString();
        pil2.setHint("Budi meminta baju yang diambil pencuri pada pemilik toko");
        pil2.getHint().toString();
        pil3.setHint("Budi membantu dengan ikhlas");
        pil3.getHint().toString();

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=0;
                pulangkerumah();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=3;
                pulangkerumah();
            }
        });
        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                pulangkerumah();
            }
        });
    }

    public void pulangkerumah(){
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        lur.setText("Setelah mencari pakaian yang Asep inginkan, akhirnya Budi mengantarkan Asep ke rumahnya. " +
                "Ibu Asep yang melihat Asep dan Budi terlihat sangat bugar seperti tidak puasa, merasa curiga... ");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.rumah2);
        gmbr1.setImageResource(R.drawable.asep2);
        gmbr1.setImageResource(R.drawable.ibu);

        pil1.setHint("Berkata jujur pada Ibu Asep");
        pil1.getHint().toString();
        pil2.setHint("Mengatakan kebohongan");
        pil2.getHint().toString();
        pil3.setHint("Tak berkata apa-apa");
        pil3.getHint().toString();

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=2;
                ending();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=5;
                ending();
            }
        });
        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=0;
                ending();
            }
        });
    }

    //ENDING GAGAL KARENA PACAR
    public void ketemupacar(){
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        lur.setText("Budi berbincang banyak dengan pacarnya, Hingga pacarnya meminta Budi untuk datang ke rumahnya. " +
                "Budi sedikit bimbang, namun memutuskan untuk...");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.rumah3);
        gmbr2.setImageResource(R.drawable.budi);

        pil1.setHint("Pergi Ke rumah pacarnya");
        pil1.getHint().toString();
        pil2.setHint("Menolak dan bilang Budi telah memiliki janji");
        pil2.getHint().toString();
        pil3.setHint("Menolak tanpa alasan");
        pil3.getHint().toString();
        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=5;
                keasikanpacaran();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                kerumahasep();
            }
        });
        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=2;
                kerumahasep();
            }
        });
    }

    public void keasikanpacaran(){
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.INVISIBLE);
        lur.setText("Budi pergi ke rumah pacarnya dan tanpa sadar ia melewatkan janjinya untuk menemani temannya, Asep. ");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.rumah3);
        gmbr2.setImageResource(R.drawable.budi);
        gmbr2.setImageResource(R.drawable.julia1);

        pil1.setHint("Budi menghubungi Asep dan meminta maaf");
        pil1.getHint().toString();
        pil2.setHint("Budi tidak peduli");
        pil2.getHint().toString();
        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=0;
                ending();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=5;
                gagalnemenin();
            }
        });
    }

    public void gagalnemenin(){
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        String hasil = "Kamu gagal nemenin Asep karena kamu lebih memilih bersama pacarmu. Asep merasa kesal karena kamu ingkar janji, lalu memblokir kontakmu.";
        lur.setText("ENDING YANG KAMU DAPATKAN \n\n"+hasil);

        pil1.setHint("Coba Lagi?");
        pil2.setHint("Keluar?");
        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                terbangun();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keluar(v);
            }
        });
    }
    //ENDING GAGAL KARENA PACAR


    //ENDINGS
    public void ending(){
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        pil3.setVisibility(View.INVISIBLE);
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        String hasil;
        if (poin >=10){
            hasil = " Kamu berhasil menemani Asep untuk membeli baju lebaran, Asep pun berterimakasih ada teman baik sepertimu! ";
        }else if(poin >= 0 && poin < 10){
            hasil = " Kamu bisa jadi teman yang lebih baik dari ini. ";
        }
        else{
            hasil = " Kamu bukan teman yang baik untuk Asep, Asep akhirnya menjauhimu. ";
        }

        lur.setText("ENDING YANG KAMU DAPATKAN \n\n"+hasil);
        pil1.setVisibility(View.VISIBLE);
        pil1.setHint("Coba Lagi?");
        pil2.setVisibility(View.VISIBLE);
        pil2.setHint("Keluar?");

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                terbangun();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keluar(v);
            }
        });
    }

    public void keluar(View v){
        final AlertDialog.Builder keluar = new AlertDialog.Builder(v.getContext());
        keluar.setTitle("Keluar");
        keluar.setMessage("Apa anda yakin ingin keluar dari cerita?");

        keluar.setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(BajuLebaranAsep.this,"Anda keluar dari cerita",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Home.class));
                finish();
            }
        });
        keluar.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        keluar.create().show();
    }
}