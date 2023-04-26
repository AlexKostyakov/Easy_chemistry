package com.example.easy_chemistry;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewFlipper;


public class TableFragment extends Fragment {

    private ViewFlipper viewFlipper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_table,container,false);
        Button previous = view.findViewById(R.id.btn_previous);
        Button next = view.findViewById(R.id.btn_next);
        viewFlipper = view.findViewById(R.id.view_flipper);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("previous", "onClick: ");
                viewFlipper.showPrevious();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("next", "onClick: ");
                viewFlipper.showNext();
            }
        });
        return inflater.inflate(R.layout.fragment_table, container, false);
    }


}