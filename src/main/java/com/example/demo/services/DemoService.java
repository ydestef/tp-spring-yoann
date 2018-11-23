package com.example.demo.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("DemoService")
@Scope("prototype")
// @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DemoService implements IService {
	
	public Integer number;
	
	// execute after bean initialization
	@PostConstruct
	private void init() {
		// random number between 0 - 100
		this.number = (int) (Math.random() * 100);   
	}

	@Override
	public Integer getNumber() {
		return this.number;
	}

}
