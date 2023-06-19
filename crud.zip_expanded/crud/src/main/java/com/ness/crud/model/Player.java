package com.ness.crud.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

	@Id
	String email;
	String name;
	String team;
	String status;
	String role;
	
	
}



