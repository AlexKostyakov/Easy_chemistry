package com.example.easy_chemistry.Adapters;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class MyImageAdapter extends PagerAdapter {
    private List<Bitmap> bitmapList;

    public MyImageAdapter(List<Bitmap> bitmapList) {
        this.bitmapList = bitmapList;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(container.getContext());
        imageView.setImageBitmap(bitmapList.get(position));
        container.addView(imageView);
        return imageView;

    }


    @Override
    public int getCount() {
        return bitmapList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}