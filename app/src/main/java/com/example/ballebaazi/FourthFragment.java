package com.example.ballebaazi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static com.google.android.gms.tasks.Tasks.await;


public class FourthFragment extends Fragment {

    public String currentUserId;
    private FirebaseAuth mAuth;

    String coinsValue;
    String matchesValue;
    String matchesWonValue;
    String centuryValue;
    String sixesValue;
    String maxValue;



    TextView textCoin;
    TextView textScore;
    ImageView imageview;


    private static final String TAG = "Vishwas";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        final View view = inflater.inflate(R.layout.fragment_fourth, container, false);
        mAuth = FirebaseAuth.getInstance();
        textCoin = view.findViewById(R.id.textCoins);
        textScore = view.findViewById(R.id.textScore);
        imageview = view.findViewById(R.id.imageView7);
        imageview.setOnClickListener(v -> shareViaWhatsApp());
        GetAccountInformation();

        return view;

    }

    public void shareViaWhatsApp() {
        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.setType("text/plain");
        whatsappIntent.setPackage("com.whatsapp");
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, "Hey there, checkout this game Balle Baazi, I challenge you to score more than my " + maxValue +" !" +

                " Simple yet an amazing game to play with your friends.Playing hand cricket is fun. This is a BalleBaazi , the hand cricket game built using Java and Firebase. " +
                " Visit www.rooloo.in/ballebaazi to download the apk! :)");
        try {
            requireActivity().startActivity(whatsappIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=com.whatsapp")));
        }
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
                    Log.d(TAG, "Coins data: " + coinsValue);


                    matchesValue = fetchedValues.get("matches");
                    maxValue = fetchedValues.get("max");
                    Log.d(TAG, "Coins data: " + maxValue);


                    textCoin.setText(coinsValue);


                    textScore.setText(maxValue);




                } else {
                    Log.d(TAG, "No such document");
                }
            } else {
                Log.d(TAG, "get failed with ", task.getException());
            }
        });


    }
}