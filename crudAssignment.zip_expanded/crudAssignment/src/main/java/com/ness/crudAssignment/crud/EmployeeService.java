package com.ness.crudAssignment.crud;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
	//create methods and override it in serviceimpl.
	public Employee saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee findEmployeeByName(String empName);
	public Employee updateEmployee(Employee employee, int empId);
	public String deleteByempId(int empId);
	
	

}
