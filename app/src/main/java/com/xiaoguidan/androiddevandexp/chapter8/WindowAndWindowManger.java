package com.xiaoguidan.androiddevandexp.chapter8;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.xiaoguidan.androiddevandexp.R;

public class WindowAndWindowManger extends AppCompatActivity implements View.OnClickListener {

    Button createWindowBtn;
    WindowManager mWindowManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window_and_window_manger);
        createWindowBtn = (Button) findViewById(R.id.create_window_btn);
        mWindowManager = (WindowManager) WindowAndWindowManger.this.getSystemService(Context.WINDOW_SERVICE);
        createWindowBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)  throws ArithmeticException {
        final ImageView icon = new ImageView(this);
        icon.setBackgroundDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
        final WindowManager.LayoutParams mLayoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT,8,0, PixelFormat.TRANSPARENT);
        // | 与或符号？
        mLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
        mLayoutParams.gravity = Gravity.LEFT | Gravity.TOP;
        mLayoutParams.x = 200;
        mLayoutParams.y = 300;
        try {
            int i = 5/0;
        }catch (Exception e){
            e.printStackTrace();
        }
        
        mWindowManager.addView(icon, mLayoutParams);
        icon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_MOVE:
                        mLayoutParams.x = rawX;
                        mLayoutParams.y = rawY;
                        mWindowManager.updateViewLayout(icon,mLayoutParams);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

    }
}
