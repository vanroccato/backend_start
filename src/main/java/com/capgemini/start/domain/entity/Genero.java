package com.capgemini.start.domain.entity;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity(name="tb_genero")
public class Genero {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_genero", nullable = false)
	private Long id;
	
	@Column(name ="ds_genero", nullable = false, length = 100)
	private String descricao;
	
	@Column(name = "dt_criacao", nullable = false)
	private Date dataCriacao;

	@Column(name = "dt_alteracao")
	private Date dataAlteracao;

	public void setDescricao(Object descricao2) {
		// TODO Auto-generated method stub
		
	}

	public Map<String, ?> getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescricao() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDataInclusao(Date date) {
		// TODO Auto-generated method stub
		
	}
	}
