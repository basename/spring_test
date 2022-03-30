package com.basename.threds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StatTask {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<Integer> queue = new LinkedList<>();

    private Integer cout;

    public void add(Integer num){
        lock.lock();
        try {
            this.queue.add(num);
            condition.notify();
        }finally {
            lock.unlock();
        }
    }

    public Integer get(){
        lock.lock();

        try {
            while (this.queue.isEmpty()){
                try {
                    condition.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return  this.queue.remove();
        }finally {
            lock.unlock();
        }
    }
}
