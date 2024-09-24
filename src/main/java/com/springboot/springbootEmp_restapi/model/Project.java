package com.springboot.springbootEmp_restapi.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "project-data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    
     @Id
    private String projectId;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
}
