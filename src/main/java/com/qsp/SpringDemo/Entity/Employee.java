package com.qsp.SpringDemo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "EMPLOYEE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	@Column(name = "Employee_Name")
	@NotBlank
	@Size(max = 15, min = 5, message = "Name should contain in between 5 and 15")
	private String employeeName;
	@Column(name = "Employee_Email")
	@Email(message = "Given maild is not correct")
	private String employeeEmail;
	@Column(name = "Employee_Salary")
	private String employeeSalary;
	@Column(name = "Employee_Department")
	private String employeeDepartment;
	@Column(name = "Employee_Password")
	private String employeePassword;

}
