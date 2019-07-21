package com.example.demo.userservice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
@Transactional
public class ApplicationDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	private List<UserEntity> users;
	
	public List<UserEntity> getUsers(){		
		Query query = entityManager.createNativeQuery("select * from USER", UserEntity.class);
		users = query.getResultList();
		return users;
	}
	
	
}
