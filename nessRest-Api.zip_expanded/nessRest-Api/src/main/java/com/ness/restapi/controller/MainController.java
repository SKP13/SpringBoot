package com.ness.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ness.restapi.model.Author;

@RestController
public class MainController {
	

	@GetMapping("/hello")
	public String sayHello()
	{
		
		return "hello world";
	}
	
	@GetMapping("/author")
	public Author getAuthor()
	{
		
		return new Author("Chetan Bhagat", 20);
	}
	
	@GetMapping("/authorre")
	public ResponseEntity<Author> getAuthorRe()
	{		
		Author author=new Author("Charles Buwoski", 18);
		return new ResponseEntity<Author>(author,HttpStatus.FOUND);
	}
	//responseEntity is a standard way to return json object.
	//it takes two args, ist obj, 2nd http status.
	
}


