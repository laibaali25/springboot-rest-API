
// http://localhost:8081/employee

package com.springboot.springbootEmp_restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.springbootEmp_restapi.model.Employee;
import com.springboot.springbootEmp_restapi.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Create Employee
    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    // Get All Employees
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        return service.findAllEmployees();
    }

    // Get Employee by ID
    @GetMapping("{employeeId}")
    public ResponseEntity<Object> getEmployee(@PathVariable String employeeId) {
        return service.getEmployeeByEmployeeId(employeeId);
    }

    // Update Employee
    @PutMapping("/{employeeId}")
    public ResponseEntity<String> modifyEmployee(@PathVariable String employeeId, @RequestBody Employee employee) {
        employee.setEmployeeId(employeeId);
        return service.updateEmployee(employee);
    }

    // Delete Employee
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String employeeId) {
        return service.deleteEmployee(employeeId);
    }
}
