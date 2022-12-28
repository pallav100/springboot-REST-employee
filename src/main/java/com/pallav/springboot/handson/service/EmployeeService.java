package com.pallav.springboot.handson.service;

import java.util.List;

import com.pallav.springboot.handson.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int id);
	public void save(Employee e);
	public void deleteById (int id);


}
