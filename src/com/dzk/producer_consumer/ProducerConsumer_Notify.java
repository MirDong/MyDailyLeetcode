package com.dzk.producer_consumer;

import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer_Notify {
    private static Object mLock = new Object();
    private static final int MAX_CAPACITY = 10;
    private  static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Producer(),"producer_" + i).start();
            new Thread(new Consumer(),"consumer_" + i).start();
        }
    }


    static class Producer extends Thread {
        @Override
        public void run() {
            synchronized (mLock){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (count.get() == MAX_CAPACITY){
                    try {
                        mLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int produceCount = count.incrementAndGet();
                System.out.println(String.format("%s:生产者生产,总共有%d个",Thread.currentThread().getName(),produceCount));
                mLock.notifyAll();
            }
        }
    }


    static class Consumer extends Thread {
        @Override
        public void run() {
            synchronized (mLock){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (count.get() == 0){
                    try {
                        mLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int consumerCount = count.decrementAndGet();
                System.out.println(String.format("%s:消费者消费,总共有%d个",Thread.currentThread().getName(),consumerCount));
                mLock.notifyAll();
            }
        }
    }
}
