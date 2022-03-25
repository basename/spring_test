package com.basename.threds;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class TaskRunnable1 implements Runnable{

    private List<Integer> list = new ArrayList<>();

    @Override
    public void run() {
        Integer i = 0;
        while (true){
            if (i >= 10000){
                break;
            }
            System.out.println("this is thread =====taskrunnable====="+i);
            i++;
        }

        for (int j = 0; j < 100; j++) {
            list.add(j);
        }
        return;
    }

    public List<Integer> getList() {
        return list;
    }
}