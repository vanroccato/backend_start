package com.capgemini.start.api.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.capgemini.start.api.dto.input.GeneroInputDTO;
import com.capgemini.start.api.dto.output.GeneroDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface GeneroResource {
	@Operation(summary = "Consulta um Genero por id")
	@GetMapping(value = "/{id}")
	ResponseEntity<GeneroDTO> findById(@PathVariable Long id);

	@Operation(summary = "Lista todos os generos")
	@GetMapping()
	ResponseEntity<List<GeneroDTO>> findAll();

	@Operation(summary = "Insere um genero")
	@PostMapping()
	ResponseEntity<GeneroDTO> insert(@RequestBody @Valid GeneroInputDTO genero);

	@Operation(summary = "Atualiza um genero")
	@PutMapping(value = "/{id}")
	ResponseEntity<GeneroDTO> update(@PathVariable Long id, @RequestBody @Valid GeneroInputDTO genero);

	@Operation(summary = "Exclui um genero pelo id")
	@DeleteMapping(value = "/{id}")
	ResponseEntity<Void> delete(@PathVariable Long id);

	ResponseEntity<Void> delete(Integer id);

	ResponseEntity<GeneroDTO> update(Integer id, @Valid GeneroDTO genero);

	ResponseEntity<GeneroDTO> findById(Integer id);

}
