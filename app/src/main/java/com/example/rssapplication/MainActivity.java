package com.example.rssapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer,new KhoaHocFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);


    }
    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;
            switch (item.getItemId())
            {
                case R.id.giaiTri:
                    fragment = new GiaiTri();
                    break;
                case R.id.xe:
                    fragment = new XeFragment();
                    break;
                case R.id.khoaHoc:
                    fragment = new KhoaHocFragment();
                    break;
                case R.id.theThao:
                    fragment = new TheThaoFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).commit();

            return true;
        }
    };

}