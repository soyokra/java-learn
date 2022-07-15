package com.soyokra.learn.lock;

// synchronized
public class SynchronizedFoo implements Runnable  {

    private static Integer fooCount = 0;

    private static Integer barCount = 0;

    // 对象级
    public synchronized void foo() {
        fooCount++;
        System.out.println("foo: " + fooCount);
    }

    public void foo1() {
        synchronized(this) {
            System.out.println("foo1");
        }
    }

    // 类级
    public static synchronized void bar() {
        barCount++;
        System.out.println("bar: " + barCount);
    }

    public void bar1() {
        synchronized (SynchronizedFoo.class) {
            System.out.println("bar1");
        }
    }

    public void boo() {
        Integer x = 1;
        synchronized(x) {
            System.out.println("boo");
        }
    }

    public static void main(String[] args) {
        SynchronizedFoo synchronizedFoo1 = new SynchronizedFoo();
        SynchronizedFoo synchronizedFoo2 = new SynchronizedFoo();

        Thread thread1 = new Thread(synchronizedFoo1);
        Thread thread2 = new Thread(synchronizedFoo2);
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        // 线程不安全
        foo();

        // 线程安全
        bar();
    }
}
