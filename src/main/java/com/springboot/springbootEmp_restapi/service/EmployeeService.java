package com.springboot.springbootEmp_restapi.service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service; 
import com.springboot.springbootEmp_restapi.model.Employee;
import com.springboot.springbootEmp_restapi.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    // Add Employees
    public ResponseEntity<String> addEmployee(Employee employee) {
        try {
            employee.setEmployeeId(UUID.randomUUID().toString().split("-")[0]);
             repository.save(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body("Employee Created successfully");
        } 
        catch (Exception e) 
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while creating employee");
        }
    }

    // Get all employees
    public ResponseEntity<List<Employee>> findAllEmployees() {
        try {
            List<Employee> employees = repository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(employees);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Get employee by id
    public ResponseEntity<Object> getEmployeeByEmployeeId(String employeeId) {
        try {
            Optional<Employee> employee = repository.findById(employeeId);
            if (employee.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(employee.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not present");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while retrieving the employee");
        }
    }

 

    // Update Employee
    public ResponseEntity<String> updateEmployee(Employee employeeRequest) {
        try {
            Optional<Employee> existingEmployeeOpt = repository.findById(employeeRequest.getEmployeeId());
            if (existingEmployeeOpt.isPresent()) {
                Employee existingEmployee = existingEmployeeOpt.get();
                existingEmployee.setAlternativeMobile(employeeRequest.getAlternativeMobile());
                existingEmployee.setDateOfJoining(employeeRequest.getDateOfJoining()); 
                existingEmployee.setDesignation(employeeRequest.getDesignation());
                existingEmployee.setEmail(employeeRequest.getEmail());
                existingEmployee.setEmployeeName(employeeRequest.getEmployeeName());
                existingEmployee.setMobile(employeeRequest.getMobile());
                existingEmployee.setSalary(employeeRequest.getSalary());
                repository.save(existingEmployee);
                return ResponseEntity.status(HttpStatus.OK).body("Updated Successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee Id does not exist");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while updating the data");
        }
    }

    // Delete employee
    public ResponseEntity<String> deleteEmployee(String employeeId) {
        try {
            Optional<Employee> existingEmployeeOpt = repository.findById(employeeId);

            if(existingEmployeeOpt.isPresent()){
                repository.delete(existingEmployeeOpt.get());
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(employeeId + " Employee deleted");
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(employeeId + " ID not found");
            }

            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting employee");
        }
    }
}
    



// package com.springboot.springbootEmp_restapi.service;

// import java.util.List;
// import java.util.Optional;
// import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service; 

// import com.springboot.springbootEmp_restapi.model.Employee;
// //import com.springboot.springbootEmp_restapi.model.Project;
// //import com.springboot.springbootEmp_restapi.model.Department;
// import com.springboot.springbootEmp_restapi.repository.EmployeeRepository;
// import com.springboot.springbootEmp_restapi.repository.ProjectRepository;
// import com.springboot.springbootEmp_restapi.repository.DepartmentRepository;

// @Service
// public class EmployeeService {

//     @Autowired
//     private EmployeeRepository employeeRepository;

//     @Autowired
//     private ProjectRepository projectRepository;

//     @Autowired
//     private DepartmentRepository departmentRepository;

//     // Add Employees
//     public ResponseEntity<String> addEmployee(Employee employee) {
//         try {
//             // Validate Projects
//             for (String projectId : employee.getProjectIds()) {
//                 if (!projectRepository.existsById(projectId)) {
//                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Project ID: " + projectId);
//                 }
//             }

//             // Validate Departments
//             for (String departmentId : employee.getDepartmentIds()) {
//                 if (!departmentRepository.existsById(departmentId)) {
//                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Department ID: " + departmentId);
//                 }
//             }

//             // Generate Employee ID and save
//             employee.setEmployeeId(UUID.randomUUID().toString().split("-")[0]);
//             employeeRepository.save(employee);
//             return ResponseEntity.status(HttpStatus.CREATED).body("Employee Created successfully");
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while creating employee");
//         }
//     }

//     // Get all employees
//     public ResponseEntity<List<Employee>> findAllEmployees() {
//         try {
//             List<Employee> employees = employeeRepository.findAll();
//             return ResponseEntity.status(HttpStatus.OK).body(employees);
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//         }
//     }

//     // Get employee by id
//     public ResponseEntity<Object> getEmployeeByEmployeeId(String employeeId) {
//         try {
//             Optional<Employee> employee = employeeRepository.findById(employeeId);
//             if (employee.isPresent()) {
//                 return ResponseEntity.status(HttpStatus.OK).body(employee.get());
//             } else {
//                 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not present");
//             }
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while retrieving the employee");
//         }
//     }

//     // Update Employee
//     public ResponseEntity<String> updateEmployee(Employee employeeRequest) {
//         try {
//             Optional<Employee> existingEmployeeOpt = employeeRepository.findById(employeeRequest.getEmployeeId());
//             if (existingEmployeeOpt.isPresent()) {
//                 Employee existingEmployee = existingEmployeeOpt.get();

//                 // Validate Projects
//                 for (String projectId : employeeRequest.getProjectIds()) {
//                     if (!projectRepository.existsById(projectId)) {
//                         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Project ID: " + projectId);
//                     }
//                 }

//                 // Validate Departments
//                 for (String departmentId : employeeRequest.getDepartmentIds()) {
//                     if (!departmentRepository.existsById(departmentId)) {
//                         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Department ID: " + departmentId);
//                     }
//                 }

//                 // Update fields
//                 existingEmployee.setAlternativeMobile(employeeRequest.getAlternativeMobile());
//                 existingEmployee.setDateOfJoining(employeeRequest.getDateOfJoining()); 
//                 existingEmployee.setDesignation(employeeRequest.getDesignation());
//                 existingEmployee.setEmail(employeeRequest.getEmail());
//                 existingEmployee.setEmployeeName(employeeRequest.getEmployeeName());
//                 existingEmployee.setMobile(employeeRequest.getMobile());
//                 existingEmployee.setSalary(employeeRequest.getSalary());
//                 existingEmployee.setAddress(employeeRequest.getAddress());
//                 existingEmployee.setProjectIds(employeeRequest.getProjectIds());
//                 existingEmployee.setDepartmentIds(employeeRequest.getDepartmentIds());

//                 employeeRepository.save(existingEmployee);
//                 return ResponseEntity.status(HttpStatus.OK).body("Updated Successfully");
//             } else {
//                 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee Id does not exist");
//             }
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while updating the data");
//         }
//     }

//     // Delete employee
//     public ResponseEntity<String> deleteEmployee(String employeeId) {
//         try {
//             Optional<Employee> existingEmployeeOpt = employeeRepository.findById(employeeId);

//             if(existingEmployeeOpt.isPresent()){
//                 employeeRepository.delete(existingEmployeeOpt.get());
//                 return ResponseEntity.status(HttpStatus.NO_CONTENT).body(employeeId + " Employee deleted");
//             }
//             else{
//                 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(employeeId + " ID not found");
//             }
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting employee");
//         }
//     }
// }

