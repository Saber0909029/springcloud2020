package com.yfh.jucdemo.volatilepractice;

import java.util.concurrent.TimeUnit;

public class VolatileVisibilityDemo {

    public static void main(String[] args) {


        MyData myData = new MyData();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "\t come in~");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myData.addTo60();
                System.out.println(Thread.currentThread().getName() + "\t update value~" + myData.number);
            }
        }, "A").start();

        while (myData.number == 0) {

        }

        System.out.println(Thread.currentThread().getName() + "\t mission over~");

    }


}
