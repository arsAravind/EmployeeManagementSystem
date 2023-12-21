package com.qsp.SpringDemo.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qsp.SpringDemo.Entity.Employee;
import com.qsp.SpringDemo.ExceptionHandling.EmailNotValidException;
import com.qsp.SpringDemo.ExceptionHandling.IdNotFoundException;
import com.qsp.SpringDemo.ExceptionHandling.PasswordInvalidException;
import com.qsp.SpringDemo.Repo.EmployeeRepo;

@Service
public class ServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public Employee save(Employee employee) {
		Employee save = employeeRepo.save(employee);

		return save;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> findAll = employeeRepo.findAll();

		return findAll;
	}

	@Override
	public Employee getOne(int id) throws IdNotFoundException {
		Employee emp = employeeRepo.findById(id).orElse(null);
		if (emp != null) {
			 return emp;
		}
		else
		{
			throw new IdNotFoundException();
		}
	}

	@Override
	public Employee update(Employee employee, int id) throws IdNotFoundException {

		Employee e = employeeRepo.findById(id).orElse(null);
		if (e == null) {
			throw new IdNotFoundException();

		} else {
			e.setEmployeeId(employee.getEmployeeId());
			e.setEmployeeName(employee.getEmployeeName());
			e.setEmployeeSalary(employee.getEmployeeSalary());
			e.setEmployeePassword(employee.getEmployeePassword());
			e.setEmployeeDepartment(employee.getEmployeeDepartment());
			e.setEmployeeEmail(employee.getEmployeeEmail());
			;
		}
		return employeeRepo.save(e);
	}

	@Override
	public String delete(int id) throws IdNotFoundException {
		Employee e = employeeRepo.findById(id).orElse(null);
		if (e == null) {
			throw new IdNotFoundException();

		}
		employeeRepo.delete(e);
		return "Deleted Successfully";
	}

	@Override
	public String validate(String empEmail, String empPassword)
			throws IdNotFoundException, PasswordInvalidException, EmailNotValidException {

		Employee findByEmpEmail = employeeRepo.findByEmployeeEmail(empEmail);
		if (findByEmpEmail != null) {
			if (findByEmpEmail.getEmployeePassword().equals(empPassword)) {
				// return "login successfull"; // we can throw either exception or return
				return "Login Successful";
			} else {
				throw new PasswordInvalidException();
			}
		} else {
			throw new EmailNotValidException();
		}
	}
}
