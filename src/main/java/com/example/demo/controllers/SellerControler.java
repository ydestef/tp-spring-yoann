package com.example.demo.controllers;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Seller;
import com.example.demo.services.SellerService;


@RestController
@RequestMapping("/sellers")
public class SellerControler {
	
	private SellerService sellerService;

	@Autowired
	public SellerControler(SellerService sellerService) {
		super();
		this.sellerService = sellerService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Seller> getSellerByID(@PathVariable Long id) {
		return new ResponseEntity<Seller>(
				sellerService.findbyId(id), 
				HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Void> deleteSellerByID(@PathVariable Long id) {
			sellerService.DeleteById(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Seller seller, @PathVariable Long id) {

		Seller sellerOptimal = sellerService.findbyId(id);

		if (sellerOptimal.getId() == null)
			return ResponseEntity.notFound().build();

		seller.setId(id);
		
		sellerService.AddSeller(seller);

		return ResponseEntity.noContent().build();
	}
	
	
	@PostMapping("/")
	public ResponseEntity<Object> createStudent(@RequestBody Seller seller) {
		Seller savedSelled = sellerService.AddSeller(seller);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedSelled.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	


}
