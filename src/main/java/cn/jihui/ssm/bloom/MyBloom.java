package cn.jihui.ssm.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.ArrayList;

public class MyBloom {
    private static int size = 1000000;
    private static int size1 = 2000000;
    public static void main(String[] args) {
        BloomFilter bloomFilter = BloomFilter.create(Funnels.integerFunnel(),200000000,0);
        for (int i = 0; i < size; i++) {
            bloomFilter.put(i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = size; i < size1; i++) {
            if(bloomFilter.mightContain(i)){
               list.add(i);
            }
        }
        System.out.println("误判率："+(float)list.size()/size);
        System.out.println(list.size());

    }
}
