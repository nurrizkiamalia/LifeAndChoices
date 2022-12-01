package com.TiB.lifeandchoice;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.ConstraintTableLayout;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    Button regis, lgn, hom;
    ImageView drp;
    BottomNavigationView btnav;
    ConstraintLayout opsilc;
    TextView opsi, opsidown;
    FirebaseAuth fAuth;
    MenuItem tem;
    boolean pertamamuncul = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        regis = findViewById(R.id.toRegis);
        lgn = findViewById(R.id.toLgn);
        hom = findViewById(R.id.toHome);
        tem = findViewById(R.id.item3);
        drp = findViewById(R.id.ldrop);
        opsi  = findViewById(R.id.opsilaintxt);
        btnav = findViewById(R.id.bottomNavigationView);
        opsilc = findViewById(R.id.opsilaincons);
        opsidown = findViewById(R.id.opsidroptext);

        fAuth = FirebaseAuth.getInstance();
        if (fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),Home.class));
            finish();
        }

        drp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pertamamuncul == true) {
                    opsilc.getLayoutParams().height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
                    opsilc.requestLayout();
                    opsi.setVisibility(View.VISIBLE);
                    regis.setVisibility(View.VISIBLE);
                    lgn.setVisibility(View.VISIBLE);
                    opsidown.setVisibility(View.INVISIBLE);
                    pertamamuncul = false;
                }else{
                    ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) opsilc.getLayoutParams();
                    params.height = 120;
                    opsilc.setLayoutParams(params);
                    opsi.setVisibility(View.INVISIBLE);
                    regis.setVisibility(View.INVISIBLE);
                    lgn.setVisibility(View.INVISIBLE);
                    opsidown.setVisibility(View.VISIBLE);
                    pertamamuncul = true;
                }
            }
        });

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainActivity.this,registration.class);
                startActivity(i1);
            }
        });

        lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainActivity.this,login.class);
                startActivity(i1);
            }
        });

        hom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainActivity.this,Home.class);
                startActivity(i1);
            }
        });
    }
}