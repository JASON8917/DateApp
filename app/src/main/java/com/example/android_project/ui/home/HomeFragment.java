package com.example.android_project.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.android_project.*;
import com.example.android_project.MainActivity;
import com.example.android_project.R;
import com.example.android_project.TestActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeViewModel homeViewModel;
    private ViewPager mViewPager;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        SectionPageAdapter adapter = new SectionPageAdapter(getChildFragmentManager());

        mViewPager = (ViewPager) root.findViewById(R.id.container);
        setupViewPager(mViewPager, adapter);

        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



        return root;
    }





    public void setupViewPager(ViewPager viewPager, SectionPageAdapter adapter) {
        adapter.addFragment(new Fragment_First(), "오늘의카드");
        adapter.addFragment(new Fragment_Second(), "초이스");
        adapter.addFragment(new Fragment_Third(), "라이브");
        adapter.addFragment(new Fragment_Fourth(), "모든카드");
        adapter.addFragment(new Fragment_Fifth(), "놀이터");
        viewPager.setAdapter(adapter);
    }

}