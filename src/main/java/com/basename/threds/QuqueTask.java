package com.basename.threds;

public class QuqueTask implements Runnable{
    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       Task task = new Task();
       task.addTask(1);
    }
}
