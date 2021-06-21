package com.example.ballebaazi;

import android.os.Handler;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Objects;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class AiBatFirst extends AppCompatActivity {


    int UserChoice = 0;
    int ComputerChoice = 0;
    int total = 0;
    int wickets = 0;

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6;
    EditText edt_1, edt_2, edt_3, edt_4;
    ImageView img;

    final Handler handler = new Handler();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //to hide the top title bar//
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_aibatfirst);

        btn_1 = findViewById(R.id.button1);
        btn_2 = findViewById(R.id.button2);
        btn_3 = findViewById(R.id.button3);
        btn_4 = findViewById(R.id.button4);
        btn_5 = findViewById(R.id.button5);
        btn_6 = findViewById(R.id.button6);
        edt_1 = findViewById(R.id.editTextai);
        edt_2 = findViewById(R.id.editTextplayer);
        edt_3 = findViewById(R.id.editTexttotal);
        edt_4 = findViewById(R.id.editTextwickets);

        img = findViewById(R.id.imageAudience);




        btn_1.setOnClickListener(v -> {
            UserChoice = 1;
            ComputerChoice = generateComputerChoice();
            if (UserChoice == ComputerChoice) {
                // out

                outFunction();


            } else {
                //add to total
                img.setImageResource(R.drawable.audience2);
                total = total + 1;

                edt_1.setText(Integer.toString(ComputerChoice));
                edt_2.setText("1");
                edt_3.setText(Integer.toString(total));
            }

        });
        btn_2.setOnClickListener(v -> {
            UserChoice = 2;
            ComputerChoice = generateComputerChoice();
            if (UserChoice == ComputerChoice) {
                // out
                outFunction();

            } else {
                //add to total
                img.setImageResource(R.drawable.audience3);
                total = total + 2;
                edt_1.setText(Integer.toString(ComputerChoice));
                edt_2.setText("2");
                edt_3.setText(Integer.toString(total));
            }

        });
        btn_3.setOnClickListener(v -> {
            UserChoice = 3;
            ComputerChoice = generateComputerChoice();
            if (UserChoice == ComputerChoice) {
                // out
                outFunction();

            } else {
                //add to total
                img.setImageResource(R.drawable.audience2);
                total = total + 3;
                edt_1.setText(Integer.toString(ComputerChoice));
                edt_2.setText("3");
                edt_3.setText(Integer.toString(total));
            }

        });
        btn_4.setOnClickListener(v -> {
            UserChoice = 4;
            ComputerChoice = generateComputerChoice();
            if (UserChoice == ComputerChoice) {
                // out

                outFunction();
            } else {
                //add to total
                img.setImageResource(R.drawable.audience1);
                total = total + 4;
                edt_1.setText(Integer.toString(ComputerChoice));
                edt_2.setText("4");
                edt_3.setText(Integer.toString(total));
            }

        });
        btn_5.setOnClickListener(v -> {
            UserChoice = 5;
            ComputerChoice = generateComputerChoice();
            if (UserChoice == ComputerChoice) {
                // out
                outFunction();

            } else {
                //add to total
                img.setImageResource(R.drawable.audience4);
                total = total + 5;
                edt_1.setText(Integer.toString(ComputerChoice));
                edt_2.setText("5");
                edt_3.setText(Integer.toString(total));
            }

        });
        btn_6.setOnClickListener(v -> {
            UserChoice = 6;
            ComputerChoice = generateComputerChoice();
            if (UserChoice == ComputerChoice) {
                // out
                outFunction();

            } else {
                //add to total
                img.setImageResource(R.drawable.audience5);
                total = total + 6;
                edt_1.setText(Integer.toString(ComputerChoice));
                edt_2.setText("6");
                edt_3.setText(Integer.toString(total));
            }

        });


    }

    private void outFunction() {

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();


        Intent end = new Intent(AiBatFirst.this, PlayerTarget.class);

        img.setImageResource(R.drawable.out);

        if (wickets < 9) {
            wickets = wickets + 1;
            edt_4.setText(Integer.toString(wickets));
        } else {

            editor.putInt("ai_bat_first_key", total);

            editor.apply();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 1s = 1000ms
                    startActivity(end);
                }
            }, 1000);
        }
    }

    public static int generateComputerChoice() {

        Random random = new Random();
        int RandomNumber;
        RandomNumber = random.nextInt(6) + 1;


        int ComputerChoice;

        if (RandomNumber == 1) {
            ComputerChoice = 1;

        } else if (RandomNumber == 2) {
            ComputerChoice = 2;
        } else if (RandomNumber == 3) {
            ComputerChoice = 3;
        } else if (RandomNumber == 4) {
            ComputerChoice = 4;
        } else if (RandomNumber == 5) {
            ComputerChoice = 5;
        } else {
            ComputerChoice = 6;
        }

        return ComputerChoice;

    }

}


