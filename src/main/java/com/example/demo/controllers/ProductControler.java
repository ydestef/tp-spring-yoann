package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

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

import com.example.demo.domain.Product;
import com.example.demo.domain.Seller;
import com.example.demo.services.ProductService;
import com.example.demo.services.SellerService;


@RestController
@RequestMapping("/products")
public class ProductControler{
	
	private ProductService productService;

	@Autowired
	public ProductControler(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> findByAll() {
		return new ResponseEntity<List<Product>>(
				productService.findByAll(), 
				HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> DeleteByID(@PathVariable Long id) {
		return new ResponseEntity<String>(
				productService.DeleteById(id),
				HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Product prd, @PathVariable Long id) {

		Product prdOptimal = productService.findbyId(id);

		if (prdOptimal.getId() == null)
			return ResponseEntity.notFound().build();

		prd.setId(id);
		
		productService.AddProduct(prdOptimal);

		return ResponseEntity.noContent().build();
	}
	
	
	@PostMapping("/")
	public ResponseEntity<Object> createStudent(@RequestBody Product prd) {
		Product savedProduct = productService.AddProduct(prd);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProduct.getId()).toUri();

		return ResponseEntity.created(location).build();

	}


}
