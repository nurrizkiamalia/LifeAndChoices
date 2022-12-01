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

public class malihdandompet extends AppCompatActivity {

    Button pil1,pil2,pil3,kluar;
    ImageView gmbr1,gmbr2;
    TextView lur;
    ConstraintLayout bg;
    FirebaseAuth fAuth;

    int poin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        malihdandompet s = new malihdandompet();
        pil1 = findViewById(R.id.pilihan1);
        pil2 = findViewById(R.id.pilihan2);
        pil3 = findViewById(R.id.pilihan3);
        lur = findViewById(R.id.alur);
        kluar = findViewById(R.id.keluar1);
        bg = findViewById(R.id.background);

        gmbr1 = findViewById(R.id.gambar1);
        gmbr2 = findViewById(R.id.gambar2);

        intermezzo1();

        kluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder keluar = new AlertDialog.Builder(v.getContext());
                keluar.setTitle("Keluar");
                keluar.setMessage("Apa anda yakin ingin keluar dari cerita?");

                keluar.setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(malihdandompet.this,"Anda keluar dari cerita",Toast.LENGTH_SHORT).show();
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

    public void intermezzo1(){
        pil1.setVisibility(View.INVISIBLE);
        pil2.setVisibility(View.INVISIBLE);
        pil3.setVisibility(View.INVISIBLE);
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        lur.setText("Disuatu siang yang sangat cerah, sangking cerahnya aspal pun terasa terbakar pada hari itu. " +
                "Malih berjalan pulang dari kampus dengan wajah tidak karuan." +
                " Ia pun menggerutu setiap kali ia mengambil langkah, membatin akan balas dendam beli es yang banyak untuk " +
                "menghilangkan rasa panas tersebut. Tiba-tiba...");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.jalanrayacrop);

