package cn.edu.shu.controller;

import cn.edu.shu.domains.Employee;
import cn.edu.shu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    private TestService testService;

    @RequestMapping("/findAllTest")
    public List<Employee> findAll(){
        List<Employee> list = testService.findAll();
         return list;
    }

}
