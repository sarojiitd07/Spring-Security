package com.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.entities.EmployeeEntity;
import com.springsecurity.exception.EmployeeNotFoundException;
import com.springsecurity.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	@Qualifier("employeeServiceImpl")
	private EmployeeService employeeService;
	
//	EmployeeController(EmployeeService employeeService) {
//		this.employeeService=employeeService;
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable Long id) throws EmployeeNotFoundException{
		return new ResponseEntity<EmployeeEntity>(employeeService.getEmplyee(id),HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<EmployeeEntity>> getAllEmployee(){
		return new ResponseEntity<List<EmployeeEntity>>(employeeService.getAllEmployee(),HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody @Valid EmployeeEntity employeeEntity){
		return new ResponseEntity<>(employeeService.createEmployee(employeeEntity),HttpStatus.OK);
	}
}
