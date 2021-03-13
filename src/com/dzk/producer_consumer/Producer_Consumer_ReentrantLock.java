package com.dzk.producer_consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用可重入锁实现生产消费者模型
 */
public class Producer_Consumer_ReentrantLock {
    private final int MAX_CAPACITY = 10;
    private int count = 0;
    private Lock lock = new ReentrantLock();
    private final Condition nonFull = lock.newCondition();
    private final Condition nonEmpty = lock.newCondition();
    public static void main(String[] args) {
        Producer_Consumer_ReentrantLock producerConsumer = new Producer_Consumer_ReentrantLock();
        producerConsumer.runModel();
    }

    private void runModel(){
        for (int i = 0; i < 5; i++) {
            new Thread(new Producer(),"thread-producer-" + i).start();
            new Thread(new Consumer(),"thread-consumer-" + i).start();
        }
    }


    class Producer implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                if (count == MAX_CAPACITY){
                    try {
                        nonFull.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count++;

                System.out.println(String.format("%s生产者生产，容器中总共有%d",Thread.currentThread().getName(),count));
                nonEmpty.signal();
            }finally {
                lock.unlock();
            }
        }
    }


    class Consumer implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.lock();
            try {
                if (count == 0){
                    try {
                        nonEmpty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count--;
                System.out.println(String.format("%s消费者消费，容器中总共有%d",Thread.currentThread().getName(),count));
                nonFull.signal();
            }finally {
                lock.unlock();
            }
        }
    }
}
