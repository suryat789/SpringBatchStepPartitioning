package com.demo.spring.batch.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.demo.spring.batch.models.PersonTarget;

@Repository("employeeDao")
public class PersonTargetDAOImpl implements PersonTargetDAO {
	
	@PersistenceContext(unitName="JPA-SB")
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void persist(Object entity) {
		getEntityManager().persist(entity);
	}

	public void delete(Object entity) {
		getEntityManager().remove(entity);
	}
	
	public void addPersonTarget(PersonTarget personTarget) {
		try {
			persist(personTarget);
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public PersonTarget getEmpoyeeDetails(String id) {
		Query query = getEntityManager().createQuery(" from PersonTarget pt WHERE pt.id = :id");
		query.setParameter("employeeID", id);
		
		List<PersonTarget> employees = query.getResultList();
		if(employees != null && !employees.isEmpty()){
			return employees.get(0);
		}
		return null;
	}
	
}
