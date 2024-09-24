package com.springboot.springbootEmp_restapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.springboot.springbootEmp_restapi.model.Project;

public interface ProjectRepository extends MongoRepository<Project, String> {
}
