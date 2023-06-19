package com.ness.crudAssignment.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
// here in DOA naming convention must be followed
	public Employee findByEmpName(String empName);
	

	
	
	

}
