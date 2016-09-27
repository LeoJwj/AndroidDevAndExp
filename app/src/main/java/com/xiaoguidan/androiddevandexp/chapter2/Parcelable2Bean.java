package com.xiaoguidan.androiddevandexp.chapter2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2016/8/4.
 */
public class Parcelable2Bean implements Parcelable {

    public String name;
    public int age;

    public Parcelable2Bean(String name,int age){
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    protected Parcelable2Bean(Parcel in) {
        this.age = in.readInt();
        this.name = in.readString();
    }

    public static final Creator<Parcelable2Bean> CREATOR = new Creator<Parcelable2Bean>() {
        @Override
        public Parcelable2Bean createFromParcel(Parcel in) {
            return new Parcelable2Bean(in);
        }

        @Override
        public Parcelable2Bean[] newArray(int size) {
            return new Parcelable2Bean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(parcel.readInt());
        parcel.writeString(parcel.readString());
    }
}
