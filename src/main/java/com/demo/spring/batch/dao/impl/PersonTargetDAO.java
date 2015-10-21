package com.demo.spring.batch.dao.impl;

import com.demo.spring.batch.models.PersonTarget;


public interface PersonTargetDAO {
	
	public void addPersonTarget(PersonTarget personTarget);

	PersonTarget getEmpoyeeDetails(String id);
		
}