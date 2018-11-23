package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
