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

import br.coop.integrada.arquivomorto.model.Arquivo;
import br.coop.integrada.arquivomorto.model.Caixa;
import br.coop.integrada.arquivomorto.model.Setor;
import br.coop.integrada.arquivomorto.services.ArquivoService;
import br.coop.integrada.arquivomorto.services.CaixaService;
import br.coop.integrada.arquivomorto.services.SetorService;

@RestController
@RequestMapping(value = "/caixas")
public class CaixaController {
	
	@Autowired
	private CaixaService service;
	@Autowired
	private SetorService serviceCaixa;
	@Autowired
	private ArquivoService serviceArquivo;
	
	@GetMapping
	public ResponseEntity<List<Caixa>> findAll(){
		List<Caixa> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/{id}/list-id")
	public ResponseEntity<Caixa> findAllId(@PathVariable Long id){
		Optional<Caixa> caixa = service.findById(id);
		if(caixa.isPresent()) {
			return ResponseEntity.ok().body(caixa.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Caixa> insert(@RequestBody Caixa caixa){
		Optional <Setor> setor = serviceCaixa.findById(caixa.getIdSetor());
			
		if(setor.isPresent()) {
			caixa = service.insert(caixa);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(caixa.getIdCaixa()).toUri();	
			return ResponseEntity.created(uri).body(caixa);
			
		}
		else{
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PutMapping
	public ResponseEntity<Caixa> update(@RequestBody Caixa caixa){
		
		Optional<Caixa> cx = service.findById(caixa.getIdCaixa());
		
		if(cx.isPresent()) {
			caixa = service.update(caixa);
			return ResponseEntity.ok().body(caixa);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}/delete-id")
	public ResponseEntity<Caixa> delete(@PathVariable Long id){
		Optional<Caixa> cx = service.findById(id);
		if(cx.isPresent()){
			Caixa caixa = cx.get();
			if(caixa.getArquivos()!= null){
				serviceArquivo.delete(caixa.getArquivos());
			}
			service.delete(caixa);
		}
		return null;
	}
	
}
