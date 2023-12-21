package com.qsp.SpringDemo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.SpringDemo.Entity.Employee;
import com.qsp.SpringDemo.ExceptionHandling.EmailNotValidException;
import com.qsp.SpringDemo.ExceptionHandling.IdNotFoundException;
import com.qsp.SpringDemo.ExceptionHandling.PasswordInvalidException;
import com.qsp.SpringDemo.Repo.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepo employeeRepo;

	public Employee save(Employee employee) {
		Employee save = employeeRepo.save(employee);
		return save;
	}

	public List<Employee> fechAll() {

		List<Employee> findAll = employeeRepo.findAll();
		return findAll;
	}

	public Employee fetchOne(int id) throws IdNotFoundException {
		Employee employee = employeeRepo.findById(id).orElseThrow(() -> new IdNotFoundException());
		return employee;
	}

	public Employee update(int id, Employee employee) throws IdNotFoundException {
		Employee emp = employeeRepo.findById(id).orElseThrow(() -> new IdNotFoundException());
		emp.setEmployeeId(employee.getEmployeeId());
		emp.setEmployeeName(employee.getEmployeeName());
		emp.setEmployeeEmail(employee.getEmployeeEmail());
		emp.setEmployeeDepartment(employee.getEmployeeDepartment());
		emp.setEmployeePassword(employee.getEmployeePassword());
		emp.setEmployeeSalary(employee.getEmployeeSalary());
		return emp;
	}

	public String delete(int id) throws IdNotFoundException {
		Employee emp = employeeRepo.findById(id).orElseThrow(() -> new IdNotFoundException());
		employeeRepo.delete(emp);
		return "Deleted";
	}

	public String loginByEmail(String email, String password) throws EmailNotValidException, PasswordInvalidException {

		Employee emp = employeeRepo.findByEmployeeEmail(email);
		if (emp != null) {
			if (emp.getEmployeePassword().equals(password)) {
				return "Login Successfully";
			} else {
				throw new PasswordInvalidException();
			}
		} else {
			throw new EmailNotValidException();
		}
	}

	public String loginByName(String name, String password) throws EmailNotValidException, PasswordInvalidException {

		Employee e = employeeRepo.findByEmployeeName(name);
		if (e != null) {
			if (e.getEmployeePassword().equals(password)) {
				return "Login Successfully by username";
			} else {
				throw new PasswordInvalidException();
			}
		} else {
			throw new EmailNotValidException();
		}
	}
}
