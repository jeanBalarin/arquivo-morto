package br.coop.integrada.arquivomorto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.coop.integrada.arquivomorto.model.Vaga;
import br.coop.integrada.arquivomorto.repositories.VagaRepository;

@Service

public class VagaService {
    @Autowired
    private VagaRepository vagaRep;

    @Transactional(readOnly = true)
    public List<Vaga> findAll(){
        return vagaRep.findAll();
    }

    @Transactional(readOnly=true)
    public Optional<Vaga> findById(Long id){
        return vagaRep.findById(id);
    }

    @Transactional
    public Vaga insert(Vaga vaga){
        return vagaRep.save(vaga);
    }

    @Transactional
    public void delete (Vaga vaga){
        vagaRep.delete(vaga);
    }

    @Transactional
    public void delete (List<Vaga> vagas){
        for (Vaga v : vagas){
            delete(v);
        }
    }

}
