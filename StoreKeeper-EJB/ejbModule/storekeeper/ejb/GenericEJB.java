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
		try
		{
			return entityManager.find(entityClass, entityID);			
		}
		catch(Exception e)
		{
			return null;			
		}		
	}

	public List<T> findAll() {
		CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return entityManager.createQuery(cq).getResultList();
	}

	protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
		try {
			Query query = entityManager.createQuery(namedQuery.toString());

			// Method that will populate parameters if they are passed not null and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}
			return (T) query.getSingleResult();

		}
		catch (Exception e) {
			return null;
		}
	}

	private void populateQueryParameters(Query query, Map<String, Object> parameters) {
		for (Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}	

}
