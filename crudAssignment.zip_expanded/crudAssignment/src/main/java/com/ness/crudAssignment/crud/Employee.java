package com.ness.crudAssignment.crud;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
	
	@Id
	private int empId;
	private String empName;
	private String city;
	private int mobilenumber;
	private int salary; 


}
