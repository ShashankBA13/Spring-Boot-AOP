package com.practice.controller;

import com.practice.aop.LogExecutionTime;
import com.practice.entity.Employee;
import com.practice.entity.EmployeeDTO;
import com.practice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired()
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody @Valid EmployeeDTO employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("employeeId") Integer employeeId) {
        return employeeService.findByEmployeeId(employeeId);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> fetchAllEmployees() {
        return employeeService.fetchAllEmployees();
    }

    @PutMapping("/update/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee, employee.getId());
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body("Employee with id " + employeeId + " was deleted");
    }

}