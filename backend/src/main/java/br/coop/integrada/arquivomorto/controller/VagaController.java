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

import br.coop.integrada.arquivomorto.model.Reparticao;
import br.coop.integrada.arquivomorto.model.Vaga;
import br.coop.integrada.arquivomorto.services.ReparticaoService;
import br.coop.integrada.arquivomorto.services.VagaService;

@RestController
@RequestMapping(value = "/vagas")
public class VagaController {

    @Autowired
    private VagaService service;
    @Autowired
    private ReparticaoService reparticaoService;

    @GetMapping
    public ResponseEntity<List<Vaga>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}/list-id")
    public ResponseEntity<Vaga> findById(@PathVariable Long id){
        Optional<Vaga> vaga = service.findById(id);

        if(vaga.isPresent()){
            return ResponseEntity.ok().body(vaga.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Vaga> insert(@RequestBody Vaga vaga){
        Optional<Reparticao> reparticao = reparticaoService.findById(vaga.getIdReparticao());

        if(reparticao.isPresent()){
            vaga = service.insert(vaga);
            return ResponseEntity.ok().body(vaga);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Vaga> update(@RequestBody Vaga vaga){
        Optional<Reparticao> reparticao = reparticaoService.findById(vaga.getIdReparticao());
        Optional<Vaga> vg = service.findById(vaga.getIdVaga());

        if(reparticao.isPresent() && vg.isPresent()){
            return ResponseEntity.ok().body(service.insert(vaga));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/delete-id")
    public ResponseEntity<Vaga> delete (@PathVariable Long id){
        Optional<Vaga> vg = service.findById(id);

        if(vg.isPresent()){
            service.delete(vg.get());
            return ResponseEntity.ok().body(vg.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    
    
}
