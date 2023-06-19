package com.ness.crud.model;

import java.sql.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {

String authorName;
// generate gives automatic id to entered data if id is not given.
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Id
	int authorId;
	String bookTitle;
	Date dob;
	//boolean is not specified is sql. therefore type is used to state what datatype it is.
	@Type(type="yes_no") 
	boolean isActive;
	
	//agar variable sql mai same keyword rahega toh coloumn use karne se user_name column name mai rahega par user variable rahega. kyuki user keyword hai sql mai. toh avoid karne k liye 
	@Column(name="user_name") 
	String user;

	//actual table mai column add nahi hoga is property ka.
	@Transient 
	int somecalc;

	//agar datatype class type hai jaise address toh apne model mai woh property use karne k liye embedded lagega.
	@Embedded  
	Address officeAddress;


	 @AttributeOverrides({
	      @AttributeOverride(name = "city", column = @Column(name = "Home_City")),
	      @AttributeOverride(name = "state", column = @Column(name = "Home_State"))
	    })
	@Embedded
	Address homeAddress;
	 
	 
	 
	 
}

	


