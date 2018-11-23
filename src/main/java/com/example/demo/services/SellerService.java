package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Seller;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.SellerRepository;


@Service
public class SellerService {
	
	private SellerRepository sellerRepo;

	@Autowired
	public SellerService(SellerRepository sellerRepository){
		super();
		this.sellerRepo = sellerRepository;
	}
	
	
	public Seller findByName(String name) {
		List<Seller> sellers = sellerRepo.findByName(name);
		return (sellers.isEmpty()) ?  null : sellers.get(0);
	}
	
	public Seller findbyId(Long id) {
		return sellerRepo.findById(id).orElse(new Seller());
	}
	
	public void DeleteById(Long id) {
		
		 sellerRepo.deleteById(id);
		
	}
	
	public void updateSeller()
	{
		List<Seller> sellers = (List<Seller>) sellerRepo.findAll();
		
	}
	

}
