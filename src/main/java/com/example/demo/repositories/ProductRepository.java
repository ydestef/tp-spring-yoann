package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.domain.Product;
import com.example.demo.domain.Seller;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
}
