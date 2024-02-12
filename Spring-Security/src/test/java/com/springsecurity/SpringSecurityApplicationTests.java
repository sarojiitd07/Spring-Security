package com.springsecurity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springsecurity.entities.EmployeeEntity;
import com.springsecurity.exception.EmployeeNotFoundException;
import com.springsecurity.repository.EmployeeRepo;
import com.springsecurity.serviceImpl.EmployeeServiceImpl;

@SpringBootTest
class SpringSecurityApplicationTests {
	
	@Mock
	private PasswordEncoder passwordEncoder;
	
	@InjectMocks
	private EmployeeServiceImpl mockEmployeeServiceImpl;

	@Mock
	private EmployeeRepo mockEmployeeRepo;
	
	private EmployeeEntity employeeEntity = new EmployeeEntity(1L,"saroj","saroj","Java Developer","ADMIN");
	
//	@BeforeAll
//	@Test
//	static void beforeAllTestCases() {
//		EmployeeEntity employeeEntity = new EmployeeEntity();
//		employeeEntity.setId(1L);
//		employeeEntity.setPassword("saroj");
//		employeeEntity.setRoles("ADMIN");
//		employeeEntity.setDesignation("Java developer");
//		employeeEntity.setUserName("saroj");
//	}
	
	@Test
	void getEmployee() throws EmployeeNotFoundException {
		Long emp_id = 1L;
		
		Optional<EmployeeEntity> empOpt = Optional.of(employeeEntity);
		
		Mockito.when(mockEmployeeRepo.findById(emp_id)).thenReturn(empOpt);
		assertEquals(mockEmployeeServiceImpl.getEmplyee(emp_id), employeeEntity);
	}
	
	@Test
	void getAllEmployee() {
		Long emp_id = 1L;
		
		EmployeeEntity employeeEntity1 = new EmployeeEntity();
		employeeEntity1.setId(emp_id);
		employeeEntity1.setPassword("saroj");
		employeeEntity1.setRoles("ADMIN");
		employeeEntity1.setDesignation("Java developer");
		employeeEntity1.setUserName("saroj");
		
		EmployeeEntity employeeEntity2 = new EmployeeEntity();
		employeeEntity2.setId(emp_id);
		employeeEntity2.setPassword("saroj");
		employeeEntity2.setRoles("ADMIN");
		employeeEntity2.setDesignation("Java developer");
		employeeEntity2.setUserName("saroj");
		
		List<EmployeeEntity> employees = List.of(employeeEntity1,employeeEntity2);
		
		Mockito.when(mockEmployeeRepo.findAll()).thenReturn(employees);
		assertEquals(mockEmployeeServiceImpl.getAllEmployee(), employees);
	}
	
	@Test
	void createEmployee() {
		Long emp_id = 1L;
		
		Mockito.when(mockEmployeeRepo.save(employeeEntity)).thenReturn(employeeEntity);
		assertEquals(mockEmployeeServiceImpl.createEmployee(employeeEntity), employeeEntity);

	}

}
