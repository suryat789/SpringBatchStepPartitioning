package com.demo.spring.batch.steps;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.spring.batch.dao.impl.PersonTargetDAO;
import com.demo.spring.batch.models.PersonTarget;

public class PersonWriter implements ItemWriter<PersonTarget> {

	//@Autowired
	//@Qualifier("targetDAO")
	private PersonTargetDAO personTargetDAO;
	
	public PersonTargetDAO getPersonTargetDAO() {
		return personTargetDAO;
	}

	public void setPersonTargetDAO(PersonTargetDAO personTargetDAO) {
		this.personTargetDAO = personTargetDAO;
	}

	public void write(List<? extends PersonTarget> persons) throws Exception {
		for (PersonTarget personTarget : persons) {
			if(personTarget != null){
				System.out.println(personTarget);
				getPersonTargetDAO().addPersonTarget(personTarget);
			}
		}
		
	}
}
