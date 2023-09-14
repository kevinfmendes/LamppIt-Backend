package com.lamppIt.backed.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lamppIt.backed.model.ClienteModel;
import com.lamppIt.backed.service.ClienteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;
	
	@GetMapping(value = "/listar-todos",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listar(){
	 try {
		 List<ClienteModel> lista = service.listar(); 
		 return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
			
		} catch (Exception e) {
			 return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping(value = "/buscar-por-id",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarPorId(@RequestParam("id") Long id){
	 try {
		 ClienteModel cliente = service.buscarPorId(id); 
		 return cliente == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(cliente);
			
		} catch (Exception e) {
			 return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	@PostMapping(value = "/salvar-cliente", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> salvar(@RequestBody ClienteModel cliente){
	 try {
		 service.salvar(cliente); 
		 URI location = URI.create(String.format("/clientes/buscar-por-id?id=%s", cliente.getId()));
		 return ResponseEntity.created(location).build();
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping(value = "/atualizar-cliente", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> atualizar(@RequestBody ClienteModel cliente){
	 try {
		 service.atualizar(cliente); 
		 URI location = URI.create(String.format("/clientes/buscar-por-id?id=%s", cliente.getId()));
		 return ResponseEntity.ok().location(location).build();
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	@DeleteMapping(value = "/excluir-por-id",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> excluir(@RequestParam("id") Long id){
	 try {
		 service.excluir(id); 
		 return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			 return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
}
