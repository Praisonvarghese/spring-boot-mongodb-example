package com.techiemaster.mongo.controller;

import com.techiemaster.mongo.model.Employee;
import com.techiemaster.mongo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("/addEmployee")
    private String addEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeRepo.save(employee);
        return "Added Employee With Id "+savedEmployee.getId();
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    @GetMapping("/employee/{id}")
    private Optional<Employee> getEmployee(@PathVariable int id){
        return employeeRepo.findById(id);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    private String deleteEmployee(@PathVariable int id){
        employeeRepo.deleteById(id);
        return "Employee with id "+id+" Deleted from Database";
    }
}
