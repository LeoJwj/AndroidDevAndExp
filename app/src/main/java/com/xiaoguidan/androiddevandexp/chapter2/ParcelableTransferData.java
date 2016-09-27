package com.xiaoguidan.androiddevandexp.chapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaoguidan.androiddevandexp.R;

public class ParcelableTransferData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable_transfer_data);
        ParcelableBean parcelableBean = (ParcelableBean) getIntent().getExtras().get("parcelable");
    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }
}
