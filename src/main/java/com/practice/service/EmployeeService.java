package com.practice.service;

import com.practice.aop.LogExecutionTime;
import com.practice.entity.Employee;
import com.practice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;


    public ResponseEntity<Employee> addEmployee(Employee employee) {
        Employee employeeAdded = repo.save(employee);
        return ResponseEntity.ok(employeeAdded);
    }

    @Cacheable(value = "employee", key = "#employeeId", unless = "#result == null")
    public ResponseEntity<Employee> findByEmployeeId(Integer employeeId) {
        Employee employee = repo.findById(employeeId).orElse(null);
        return ResponseEntity.ok(employee);
    }

    @CachePut(value="employee", key = "#employee.id")
    public ResponseEntity<Employee> updateEmployee(Employee employee, Integer employeeId) {
        System.out.println("Employee with id " + employeeId + " updated");
        Employee updatedEmployee = new Employee();
        updatedEmployee.setName(employee.getName());
        return ResponseEntity.ok().body(repo.save(updatedEmployee));
    }

    public ResponseEntity<List<Employee>> fetchAllEmployees() {
        List<Employee> employees = repo.findAll();
        return ResponseEntity.ok(employees);
    }


    @CacheEvict(value = "employee", key = "#employeeId")
    public void deleteEmployee(Integer employeeId) {
        System.out.println("Employee with id " + employeeId + " is deleted");
        repo.deleteById(employeeId);
    }
}