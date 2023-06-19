package com.hm.entitymanager.entity;

import java.util.List;

import com.hm.entitymanager.enums.EmploymentType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@Column(name = "employee_id")
	private Integer employeeId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "employment_type")
	@Enumerated
	private EmploymentType employmentType;
	
	@Column(name = "salary")
	private double salary;
	

}
