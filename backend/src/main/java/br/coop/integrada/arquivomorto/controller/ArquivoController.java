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

import br.coop.integrada.arquivomorto.model.Caixa;
import br.coop.integrada.arquivomorto.model.Arquivo;
import br.coop.integrada.arquivomorto.services.ArquivoService;
import br.coop.integrada.arquivomorto.services.CaixaService;


@RestController
@RequestMapping(value = "/arquivos")
public class ArquivoController {
	
	@Autowired
	private ArquivoService service;
	@Autowired
	private CaixaService serviceCaixa;

	
	@GetMapping
	public ResponseEntity<List<Arquivo>> findAll(){
		List<Arquivo> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("/{id}/list-id")
	public ResponseEntity<Arquivo> findAllId(@PathVariable Long id){
		Optional<Arquivo> arquivo = service.findById(id);
		
		if(arquivo.isPresent()) {
			return ResponseEntity.ok().body(arquivo.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	@PostMapping
	public ResponseEntity<Arquivo> insert(@RequestBody Arquivo arq){
		Optional<Caixa> caixa = serviceCaixa.findById(arq.getIdCaixa());
		if(caixa.isPresent()) {
			arq = service.insert(arq);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(arq.getIdArquivo()).toUri();	
			return ResponseEntity.created(uri).body(arq);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Arquivo> update(@RequestBody Arquivo arq){
		Optional<Arquivo> arquivo = service.findById(arq.getIdArquivo());
		if(arquivo.isPresent()) {
			arq = service.update(arq);
			return ResponseEntity.ok().body(arq);
		}
		else {
			return ResponseEntity.notFound().build();
		}	
	}
	
	
	@DeleteMapping("/{id}/delete-id")
	public ResponseEntity<Arquivo> delete(@PathVariable Long id){
		Optional<Arquivo> arquivo = service.findById(id);
		if(arquivo.isPresent()) {
			service.delete(arquivo.get());
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(arquivo.get().getIdArquivo()).toUri();
			return ResponseEntity.created(uri).body(arquivo.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}	
	}
}
