package com.example.easy_chemistry;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;


public class TableFragment extends Fragment {

    private ViewFlipper viewFlipper;
    private MyImageAdapter adapter;
    private List<Bitmap> imageList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_table, container, false);
        Button previous = view.findViewById(R.id.btn_previous);
        Button next = view.findViewById(R.id.btn_next);
        viewFlipper = view.findViewById(R.id.view_flipper);

        imageList.add(BitmapFactory.decodeResource(getResources(),R.drawable.al));

        previous.setOnClickListener(v -> {
            Log.d("previous", "onClick: ");
            viewFlipper.showPrevious();
        });
        next.setOnClickListener(v -> {
            Log.d("next", "onClick: ");
            viewFlipper.showNext();
        });
        adapter = new MyImageAdapter(imageList);
        ViewPager viewPager = new ViewPager(getContext());
        viewPager.setAdapter(adapter);
        viewFlipper.addView(viewPager);



        return view;
    }

    private void addImage(String imagePath) {
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        imageList.add(bitmap);
        adapter.notifyDataSetChanged();

    }


}