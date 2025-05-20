package com.cts.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Employee;
import com.cts.exception.IdNotFoundException;
import com.cts.exception.InValidAgeException;
import com.cts.repository.EmployeeRepository;
import com.cts.util.AppConstant;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Override
	public Employee addEmployee(Employee employee) {
		  if(employee.getAge()<=18)
			  throw new InValidAgeException(AppConstant.INVALID_AGE_MESSAGE);
		return employeeRepository.save(employee);
	}

	
	@Override
	public List<Employee> viewAllEmployee() {
		return employeeRepository.findAll();
	}

	
	@Override
	public Employee getEmployeeById(int id) {
		
		return employeeRepository.findById(id)
				.orElseThrow(()->new IdNotFoundException(AppConstant.ID_NOT_FOUND_MESSAGE));
	}

	
	
	@Override
	public Employee updateEmployeeById(int id, Employee employee) {
		
	Employee emp=	employeeRepository.findById(id)
		     .orElseThrow(()->new IdNotFoundException(AppConstant.ID_NOT_FOUND_MESSAGE_FOR_UPDATE));
	
	emp.setName(employee.getName());
	emp.setDept(employee.getDept());
	emp.setSalary(employee.getSalary());
	emp.setAge(employee.getAge());
	
		return employeeRepository.save(emp);
	}

	
	
	@Override
	public void deleteEmployeeById(int id) {
	   
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		
		if(optionalEmployee.isEmpty())
		{
			throw new IdNotFoundException(AppConstant.ID_NOT_FOUND_MESSAGE_FOR_DELETE);
		}
		employeeRepository.deleteById(id);
	}

}
