package com.capgemini.start.api.resource.impl;

import java.net.URI;
import java.net.http.HttpHeaders;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.capgemini.start.api.dto.input.GeneroInputDTO;
import com.capgemini.start.api.dto.output.GeneroDTO;
import com.capgemini.start.api.mapper.GeneroMapper;
import com.capgemini.start.api.resource.GeneroResource;
import com.capgemini.start.domain.entity.Genero;
import com.capgemini.start.domain.service.GeneroService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@SuppressWarnings("unused")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/generos")
public class GeneroResourceImpl  implements GeneroResource{

	private final GeneroService service;

	@Autowired
	private GeneroMapper mapper;

	@Override
	public ResponseEntity<GeneroDTO> findById(Integer id) {
		Genero genero = this.service.findById(id);
		GeneroDTO dto = mapper.toDTO(genero);
		return ResponseEntity.ok(dto);
	}

	@Override
	public ResponseEntity<List<GeneroDTO>> findAll() {
		return ResponseEntity.ok(
				this.service.findAll()
				.stream()
				.map(genero -> mapper.toDTO(genero))
				.collect(Collectors.toList())
				);
	}


	@Override
	public ResponseEntity<GeneroDTO> insert(@RequestBody @Valid GeneroInputDTO genero) {
		Genero entity = mapper.toEntity(genero);
		Genero createdEntity = this.service.insert(entity);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdEntity.getId())
				.toUri();
		return ResponseEntity.status(HttpStatus.CREATED)
				.header(org.springframework.http.HttpHeaders.LOCATION, location.toString())
				.body(mapper.toDTO(createdEntity));
	}

	@Override
	public ResponseEntity<GeneroDTO> update(Integer id, @Valid GeneroDTO genero) {
		Genero toUpdate = this.service.findById(id);
		toUpdate.setDescricao(genero.getDescricao());

		Genero updated = this.service.update(toUpdate);

		return ResponseEntity.ok(mapper.toDTO(updated));
	}

	@Override
	public ResponseEntity<Void> delete(Integer id) {
		this.service.delete(id);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<GeneroDTO> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<GeneroDTO> update(Long id, @Valid GeneroInputDTO genero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}