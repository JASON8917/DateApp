package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

public class TestActivity extends AppCompatActivity {
    private ItemData item;
    private SimpleDraweeView profile_image;
    private TextView profile_information;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        setComponent();
        getItemDetail();
        setItem();
    }
    public void setComponent() {
        profile_image = findViewById(R.id.profile_image);
        profile_information = findViewById(R.id.profile_information);
    }
    //이전 엑티비티에서 받아오는 인텐트
    public void getItemDetail() {
        Intent intent = getIntent();
        if(intent != null) {
            Bundle mBundle = intent.getExtras();

            Object obj = mBundle.get("item");
            if(obj != null && obj instanceof ItemData) {
                this.item = (ItemData) obj;
            }
        }
    }
    public void setItem() {
        if(this.item != null) {
            String url = this.item.getUrlToImage();
            if(url != null) {
                profile_image.setImageResource(R.drawable.bonobono);
            }
            String information = this.item.getAge() + " / " + this.item.getName() + " / " + this.item.getResidence();
            if(information != null) {
                //전체 본문은 url 값의 실제 뉴스 사이트에 있으며, 해당 전체 본문을 불러오기 위해서는 스크래핑 (크롤링) 기술로 읽어와야 합니다.
                profile_information.setText(information);
            }
        }
    }
}
