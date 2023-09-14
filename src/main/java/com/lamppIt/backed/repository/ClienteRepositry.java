package com.lamppIt.backed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.lamppIt.backed.model.ClienteModel;

import jakarta.transaction.Transactional;

@Transactional
public interface ClienteRepositry extends JpaRepository<ClienteModel, Long> {
	
	@Query(value = "SELECT * FROM CLIENTES WHERE ID = :id", nativeQuery = true)
	ClienteModel buscarPorId(Long id);

	@Modifying
	@Query(value = "UPDATE CLIENTES SET"
	        + " NOME = :#{#cliente.nome},"
	        + " SOBRENOME = :#{#cliente.sobrenome},"
	        + " EMAIL = :#{#cliente.email},"
	        + " TELEFONE = :#{#cliente.telefone}" 
	        + " WHERE ID = :#{#cliente.id}", nativeQuery = true)
	void atualizar(ClienteModel cliente);

}
