package cn.jihui.ssm.java8;

public interface Animals {

    void run();


    default void  eat(){
        System.out.println("什么都吃");
    }
}
