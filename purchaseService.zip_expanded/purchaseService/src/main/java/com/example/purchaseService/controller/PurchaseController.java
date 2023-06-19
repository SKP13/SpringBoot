package com.example.purchaseService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.purchaseService.model.Product;

@RestController
@RequestMapping("purchase")
public class PurchaseController {
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("dispprods")
	public ResponseEntity<List<Product>> getProds() {
		List<Product> products = restTemplate.getForObject("http://product/products/getprods", List.class);
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		
	}
	
	@GetMapping("getreq")
	public ResponseEntity<String>getServiceInfo(){
		String msg = restTemplate.getForObject("http://product/products/getinfo", String.class);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PostMapping("addprods")
	public ResponseEntity<Product> addProd(@RequestBody Product product){
		Product savedProducts = restTemplate.postForObject("http://localhost:1234/products", product, Product.class);
		return new ResponseEntity<Product>(savedProducts,HttpStatus.OK);
		
	}
	

}
