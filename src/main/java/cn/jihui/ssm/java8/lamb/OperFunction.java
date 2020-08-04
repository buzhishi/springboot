package cn.jihui.ssm.java8.lamb;

import java.util.List;

@FunctionalInterface
public interface OperFunction<R,T> {

    R operator(T t1, T t2);

}
