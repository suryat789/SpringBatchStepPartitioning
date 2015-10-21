package com.demo.spring.batch.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.spring.batch.models.Person;

public class PersonMapper implements RowMapper<Person>{

	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();
		person.setFirstName(rs.getString("firstName"));
		person.setLastName(rs.getString("lastName"));
		person.setCity(rs.getString("city"));
		person.setId(rs.getInt("id"));
		return person;
	}

}
