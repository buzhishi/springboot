package cn.jihui.ssm.test;

import cn.jihui.ssm.ApplicationConfig;
import cn.jihui.ssm.domain.Employee;
import cn.jihui.ssm.mapper.EmployeeMapper;
import cn.jihui.ssm.service.IEmployeeService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class)
public class MyBootTest {
    Logger logger = LoggerFactory.getLogger(MyBootTest.class);

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;


    @Test
    public void  test(){
        logger.trace("这是一个trace");
        logger.debug("这是一个debug");
        logger.info("这是一个info");
        logger.warn("这是一个warn");
        logger.error("这是一个error");
    }

    @Test
    public void  test2(){
        List<Employee> employeeList =employeeService.selectAll();
        for (Employee  employee:employeeList
             ) {
            logger.info(employee.toString());
        }
       
    }

    @Test
    public void  test3(){
        String userName =employeeMapper.selectUserName("000111");
        logger.info(userName);
    }



    @Test
    public void  test4() throws Exception{
        String resource = "application.yml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
//        Connection connection = session.getConnection();
//        connection.prepareStatement()
        String userName = session.selectOne("cn.jihui.ssm.mapper.EmployeeMapper.selectUserName","000111");
        logger.info(userName);
        session.close();
    }

}
