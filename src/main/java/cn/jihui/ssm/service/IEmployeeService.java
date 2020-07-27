package cn.jihui.ssm.service;

import cn.jihui.ssm.domain.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IEmployeeService {
    // 查询所有
    List<Employee> selectAll(
            );

    // 查询名字根据ID
    String selectUserName(String id);

}
