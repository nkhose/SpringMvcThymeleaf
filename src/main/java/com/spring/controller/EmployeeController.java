package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.model.Employee;


@Controller
public class EmployeeController {
	List<Employee> emp = new ArrayList<Employee>();

	@PostConstruct
	public void init() throws Exception {
		emp.add(new Employee(1, "Prashant", "Pune"));
		emp.add(new Employee(2, "Nikita", "Pune"));
	}

//	@GetMapping
//	public String index() {
//		return "redirect:/employee";
//	}

	@GetMapping("/employee")
	public String getEmployee(Model model) {
		model.addAttribute("employee", emp);
		return "employee/employee.html";
	}

}
