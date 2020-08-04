package cn.jihui.ssm.java8.lamb;

import cn.jihui.ssm.java8.Animals;
import cn.jihui.ssm.java8.Cat;
import cn.jihui.ssm.java8.Tiger;
import junit.framework.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class OperTest {
    public static void main(String[] args) {
        System.out.println(oper(1,3,(Integer o1,Integer o2)-> o1 * o2 ));
        System.out.println(oper(1,3,(o1,o2)-> o1 + o2 ));
        System.out.println(oper(1,3,(o1,o2)-> o1 - o2 ));
        System.out.println(oper(6,3,(o1,o2)-> o1 / o2 ));
        List<? extends Animals> animal;

        animal = new ArrayList<Tiger>();
        animal = new ArrayList<Animals>();



        /**
         *
         * predicate
         *
         */
        List<String> list = Arrays.asList("aaa", "bbb", "dsf", "dsasfq", "aafef");
        List<String> filterList = filter(list,  (String t) -> t.indexOf("a") >-1);
        filterList.forEach(obj-> System.out.println(obj));


        /**
         *
         */
        List<? super Cat> objects = listNew(() -> new ArrayList<>());

        List<? extends Cat> cats = listNew1(() -> new ArrayList<>());



        String content = "一道美丽的风景";
        Function<Integer, String> fuction = content::substring;
        System.out.println(fuction.apply(1));

        sayHello(String::toUpperCase,"xljdflsfsdf");

    }


    public static Integer  oper(Integer o1,Integer o2,OperFunction<Integer,Integer> of){
        return  of.operator(o1,o2);
    }


    /**
     *
     * super 表示下限，只能new 自己 或者父类
     * 插入可以插入自己的子类
     *
     * @param fun
     * @return
     */
    public static List<? super Cat>  listNew(ListNewFunction<? super Cat> fun){
        return  fun.listNew();
    }

    /**
     *
     * extends 表示上限  可以new 自己和 父类
     * 无法插入
     *
     * @param fun
     * @return
     */
    public static List<? extends Cat>  listNew1(ListNewFunction<? extends Cat> fun){
        return  fun.listNew();
    }

    public static <T> List<T> filter(List<T> list, Predicate<? super T> predicate){
        List<T> results = new ArrayList<>();
        list.forEach(str -> {
            if(predicate.test(str)){
                results.add(str);
            }
        });
        return results;
    }

    public static  void  sayHello(Function<String,String> func,String  strings){
        String apply = func.apply(strings);
        System.out.println(apply);
    }

}
