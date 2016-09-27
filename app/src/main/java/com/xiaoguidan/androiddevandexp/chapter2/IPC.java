package com.xiaoguidan.androiddevandexp.chapter2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xiaoguidan.androiddevandexp.FileUtils;
import com.xiaoguidan.androiddevandexp.R;

import java.util.ArrayList;

public class IPC extends AppCompatActivity implements View.OnClickListener {

    Button button;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    private static final String fileName = "cache123.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button = (Button) findViewById(R.id.button);
        button2.setOnClickListener(this);
        button.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, MultipleProcesses_1.class);
                startActivity(intent);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(this, MultipleProcesses_2.class);
                startActivity(intent2);
                break;
            case R.id.button3:
                saveDate();
                break;
            case R.id.button4:
                getDate();
                break;
            case R.id.button5:
                Intent intent3 = new Intent(this, ParcelableTransferData.class);
                SerializableBean serializableBean = new SerializableBean("1", "1");
                Parcelable2Bean parcelable2Bean = new Parcelable2Bean("2", 1);
                ArrayList<SerializableBean> serializableBeanList = new ArrayList<SerializableBean>();
                ArrayList<Parcelable2Bean> parcelable2BeanList = new ArrayList<Parcelable2Bean>();
                for (int i = 0; i < 2; i++) {
                    SerializableBean serializableBean1 = new SerializableBean("2" + i, "2" + i);
                    serializableBeanList.add(serializableBean1);
                }
                for (int i = 0; i < 2; i++) {
                    Parcelable2Bean parcelable2Bean1 = new Parcelable2Bean("2" + i, i);
                    parcelable2BeanList.add(parcelable2Bean1);
                }
                ParcelableBean parcelableBean = new ParcelableBean("3", 3, parcelable2Bean, serializableBean, parcelable2BeanList, serializableBeanList);
                intent3.putExtra("parcelable", parcelableBean);
                startActivity(intent3);
                break;
        }
    }

    public void saveDate() {
        SerializableBean serializableBean = new SerializableBean("jiang", "24");
        FileUtils.saveDataBySerializable(serializableBean, fileName, this);
    }

    public void getDate() {
        FileUtils.getDataBySerializable(fileName, this);
    }

    //    @OnClick({R.id.button, R.id.button2})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.button:
//                break;
//            case R.id.button2:
//                break;
//        }
//    }
}
