package com.pallav.springboot.handson.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pallav.springboot.handson.dao.EmployeeRepository;
import com.pallav.springboot.handson.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeRepository er;
	
	public EmployeeServiceImpl(EmployeeRepository er) {
		this.er = er;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return er.findAll();
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> res = er.findById(id);
		Employee et = null;
		if(res.isPresent()) {
			et = res.get();
		}
		return et;
	}

	@Override
	public void save(Employee e) {
		// TODO Auto-generated method stub
		er.save(e);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		er.deleteById(id);
	}

}
