package cn.jihui.ssm.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service
@PropertySource(value = "")
public class TestService {
//    @Autowired
//    @Qualifier (value = "Cat")
  //  @Resource
    private  Animals animals;
    //    @Autowired
//    @Qualifier (value = "Cat")
    private Cat cat;


    public static void main(String[] args) {
        new  TestService().action();
    }

    public  void  action(){
        System.out.println(animals);
    }

    @PostConstruct
    public  void init(){
        System.out.println("我被初始化");
    }

    @PreDestroy
    public  void destroy(){
        System.out.println("我被销毁了");
    }
}
