package com.qsp.SpringDemo.Service;

import java.util.List;

import com.qsp.SpringDemo.Entity.Employee;
import com.qsp.SpringDemo.ExceptionHandling.EmailNotValidException;
import com.qsp.SpringDemo.ExceptionHandling.IdNotFoundException;
import com.qsp.SpringDemo.ExceptionHandling.PasswordInvalidException;

public interface EmployeeService {

	Employee save(Employee employee);

	List<Employee> getAll();

	Employee getOne(int id) throws IdNotFoundException;

	Employee update(Employee employee, int id) throws IdNotFoundException;

	String delete(int id) throws IdNotFoundException;

	String validate(String email, String password) throws IdNotFoundException, PasswordInvalidException, EmailNotValidException;

}
