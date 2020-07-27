package cn.jihui.ssm.mapper;

import cn.jihui.ssm.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    public String selectUserName(@Param("id") String id);


    public List<Employee> selectAll();
}
