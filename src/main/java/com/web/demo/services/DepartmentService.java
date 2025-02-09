package com.web.demo.services;

import com.web.demo.mongo.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department save(Department department);

    List<Department> getAll();
}