        lur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pertama();
            }
        });
    }

    @Override
    public void onBackPressed() {

    }

    //PERTANYAAN PERTAMA

    private void pertama() {
        poin = 0;
        lur.setText("Tiba-tiba Malih menemukan dompet dijalan menuju rumahnya, ia berpikir...");
        lur.getText().toString();
        gmbr1.setVisibility(View.VISIBLE);
        bg.setBackgroundResource(R.drawable.jalanrayacrop);
        gmbr1.setImageResource(R.drawable.malih1);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);

        pil1.setHint("Ambil dompet tersebut tanpa mengambil uangnya.");
        pil1.getHint().toString();
        pil2.setHint("Ambil dompet tersebut DAN mengambil uangnya.");
        pil2.getHint().toString();
        pil3.setHint("Biarkan dompet tersebut");
        pil3.getHint().toString();

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                kedua();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=2;
                kedua();
            }
        });

        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=0;
                pertamalagi();
            }
        });
    }

    public void pertamalagi(){
        lur.setText("Malih pun tidak yakin dengan keputusannya, lalu berpikir kembali...");
        lur.getText().toString();
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.INVISIBLE);

        bg.setBackgroundResource(R.drawable.jalanrayacrop);
        gmbr1.setImageResource(R.drawable.malih1);

        pil1.setHint("Kembali ke tempat dompet");
        pil1.getHint().toString();
        pil2.setHint("Ah, sudahlah biarkan saja.");
        pil2.getHint().toString();

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=1;
                pertama();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=0;
                ending();
            }
        });
    }

    //PERTANYAAN KEDUA

    private void kedua() {
        lur.setText("Selepas kejadian itu, Malih pulang ke rumahnya dan melewati kantor polisi. Malih berpikir sejenak, " +
                "lalu ia memutuskan untuk...");
        lur.getText().toString();
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.VISIBLE);

        bg.setBackgroundResource(R.drawable.kantorpolisi);
        gmbr2.setImageResource(R.drawable.polisi1);

        pil1.setHint("Hanya melewati kantor polisi");
        pil1.getHint().toString();
        pil2.setHint("Memberikan dompet, namun berbohong tentang uang di dalamnya");
        pil2.getHint().toString();
        pil3.setHint("Memberitahukan tentang dompet ke kantor polisi");
        pil3.getHint().toString();

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=0;
                intermezzo2();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=2;
                intermezzo2();
            }
        });

        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                ending();
            }
        });
    }

    public void intermezzo2(){
        pil1.setVisibility(View.INVISIBLE);
        pil2.setVisibility(View.INVISIBLE);
        pil3.setVisibility(View.INVISIBLE);
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);

        bg.setBackgroundResource(R.drawable.rumahmalih);

        lur.setText("Setelah berjalan pulang, Malih pun sampai di rumahnya. Dia berganti pakaian dengan sembrono, tas, sepatu, dan baju " +
                "berserakan tidak beraturan. Ia kemudian membuka kulkas untuk mencari air dingin, " +
                "tapi ternyata air di dalam kulkas tidak dingin dikarenakan kulkas sedang rusak...");
        lur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketiga();
            }
        });
    }

    //PERTANYAAN KETIGA

    public void ketiga() {
        lur.setText("Malih menggerutu kesal, kemudian berniat untuk membeli es di warung Bu Onah. Ia berpikir....");
        lur.getText().toString();
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.VISIBLE);
        bg.setBackgroundResource(R.drawable.warung);
        gmbr1.setImageResource(R.drawable.buonah2);
        gmbr2.setImageResource(R.drawable.malih1);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);

        pil1.setHint("Menjajankan uang yang diambilnya tadi");
        pil1.getHint().toString();
        pil2.setHint("Jajan dengan uangnya sendiri");
        pil2.getHint().toString();
        pil3.setHint("Berhutang pada Bu Onah");
        pil3.getHint().toString();

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=2;
                keempat();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                keempat();
            }
        });

        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=0;
                keempat();
            }
        });
    }

    //PERTANYAAN KEEMPAT

    public void keempat() {
        lur.setText("Ia kembali ke rumahnya saat sudah membeli es. Malih tiba-tiba termenung, akan uang yang diambilnya dari dompet...");
        lur.getText().toString();
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);

        bg.setBackgroundResource(R.drawable.rumahmalih);
        gmbr1.setImageResource(R.drawable.malih2);

        pil1.setHint("Menyesali keputusannya dan berniat untuk mengembalikan uang tersebut");
        pil1.getHint().toString();
        pil2.setHint("Membelikan barang yang Malih suka dengan uang tersebut");
        pil2.getHint().toString();
        pil3.setHint("Memberikannya pada pengemis");
        pil3.getHint().toString();

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=3;
                intermezzo3();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=5;
                intermezzo3();
            }
        });

        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=0;
                intermezzo3();
            }
        });
    }

    public void intermezzo3(){
        pil1.setVisibility(View.INVISIBLE);
        pil2.setVisibility(View.INVISIBLE);
        pil3.setVisibility(View.INVISIBLE);

        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        lur.setText("Malih Kembali ke kantor polisi untuk menanyakan perihal dompet yang tadi ia temukan, ia berniat untuk mencari tahu " +
                " siapa orang yang memiliki dompet tersebut. Saat ia sampai di kantor polisi, ia bertanya pada polisi yang ia titipkan " +
                "dompet milik seseorang tadi.");

        bg.setBackgroundResource(R.drawable.kantorpolisi);

        lur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intermezzo4();
            }
        });
    }

    public void intermezzo4(){
        pil1.setVisibility(View.INVISIBLE);
        pil2.setVisibility(View.INVISIBLE);
        pil3.setVisibility(View.INVISIBLE);



        bg.setBackgroundResource(R.drawable.kantorpolisi);
        gmbr1.setImageResource(R.drawable.polisi1);

        lur.setText("'Pak pol, dompet yang tadi saya titipkan apa masih ada? saya ingin mengetahui siapa pemiliknya.' " +
                " Setelah bertanya-tanya pada pak pol, ternyata dompet itu sudah diambil oleh pemiliknya... \n\n" +
                "Dan ternyata pemilik dompet tersebut ialah pak haji Sobirin, tetangga samping rumah Malih. ");

        lur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kelima();
            }
        });
    }

    //KELIMA

    public void kelima(){
        lur.setText("Malih kemudian mendatangi kediaman pak Sobirin...Tok! Tok! Tok! \n" +
                "Pak Sobirin membukakan pintu dengan wajah bertanya-tanya. Setelah berbincang sedikit, Malih pun bercerita tentang " +
                "dompet pak sobirin yang dia temukan dekat jalan raya, sebelum diserahkan pada polisi. Lalu malih...");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.rumahpakhaji);

        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);

        pil1.setHint("Meminta maaf dan mengakui atas kesalahannya memakai uang Pak Sobirin");
        pil1.getHint().toString();
        pil2.setHint("Meminta imbalann pada Pak Sobirin");
        pil2.getHint().toString();
        pil3.setHint("Memastikan dompet tersebut telah ada ditangan Pak Sobirin");
        pil3.getHint().toString();

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=3;
                ending();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=2;
                ending();
            }
        });

        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=1;
                keenam();
            }
        });
    }

    public void keenam() {
        lur.setText("Pak Sobirin senang dompetnya kembali, namun ia berbicara tentang uangnya yang sebagian hilang." +
                " Ia kehilangan 500ribu rupiah. Ia bertanya " +
                "apakah Malih mengetahui tentang uang tersebut, dan Malih pun menjawab...");
        lur.getText().toString();

        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.VISIBLE);

        bg.setBackgroundResource(R.drawable.rumahpakhaji);
        gmbr1.setImageResource(R.drawable.haji2);
        gmbr2.setImageResource(R.drawable.malih1);

        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);

        pil1.setHint("Mengaku bahwa dia mengambil uang Pak Sobirin");
        pil1.getHint().toString();
        pil2.setHint("Berbohong bahwa ia tidak tahu apa-apa");
        pil2.getHint().toString();
        pil3.setHint("Berbohong bahwa ia mengambil uang 10 ribu untuk dikasih pengemis");
        pil3.getHint().toString();

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=3;
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
                poin-=2;
                ending();
            }
        });
    }

    public void ending() {
        pil3.setVisibility(View.INVISIBLE);
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        String hasil;
        if (poin >=10){
            hasil = " Selamat! Kamu anak yang polos dan jujur, kamu mendapatkan imbalan uang atas aksimu tersebut. ";
        }else if(poin >= 0 && poin < 10){
            hasil = " Kamu bisa lebih baik dari ini. ";
        }
        else{
            hasil = " Kamu seorang Kriminal, Pada akhirnya kamu pun ketahuan, dan mendapatkan sanksi sosial atas perbuatanmu. ";
        }

        lur.setText("ENDING YANG KAMU DAPATKAN \n\n"+hasil);
        pil1.setVisibility(View.VISIBLE);
        pil1.setHint("Coba Lagi?");
        pil2.setVisibility(View.VISIBLE);
        pil2.setHint("Keluar?");

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intermezzo1();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder keluar = new AlertDialog.Builder(v.getContext());
                keluar.setTitle("Keluar");
                keluar.setMessage("Apa anda yakin ingin keluar dari cerita?");

                keluar.setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                            Toast.makeText(malihdandompet.this,"Anda keluar dari cerita",Toast.LENGTH_SHORT).show();
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
}