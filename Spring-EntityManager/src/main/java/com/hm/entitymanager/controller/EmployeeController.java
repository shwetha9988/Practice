package com.hm.entitymanager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.entitymanager.entity.Employee;
import com.hm.entitymanager.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		logger.debug("Requesting employee : {}", employee);
		Employee savedEmployee = employeeService.saveEmployee(employee);
		logger.debug("Response: {}" , savedEmployee);
		return savedEmployee;
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.findAllEmployees();
		
	}
	
	@GetMapping("/getEmployee/{employeeName}")
	public List<Employee> getEmployeeByName(@PathVariable String employeeName) {
		return employeeService.findEmployeeByName(employeeName);
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/deleteEmployee/{employeeId}")
	public void deleteEmployee(@PathVariable int employeeId) {
		employeeService.deleteEmployee(employeeId);
		
    }
	
	@DeleteMapping("/deleteAllEmployees")
	public int deleteAllEmployees() {
		return employeeService.deleteAllEmployee();
	}

}
