package com.qsp.SpringDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.qsp.SpringDemo.ResponseStructure.ResponseStructure;
import com.qsp.SpringDemo.Service.EmployeeService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody Employee employee) {
		ResponseStructure<Employee> save = employeeService.save(employee);
		return new ResponseEntity<>(save, HttpStatus.OK);
	}

	@GetMapping("/fetchAll")
	public ResponseEntity<?> fetchAll() {
		ResponseStructure<List<Employee>> save = employeeService.fetchAll();
		return new ResponseEntity<>(save, HttpStatus.OK);
	}

	@GetMapping("/fetchOne/{id}")
	public ResponseEntity<?> fetchOne(@PathVariable int id) throws IdNotFoundException {
		ResponseStructure<Employee> save = employeeService.fetchOne(id);
		return new ResponseEntity<>(save, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody Employee employee) throws IdNotFoundException {
		ResponseStructure<Employee> save = employeeService.update(id, employee);
		return new ResponseEntity<>(save, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) throws IdNotFoundException {
		ResponseStructure<String> save = employeeService.delete(id);
		return new ResponseEntity<>(save, HttpStatus.OK);
	}

	@GetMapping("/loginByEmail")
	public ResponseEntity<?> loginByEmail(@RequestParam String email, @RequestParam String password)
			throws EmailNotValidException, PasswordInvalidException {
		ResponseStructure<String> loginByEmail = employeeService.loginByEmail(email, password);
		return new ResponseEntity<>(loginByEmail, HttpStatus.ACCEPTED);
	}

	@GetMapping("/loginByName")
	public ResponseEntity<?> loginByName(@RequestParam String name, @RequestParam String password)
			throws EmailNotValidException, PasswordInvalidException {
		ResponseStructure<String> loginByEmail = employeeService.loginByName(name, password);
		return new ResponseEntity<>(loginByEmail, HttpStatus.ACCEPTED);
	}

}
