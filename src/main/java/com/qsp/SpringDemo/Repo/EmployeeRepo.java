package com.qsp.SpringDemo.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qsp.SpringDemo.Entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	//Employee findByEmployeeEmail(String password);

//	Employee findByEmployeeEmail(String email);
	Employee findByEmployeeEmail(String email);

}
