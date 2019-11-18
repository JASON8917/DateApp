package com.example.android_project;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<ItemData> itemDataList;
    private static View.OnClickListener onClickListener;

    // 뷰홀더 가져온 이유는 메모리 관리 효울적으로 해주는 클래스 사용하기위해
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView preview_name;
        public TextView preview_residence;
        public TextView preview_age;
        public SimpleDraweeView preview_image;
        public View rootView;

        public ItemViewHolder(View v) {
            super(v);
            // id 찾을때는 부모에서 찾기
            preview_name = v.findViewById(R.id.preview_name);
            preview_residence = v.findViewById(R.id.preview_residence);
            preview_age = v.findViewById(R.id.preview_age);
            preview_image = v.findViewById(R.id.preview_image);
            rootView = v;
            v.setClickable(true);
            v.setEnabled(true);
            v.setOnClickListener(onClickListener);
        }
    }

    // 홀더 메서드는 이 데이터 셋의 길이만큼 돌아간다
    // Provide a suitable constructor (depends on the kind of dataset)
    public ItemAdapter(List<ItemData> itemset, Context context, View.OnClickListener onClick) {
        itemDataList = itemset;
        onClickListener = onClick;
        Fresco.initialize(context);
    }

    // 하나의 피드을 연결해주는 코드
    // Create new views (invoked by the layout manager)
    @Override
    public ItemAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        // 통째로가 아닌 특정 한 부분을 연결해주고 싶을때는 inflate, 부모를 연결해준다
        ItemViewHolder vh = new ItemViewHolder(v);
        return vh;
    }

    // 반복할 때마다 데이터를 바인딩해주는 함수
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        ItemData item = itemDataList.get(position);
        holder.preview_age.setText(item.getAge());
        holder.preview_name.setText(item.getName());
        holder.preview_residence.setText(item.getResidence());

        //Uri uri = Uri.parse(item.getUrlToImage());
        //holder.preview_image.setImageURI(uri);
        holder.preview_image.setImageResource(R.drawable.bonobono);

        holder.rootView.setTag(position);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return itemDataList == null ? 0 : itemDataList.size();
    }
    public  ItemData getItem(int position){
        return itemDataList != null ? itemDataList.get(position) : null;
    }
}