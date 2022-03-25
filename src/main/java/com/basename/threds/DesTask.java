package com.basename.threds;

public class DesTask implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (Counter.lock){
                Counter.count--;
            }
        }
    }
}
