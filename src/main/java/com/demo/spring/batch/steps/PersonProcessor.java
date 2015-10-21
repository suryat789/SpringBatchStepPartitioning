package com.demo.spring.batch.steps;

import org.springframework.batch.item.ItemProcessor;

import com.demo.spring.batch.models.Person;
import com.demo.spring.batch.models.PersonTarget;

public class PersonProcessor implements ItemProcessor<Person, PersonTarget> {

	public PersonTarget process(Person person) throws Exception {
		PersonTarget personTarget = new PersonTarget(person.getId(), person.getFirstName(), person.getLastName(), person.getCity());
		
		return personTarget;
	}

}
