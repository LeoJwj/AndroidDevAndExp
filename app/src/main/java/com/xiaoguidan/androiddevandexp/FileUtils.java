package com.xiaoguidan.androiddevandexp;

import android.content.Context;
import android.text.TextUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Administrator on 2016/8/4.
 */
public class FileUtils {

    /**
     * 递归创建父目录
     *
     * @param
     * @return
     */
    public static boolean makeDir(File file) {
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }

    /**
     * 通过Serializable存储数据
     *
     * @param object
     * @param filename
     * @param context
     */

    public static void saveDataBySerializable(Object object, String filename, Context context) {
        ObjectOutputStream objectOutputStream = null;
        String path = getFilePath(context, filename);
        try {
            File file = new File(path);
            if (file != null) {
                if (!file.exists()) {
                    if (createFile(file) != null) {
                        objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
                        objectOutputStream.writeObject(object);
                    }
                } else {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
                    objectOutputStream.writeObject(object);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过Serializable来拿本地数据
     * @param fileName
     * @param context
     * @return
     */
    public static Object getDataBySerializable(String fileName, Context context) {
        ObjectInputStream objectInputStream = null;
        Object object = null;
        String filePath = getFilePath(context, fileName);
        if (TextUtils.isEmpty(filePath)) {
            return null;
        }
        File file = new File(filePath);
        if (file.exists()) {
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
                object = objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return object;
    }

    public static File createFile(File file) {
        try {
            if (!file.exists()) {
                makeDir(file.getParentFile());
                if (file.createNewFile())
                    return file;
            }
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFilePath(Context context, String filename) {
        if (context == null || TextUtils.isEmpty(filename)) {
            return "";
        }
        return context.getCacheDir().getAbsolutePath() + File.separator + "test" + File.separator + filename;
    }
}
