package cn.jihui.ssm.java8.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对于集合使用，不止list ,包括map等均可以
 *
 */
public class MyStream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        /**
         *
         * list.stream().map(obj->obj.toUpperCase()).collect(Collectors.toList());
         * 其中包含了像
         * map:数据转换
         * filter:做一些方法过滤
         * sorted ：用于排序
         * limit
         * sorted
         * allMatch
         *
         */
        list.stream().map(obj->obj.toUpperCase()).collect(Collectors.toList());
    }
}
