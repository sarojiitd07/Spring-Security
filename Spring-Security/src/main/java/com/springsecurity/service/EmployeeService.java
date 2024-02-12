package com.springsecurity.service;

import java.util.List;

import com.springsecurity.entities.EmployeeEntity;
import com.springsecurity.exception.EmployeeNotFoundException;

public interface EmployeeService {
	public EmployeeEntity getEmplyee(Long id) throws EmployeeNotFoundException;
	public List<EmployeeEntity> getAllEmployee();
	public EmployeeEntity createEmployee(EmployeeEntity employeeEntity);
}
