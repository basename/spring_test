package com.basename.threds;

import java.util.LinkedList;
import java.util.Queue;

public class Task {

    Queue<Integer> queue = new LinkedList<>();

    public synchronized void addTask(Integer integer){
        this.queue.add(integer);
        this.notify();
    }

    public synchronized int getTask(){
        while (queue.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.queue.remove();
    }
}
