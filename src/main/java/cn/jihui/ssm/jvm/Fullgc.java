package cn.jihui.ssm.jvm;

import java.util.Vector;

public class Fullgc {
    private static final int  SIZE = 1024*1024*300;
    public static void main(String[] args) {
//        Byte[] bytes = instanceBig();
        Vector v = new  Vector( 10 );
        for  ( int  i = 1 ;i < 10000 ; i ++ ){
            Object o = new  Object();
            v.add(o);
            o = null ;
        }



    }


    public static Byte[]   instanceBig(){
        Byte[]  by = new Byte[SIZE];
        return by;
    }



}
