package com.noura.anwar.new4shop.Adapter;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.noura.anwar.new4shop.Moodle.AboutModel;
import com.noura.anwar.new4shop.R;

import java.util.ArrayList;
import java.util.List;

public class AboutPagerAdapter extends PagerAdapter {
    private ArrayList<AboutModel>imageModelArrayList;
    private LayoutInflater inflater ;
    private Context context ;
    private boolean isAds = false;

    public AboutPagerAdapter(  Context context,ArrayList<AboutModel>imageModelArrayList) {
        this.context = context;
        this.imageModelArrayList = imageModelArrayList;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return imageModelArrayList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View imageLayout = null;
        if(!isAds){
        imageLayout = inflater.inflate(R.layout.sliding_image ,container ,false );
        assert imageLayout !=null;
        final ImageView imageView = imageLayout.findViewById(R.id.FScreen_img);
            TextView tvTittle = imageLayout.findViewById(R.id.about_title);
            TextView tvDesc = imageLayout.findViewById(R.id.about_description);
            imageView.setImageResource(imageModelArrayList.get(position).getImageIcon());
            tvTittle.setText(imageModelArrayList.get(position).getTitle());
            tvDesc.setText(imageModelArrayList.get(position).getDescription());

//        }else {
//            imageLayout =


        }
        container.addView(imageLayout,0);
        return imageLayout;
    }

    public void isAds(boolean isAds){
        this.isAds = isAds;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(@Nullable Parcelable state, @Nullable ClassLoader loader) {

    }

    @Nullable
    @Override
    public Parcelable saveState() {
        return null;
    }
}