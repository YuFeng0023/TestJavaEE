package com.yufeng.util;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class JPAUtil {
	static EntityManagerFactory factory ;
	static{
		factory = Persistence.createEntityManagerFactory("UserDao",null);
	}
	private EntityManager manager;
	public void init(){
		manager = factory.createEntityManager();
	}
	public <T> List<T> queryAll(String hql,Class<T> T){
		if(manager == null){
			init();
		}
		List<T> result = manager.createQuery(hql,T).getResultList();
		close();
		return result;
	}
	public void addObject(Object object){
		init();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(object);
		transaction.commit();
		close();
	}
	public void close(){
		manager.close();
		manager = null;
	}
}
