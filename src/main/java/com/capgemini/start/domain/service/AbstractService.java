package com.capgemini.start.domain.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.start.domain.service.exceptions.ObjectNotFoundException;

public abstract class AbstractService <T, ID>{
	
	protected abstract JpaRepository<T, ID> getRepository();
	
	public T findById(ID id) {
		return getRepository().findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto encontrado"));
	}
	
	public T insert(T entity) {
		return getRepository().save(entity);
	}
	
	public T update(T entity) {
		return getRepository().save(entity);
	}
	
	public void delete(ID id) {
		if (!getRepository().existsById(id)) {
			throw new ObjectNotFoundException("Objeto encontrado");
		}
		getRepository().deleteById(id);
	}
	
	public List<T> findAll(){
		return getRepository().findAll();
	}

}