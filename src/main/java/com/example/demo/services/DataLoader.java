package com.example.demo.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Product;
import com.example.demo.domain.Seller;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.SellerRepository;



@Service
public class DataLoader {

	private SellerRepository sellerRepo;
	private ProductRepository productRepo;

	@Autowired
	public DataLoader(SellerRepository sellerRepo, ProductRepository productRepo) {
		super();
		this.sellerRepo = sellerRepo;
		this.productRepo = productRepo;
	}

	@PostConstruct
	private void loadData() {
		
		productRepo.deleteAll();
		sellerRepo.deleteAll();
		
		
		//create client 
		Seller seller1 = new Seller(null,"patrick","rue des champs",20000,"paris",null);
		sellerRepo.save(seller1);
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		Date date = new Date();
		
		Product p1 = new Product(null,"nintendoDS","console portable","//img//ds.png",125.6,date,seller1);
		Product p2 = new Product(null,"ps4","console salon","//img//ps4.png",400.66,date,seller1);
		productRepo.save(p1);
		productRepo.save(p2);
		
	}
	
	
}
