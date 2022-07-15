package com.soyokra.learn.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockFoo implements Runnable{

    // 非公平锁
    private final Lock lock = new ReentrantLock();

    // 公平锁
    private final Lock fairLock = new ReentrantLock(true);
    private int count;

    public void foo(int n) {
        lock.lock();
        try {
            count += n;
        } finally {
            lock.unlock();
        }
    }

    public void bar() throws InterruptedException {
        if (lock.tryLock(1, TimeUnit.SECONDS)) {
            try {
                // do-something
            } finally {
                lock.unlock();
            }
        } else {
            // do-something
        }
    }

    public void goo1() {
        lock.lock();
        count++;
        System.out.println(count);
        lock.unlock();
    }

    public void goo2() {
        lock.lock();
        count++;
        System.out.println(count);
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLockFoo reentrantLockFoo = new ReentrantLockFoo();
        Thread thread1 = new Thread(reentrantLockFoo);
        Thread thread2 = new Thread(reentrantLockFoo);
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        goo1();
        goo1();
        goo2();
    }
}
