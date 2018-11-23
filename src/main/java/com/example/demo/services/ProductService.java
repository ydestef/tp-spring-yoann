package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Product;
import com.example.demo.domain.Seller;
import com.example.demo.repositories.ProductRepository;


@Service
public class ProductService {
	
	private ProductRepository productRepo;

	@Autowired
	public ProductService(ProductRepository productRepo){
		super();
		this.productRepo = productRepo;
	}
	
	/*
	public Product findByName(String name) {
		List<Client> clients = clientRepo.findByLastname(name);
		return (clients.isEmpty()) ?  null : clients.get(0);
	}
	*/
	
	public List<Product> findByAll()
	{
		List<Product> products = (List<Product>) productRepo.findAll();
		return(products.isEmpty()) ? null : products;
	}
	
	public String DeleteById(Long id) {		
		 productRepo.deleteById(id);
		 return "DELETED";
	}
	public Product findbyId(Long id) {
		return productRepo.findById(id).orElse(new Product());
	}
	
	public Product AddProduct(Product prd) {
		Product savedProduct = productRepo.save(prd);
		return savedProduct;
	}
}
