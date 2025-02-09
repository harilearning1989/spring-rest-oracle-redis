package com.web.demo.services;

import com.web.demo.mongo.entity.Department;
import com.web.demo.mongo.repos.DepartmentRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;
    //private final RedisTemplate<String, Department> redisTemplate;
    private static final String CACHE_KEY = "DEPARTMENT_CACHE";

    public Department save(Department department) {
        Department saved = repository.save(department);
        //redisTemplate.opsForHash().put(CACHE_KEY, saved.getId(), saved);
        return saved;
    }

    @Cacheable(value = "departmentAll")
    public List<Department> getAll() {
        return repository.findAll();
    }

    public Department getById(String id) {
        //if (Boolean.TRUE.equals(redisTemplate.opsForHash().hasKey(CACHE_KEY, id))) {
        //    return (Department) redisTemplate.opsForHash().get(CACHE_KEY, id);
        //}
        return repository.findById(id).orElse(null);
    }
}

