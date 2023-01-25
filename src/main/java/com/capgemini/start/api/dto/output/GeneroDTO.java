package com.capgemini.start.api.dto.output;

import java.time.LocalDateTime;

public class GeneroDTO {
	private Long id;
	private String descricao;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataAlteracao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

}
