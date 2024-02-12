package com.springsecurity.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecurity.entities.EmployeeEntity;
import com.springsecurity.exception.EmployeeNotFoundException;
import com.springsecurity.repository.EmployeeRepo;
import com.springsecurity.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public EmployeeEntity getEmplyee(Long id) throws EmployeeNotFoundException {
		Optional<EmployeeEntity> empOpt = employeeRepo.findById(id);
		if(empOpt.isEmpty()) {
			throw new EmployeeNotFoundException("Employee doesn't exist");
		}else {
			return empOpt.get();
		}

	}

	@Override
	public List<EmployeeEntity> getAllEmployee() {
		return employeeRepo.findAll();
	}

	@Override
	public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {
		employeeEntity.setPassword(passwordEncoder.encode(employeeEntity.getPassword()));
		return employeeRepo.save(employeeEntity);
	}

}
