package com.springsecurity.entities;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Field cannot be blank or null")
	private String userName;
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Min 1 uppercase letter.\r\n"
			+ "Min 1 lowercase letter.\r\n" + "Min 1 special character.\r\n" + "Min 1 number.\r\n"
			+ "Min 8 characters.\r\n" + "Max 30 characters.")
	private String password;
	@NotBlank(message = "Field cannot be blank or null")
	private String designation;
	@NotBlank(message = "Field cannot be blank or null")
	private String roles;
}
