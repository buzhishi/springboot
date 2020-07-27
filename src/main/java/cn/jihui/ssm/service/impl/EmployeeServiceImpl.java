package cn.jihui.ssm.service.impl;

import cn.jihui.ssm.domain.Employee;
import cn.jihui.ssm.mapper.EmployeeMapper;
import cn.jihui.ssm.service.IEmployeeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@CacheConfig(cacheNames = "employeeServiceCache")   //  开启缓存
@Transactional(propagation = Propagation.REQUIRED,readOnly = false,rollbackFor = Exception.class)
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> selectAll() {
        return employeeMapper.selectAll();
    }

    @Override
    @Cacheable(key = "#p0",unless = "#result==null ")
    public String selectUserName(String id) {
        return employeeMapper.selectUserName(id);
    }

}
