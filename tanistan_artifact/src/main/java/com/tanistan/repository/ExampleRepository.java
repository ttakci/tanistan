package com.tanistan.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ExampleRepository {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void testSave(Example example){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(example);
		tx.commit();
		session.close();
	}
}
