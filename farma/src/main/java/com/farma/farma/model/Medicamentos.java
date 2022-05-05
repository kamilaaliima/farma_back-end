package com.farma.farma.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_medicamentos")
public class Medicamentos {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message= "O atributo nome é obrigatorio!")
	@Size(min = 5, max = 20)
	private String nome; 
	
	@NotBlank(message= "O atributo descrição é obrigatorio!")
	@Size(min = 5, max = 20)
	private String descricao;
	
	@NotBlank(message= "O atributo descrição é obrigatorio!")
	@Size(min = 5, max = 10)
	private String tipo;
	

	@NotBlank
	private String valor;
	
	@ManyToOne
	@JsonIgnoreProperties("medicamentos")
	private Categorias categorias;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	} 
	
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
