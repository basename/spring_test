package com.basename.threds;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class TaskRunnable implements Runnable{
    private volatile  boolean running = true;
    private List<Integer> list = new ArrayList<>();

    @Override
    public void run() {
        Integer i = 0;
        while (running){
//            if (i >= 10000){
//                break;
//            }
            System.out.println("this is thread ---taskrunnable---"+i);
            i++;
        }

        for (int j = 0; j < 100; j++) {
            this.list.add(j);
        }
        return;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}