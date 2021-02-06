package br.coop.integrada.arquivomorto.controller;

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

import br.coop.integrada.arquivomorto.model.Prateleira;
import br.coop.integrada.arquivomorto.model.Reparticao;
import br.coop.integrada.arquivomorto.services.PrateleiraService;
import br.coop.integrada.arquivomorto.services.ReparticaoService;

@RestController
@RequestMapping(value = "/reparticoes")
public class ReparticaoController {
    
    @Autowired
    private ReparticaoService service;
    @Autowired
    private PrateleiraService prateleiraService;

    @GetMapping
    public ResponseEntity<List<Reparticao>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}/list-id")
    public ResponseEntity<Reparticao> findById(@PathVariable Long id){
        Optional<Reparticao> reparticao = service.findById(id);

        if(reparticao.isPresent()){
            return ResponseEntity.ok().body(reparticao.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Reparticao> insert(@RequestBody Reparticao reparticao){
        Optional <Prateleira> prateleira = prateleiraService.findById(reparticao.getIdPrateleira());

        if(prateleira.isPresent()){
            reparticao = service.insert(reparticao);
            return ResponseEntity.ok().body(reparticao);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Reparticao>update(@RequestBody Reparticao reparticao){
        Optional <Prateleira> prateleira = prateleiraService.findById(reparticao.getIdPrateleira());
        Optional <Reparticao> repart = service.findById(reparticao.getIdReparticao());

        if(prateleira.isPresent() && repart.isPresent()){
            reparticao = service.insert(reparticao);
            return ResponseEntity.ok().body(reparticao);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/delete-id")
    public ResponseEntity<Reparticao> delete (@PathVariable Long id){
        Optional<Reparticao> repar = service.findById(id);

        if(repar.isPresent()){
            Reparticao reparticao = repar.get();
            service.delete(reparticao);
            return ResponseEntity.ok().body(reparticao);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}
