package br.coop.integrada.arquivomorto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.coop.integrada.arquivomorto.model.Reparticao;
import br.coop.integrada.arquivomorto.repositories.ReparticaoRepository;

@Service
public class ReparticaoService {
    @Autowired
    private ReparticaoRepository reparticaoRep;

    @Transactional(readOnly = true)
    public List<Reparticao> findAll(){
        return reparticaoRep.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Reparticao> findById(Long id){
        return reparticaoRep.findById(id);
    }

    @Transactional
    public Reparticao insert(Reparticao reparticao){
        return reparticaoRep.save(reparticao);
    }

    @Transactional
    public void delete(Reparticao reparticao){
        reparticaoRep.delete(reparticao);
    }
}
