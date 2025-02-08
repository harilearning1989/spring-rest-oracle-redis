package com.web.demo.services;

import com.web.demo.entities.Employee;
import com.web.demo.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Cacheable(value = "employeeCacheable")
    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }
}
