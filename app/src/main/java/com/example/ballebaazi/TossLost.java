package com.example.ballebaazi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;

public class TossLost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //to hide the top title bar//
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_tosslost);
        Button bowlFirst;

        bowlFirst = findViewById(R.id.bowlfirst);

        bowlFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AiBatFirst.class));
            }
        });

    }


}
