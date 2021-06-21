package com.example.ballebaazi;

import android.os.Handler;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerChase extends AppCompatActivity {

    String centuryScore;
    String centuryScored;
    String sixesScore;
    String sixesScored;
    int centuryCount = 0;
    int sixesCount = 0;

    FirebaseAuth mAuth;
    public String currentUserId;
    private static final String TAG = "Vishwas";

    int UserChoice = 0;
    int ComputerChoice = 0;
    int total = 0;
    int wickets = 0;

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6;
    EditText edt_1, edt_2, edt_3, edt_4,edt_5;
    ImageView img;

    final Handler handler = new Handler();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //to hide the top title bar//
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_playerchase);
        mAuth = FirebaseAuth.getInstance();

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



        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        int totalScore=sharedPref.getInt("ai_bat_first_key", 0);


        edt_5 = findViewById(R.id.editTexttarget);

        edt_5.setText(Integer.toString(totalScore));

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

                winFunction();

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

                winFunction();

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

                winFunction();

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

                winFunction();

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

                winFunction();

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
                sixesCount = sixesCount + 1;
                img.setImageResource(R.drawable.audience5);
                total = total + 6;

                winFunction();

                edt_1.setText(Integer.toString(ComputerChoice));
                edt_2.setText("6");
                edt_3.setText(Integer.toString(total));
            }

        });


    }

    public void CheckCountNumber() {


        currentUserId = mAuth.getCurrentUser().getUid();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection("users").document(currentUserId);
        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {

                    HashMap<String, String> fetchedValues;
                    fetchedValues = (HashMap) document.getData();
                    Log.d(TAG, "HashMp data: " + fetchedValues);


                    sixesScore = fetchedValues.get("sixes");
                    sixesScored = Integer.toString(Integer.parseInt(sixesScore) + sixesCount);

                    centuryScore = fetchedValues.get("century");
                    centuryScored = Integer.toString(Integer.parseInt(centuryScore) + centuryCount);
                    updateValues();


                } else {
                    Log.d(TAG, "No such document");
                }
            } else {
                Log.d(TAG, "get failed with ", task.getException());
            }
        });


    }

    private void updateValues() {


        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("users").document(currentUserId)
                .update("sixes", sixesScored);
        db.collection("users").document(currentUserId)
                .update("century", centuryScored);


    }

    private void winFunction() {

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        int totalScore=sharedPref.getInt("ai_bat_first_key", 0);

        // player wins //
        Intent won = new Intent(PlayerChase.this, MatchWon.class);

        if(total>totalScore)
        {
            int a = total%100;
            total = total - a;
            centuryCount = total/100;
            CheckCountNumber();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 1s = 1000ms
                    startActivity(won);
                }
            }, 1000);
        }

    }

    private void outFunction() {

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        // ai wins //
        Intent end = new Intent(PlayerChase.this, MatchLost.class);

        img.setImageResource(R.drawable.out);

        if (wickets < 9) {
            wickets = wickets + 1;
            edt_4.setText(Integer.toString(wickets));
        } else {

            int a = total%100;
            total = total - a;
            centuryCount = total/100;
            CheckCountNumber();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 2s = 2000ms
                    startActivity(end);
                }
            }, 2000);
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


