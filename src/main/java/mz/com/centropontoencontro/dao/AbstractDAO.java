package mz.com.centropontoencontro.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public abstract class AbstractDAO<T> {

	@SuppressWarnings("unchecked")
	private final Class<T> entityClass = (Class<T>) ((java.lang.reflect.ParameterizedType) getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void save(T entity) {
		entityManager.persist(entity);
	}
	
	public void update(T entity) {
		entityManager.merge(entity);
	}
	
	public T findById(Long id) {
		return entityManager.find(entityClass, id);
	}
	
	public void delete(Long id) {
		entityManager.remove(entityManager.getReference(entityClass, id));
	}
	
	public List<T> findAll(){
		return entityManager.createQuery("from "+ entityClass.getSimpleName(), entityClass).getResultList();
	}
	
	public List<T> createQuery(String jpql, Object... params){
		TypedQuery<T> query = entityManager.createQuery(jpql, entityClass);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}
		return query.getResultList();
	}
	
	public List<T> createJpqlQuery(String jpql){
		TypedQuery<T> query = (TypedQuery<T>) entityManager.createQuery(jpql);
		return query.getResultList();
	}
	

	public Long createSingleResultQueryJpql(String jpql) {
		TypedQuery<Long> query = (TypedQuery<Long>) entityManager.createQuery(jpql);
		return query.getSingleResult();
		
	}
	
	public void createQuery(String jpql) {
		Query query = entityManager.createQuery(jpql);
		query.executeUpdate();
	}
	

		

	
	

	
	
	
	
	
	
	
}
