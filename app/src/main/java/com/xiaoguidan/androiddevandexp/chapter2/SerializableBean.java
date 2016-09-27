package com.xiaoguidan.androiddevandexp.chapter2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/4.
 */
public class SerializableBean implements Serializable {

    //不手动定义UID，如果增加或者删除某个变量，系统会重新计算当前类的hash值并把这个值赋给serialVersionUID。这就会导致在反序列话时报EOFException异常
    private static final long serialVersionUID = 1048227314170633824L;
    public String name;
    public String age;

    public SerializableBean(String name,String age){
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
//      重写writeObject和readObject。ObjectOut(In)putStream不会调用默认的方法，会直接调用重写的方法。
//      ObjectOut(In)Stream通过反射的方式，获取到这两个方法。
//      ObjectOut(In)Stream使用了getPrivateMethod来获取方法。所以必须定义为私有方法

//    private void writeObject(ObjectOutputStream oos) throws IOException {
//        oos.defaultWriteObject();
//        oos.writeInt(data);
//        System.out.println("session serialized");
//    }
//
//    private void readObject(ObjectInputStream ois) throws IOException,
//            ClassNotFoundException {
//        ois.defaultReadObject();
//        data = ois.readInt();
//        activationTime = System.currentTimeMillis();
//        System.out.println("session deserialized");
//    }

}
