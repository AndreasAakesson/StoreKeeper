package storekeeper.ejb;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericEJB<T> {
	
	@PersistenceContext
	private EntityManager entityManager;
	private Class<T> entityClass;
	
	public GenericEJB(Class<T> iEntityClass){
		entityClass = iEntityClass;
	}
	
	// Mulig vi må bruke entityManager.persist(entity) i stedet for, men det er en void metode.
	public T add(T entity){
		return entityManager.merge(entity);
	}
	
	public void delete(T entity){
		T entityToBeRemoved = entityManager.merge(entity);
		entityManager.remove(entityToBeRemoved);
	}
	
	public T update(T entity) {
		return entityManager.merge(entity);
	}

	public T find(int entityID) {
		  return entityManager.find(entityClass, entityID);
		 }
		 
	 // Using the unchecked because JPA does not have a
	 // entityManager.getCriteriaBuilder().createQuery()<T> method
	 // @SuppressWarnings({ 'unchecked', 'rawtypes' })
	 public List<T> findAll() {
		 CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
		 cq.select(cq.from(entityClass));
		 return entityManager.createQuery(cq).getResultList();
	 }
		 
	 // Using the unchecked because JPA does not have a
	 // query.getSingleResult()<T> method
	 // @SuppressWarnings('unchecked')
	 protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
		 T result = null;
		 
		 try {
			 Query query = entityManager.createNamedQuery(namedQuery);
		 
			 // Method that will populate parameters if they are passed not null and empty
			 if (parameters != null && !parameters.isEmpty()) {
				 populateQueryParameters(query, parameters);
			 }
			 result = (T) query.getSingleResult();
		 
		  }
		 catch (Exception e) {
			 System.out.println("Error while running query: " + e.getMessage());
			 e.printStackTrace();
		 }
		 
		 return result;
	 }
	 
	 private void populateQueryParameters(Query query, Map<String, Object> parameters) {
		 for (Entry<String, Object> entry : parameters.entrySet()) {
			 query.setParameter(entry.getKey(), entry.getValue());
		 }
	 }	
	
}
