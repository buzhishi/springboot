package cn.jihui.ssm.thread;

public class MyThread {
    private static final Object lock = new Object();
 3
         4    static  class ThreadA extends Thread{
 5         @Override
 6         public void run() {
            7             for (int i = 0; i < 100; i = i+2) {
                8                synchronized (lock){
                    9                    lock.notify();
                    10                    System.out.println(Thread.currentThread().getName()+" "+i);
                    11                    try {
                        12                        lock.wait();
                        13                    } catch (InterruptedException e) {
                        14                        e.printStackTrace();
                        15                    }
                    16
                    17                }
                18             }
            19         }
20
        21     }
22
        23     static  class ThreadB extends Thread{
24         @Override
25         public void run() {
            26             for (int i = 1; i < 100; i = i+2) {
                27                 synchronized (lock){
                    28                     lock.notify();
                    29                     System.out.println(Thread.currentThread().getName()+" "+i);
                    30                     try {
                        31                         lock.wait();
                        32                     } catch (InterruptedException e) {
                        33                         e.printStackTrace();
                        34                     }
                    35
                    36                 }
                37             }
            38         }
39
        40     }
41
        42     public static void main(String[] args) {
        43         new ThreadA().start();
        44         new ThreadB().start();
        45     }
}
}
