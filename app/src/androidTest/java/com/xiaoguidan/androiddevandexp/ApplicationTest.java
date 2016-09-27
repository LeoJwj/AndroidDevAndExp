package com.xiaoguidan.androiddevandexp;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void test(){
        int a = 0x45;
        int b = 2;
        int c = a|b;
        Log.e("c",c+"");
    }
}