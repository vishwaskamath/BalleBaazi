package com.example.ballebaazi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;

public class TossWon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //to hide the top title bar//
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_tosswon);

        Button batFirst,bowlFirst;
        batFirst = findViewById(R.id.batfirst);
        bowlFirst = findViewById(R.id.bowlfirst);

        batFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PlayerBatFirst.class));
            }
        });
        bowlFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AiBatFirst.class));
            }
        });


    }


}
