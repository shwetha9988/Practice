package com.hm.entitymanager.repository;

import java.util.List;

import com.hm.entitymanager.entity.Employee;

public interface EmployeeRepository {
	
	Employee saveEmployee(Employee employee);
	
	List<Employee> findAllEmployees();
	
	List<Employee> findEmployeeByName(String employeeName);
	
	Employee updateEmployee(Employee employee);
	
	void deleteEmployee(int employeeId);
	
	int deleteAllEmployee();

}
