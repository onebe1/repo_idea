package cn.edu.shu.service.Impl;

import cn.edu.shu.dao.TestMapper;
import cn.edu.shu.domains.Course;
import cn.edu.shu.domains.CourseVO;
import cn.edu.shu.domains.Employee;
import cn.edu.shu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    //注入对象

    @Autowired
    private TestMapper testMapper;


    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = testMapper.findAll();
        return employeeList;
    }
}
