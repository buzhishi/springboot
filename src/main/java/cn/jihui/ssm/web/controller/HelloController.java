package cn.jihui.ssm.web.controller;

import cn.jihui.ssm.domain.Employee;
import cn.jihui.ssm.domain.User;
import cn.jihui.ssm.service.IEmployeeService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Controller
public class HelloController {
    // 日志
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private User user;


    @Autowired
    private DataSource dataSource;

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() throws SQLException {
        logger.debug(user.toString());
        logger.info(user.toString());
        logger.warn(user.toString());
        logger.error(user.toString());
        Connection connection = dataSource.getConnection();
        logger.info(connection.toString());
        return "Hello World";
    }



    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("msg","一道风景");
        // 默认的前缀： /templates
        // 默认的后缀： .html
        return "hello";
    }

    // http://localhost:8090/redis/selectUserName/000111
    @GetMapping(value = "/redis/selectUserName/{id}")
    @ResponseBody
    public String selectUserName(@PathVariable("id") String id){
        // 此方法存入的key 为employeeServiceCache::000111  即cacheNames : id 的值
        String userName = employeeService.selectUserName(id);
        return userName;
    }

    // http://localhost:8090/redis/selectAll
    @GetMapping(value = "/redis/selectAll")
    @ResponseBody
    public String selectUserName(HttpServletRequest request){
        List<Employee>  employees = employeeService.selectAll();
        request.getSession().setAttribute("selectAllSessionId","axb");
        return JSON.toJSONString(employees);
    }




}
