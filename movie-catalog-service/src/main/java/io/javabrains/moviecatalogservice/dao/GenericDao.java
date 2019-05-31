package io.javabrains.moviecatalogservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.javabrains.moviecatalogservice.models.HasId;

public abstract class GenericDao<T extends HasId> {

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<T> clazz;

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T findOne(Long id) {
		return entityManager.find(clazz, id);
	}

	public void persist(T entity) {
		entityManager.persist(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return entityManager.createQuery("from " + clazz.getName()).getResultList();
	}

	public void save(T entity) {
		entityManager.persist(entity);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	public void deleteById(Long entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}
}
