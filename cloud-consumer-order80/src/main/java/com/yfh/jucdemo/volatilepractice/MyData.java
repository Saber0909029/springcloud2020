package com.yfh.jucdemo.volatilepractice;

/**
 * Volatile Java虚拟机提供的轻量级同步机制
 *
 * 可见性（及时通知）
 * 不保证原子性
 * 禁止指令重排
 *
 * @author: 陌溪
 * @create: 2020-03-09-15:58
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 假设是主物理内存
 */
class MyData {

    /**可见性测试
    volatile增强了主内存和各线程之间的可见性，只要有一个线程改了主内存的值，
     其他线程马上获得通知，迅速获得最新值。
     */
    volatile int number = 0;


    public void addTo60() {
        this.number = 60;
    }

    /**
     * 原子性测试
     *  创建一个原子Integer包装类，默认为0
     */
    AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * 注意，此时number 前面是加了volatile修饰
     */
    public void addPlusPlus() {
        number ++;
    }

    public void addAtomic() {
        // 相当于 atomicInter ++
        atomicInteger.getAndIncrement();
    }





}

