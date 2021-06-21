package com.example.ballebaazi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;


public class ThirdFragment extends Fragment {

    public String currentUserId;
    private FirebaseAuth mAuth;

    String coinsValue;
    String matchesValue;
    String matchesWonValue;
    String centuryValue;
    String sixesValue;
    String maxValue;



    ProgressBar progressBar1;
    ProgressBar progressBar2;
    ProgressBar progressBar3;
    ProgressBar progressBar4;

    private static final String TAG = "Vishwas";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_third, container, false);
        mAuth = FirebaseAuth.getInstance();


        progressBar1 = view.findViewById(R.id.progressBar1);
        progressBar2 = view.findViewById(R.id.progressBar2);
        progressBar3 = view.findViewById(R.id.progressBar3);
        progressBar4 = view.findViewById(R.id.progressBar4);

        GetAccountInformation();

        return view;




    }
    public void GetAccountInformation() {


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

                    centuryValue = fetchedValues.get("century");
                    coinsValue = fetchedValues.get("coins");
                    matchesValue = fetchedValues.get("matches");
                    maxValue = fetchedValues.get("max");
                    sixesValue = fetchedValues.get("sixes");
                    matchesWonValue = fetchedValues.get("won");

                    progressBar1.setProgress(Integer.parseInt(matchesValue));
                    progressBar2.setProgress(Integer.parseInt(matchesWonValue));
                    progressBar3.setProgress(Integer.parseInt(centuryValue));
                    progressBar4.setProgress(Integer.parseInt(sixesValue));



                } else {
                    Log.d(TAG, "No such document");
                }
            } else {
                Log.d(TAG, "get failed with ", task.getException());
            }
        });


    }

}