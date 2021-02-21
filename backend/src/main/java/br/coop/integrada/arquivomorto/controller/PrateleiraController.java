package br.coop.integrada.arquivomorto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.coop.integrada.arquivomorto.model.Local;
import br.coop.integrada.arquivomorto.model.Prateleira;
import br.coop.integrada.arquivomorto.services.LocalService;
import br.coop.integrada.arquivomorto.services.PrateleiraService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/prateleiras")
public class PrateleiraController {
    @Autowired
    private PrateleiraService service;
    @Autowired
    private LocalService localService;

    @GetMapping
    public ResponseEntity<List<Prateleira>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }
    
    @GetMapping("/{id}/list-id")
    public ResponseEntity<Prateleira> findById(@PathVariable Long id){
        Optional<Prateleira> prateleira = service.findById(id);
        if(prateleira.isPresent()){
            return ResponseEntity.ok().body(prateleira.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Prateleira> insert(@RequestBody Prateleira prateleira){
        Optional<Local> local = localService.findById(prateleira.getIdLocal());
        
        if(local.isPresent()){
            prateleira = service.criarPrateleira(prateleira);
            return ResponseEntity.ok().body(prateleira);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Prateleira> update(@RequestBody Prateleira prateleira){
        Optional<Prateleira> prat = service.findById(prateleira.getIdPrateleira());
        Optional<Local> local = localService.findById(prateleira.getIdLocal());

        if(prat.isPresent() && local.isPresent()){
            prateleira = service.insert(prateleira);
            return ResponseEntity.ok().body(prateleira);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/delete-id")
    public ResponseEntity<Prateleira> delete(@PathVariable Long id){
        Optional<Prateleira> prat = service.findById(id);
        if(prat.isPresent()){
            Prateleira prateleira = prat.get();
            service.delete(prateleira);
            return ResponseEntity.ok().body(prateleira);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
