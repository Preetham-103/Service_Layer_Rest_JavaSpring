package com.cts.service;

import java.util.List;

import com.cts.entity.Employee;

public interface IEmployeeService {

	 Employee addEmployee(Employee employee);
	 List<Employee> viewAllEmployee();
	 Employee getEmployeeById(int id);
	 Employee updateEmployeeById(int id,Employee employee);
	 void deleteEmployeeById(int id);
	
}
