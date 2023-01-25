package com.capgemini.start.domain.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.capgemini.start.domain.entity.Genero;
import com.capgemini.start.domain.repository.GeneroRepository;
import com.capgemini.start.domain.service.exceptions.ObjectAlreadyExistsException;
import com.capgemini.start.domain.service.exceptions.ObjectNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GeneroService extends AbstractService<Genero, Integer> {

	private final GeneroRepository repository;

	@Override
	protected JpaRepository<Genero, Integer> getRepository() {
		return this.repository;
	}

	public Genero findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Gênero não encontrado!"));
	}

	public List<Genero> findAll(){
		return repository.findAll();
	}

	@Override
	public Genero insert(Genero genero) {
		if(this.repository.existsByDescricaoIgnoreCase(genero.getDescricao())) {
			throw new ObjectAlreadyExistsException("Já existe um genero com esta descrição.");
		}
		genero.setDataInclusao((java.sql.Date) new Date());
		return this.repository.save(genero);
	}

	public Genero update(Genero genero) {
		if(this.repository.existsByIdNotAndDescricaoIgnoreCase(genero.getId(), genero.getDescricao())) {
			throw new ObjectAlreadyExistsException("Já existe outro genero com esta descrição.");
		}
		genero.setDataAlteracao((java.sql.Date) new Date());
		return repository.save(genero);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}