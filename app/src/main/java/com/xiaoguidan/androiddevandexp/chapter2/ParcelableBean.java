package com.xiaoguidan.androiddevandexp.chapter2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/4.
 */
public class ParcelableBean implements Parcelable {

    public String name;
    public int age;
    public Parcelable2Bean parcelable2Bean;
    public SerializableBean serializableBean;
    public List<Parcelable2Bean> parcelable2BeanList;
    public List<SerializableBean> serializableBeanList;

    public ParcelableBean(String name, int age, Parcelable2Bean parcelable2Bean,
                          SerializableBean serializableBean, ArrayList<Parcelable2Bean> parcelable2BeanList,
                          ArrayList<SerializableBean> serializableBeanList) {
        this.age = age;
        this.name = name;
        this.parcelable2Bean = parcelable2Bean;
        this.serializableBean = serializableBean;
        this.parcelable2BeanList = parcelable2BeanList;
        this.serializableBeanList = serializableBeanList;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected ParcelableBean(Parcel in) {
        age = in.readInt();
        name = in.readString();
        parcelable2Bean = in.readParcelable(Thread.currentThread().getContextClassLoader());
        serializableBean = (SerializableBean) in.readSerializable();
        serializableBeanList = in.readArrayList(SerializableBean.class.getClassLoader());
        parcelable2BeanList = in.createTypedArrayList(Parcelable2Bean.CREATOR);
    }

    public Parcelable2Bean getParcelable2Bean() {
        return parcelable2Bean;
    }

    public void setParcelable2Bean(Parcelable2Bean parcelable2Bean) {
        this.parcelable2Bean = parcelable2Bean;
    }

    public static final Creator<ParcelableBean> CREATOR = new Creator<ParcelableBean>() {
        @Override
        public ParcelableBean createFromParcel(Parcel in) {
            return new ParcelableBean(in);
        }

        @Override
        public ParcelableBean[] newArray(int size) {
            return new ParcelableBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(age);
        parcel.writeString(name);
        parcel.writeParcelable(parcelable2Bean, 0);
        parcel.writeSerializable(serializableBean);
        parcel.writeList(serializableBeanList);
        parcel.writeList(parcelable2BeanList);
    }
}
