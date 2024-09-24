package com.springboot.springbootEmp_restapi.model;

import java.util.List;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "department-data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
      
    @Id
    private String departmentId;
    private String departmentName;

    private List<String> employeeIds; // References to Employee IDs
}
