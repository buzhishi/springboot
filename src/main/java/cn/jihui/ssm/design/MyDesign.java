package cn.jihui.ssm.design;

import java.util.LinkedHashMap;

public class MyDesign {
    public static void main(String[] args) throws CloneNotSupportedException {
        Object clone = new MyDesign().clone();
        System.out.println(clone instanceof MyDesign);

        new LinkedHashMap<>();
    }
}
