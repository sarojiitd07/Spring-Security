package com.springsecurity.serviceImpl;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.springsecurity.entities.EmployeeEntity;
import com.springsecurity.repository.EmployeeRepo;
import com.springsecurity.securityConfig.EmployeeDetails;

@Component
public class EmployeeInfoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private EmployeeRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			Optional<EmployeeEntity> employee = repo.findByUserName(username);
			
			EmployeeDetails employeeDetails = new EmployeeDetails();
			employeeDetails.setName(employee.get().getUserName());
			employeeDetails.setPassword(employee.get().getPassword());
			employeeDetails.setAuthorities(Arrays.stream(employee.get().getRoles().split(","))
					.map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
			return employeeDetails;
			
//			return employee.map(EmployeeDetails::new)
	}

}
