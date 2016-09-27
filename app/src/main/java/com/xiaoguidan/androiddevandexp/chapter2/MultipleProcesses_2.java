package com.xiaoguidan.androiddevandexp.chapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaoguidan.androiddevandexp.R;

public class MultipleProcesses_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_processes_2);
    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }
}
