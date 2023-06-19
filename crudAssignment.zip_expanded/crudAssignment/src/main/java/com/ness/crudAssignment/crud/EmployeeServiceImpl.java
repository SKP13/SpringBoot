package com.ness.crudAssignment.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	//use DOA inbuilt methods in functions
	@Autowired
	EmployeeDao employeeDao;
	


	public Employee saveEmployee(Employee employee) {
		return employeeDao.save(employee);
		
	}
	
	public List<Employee> getAllEmployees(){
		return (List<Employee>)employeeDao.findAll();
		
	}
	public Employee findEmployeeByName(String empName) {
		return employeeDao.findByEmpName(empName);
	}
	public Employee updateEmployee(Employee employee, int empId) {
		return employeeDao.save(employee);
		
	}

	
	
	@Override
	public String deleteByempId(int empId) {
		employeeDao.deleteById(empId);
		return "EMPLOYEE DELETED";
	}
	
	

}
