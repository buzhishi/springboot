package cn.jihui.ssm.computer;

import org.springframework.transaction.jta.UserTransactionAdapter;

public class LruTest {
    public static void main(String[] args) {
        int f = (int) Math.ceil(3 / 0.75) + 1;
        System.out.println(f);
        MyLru<String,Integer> lru=new MyLru<>(3);
        for(int i=0;i<50;i++) {
            lru.put("aa"+i, i);
            lru.print();
        }


    }
}
