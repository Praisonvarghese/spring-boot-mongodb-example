package com.techiemaster.mongo.repository;

import com.techiemaster.mongo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository<Employee,Integer> {
}
