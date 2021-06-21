package com.example.ballebaazi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;

public class MatchWon extends AppCompatActivity {

    String matchesPlayed;
    String matchPlayed;
    String matchWon;
    String matchesWon;
    String coinsCount;
    String coinsCounted;

    int coins;
    public String currentUserId;
    private FirebaseAuth mAuth;
    private static final String TAG = "Vishwas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //to hide the top title bar//
        Objects.requireNonNull(getSupportActionBar()).hide();
        mAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_matchwon);
        CheckWinNumber();

        Button button;
        button = findViewById(R.id.mainMenu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), HomePage.class));
            }
        });


    }

    public void CheckWinNumber() {


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


                    matchesWon = fetchedValues.get("won");
                    coinsCount = fetchedValues.get("coins");
                    matchesPlayed = fetchedValues.get("matches");
                    int a = Integer.parseInt(matchesWon) + 1;
                    matchWon = Integer.toString(a);
                    int b = Integer.parseInt(coinsCount) + 1000;
                    coinsCounted = Integer.toString(b);
                    int c = Integer.parseInt(matchesPlayed) + 1;
                    matchPlayed = Integer.toString(c);
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
                .update("won", matchWon);
        db.collection("users").document(currentUserId)
                .update("matches", matchPlayed);
        db.collection("users").document(currentUserId)
                .update("coins", coinsCounted);


    }


}
