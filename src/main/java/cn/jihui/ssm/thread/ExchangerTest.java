package cn.jihui.ssm.thread;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Exchanger;

/**
 * Exchanger（交换机）可以实现两个线程在运行中，实
 * 现交换对象的效果，例如 A 线程和 B线程，在运行中，
 * 交换了信息，然后继续运行。先到达的线程会阻塞等待后来的线程，
 * 直到两个线程都到达交换机后，互换对象，再各自执行。
 *
 * 感觉有点像谍战片，两个特务在互换情报的感觉…
 *
 *
 *
 */

public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger= new Exchanger<>();
        String telegram1 = UUID.randomUUID().toString();
        String telegram2 = UUID.randomUUID().toString();
        new Thread(new Spy(exchanger,telegram1),"老鬼").start();
        new Thread(new Spy(exchanger,telegram2),"老枪").start();
    }
}
class Spy implements Runnable{
    Exchanger<String> exchanger ;
    String intelligence ;
    Spy(Exchanger<String> exchanger , String intelligence){
        this.exchanger = exchanger;
        this.intelligence = intelligence;
    }
    @Override
    public void run() {
        try {
            String name = Thread.currentThread().getName();
            System.out.println(name + "获得情报 : " + intelligence);
            System.out.println(name + "  ----->正在传递情报的路上");
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println(name + " 已经到达，等待对方交换情报");
            String exchange = exchanger.exchange(intelligence);
            System.out.println(name + "情报交换，获得情报" + exchange);
            System.out.println(name + "继续自己的工作......");
            //dosomething
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
