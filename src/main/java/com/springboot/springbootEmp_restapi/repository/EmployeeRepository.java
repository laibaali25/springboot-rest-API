package com.springboot.springbootEmp_restapi.repository;


    

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.springbootEmp_restapi.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

   
}