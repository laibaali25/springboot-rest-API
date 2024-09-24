package com.springboot.springbootEmp_restapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.springboot.springbootEmp_restapi.model.Department;

public interface DepartmentRepository extends MongoRepository<Department, String> {
}

