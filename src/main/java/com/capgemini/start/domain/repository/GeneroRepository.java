package com.capgemini.start.domain.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.start.domain.entity.Genero;


@SuppressWarnings("unused")
public interface GeneroRepository extends JpaRepository<Genero, Long>{

	boolean existsByDescricaoIgnoreCase(String descricao);

	boolean existsByIdNotAndDescricaoIgnoreCase(Map<String, ?> map, String descricao);

}