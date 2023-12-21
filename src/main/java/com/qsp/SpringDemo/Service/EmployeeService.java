package com.qsp.SpringDemo.Service;

import java.util.List;

import com.qsp.SpringDemo.Entity.Employee;
import com.qsp.SpringDemo.ExceptionHandling.EmailNotValidException;
import com.qsp.SpringDemo.ExceptionHandling.IdNotFoundException;
import com.qsp.SpringDemo.ExceptionHandling.PasswordInvalidException;
import com.qsp.SpringDemo.ResponseStructure.ResponseStructure;

public interface EmployeeService {

	ResponseStructure<Employee> save(Employee employee);

	ResponseStructure<List<Employee>> fetchAll();

	ResponseStructure<Employee> fetchOne(int id) throws IdNotFoundException;

	ResponseStructure<Employee> update(int id, Employee employee) throws IdNotFoundException;

	ResponseStructure<String> delete(int id) throws IdNotFoundException;

	ResponseStructure<String> loginByEmail(String email, String password) throws EmailNotValidException, PasswordInvalidException;

	ResponseStructure<String> loginByName(String name, String password) throws EmailNotValidException, PasswordInvalidException;}
