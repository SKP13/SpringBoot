package com.example.productService.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productService.model.Product;

@RestController
@RequestMapping("products")
public class ProductController {
	
	List<Product> products;
	
	@Value("${server.port}")
	int port;
	
	@GetMapping("getinfo")
	public ResponseEntity<String>getInfo(){
		return new ResponseEntity<String>("Server Running on Port"+port,HttpStatus.OK);
	}
	
	
	
	@PostConstruct
	void init()
	{

		products=new ArrayList<>();
		
		
		List<Product> productObj= Arrays.asList(new Product(1, "S22", 67000), 
				new Product(2, "Iphone13", 75000),
				new Product(3, "OnePlus 10R", 40000)
				);	
		products.addAll(productObj);
	

	}
	@GetMapping("getprods")
	public ResponseEntity<List<Product>> getProds(){
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Product> postProd(@RequestBody Product product){
		products.add(product);
		return new ResponseEntity<Product>(product,HttpStatus.OK);

		
	}
	
	
	

	
	
	
	
}
