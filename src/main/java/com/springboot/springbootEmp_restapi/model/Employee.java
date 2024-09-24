package com.springboot.springbootEmp_restapi.model;



import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "employee-data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private String employeeId;
    private String employeeName;
    private LocalDate dateOfJoining;
    private String mobile;
    private String email;
    private double salary;
    private String designation;
    private String alternativeMobile;

    private Address address;// Embedded Address entity

     private List<String> projectIds; // List of Project IDs for referencing multiple projects

     private List<String> departmentIds;  // List of Project IDs for referencing multiple projects
}
