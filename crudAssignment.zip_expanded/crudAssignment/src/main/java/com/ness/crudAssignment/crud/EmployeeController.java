package com.ness.crudAssignment.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//ALL THE MAPPING IS DONE HERE.

@RequestMapping("employee")
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		Employee savedEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(savedEmployee,HttpStatus.FOUND);
	}
	@GetMapping
	public ResponseEntity<List<Employee>> getAll(){
		List<Employee> allEmployees = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(allEmployees,HttpStatus.FOUND);
			
	}
	@GetMapping("{empName}")
	public ResponseEntity<Employee> findEmployee(String empName){
		Employee employeeByName = employeeService.findEmployeeByName(empName);
		return new ResponseEntity<Employee>(employeeByName,HttpStatus.OK);
		
	}
	@PutMapping("{empId}")
	public ResponseEntity<Employee> updateAuthor(@RequestBody Employee employee, @PathVariable int empId)
	{
		Employee update=employeeService.updateEmployee(employee,empId);
		return new ResponseEntity<Employee>(update,HttpStatus.CREATED);
	}


	@DeleteMapping("{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int empId)
	{
		String delete = employeeService.deleteByempId(empId);
		return new ResponseEntity<String>(delete,HttpStatus.OK);
	}
	
	

}
