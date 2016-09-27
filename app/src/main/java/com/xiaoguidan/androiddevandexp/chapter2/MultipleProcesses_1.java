package com.xiaoguidan.androiddevandexp.chapter2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xiaoguidan.androiddevandexp.R;

public class MultipleProcesses_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_processes_1);
        ParcelableBean parcelableBean = getIntent().getExtras().getParcelable("parcelable");

    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }
}
