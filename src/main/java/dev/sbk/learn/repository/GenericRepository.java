package dev.sbk.learn.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class GenericRepository<T> implements IGenericRepository<T> {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(T temp) {
		em.persist(temp);
	}

	@Override
	public void update(T temp) {
		em.merge(temp);
	}

	@Override
	public void remove(Class<T> temp, Long id) {
		em.remove(findOneById(temp, id));

	}

	@Override
	public T findOneById(Class<T> temp, Long id) {

		return em.find(temp, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> temp) {
		Query query = em.createQuery("SELECT t FROM " + temp.getName() + " t");
		return query.getResultList();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
