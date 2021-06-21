package com.example.ballebaazi;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;


public class SecondFragment extends Fragment {


    Intent intent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);


        ImageButton button = (ImageButton) view.findViewById(R.id.imageButton2);

        ImageButton batButton = (ImageButton) view.findViewById(R.id.imageButton3);

        button.setOnClickListener(v -> {
            intent = new Intent(getActivity(),TossPage.class);
            getActivity().startActivity(intent);
        });

        batButton.setOnClickListener(v -> {
            intent = new Intent(getActivity(),BattingMode.class);
            getActivity().startActivity(intent);
        });

        return view;


    }
}