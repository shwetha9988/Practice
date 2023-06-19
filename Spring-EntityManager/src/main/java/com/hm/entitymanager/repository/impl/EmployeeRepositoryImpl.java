package com.hm.entitymanager.repository.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hm.entitymanager.entity.Employee;
import com.hm.entitymanager.repository.EmployeeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeRepositoryImpl.class);
	
	private static final String FIND_ALL_EMPLOYEES = "select e from Employee e";
	
	private static final String FIND_EMPLOYEE_BY_NAME = "select e from Employee e where e.employeeName=:employeeName";
	
	private static final String DELETE_ALL_EMPLOYEE = "delete from Employee";
	

	@Override
	@Transactional
	public Employee saveEmployee(Employee employee) {
		 entityManager.persist(employee);
		 logger.info("Employee Saved");
		 return employee;
	}

	@Override
	@Transactional
	public List<Employee> findAllEmployees() {
		TypedQuery<Employee> query = entityManager.createQuery(FIND_ALL_EMPLOYEES, Employee.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<Employee> findEmployeeByName(String employeeName) {
		TypedQuery<Employee> query = entityManager.createQuery(FIND_EMPLOYEE_BY_NAME, Employee.class);
		return query.setParameter("employeeName", employeeName).getResultList();
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee) {
		entityManager.merge(employee);
		logger.info("Employee Updated");
		return employee;
	}

	@Override
	@Transactional
	public void deleteEmployee(int employeeId) {
		Employee employee = findEmployeeById(employeeId);
		if(employee != null) {
			entityManager.remove(employee);
			logger.info("Deleted Employee");
		}
		else {
			logger.error("Unable to delete");
		}
		
	}
	
   public Employee findEmployeeById(int employeeId) {
		Employee employee = (Employee) entityManager.find(Employee.class, employeeId);
		return employee;
	}

	@Override
	@Transactional
	public int deleteAllEmployee() {
		Query query = entityManager.createQuery(DELETE_ALL_EMPLOYEE);
		return query.executeUpdate();
		
	}

}
