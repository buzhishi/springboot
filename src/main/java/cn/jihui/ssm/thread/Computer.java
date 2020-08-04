package cn.jihui.ssm.thread;

import cn.jihui.ssm.java8.Cat;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.Callable;

public class Computer {
    private static  volatile int i=1;
    private static final Object lock = new Object();

    /**
     *
     * 启动两个线程, 一个输出 1,3,5,7…99,
     * 另一个输出 2,4,6,8…100
     * 最后 STDOUT 中按序输出 1,2,3,4,5…100
     */
    public static void main(String[] args)  {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    while (i%2>0){
                    try {
                        if(i>100){
                            lock.wait();
                        }
                        lock.notifyAll();
                        System.out.println(Thread.currentThread().getName() + ":"+i++);
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                }}
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){while (i%2==0){
                    try {
                        if(i>100){
                            lock.wait();
                        }
                        lock.notifyAll();
                        System.out.println(Thread.currentThread().getName() + ":"+i++);
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }}
        }).start();


       new Thread(String.valueOf(new Callable<String>(){

           @Override
           public String call() throws Exception {
               return "111111111111";
           }
       })).start();


    }



}
