package com.lamppIt.backed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lamppIt.backed.model.ClienteModel;
import com.lamppIt.backed.repository.ClienteRepositry;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepositry repository;

	public List<ClienteModel> listar() {
		return repository.findAll();
	}

	public ClienteModel buscarPorId(Long id) { 
		return repository.buscarPorId(id);
	}

	public void salvar(ClienteModel cliente) {
		repository.save(cliente);
	}

	public void atualizar(ClienteModel cliente) {
		repository.atualizar(cliente);
	}

	public void excluir(Long id) {
		repository.deleteById(id);
	}

}
