package br.coop.integrada.arquivomorto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.coop.integrada.arquivomorto.model.Vaga;
import br.coop.integrada.arquivomorto.repositories.VagaRepository;

@Service

public class VagaService {
    @Autowired
    private VagaRepository vagaRep;

    public List<Vaga> findAll(){
        return vagaRep.findAll();
    }



}
