package com.capgemini.start.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.start.domain.entity.Tipo;


public interface TipoRepository extends JpaRepository<Tipo, Long>{
	
	boolean existsByDescricaoIgnoreCase(String descricao);
	
	boolean existsByIdNotAndDescricaoIgnoreCase(Long id, String descricao);

}
