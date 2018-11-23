package com.example.demo.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaUpdate;

import org.springframework.stereotype.Repository;
import com.example.demo.domain.Seller;
import org.springframework.data.repository.CrudRepository;
@Repository
public interface SellerRepository  extends CrudRepository<Seller,Long>{
	List<Seller> findByName(String name);
}

