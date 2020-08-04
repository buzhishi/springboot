package cn.jihui.ssm.java8;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class Mylamb {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start...");
            }
        }).start();

        new Thread(()-> System.out.println("lamb start ...")).start();


        List<Integer> list = Arrays.asList(111, 333, 222, 444);



//        Collections.sort(list, new Comparator<Integer>() {
////            @Override
////            public int compare(Integer o1, Integer o2) {
////                return o1.compareTo(o2);
////            }
////        });

        Collections.sort(list,(o1,o2) -> o1.compareTo(o2));
        Collections.sort(list,Comparator.reverseOrder());
        list.sort(Comparator.reverseOrder());

        list.forEach(obj-> System.out.println("list:"+obj));

//        for (int num : list) {
//            System.out.println(num);
//        }

        List<String> list1 = Arrays.asList("111", "333", "222", "444");
        Collections.sort(list1,Comparator.reverseOrder());
        for (String num1 : list1) {
            System.out.println(num1);
        }


        Map<String, String> map = new LinkedHashMap<>();
        map.put("1","1211");
        map.put("3","33333");
        map.put("2","22222");
        List<String> entries = new ArrayList<>(map.keySet());
        entries.sort(Comparator.reverseOrder());
        entries.sort((o1,o2) -> o1.compareTo(o2));
        for (String num2 : entries) {
            System.out.println(num2);
        }
//        entries.sort((o1,o2) -> );
//        sortByKey(map);
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            String key = next.getKey();
            String value = next.getValue();
            System.out.println("{"+key+":"+value+"}");
        }

    }

    public static  <K extends Comparable<? super K>, V > Map<K, V> sortByKey(Map<K, V> map) {
        Map<K, V> result = new HashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.<K, V>comparingByKey()
                        .reversed()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        return result;
    }
}
