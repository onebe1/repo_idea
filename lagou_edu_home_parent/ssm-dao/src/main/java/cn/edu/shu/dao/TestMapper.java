package cn.edu.shu.dao;

import cn.edu.shu.domains.Employee;

import java.util.List;

public interface TestMapper {


//    public Employee findAll();

    //这个查询操作，返回的是一个List集合
    public List<Employee> findAll();
}

