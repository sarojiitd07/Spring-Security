package com.springsecurity.serviceImpl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.springsecurity.entities.EmployeeEntity;
import com.springsecurity.service.EmployeeService;

@Service
public class EmployeeServiceImpl2 implements EmployeeService{

	@Override
	public EmployeeEntity getEmplyee(Long id) {
		return null;
	}

	@Override
	public List<EmployeeEntity> getAllEmployee() {
		return null;
	}

	@Override
	public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {
		return null;
	}

}
