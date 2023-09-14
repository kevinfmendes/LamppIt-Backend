package com.lamppIt.backed.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "CLIENTES")
public class ClienteModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@JsonProperty(value = "id") 
	private Long id;
	
	@JsonProperty(value = "nome") 
	@Column(name = "NOME")
	private String nome;
	
	@JsonProperty(value = "sobrenome")
	@Column(name = "SOBRENOME")
	private String sobrenome;
	
	@JsonProperty(value = "email")
	@Column(name = "EMAIL")
	private String email;
	
	@JsonProperty(value = "telefone")
	@Column(name = "TELEFONE")
	private String telefone;
	
	
	
	

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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}
