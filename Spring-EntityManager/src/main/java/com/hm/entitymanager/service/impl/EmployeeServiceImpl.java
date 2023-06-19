package com.hm.entitymanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.entitymanager.entity.Employee;
import com.hm.entitymanager.repository.EmployeeRepository;
import com.hm.entitymanager.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.saveEmployee(employee);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAllEmployees();
	}

	@Override
	public List<Employee> findEmployeeByName(String employeeName) {
		return employeeRepository.findEmployeeByName(employeeName);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
	   return employeeRepository.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		 employeeRepository.deleteEmployee(employeeId);
	}

	@Override
	public int deleteAllEmployee() {
		return employeeRepository.deleteAllEmployee();
	}

}
