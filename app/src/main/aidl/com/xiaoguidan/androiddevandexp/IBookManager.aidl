// IBookManager.aidl
package com.xiaoguidan.androiddevandexp;

// Declare any non-default types here with import statements
import com.xiaoguidan.androiddevandexp.Book;
interface IBookManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);


    List<Book> getBookList();
    void addBook(in Book book);
}

/*
http://blog.csdn.net/sun971782067/article/details/49494577  aidl详解以及注意事项

http://blog.csdn.net/wuyuxing24/article/details/46948961   Android Studio AIDL 自定义类型找不到问题




package com.xiaoguidan.androiddevandexp;

public interface IBookManager extends android.os.IInterface {

    public static abstract class Stub extends android.os.Binder implements com.xiaoguidan.androiddevandexp.IBookManager {

        Binder的唯一标示，一般是当前Binder的类名
        private static final java.lang.String DESCRIPTOR = "com.xiaoguidan.androiddevandexp.IBookManager";


        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        用于将服务端的Binder对象转换成客户端所需的AIDL接口类型的对象，这种转换过程区分进程的，如果客户端和服务端位于同一个进程，
        那么此方法返回的就是服务端的stub对象本身，否则返回的是系统封装后的Stub.proxy对象
        public static com.xiaoguidan.androiddevandexp.IBookManager asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            同一个进程的话DESCRIPTOR是一样的，否则是不一样的。
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof com.xiaoguidan.androiddevandexp.IBookManager))) {
                return ((com.xiaoguidan.androiddevandexp.IBookManager) iin);
            }
            系统封装后的Stub.proxy对象
            return new com.xiaoguidan.androiddevandexp.IBookManager.Stub.Proxy(obj);
        }

        用于返回当前Binder对象
        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        这个方法是运行在服务端的Binder线程池中的，远程请求会通过系统底层封装好后交由次方法处理。
        code 用来区分是哪个目标方法
        data 目标方法所需的参数（如果有的话）
        reply 目标方法返回值（如果有的话）
        如果返回false就是客户端请求失败，可以用这个来做权限验证。
        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_basicTypes: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    long _arg1;
                    _arg1 = data.readLong();
                    boolean _arg2;
                    _arg2 = (0 != data.readInt());
                    float _arg3;
                    _arg3 = data.readFloat();
                    double _arg4;
                    _arg4 = data.readDouble();
                    java.lang.String _arg5;
                    _arg5 = data.readString();
                    this.basicTypes(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getBookList: {
                    data.enforceInterface(DESCRIPTOR);
                    java.util.List<com.xiaoguidan.androiddevandexp.Book> _result = this.getBookList();
                    reply.writeNoException();
                    reply.writeTypedList(_result);
                    return true;
                }
                case TRANSACTION_addBook: {
                    data.enforceInterface(DESCRIPTOR);
                    com.xiaoguidan.androiddevandexp.Book _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = com.xiaoguidan.androiddevandexp.Book.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    this.addBook(_arg0);
                    reply.writeNoException();
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }



        private static class Proxy implements com.xiaoguidan.androiddevandexp.IBookManager {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                return mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }


            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, java.lang.String aString) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(anInt);
                    _data.writeLong(aLong);
                    _data.writeInt(((aBoolean) ? (1) : (0)));
                    _data.writeFloat(aFloat);
                    _data.writeDouble(aDouble);
                    _data.writeString(aString);
                    mRemote.transact(Stub.TRANSACTION_basicTypes, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            首先会从Parcel池里面拿到新的Parcel对象。分别分配给_data,_reply
            @Override
            public java.util.List<com.xiaoguidan.androiddevandexp.Book> getBookList() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.util.List<com.xiaoguidan.androiddevandexp.Book> _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getBookList, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(com.xiaoguidan.androiddevandexp.Book.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void addBook(com.xiaoguidan.androiddevandexp.Book book) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((book != null)) {
                        _data.writeInt(1);
                        book.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_addBook, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_basicTypes = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_getBookList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
        static final int TRANSACTION_addBook = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    }


    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, java.lang.String aString) throws android.os.RemoteException;

    public java.util.List<com.xiaoguidan.androiddevandexp.Book> getBookList() throws android.os.RemoteException;

    public void addBook(com.xiaoguidan.androiddevandexp.Book book) throws android.os.RemoteException;
}

*/
