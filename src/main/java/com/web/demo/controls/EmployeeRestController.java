package com.web.demo.controls;


import com.web.demo.entities.Employee;
import com.web.demo.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("emp")
public class EmployeeRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRestController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("list")
    public List<Employee> getEmployeeList(){
        LOGGER.info("Entered into getEmployeeList");
        return employeeService.getEmployeeList();
    }
}
