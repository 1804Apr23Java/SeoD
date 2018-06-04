package com.revature.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.bean.Coffee;
import com.revature.repository.CoffeeRepository;
//import com.revature.service.CoffeeService;

@RestController
public class CoffeeController {
	
	
	@Autowired
	CoffeeRepository coffeeRepo;
	
	
	@GetMapping("/coffee")
	public ResponseEntity<Coffee> getMahCoffee() {
		return new ResponseEntity<>(coffeeRepo.getOne(1), HttpStatus.OK);
	}
	
	@GetMapping("/gimme")
	public String hardCoded() {
		return "Here you go";
		//return new ResponseEntity<>(coffeeRepo.getOne(1), HttpStatus.OK);
	}

}
