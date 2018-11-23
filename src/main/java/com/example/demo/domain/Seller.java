package com.example.demo.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name="seller")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;

	private String address;
	
	private Integer zipcode;
	private String city;
	@OneToMany(mappedBy="seller")
	private List<Product>products;
}
