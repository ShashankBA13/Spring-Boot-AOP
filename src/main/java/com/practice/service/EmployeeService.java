package com.practice.service;

import com.practice.aop.LogExecutionTime;
import com.practice.entity.Employee;
import com.practice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public ResponseEntity<Employee> addEmployee(Employee employee) {
       Employee employeeAdded =  repo.save(employee);
       return ResponseEntity.ok(employeeAdded);
    }

    public ResponseEntity<List<Employee>> fetchAllEmployees(){
        List<Employee> employees = repo.findAll();
        return ResponseEntity.ok(employees);
    }
}
