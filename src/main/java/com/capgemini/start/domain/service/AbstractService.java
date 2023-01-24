package com.capgemini.start.domain.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.start.domain.entity.Tipo;

public class AbstractService {

	protected JpaRepository<Tipo, Long> getRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Tipo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Tipo findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Tipo update(Tipo tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Tipo insert(Tipo tipo) {
		// TODO Auto-generated method stub
		return null;
	}

}
