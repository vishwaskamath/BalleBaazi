package com.example.ballebaazi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class TossPage extends AppCompatActivity {


    int UserChoice = 0;
    int ComputerChoice = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //to hide the top title bar//
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_tosspage);

        Intent won = new Intent (TossPage.this, TossWon.class);
        Intent lost = new Intent (TossPage.this, TossLost.class);

        Button HeadsButton = findViewById(R.id.heads);
        Button TailsButton = findViewById(R.id.tails);
        HeadsButton.setOnClickListener(v -> {
            UserChoice = 1;
            ComputerChoice = generateComputerChoice();
            if(UserChoice == ComputerChoice)
            {
                //toss won//

                startActivity(won);
            }
            else
            {
                //toss lost//
                startActivity(lost);
            }

        });
        TailsButton.setOnClickListener(v -> {
            UserChoice = 2;
            ComputerChoice = generateComputerChoice();
            if(UserChoice == ComputerChoice)
            {
                //toss won//

                startActivity(won);

            }
            else
            {
                //toss lost//
                startActivity(lost);
            }
        });



    }

    public static int generateComputerChoice(){

        Random random = new Random();
        int RandomNumber;
        RandomNumber = random.nextInt( 2 ) + 1;


        int ComputerChoice = 0;

        if( RandomNumber == 1 ){
            ComputerChoice = 1;

        }else {
            ComputerChoice = 2;
        }

        return ComputerChoice;

    }


}


