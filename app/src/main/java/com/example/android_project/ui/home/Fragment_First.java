package com.example.android_project.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.android_project.ItemAdapter;
import com.example.android_project.ItemData;
import com.example.android_project.R;
import com.example.android_project.TestActivity;

import java.util.ArrayList;
import java.util.List;

public class Fragment_First extends Fragment {
    ViewPager viewPager;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public Fragment_First(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        // item recycler and adapter


        // connect the item to adapter
        recyclerView = view.findViewById(R.id.recyclerview_main);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        getItem();


        return view;

    }
    public void getItem() {

        // specify an adapter (see also next example)
        // Adapter 는 가공된 item data 전체를 포함. Adapter 만들기
        // 눌렀을 때 반응하기 위해 adapter 에 click listener 추가
        List<ItemData> item = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemData itemData = new ItemData();
            itemData.setAge(Integer.toString(i) + "살");
            itemData.setName("보노보노" + Integer.toString(i));
            itemData.setResidence("서울");
            itemData.setUrlToImage("empty");
            item.add(itemData);
        }

        mAdapter = new ItemAdapter(item, getActivity(), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getTag() != null) {
                    int position = (int) v.getTag();
                    Intent intent = new Intent(getActivity(), TestActivity.class);
                    intent.putExtra("item", ((ItemAdapter) mAdapter).getItem(position));
                    startActivity(intent);
                }
            }
        });

        recyclerView.setAdapter(mAdapter);

    }
    }