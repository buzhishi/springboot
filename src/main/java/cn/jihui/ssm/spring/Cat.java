package cn.jihui.ssm.spring;

public class Cat implements Animals{
   void miaomiaomiao(){};

   @Override
   public String toString() {
      return "Cat{}";
   }

   public String v1() {
      return "v1";
   }

}
