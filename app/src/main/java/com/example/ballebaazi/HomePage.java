package com.example.ballebaazi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class HomePage extends AppCompatActivity {


    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //to hide the top title bar//
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_homepage);
        navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(selectedListener);

        // When we open the application first
        // time the fragment should be shown to the user
        // in this case it is home fragment
        FirstFragment fragment = new FirstFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment, "");
        fragmentTransaction.commit();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener selectedListener = menuItem -> {
        switch (menuItem.getItemId()) {

            case R.id.page_1:
                FirstFragment fragment1 = new FirstFragment();
                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.content, fragment1);
                fragmentTransaction1.commit();
                return true;

            case R.id.page_2:

                SecondFragment fragment2 = new SecondFragment();
                FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.content, fragment2);
                fragmentTransaction2.commit();
                return true;

            case R.id.page_3:

                ThirdFragment fragment3 = new ThirdFragment();
                FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction3.replace(R.id.content, fragment3);
                fragmentTransaction3.commit();
                return true;

            case R.id.page_4:

                FourthFragment fragment4 = new FourthFragment();
                FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction4.replace(R.id.content, fragment4);
                fragmentTransaction4.commit();
                return true;



        }
        return false;
    };





}
