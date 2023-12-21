package com.qsp.SpringDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.SpringDemo.Entity.Employee;
import com.qsp.SpringDemo.ExceptionHandling.EmailNotValidException;
import com.qsp.SpringDemo.ExceptionHandling.IdNotFoundException;
import com.qsp.SpringDemo.ExceptionHandling.PasswordInvalidException;
import com.qsp.SpringDemo.Service.EmployeeService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/employee/test")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping("/save")
	public Employee emp(@Valid  @RequestBody Employee employee) {
		Employee emp = service.save(employee);
		return emp;
	}

	@GetMapping("/getAll")
	public List<Employee> employee() {
		List<Employee> employee = service.getAll();
		return employee;
	}

	@GetMapping("/getOne/{id}")
	public Employee employee(@PathVariable int id) throws IdNotFoundException {
		Employee employee = service.getOne(id);
		return employee;
	}

	@PutMapping("/update/{id}")
	public Employee update(@RequestBody Employee employee, @PathVariable int id) throws IdNotFoundException {
		Employee employee2 = service.update(employee, id);
		return employee2;
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) throws IdNotFoundException {
		String s = service.delete(id);
		return s;
	}
	
	@GetMapping("/getByName")
	public String validateUser(@RequestParam String empEmail,@RequestParam String empPassword) throws IdNotFoundException, PasswordInvalidException, EmailNotValidException
	{
		
		
		System.out.println(empEmail + " wel" +empPassword);
		 return service.validate(empEmail,empPassword);
		
	}

}
