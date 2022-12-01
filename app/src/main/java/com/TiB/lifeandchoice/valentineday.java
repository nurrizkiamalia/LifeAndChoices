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

public class valentineday extends AppCompatActivity {

    Button pil1,pil2,pil3,kluar;
    ImageView gmbr1,gmbr2;
    TextView lur;
    ConstraintLayout bg;
    FirebaseAuth fAuth;

    int poin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story3);

        pil1 = findViewById(R.id.pilihan1);
        pil2 = findViewById(R.id.pilihan2);
        pil3 = findViewById(R.id.pilihan3);
        lur = findViewById(R.id.alur);
        kluar = findViewById(R.id.keluar1);
        bg = findViewById(R.id.background);

        gmbr1 = findViewById(R.id.gambar1);
        gmbr2 = findViewById(R.id.gambar2);

        pertama();

        kluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder keluar = new AlertDialog.Builder(v.getContext());
                keluar.setTitle("Keluar");
                keluar.setMessage("Apa anda yakin ingin keluar dari cerita?");

                keluar.setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(valentineday.this,"Anda keluar dari cerita",Toast.LENGTH_SHORT).show();
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

    public void pertama(){
        poin = 0;
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        pil1.setVisibility(View.INVISIBLE);
        pil2.setVisibility(View.INVISIBLE);
        pil3.setVisibility(View.INVISIBLE);
        lur.setText("Hari valentine, adalah hari dimana seseorang menyatakan sayang dengan cara memberi sesuatu. Dan identiknya seseorang memberi coklat ataupun bunga " +
                " sebagai bentuk ungkapan sayang kepada kekasih, atau orang tercintanya. Seperti seorang pemuda yang ingin memberikan sesuatu kepada wanita idamannya ini. ");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.jalanmendung);

        lur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perjuanganawal();
            }
        });
    }

    private void perjuanganawal() {
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);
        lur.setText("Siang itu cuaca terlihat mendung, Daniel, pemuda itu berharap dalam hatinya 'Semoga ngga ujan deh!'. Daniel mampir sebentar ke toko bunga, " +
                " ia melihat-lihat jenis bunga di sana, ia pun memutuskan untuk... ");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.tokobunga);
        gmbr1.setImageResource(R.drawable.daniel);

        pil1.setHint("Membeli 1 bucket bunga mawar");
        pil1.getHint().toString();
        pil2.setHint("Membeli 1 tangkai saja, irit");
        pil2.getHint().toString();
        pil3.setHint("Tidak jadi membeli bunga");
        pil3.getHint().toString();
        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                hujan();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=1;
                hujan();
            }
        });
        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=5;
                hujan();
            }
        });
    }

    private void hujan() {
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);
        lur.setText("Baru saja Daniel hendak menaiki motor, hujan turun dengan deras secara tiba-tiba. " +
                " Daniel pun bimbang dengan kondisi ini, karena ia sudah berjanji kepada pacarnya untuk datang tepat waktu, ia pun... ");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.hujan);
        gmbr2.setImageResource(R.drawable.daniel);

        pil1.setHint("Menerobos hujan demi kekasihnya");
        pil1.getHint().toString();
        pil2.setHint("Menunggu hingga hujan reda");
        pil2.getHint().toString();
        pil3.setHint("Ingin pulang saja");
        pil3.getHint().toString();
        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                menemuipacarkebasahan();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=1;
                menemuipacar();
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

    public void menemuipacarkebasahan(){
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);
        lur.setText("Daniel sampai ke rumah pacarnya, Julia dengan tubuh basah kuyup kehujanan. Julia yang menunggu Daniel di teras sejak daritadi memasang wajah masam,  " +
                " namun melihat tubuh Daniel yang basah kuyup ia pun terkejut, Julia akhirnya...");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.rumah4);
        gmbr1.setImageResource(R.drawable.daniel);
        gmbr2.setImageResource(R.drawable.julia1);

        pil1.setHint("Khawatir pada keadaan Daniel ");
        pil1.getHint().toString();
        pil2.setHint("Tetap marah karena Daniel tidak tepat waktu");
        pil2.getHint().toString();
        pil3.setHint("Tidak peduli");
        pil3.getHint().toString();
        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                memberikado();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=5;
                memberikado();
            }
        });
        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=2;
                memberikado();
            }
        });
    }

    private void menemuipacar() {
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);
        lur.setText("Daniel akhirnya sampai ke rumah pacarnya, Julia. Julia menunggu diteras rumahnya dengan wajah masam " +
                " Julia marah pada Daniel karena telat 1 jam dari yang dijanjikannya, Daniel memberikan pengertian kepada Julia bahwa ia terjebak hujan, "+
                " Daniel kemudian... ");
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.rumah4);
        gmbr1.setImageResource(R.drawable.daniel2);
        gmbr1.setImageResource(R.drawable.julia1);

        pil1.setHint("Meminta maaf pada Julia");
        pil1.getHint().toString();
        pil2.setHint("Bersikap biasa saja");
        pil2.getHint().toString();
        pil3.setHint("Memutuskan untuk pulang");
        pil3.getHint().toString();
        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                memberikado();
            }
        });


        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=0;
                memberikado();
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

    private void memberikado() {
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);
        lur.setText("Daniel mengambil tasnya dan berpikir untuk memberi sesuatu pada Julia... " );
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.rumah4);
        gmbr1.setImageResource(R.drawable.daniel2);

        pil1.setHint("Hanya membuka tasnya dan tidak memberikan apa-apa pada Julia");
        pil1.getHint().toString();
        pil2.setHint("Memberikan hadiah pada Julia");
        pil2.getHint().toString();
        pil3.setHint("Membuang hadiah untuk Julia");
        pil3.getHint().toString();
        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=0;
                makanmalam();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                makanmalam();
            }
        });
        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=5;
                juliamarah();
            }
        });

    }

    private void makanmalam() {
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);
        lur.setText(" Tak lama Daniel mengajak Julia untuk makan malam bersama, Julia memutuskan untuk... " );
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.rumah4);
        gmbr1.setImageResource(R.drawable.julia2);
        gmbr2.setImageResource(R.drawable.daniel);

        pil1.setHint("Makan di warung lesehan");
        pil1.getHint().toString();
        pil2.setHint("Makan malam di restoran mahal");
        pil2.getHint().toString();
        pil3.setHint("Menolak ajakan Daniel");
        pil3.getHint().toString();
        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=0;
                warunglesehan();
            }
        });
        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=0;
                restoran();
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

    private void restoran() {
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);
        lur.setText(" Mereka pun sampai ke restoran dimana makanan-makanan di restoran tersebut berharga mahal. Julia mengambil daftar menu, ia pun memilih..." );
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.restoranmahal);
        gmbr1.setImageResource(R.drawable.julia1);
        gmbr2.setImageResource(R.drawable.daniel2);

        pil1.setHint("Membeli banyak makanan yang paling mahal tanpa memikirkan keuangan Daniel");
        pil1.getHint().toString();
        pil2.setHint("Membeli air putih saja");
        pil2.getHint().toString();
        pil3.setHint("Mengajak Daniel pulang");
        pil3.getHint().toString();
        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=5;
                pulangkerumah();
            }
        });
        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=0;
                pulangkerumah();
            }
        });
        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=0;
                pulangkerumah();
            }
        });
    }

    private void warunglesehan() {
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);
        lur.setText(" Mereka pun sampai ke warung lesehan dekat rumah Julia. Juliah memesan banyak sekali makanan dan menghabiskan semuanya tanpa tersisa..." );
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.lesehan);
        gmbr1.setImageResource(R.drawable.julia2);
        gmbr2.setImageResource(R.drawable.daniel2);

        pil1.setHint("Daniel menjadi ilfeel pada Julia, lalu meninggalkan Julia sendirian");
        pil1.getHint().toString();
        pil2.setHint("Daniel tersenyum senang pacarnya makan dengan lahap");
        pil2.getHint().toString();
        pil3.setHint("Daniel beralasan dompetnya ketinggalan karena Julia memesan terlalu banyak");
        pil3.getHint().toString();
        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=5;
                juliamarah();
            }
        });
        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=5;
                pulangkerumah();
            }
        });
        pil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=3;
                pulangkerumah();
            }
        });
    }

    private void juliamarah() {

        pil3.setVisibility(View.INVISIBLE);
        String hasil = "Julia sangat marah pada kelakuan Daniel, ia memutuskan untuk putus dengan Daniel dan memblokir segala kontak Daniel. ";
        lur.setText("ENDING YANG KAMU DAPATKAN \n\n"+hasil);
        pil1.setVisibility(View.VISIBLE);
        pil1.setHint("Coba Lagi?");
        pil2.setVisibility(View.VISIBLE);
        pil2.setHint("Keluar?");

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pertama();
            }
        });

        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keluar(v);
            }
        });
    }

    private void pulangkerumah() {
        gmbr1.setVisibility(View.VISIBLE);
        gmbr2.setVisibility(View.VISIBLE);
        pil1.setVisibility(View.VISIBLE);
        pil2.setVisibility(View.VISIBLE);
        pil3.setVisibility(View.VISIBLE);

        lur.setText(" Karena menjadi romantis itu dapat dilakukan dengan berbagai cara, Daniel berniat memberikan sesuatu pada Julia..." );
        lur.getText().toString();

        bg.setBackgroundResource(R.drawable.rumah4);
        gmbr1.setImageResource(R.drawable.daniel2);
        gmbr2.setImageResource(R.drawable.julia1);

        pil1.setHint("Boneka Voodoo");
        pil1.getHint().toString();
        pil2.setHint("Cincin tunangan");
        pil2.getHint().toString();
        pil3.setHint("Tiket liburan ke sungai penuh buaya");
        pil3.getHint().toString();
        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin-=5;
                ending();
            }
        });
        pil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poin+=20;
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


    private void ending() {
        pil3.setVisibility(View.INVISIBLE);
        gmbr1.setVisibility(View.INVISIBLE);
        gmbr2.setVisibility(View.INVISIBLE);
        String hasil;
        if (poin >=10){
            hasil = " Kamu memang pacar terbaik! Julia sangat bahagia mengenalmu, tanpa ragu Julia menunjukkan rasa cintanya yang besar padamu. Julia sangat mengapresiasi usahamu itu.";
        }else if(poin >= 0 && poin < 10){
            hasil = " Walaupun kamu tidak bisa memberikan yang terbaik untuk Julia, setidaknya kamu telah berusaha. ";
        }
        else{
            hasil = " Lebih baik putuskan saja julia, dia pantas mendapatkan seseorang yang lebih baik darimu. ";
        }

        lur.setText("ENDING YANG KAMU DAPATKAN \n\n"+hasil);
        pil1.setVisibility(View.VISIBLE);
        pil1.setHint("Coba Lagi?");
        pil2.setVisibility(View.VISIBLE);
        pil2.setHint("Keluar?");

        pil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pertama();
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

                Toast.makeText(valentineday.this,"Anda keluar dari cerita",Toast.LENGTH_SHORT).show();
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