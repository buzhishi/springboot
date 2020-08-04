package cn.jihui.ssm.thread;

import java.util.Timer;

public class MyThread {
    private static final  Object lock = new Object();
   static  class ThreadA extends Thread{
         @Override
       public void run() {
                        for (int i = 1; i < 100; i = i+2) {
                               synchronized (lock){
                                        lock.notify();
                                        System.out.println(Thread.currentThread().getName()+" "+i);
                                     try {
                                              lock.wait();
                                           } catch (InterruptedException e) {
                                               e.printStackTrace();
                                           }

                                   }
                           }
                  }

   }

             static  class ThreadB extends Thread{
        @Override
        public void run() {
                     for (int i = 2; i <= 100; i = i+2) {
                               synchronized (lock){
                                         lock.notify();
                                        System.out.println(Thread.currentThread().getName()+" "+i);
                                        try {
                                                lock.wait();
                                             } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }

                                    }
                             }
                     }

            }

            public static void main(String[] args) {
                new ThreadA().start();
                 new ThreadB().start();
             }
}

