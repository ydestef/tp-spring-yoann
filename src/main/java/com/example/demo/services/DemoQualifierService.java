package com.example.demo.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("DemoQualService")
public class DemoQualifierService implements IService{

	@Override
	public Integer getNumber() {
		return 0;
	}

}
