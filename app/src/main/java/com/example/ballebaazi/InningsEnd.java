package com.example.ballebaazi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;

public class InningsEnd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //to hide the top title bar//
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_inningsend);

        Button button = (Button)findViewById(R.id.homeButton);

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        int totalScore=sharedPref.getInt("score_key", 0);

        EditText edt_1;
        edt_1 = findViewById(R.id.editTexttotal);

        edt_1.setText(Integer.toString(totalScore));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HomePage.class));
            }
        });
    }


}
