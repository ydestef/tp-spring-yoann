package com.example.demo.controllers;

//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.IService;



@RestController // => met automatique un @ResponseBody
public class DemoController {
	
	@Autowired
	@Qualifier("DemoService")
	private IService ds;

	
	@GetMapping(value="/demo", produces={MediaType.APPLICATION_JSON_VALUE})
	// @RequestMapping(value="/demo", method=RequestMethod.GET)
	public ResponseEntity<String> demo() {
		String jsonResult = "{\"msg\":\"message from json\"}";
		return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
	}
	
	@GetMapping(value="/number")
	// @RequestMapping(value="/demo", method=RequestMethod.GET)
	public ResponseEntity<Integer> getNumber() {
		return new ResponseEntity<Integer>(ds.getNumber(), HttpStatus.OK);
	}

}
