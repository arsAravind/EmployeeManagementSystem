package com.qsp.SpringDemo.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.SpringDemo.Dao.EmployeeDao;
import com.qsp.SpringDemo.Entity.Employee;
import com.qsp.SpringDemo.ExceptionHandling.EmailNotValidException;
import com.qsp.SpringDemo.ExceptionHandling.IdNotFoundException;
import com.qsp.SpringDemo.ExceptionHandling.PasswordInvalidException;
import com.qsp.SpringDemo.Repo.EmployeeRepo;
import com.qsp.SpringDemo.ResponseStructure.ResponseStructure;

@Service
public class ServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao dao;

	public ResponseStructure<Employee> save(Employee employee) {

		Employee save = dao.save(employee);
		ResponseStructure<Employee> resoponseStructure = new ResponseStructure<>();
		resoponseStructure.setData(save);
		resoponseStructure.setHttpMessage("Data saved Successfully !");
		resoponseStructure.setHttpStatuscode(200);
		resoponseStructure.setStatus(HttpStatus.ACCEPTED);
		resoponseStructure.setDate(LocalDate.now());

		return resoponseStructure;
	}

	public ResponseStructure<List<Employee>> fetchAll() {
		List<Employee> fechAll = dao.fechAll();
		ResponseStructure<List<Employee>> responseStructure = new ResponseStructure<>();
		responseStructure.setData(fechAll);
		responseStructure.setHttpMessage("All data fetched Successfully !");
		responseStructure.setHttpStatuscode(200);
		responseStructure.setStatus(HttpStatus.ACCEPTED);
		responseStructure.setDate(LocalDate.now());

		return responseStructure;

	}

	public ResponseStructure<Employee> fetchOne(int id) throws IdNotFoundException {
		Employee employee = dao.fetchOne(id);

		ResponseStructure<Employee> responseStructure = new ResponseStructure<>();
		responseStructure.setData(employee);
		responseStructure.setHttpMessage("Data fetched Successfully !");
		responseStructure.setHttpStatuscode(200);
		responseStructure.setStatus(HttpStatus.ACCEPTED);
		responseStructure.setDate(LocalDate.now());

		return responseStructure;
	}

	public ResponseStructure<Employee> update(int id, Employee employee) throws IdNotFoundException {
		Employee update = dao.update(id, employee);
		ResponseStructure<Employee> responseStructure = new ResponseStructure<>();
		responseStructure.setData(employee);
		responseStructure.setHttpMessage("Data Updated Successfully !");
		responseStructure.setHttpStatuscode(200);
		responseStructure.setStatus(HttpStatus.ACCEPTED);
		responseStructure.setDate(LocalDate.now());
		return responseStructure;
	}

	public ResponseStructure<String> delete(int id) throws IdNotFoundException {
		String delete = dao.delete(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setData(delete);
		responseStructure.setHttpMessage("Data Deleted Successfully !");
		responseStructure.setHttpStatuscode(200);
		responseStructure.setStatus(HttpStatus.ACCEPTED);
		responseStructure.setDate(LocalDate.now());
		return responseStructure;
	}

	public ResponseStructure<String> loginByEmail(String email, String password)
			throws EmailNotValidException, PasswordInvalidException {

		String loginByEmail = dao.loginByEmail(email, password);
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setData(loginByEmail);
		responseStructure.setHttpMessage("Login Successfully !");
		responseStructure.setHttpStatuscode(200);
		responseStructure.setStatus(HttpStatus.ACCEPTED);
		responseStructure.setDate(LocalDate.now());
		return responseStructure;

	}

	public ResponseStructure<String> loginByName(String name, String password)
			throws EmailNotValidException, PasswordInvalidException {
		String message = dao.loginByName(name, password);
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setData(message);
		responseStructure.setHttpMessage("Login Successfully !");
		responseStructure.setHttpStatuscode(200);
		responseStructure.setStatus(HttpStatus.ACCEPTED);
		responseStructure.setDate(LocalDate.now());
		return responseStructure;

	}

}
