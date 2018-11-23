package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.IService;



@RestController
public class DemoScopeController {
	
	@Autowired
	@Qualifier("DemoQualService")
	private IService ds;
	
	@GetMapping(value="/number2")
	// @RequestMapping(value="/demo", method=RequestMethod.GET)
	public ResponseEntity<Integer> getNumber() {
		return new ResponseEntity<Integer>(ds.getNumber(), HttpStatus.OK);
	}
}
