package com.bluewater.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.bluewater.testapp.fragments.AccountFragment;
import com.bluewater.testapp.fragments.AddFragment;
import com.bluewater.testapp.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btm;
    Fragment loadFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFrag= new  HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,loadFrag).commit();
        btm=(BottomNavigationView) findViewById(R.id.btm_nav);
        btm.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selFrag=null;
                switch (item.getItemId()){
                    case R.id.btm_home:
                        selFrag=new HomeFragment();
                        break;
                    case R.id.btm_acc:
                        selFrag=new AccountFragment();
                        break;
                    case R.id.btm_add:
                        selFrag=new AddFragment();
                        break;
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frag_container,selFrag)
                        .commit();
                return true;
            }
        });

    }
}