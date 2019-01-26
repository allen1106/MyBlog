package cn.allen.dreamsanreal.practice;


import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ThreadSingleton implements Serializable {
    private static ThreadSingleton instance;

    private ThreadSingleton() {}

    public synchronized static ThreadSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSingleton();
        }
        return instance;
    }

    protected Object readResolve() {
        return getInstance();
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        ThreadSingleton ts = ThreadSingleton.getInstance();
        System.out.println("==>" + Thread.currentThread() + "==>" + ts);
    }
}

public class SingletonTest {

    public static void reflectTest() {
        ThreadSingleton ts = null;
        ts = ThreadSingleton.getInstance();
        ThreadSingleton ts1 = null;
        ThreadSingleton ts2 = null;
        ThreadSingleton ts3 = null;
        try {
            Class cls = Class.forName("cn.allen.dreamsanreal.practice.ThreadSingleton");
            try {
                ts1 = (ThreadSingleton)cls.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                try {
                    Constructor clsConstru = cls.getDeclaredConstructor();
                    clsConstru.setAccessible(true);
                    try {
                        ts3 = (ThreadSingleton) clsConstru.newInstance();
                    } catch (InstantiationException e1) {
                        e1.printStackTrace();
                    } catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                    } catch (InvocationTargetException e1) {
                        e1.printStackTrace();
                    }
                } catch (NoSuchMethodException e1) {
                    e1.printStackTrace();
                    try {
                        Method method = cls.getDeclaredMethod("getInstance");
                        try {
                            ts2 = (ThreadSingleton) method.invoke(cls);
                        } catch (IllegalAccessException e2) {
                            e1.printStackTrace();
                        } catch (InvocationTargetException e2) {
                            e1.printStackTrace();
                        }
                    } catch (NoSuchMethodException e2) {
                        e1.printStackTrace();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("ts: =======>");
        System.out.println(ts);
        System.out.println("ts1: =======>");
        System.out.println(ts1);
        System.out.println("ts2: =======>");
        System.out.println(ts2);
        System.out.println("ts3: =======>");
        System.out.println(ts3);
    }

    public static  void serializeInstance () {
        ThreadSingleton ts = ThreadSingleton.getInstance();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("instance"));
            oos.writeObject(ts);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void serializeTest() {
        System.out.println("=======>");
        File instanceFile = new File("instance");
        FileInputStream fileStream = null;
        ObjectInputStream objStream = null;
        ThreadSingleton ts = null;
        try {
            fileStream = new FileInputStream(instanceFile);
            objStream = new ObjectInputStream(fileStream);
            ts = (ThreadSingleton) objStream.readObject();

            ThreadSingleton ts2 = ThreadSingleton.getInstance();
            System.out.println(ts);
            System.out.println(ts2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fileStream.close();
                objStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void multiThreadTest() {

        MyThread[] mts = new MyThread[10];
        for (int i = 0; i < mts.length; i++) {
            mts[i] = new MyThread();
        }

        for (int i = 0; i < mts.length; i++) {
            mts[i].start();
        }
    }

    public static void main(String[] args) {
//        ReflectTest.test();

        serializeInstance();
        serializeTest();

//        multiThreadTest();
    }
}
