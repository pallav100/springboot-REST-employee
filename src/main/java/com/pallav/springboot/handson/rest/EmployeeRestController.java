package com.pallav.springboot.handson.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pallav.springboot.handson.entity.Employee;
import com.pallav.springboot.handson.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theemployeeService) {
		employeeService = theemployeeService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> fetchEmployees() {
		return employeeService.findAll();
	}
	@GetMapping("/employees/{id}")
	public Employee fetchEmployeeById(@PathVariable int id) {
		Employee res = employeeService.findById(id);
		if(res==null) {
			throw new RuntimeException("emplpyee not found");
		}
		return res;
	}
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee eobj) {
		eobj.setId(0);
		employeeService.save(eobj);
		return eobj;
	}
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee eobj) {
		employeeService.save(eobj);
		return eobj;
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		Employee res = employeeService.findById(id);
		if(res==null) {
			throw new RuntimeException("employee not found");
		}
		employeeService.deleteById(id);
		return "success";
	}

	
}










