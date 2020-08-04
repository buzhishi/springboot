package cn.jihui.ssm.thread;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Semaphore（信号量) ，可以限制同时只有N条线程进入某一段代码，
 * 或者限制只有N条线程同时执行。主要通过抢夺信号量来获得执行权，
 * 执行完之后交换信号量。
 * 一般用在保护某一段重要代码只能有几条线程执行，或者流量控制。
 *
 * 一个抢夺信号量的例子
 * Semaphore 在初始化的时候，还可以通过boolean值来配置是否公平策略，
 * 默认是不公平的。抢夺信号量的时候也可以指定抢多少个信号量。
 *
 *
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        System.out.println("某某生病了... 10条线程去探望他..可是一次只能有3条线程去探望他");
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(new Viewer(semaphore)).start();
        }
    }
}

class Viewer implements Runnable {

    Semaphore semaphore;

    Viewer(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            String name = Thread.currentThread().getName();
            semaphore.acquire(1); //获取一个信号量
            System.out.println(name + "  已获得探望资格 正在进行探望");
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println(name + "  探望结束 归还资格");
            semaphore.release(1); // 归还
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
