package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Employee;
import com.cts.exception.IdNotFoundException;
import com.cts.exception.InValidAgeException;
import com.cts.repository.EmployeeRepository;
import com.cts.service.IEmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

//	private final EmployeeRepository employeeRepository;

	@Autowired
	IEmployeeService employeeService;

//	EmployeeController(EmployeeRepository employeeRepository) {
//		this.employeeRepository = employeeRepository;
//	}

	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.OK);
	}

	@GetMapping("employee")
	public ResponseEntity<List<Employee>> viewAllEmployee() {
//		return new ResponseEntity<List<Employee>>(employeeService.viewAllEmployee(),HttpStatus.OK);
		return new ResponseEntity<List<Employee>>(employeeService.viewAllEmployee(), HttpStatus.OK);
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> viewEmployeeById(@PathVariable int id) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable int id, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployeeById(id, employee), HttpStatus.OK);
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) {
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}

}
