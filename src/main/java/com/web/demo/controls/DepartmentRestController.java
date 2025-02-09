package com.web.demo.controls;

import com.web.demo.mongo.entity.Department;
import com.web.demo.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentRestController {
    private final DepartmentService service;

    @PostMapping
    public ResponseEntity<Department> save(@RequestBody Department department) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(department));
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}

