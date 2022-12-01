package com.TiB.lifeandchoice;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends FragmentActivity {

    Button klr;
    BottomNavigationView btmnav;
    FirebaseAuth fAuth;
    MenuItem tem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tem = findViewById(R.id.item3);

        btmnav = findViewById(R.id.bottomNavigationView);
        btmnav.setOnNavigationItemSelectedListener(navListener);
        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() != null){
            btmnav.inflateMenu(R.menu.bottom_navigation);
        }else{
            btmnav.inflateMenu(R.menu.bottom_navigation2);
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new HomeFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.item1:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.item2:
                    selectedFragment = new genreFragment();
                    break;
                case R.id.item3:
                    selectedFragment = new profileFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,selectedFragment).commit();

            return true;
        }
    };
}