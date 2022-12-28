package com.pallav.springboot.handson.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pallav.springboot.handson.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
