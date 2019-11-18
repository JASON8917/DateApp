package com.example.android_project.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.android_project.R;

import java.util.ArrayList;

public class Fragment_Fifth extends Fragment {

    public static ViewPager viewPager;

    public Fragment_Fifth(){

    }

    //awesomePager.setCurrentItem(CurrentPosition);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getChildFragmentManager());
        View view = inflater.inflate(R.layout.fragment_fifth,container,false);

        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(fragmentAdapter);


        viewPager.setClipToPadding(false);
        int dpValue = 30;
        float d = getResources().getDisplayMetrics().density;
        int margin = (int) (dpValue * d);
        viewPager.setPadding(margin, 0, margin, 0);
        viewPager.setPageMargin(margin/2);

        ArrayList<Integer> listImage = new ArrayList<>();
        listImage.add(R.drawable.fragment_image1);
        listImage.add(R.drawable.fragment_image2);
        listImage.add(R.drawable.fragment_image3);
        listImage.add(R.drawable.fragment_image4);

        for (int i = 0; i < listImage.size(); i++) {
            Fragment_Image imageFragment = new Fragment_Image();
            Bundle bundle = new Bundle();
            bundle.putInt("imgRes", listImage.get(i));
            imageFragment.setArguments(bundle);
            fragmentAdapter.addItem(imageFragment);
        }
        fragmentAdapter.notifyDataSetChanged();
        return view;
    }
}