package com.example.easy_chemistry.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.easy_chemistry.R;


public class HomeFragment extends Fragment {
    private Button button;
    private static final String LOG_TAG = HomeFragment.class.getName();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;


    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        button = view.findViewById(R.id.rules);
        button.setOnClickListener(v -> {

            Log.d(LOG_TAG, "msg");
            rulesClass();
        });
    }
    private void rulesClass(){
        Log.d(LOG_TAG, "msg");
        Dialog dialog = new Dialog(getContext(), R.style.Dialog_Theme);
        dialog.setContentView(R.layout.rules_dialog);
        Button homeButton = dialog.findViewById(R.id.home_button1);
        homeButton.setOnClickListener(v -> {
            dialog.dismiss();
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, new HomeFragment());
            fragmentTransaction.commit();
        });
        dialog.show();
    }

}