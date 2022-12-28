package com.pallav.springboot.handson.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pallav.springboot.handson.entity.Employee;
import com.pallav.springboot.handson.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> elist;
	private EmployeeService es;
	public EmployeeController(EmployeeService ess) {
		this.es = ess;
	}
	@GetMapping("/time")
	public String renderTime(Model m) {
		m.addAttribute("currtime", new java.util.Date());
		return "dummy";
	}
	@GetMapping("/list")
	public String renderList(Model m) {
		elist = es.findAll();
		m.addAttribute("employees", elist);
		return "Employee/list-employees";
	}
	@GetMapping("/add")
	public String renderAddForm(Model m) {
		Employee eobj = new Employee();
		m.addAttribute("employee", eobj);
		return "Employee/addupdateForm";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee em) {
		System.out.println(em.toString());
		es.save(em);
		return "redirect:/employees/list";
	}

	@PostMapping("/update")
	public String updateEmployee(@RequestParam("employeeId") Integer eid, Model m) {
//		System.out.println(em/.toString());
		Employee e = es.findById(eid);
		m.addAttribute("employee", e);
		return "Employee/addupdateForm";
	}
	
	@PostMapping("/delete")
	public String delEmployee(@RequestParam("employeeId") Integer eid) {
//		System.out.println(em.toString());
		Employee e = es.findById(eid);
		if(e!=null) {
			es.deleteById(eid);
		} else {
			throw new Error("No such employee found");
		}
		return "redirect:/employees/list";
	}
}
