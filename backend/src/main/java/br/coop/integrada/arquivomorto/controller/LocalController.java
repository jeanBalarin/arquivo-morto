package br.coop.integrada.arquivomorto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.coop.integrada.arquivomorto.model.Local;
import br.coop.integrada.arquivomorto.services.LocalService;

@RestController
@RequestMapping(value = "/locais")
public class LocalController {
	
	@Autowired
	private LocalService service;
	
	
	@GetMapping
	public ResponseEntity<List<Local>> findAll(){
		List<Local> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("/{id}/list-id")
	public ResponseEntity<Local> findAllId(@PathVariable Long id){
		Optional<Local> local = service.findById(id);
		
		if(local.isPresent()) {
			return ResponseEntity.ok().body(local.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	public ResponseEntity<Local> insert(@RequestBody Local local){
		local = service.insert(local);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(local.getIdLocal()).toUri();
		
		return ResponseEntity.created(uri).body(local);
	}
	
	@PutMapping
	public ResponseEntity<Local> update(@RequestBody Local local){
		Optional<Local> st = service.findById(local.getIdLocal());
		if(st.isPresent()) {
			local = service.insert(local);
			return ResponseEntity.ok().body(local);
		}
		else {
			return ResponseEntity.notFound().build();
		}	
	}
	
	
	@DeleteMapping("/{id}/delete-id")
	public ResponseEntity<Local> delete(@PathVariable Long id){
		Optional<Local> local = service.findById(id);
		if(local.isPresent()) {
			service.delete(local.get());
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(local.get().getIdLocal()).toUri();
			return ResponseEntity.created(uri).body(local.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}	
	}
}
