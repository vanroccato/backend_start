package com.capgemini.start.domain.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.capgemini.start.domain.entity.Tipo;
import com.capgemini.start.domain.repository.TipoRepository;
import com.capgemini.start.domain.service.exceptions.ObjectAlreadyExistsException;
import com.capgemini.start.domain.service.exceptions.ObjectNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TipoService extends AbstractService {
	
	private final TipoRepository repository;
	
	@Override
	protected JpaRepository<Tipo, Long> getRepository() {
		return this.repository;
	}
	
	@Override
	public List<Tipo> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Tipo findById(Long id){
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Tipo não encontrado"));
	}
	
	@Override
	public Tipo insert(Tipo tipo) {
		if (this.repository.existsByDescricaoIgnoreCase(tipo.getDescricao())){
			throw new ObjectAlreadyExistsException("Já existe um tipo com esta descrição.");
		}
		tipo.setDataCriacao(new Date());
		return this.repository.save(tipo);
	}
	
	@Override
	public Tipo update(Tipo tipo) {
		if (this.repository.existsByIdNotAndDescricaoIgnoreCase(tipo.getId(), tipo.getDescricao())) {
			throw new ObjectAlreadyExistsException("Já existe outro tipo com esta descrição.");
		}
		tipo.setDataAlteracao(new Date());
		return this.repository.save(tipo);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
