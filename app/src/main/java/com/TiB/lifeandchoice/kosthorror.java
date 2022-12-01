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

public class kosthorror extends AppCompatActivity {

    Button pil1,pil2,pil3,kluar;
    ImageView gmbr1,gmbr2;
    TextView lur;
    ConstraintLayout bg;
    FirebaseAuth fAuth;

    int poin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story4);
        pil1 = findViewById(R.id.pilihan1);
        pil2 = findViewById(R.id.pilihan2);
        pil3 = findViewById(R.id.pilihan3);
        lur = findViewById(R.id.alur);
        kluar = findViewById(R.id.keluar1);
        bg = findViewById(R.id.background);

        gmbr1 = findViewById(R.id.gambar1);
        gmbr2 = findViewById(R.id.gambar2);

        intro();

        kluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder keluar = new AlertDialog.Builder(v.getContext());
                keluar.setTitle("Keluar");
                keluar.setMessage("Apa anda yakin ingin keluar dari cerita?");

                keluar.setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(kosthorror.this,"Anda keluar dari cerita",Toast.LENGTH_SHORT).show();
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

    private void intro() {
        poin = 0;
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        pil1.setVisibility(View.INVISIBLE);
        pil2.setVisibility(View.INVISIBLE);
        pil3.setVisibility(View.INVISIBLE);
        lur.setText(" Pukul 7 pagi ini aku terbangun dari tidur, seperti biasa aku melakukan rutinitasku untuk mandi, kemudian sarapan " +
                "bersama keluargaku. Ibu dan Ayah sedang asik membahas sesuatu sambil menyantap sarapan. Aku menguping pembicaraan mereka tentang kost-kostan... ");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.tempattidur);

        lur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pembicaraankosan();
            }
        });
    }

    private void pembicaraankosan() {
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);
        lur.setText(" Kost-kostan yang Ibu bicarakan adalah kost yang berada pada ujung jalan di dekat rumahku. Ibu bilang Kost-an tersebut " +
                "sangat horror karena.. ");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.rumah);
        gmbr1.setImageResource(R.drawable.ayah);
        gmbr2.setImageResource(R.drawable.ibu);

        pil1.setHint("Kost-an tersebut terkenal angker");
        pil1.getHint().toString();
        pil2.setHint("Penghuni kost tidak mau bayar uang kost-an");
        pil2.getHint().toString();
        pil3.setHint("Penghuni kost yang sering kesurupan");
        pil3.getHint().toString();
        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                kesekolah();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=0;
                kesekolah();
            }
        });
        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=0;
                kesekolah();
            }
        });
    }

    private void kesekolah() {
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        pil1.setVisibility(View.INVISIBLE);
        pil2.setVisibility(View.INVISIBLE);
        pil3.setVisibility(View.INVISIBLE);
        lur.setText("Saat mendengar tentang cerita horror tersebut hanya aku menggelengkan kepala, heran. Aku pamit pada Ayah dan Ibu untuk " +
                " pergi ke sekolah. Sesampainya di sekolah aku berkumpul dengan ketiga temanku untuk " +
                "menceritakan hal yang kudengar dari Ibu dan Ayah tadi pagi.");
        lur.getText().toString();
        bg.setBackgroundResource(R.drawable.mall);

        lur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ceritaketeman();
            }
        });

    }

    private void ceritaketeman() {
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);
        lur.setText(" Aku menceritakan pada Nisa dan Lia. Mereka mendengar ceritaku dengan serius. Mereka tak percaya " +
                "bahwa ada hal semacam itu. Kemudian Lia berinisiatif memberi ide... ");
        lur.getText().toString();
        bg.setBackgroundResource(R.drawable.mall);
        gmbr1.setImageResource(R.drawable.nisa);
        gmbr2.setImageResource(R.drawable.lia);

        pil1.setHint("Mendatangi kost tersebut untuk membuktikannya");
        pil1.getHint().toString();
        pil2.setHint("Tidak usah memperdulikan hal tersebut");
        pil2.getHint().toString();
        pil3.setHint("Memberi saran untuk mendatangkan dukun");
        pil3.getHint().toString();
        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                kekost();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=0;
                ending();
            }
        });
        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=3;
                kekost();
            }
        });
    }

    private void kekost() {
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);
        lur.setText(" Karena rasa penasaran kami yang sangat tinggi, kami pun mendatangi kost-an di dekat rumahku " +
                "pada malam hari. Belum sempat memasuki kost-an hawa tidak enak langsung menyerang. Nisa terus-terusan melihat ke arah pojok seperti ada sesuatu yang mengganggunya, " +
                "Nisa mengajak kami untuk melihat pojokan kost dari dekat...");
        lur.getText().toString();
        bg.setBackgroundResource(R.drawable.horror3);

        pil1.setHint("Memberanikan diri untuk mengecek pojok kost-an yang gelap dan menyeramkan");
        pil1.getHint().toString();
        pil2.setHint("Lari ketakutan lalu pulang ke rumah");
        pil2.getHint().toString();
        pil3.setHint("Mendorong temanku untuk maju duluan");
        pil3.getHint().toString();
        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                horrorpart();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=0;
                ending();
            }
        });
        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=5;
                horrorpart();
            }
        });
    }

    private void horrorpart() {
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        pil1.setVisibility(View.INVISIBLE);
        pil2.setVisibility(View.INVISIBLE);
        pil3.setVisibility(View.INVISIBLE);
        lur.setText(" Hiiks... Hiiikss... \nTiba-tiba terdengar suara tangisan dari arah belakang kami. " +
                "Dengan perasaan takut, kami memberanikan diri menoleh kebelakang...");
        lur.getText().toString();
        bg.setBackgroundResource(R.drawable.horror2);

        lur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horrotpartkunti();
            }
        });
    }

    private void horrotpartkunti() {
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);

        lur.setText(" HIII HIII HII HIII... \n\n" +
                "'AAAAAAAAA' Kami pun berteriak melihat kunti yang terbang mendekat ke arah kami, matanya merah melotot, wajahnya banyak luka dan bersimbah darah...");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.horror2);
        gmbr1.setImageResource(R.drawable.lia2);
        gmbr2.setImageResource(R.drawable.nisa2);

        pil1.setHint("Kabur lari ketakukan");
        pil1.getHint().toString();
        pil2.setHint("Menyiram Kunti tersebut dengan garam");
        pil2.getHint().toString();
        pil3.setHint("Memberi semangat kepada kunti tersebut");
        pil3.getHint().toString();
        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=3;
                kuntimarah();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=5;
                kuntimarah();
            }
        });
        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=1;
                kuntimarah();
            }
        });
    }

    private void kuntimarah() {
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);

        lur.setText(" Kunti semakin marah, ia pun mengejar dan memblokir jalan kami... Kunti itu menangis kembali, " +
                "dan ia meminta pertolongan pada kami... " +
                "ia itu menceritakan dari awal bagaimana dia meninggal, kami pun...");
        lur.getText().toString();
        bg.setBackgroundResource(R.drawable.horror2);
        pil1.setHint("Bersimpati dan berusaha menghubungi pak Ustad");
        pil1.getHint().toString();
        pil2.setHint("Kabur dan tidak pernah Kembali lagi Kesana");
        pil2.getHint().toString();
        pil3.setHint("Memberitahu dukun untuk menyimpan kunti itu");
        pil3.getHint().toString();
        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                pakustad();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=0;
                dihantui();
            }
        });
        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=10;
                entitasjahat();
            }
        });
    }

    private void pakustad() {
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);
        lur.setText(" Pak ustad datang ke kosan tersebut untuk membersihkan roh tersebut agar dapat tenang " +
                "pergi ke tempat dimana ia seharusnya. Aku senang akan hal itu, oleh karena itu... ");
        lur.getText().toString();
        bg.setBackgroundResource(R.drawable.horror);
        gmbr1.setImageResource(R.drawable.haji1);
        pil1.setHint("Ikut mendoakan agar arwahnya tenang di alam sana");
        pil1.getHint().toString();
        pil2.setHint("Sompral bermain jelangkung untuk mengecek arwahnya masih ada atau tidak");
        pil2.getHint().toString();
        pil3.setHint("Meminta dukun untuk memanggil kembali arwah tersebut");
        pil3.getHint().toString();
        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
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
                poin-=10;
                ending();
            }
        });
    }

    private void dihantui() {
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        pil3.setVisibility(View.INVISIBLE);
        String hasil = "Setelah mengusik keberadaan kunti kamu pun berhasil kabur, tapi hidupmu dipenuhi " +
                " dengan ketakutan dan kesialan karena tanpa sadar kunti itu terus menerus mengikutimu...";
        lur.setText(" ENDING YANG KAMU DAPATKAN \n\n "+hasil);
        lur.getText().toString();
        pil1.setVisibility(View.VISIBLE);
        pil1.setHint("Coba Lagi?");
        pil2.setVisibility(View.VISIBLE);
        pil2.setHint("Keluar?");

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intro();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keluar(v);
            }
        });
    }

    private void entitasjahat() {
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        pil3.setVisibility(View.INVISIBLE);
        lur.setText(" Hantu tersebut 'diisi' dengan energi buruk oleh dukun tersebut, " +
                "Hantu tersebut berkembang menjadi entitas yang jahat, ia suka menganggu manusia bahkan " +
                "hingga menemui ajal. Kamu, tanpa sadar adalah salah satu targetnya.");
        lur.getText().toString();
        pil1.setVisibility(View.VISIBLE);
        pil1.setHint("Coba Lagi?");
        pil2.setVisibility(View.VISIBLE);
        pil2.setHint("Keluar?");

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intro();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keluar(v);
            }
        });
    }

    private void ending() {
        pil3.setVisibility(View.INVISIBLE);
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        String hasil;
        if (poin >=10){
            hasil = " Kamu membantu arwah tersebut untuk kembali ke alamnya, lingkungan kost pun sekarang berubah, aura positif mengelilingi kost tersebut.";
        }else if(poin >= 0 && poin < 10){
            hasil = " Kamu tidak banyak membantu, setidaknya kamu tidak membuat hantu itu mengikutimu. ";
        }
        else{
            hasil = " Karena kesompralanmu, hantu itu diam-diam mengikutimu dan berniat mengambil alih jiwamu. ";
        }

        lur.setText("ENDING YANG KAMU DAPATKAN \n\n"+hasil);
        pil1.setVisibility(View.VISIBLE);
        pil1.setHint("Coba Lagi?");
        pil2.setVisibility(View.VISIBLE);
        pil2.setHint("Keluar?");

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intro();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keluar(v);
            }
        });
    }

    private void keluar(View v) {
            final AlertDialog.Builder keluar = new AlertDialog.Builder(v.getContext());
            keluar.setTitle("Keluar");
            keluar.setMessage("Apa anda yakin ingin keluar dari cerita?");

            keluar.setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Toast.makeText(kosthorror.this,"Anda keluar dari cerita",Toast.LENGTH_SHORT).show();
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