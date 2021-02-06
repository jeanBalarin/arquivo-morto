package br.coop.integrada.arquivomorto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.coop.integrada.arquivomorto.model.Prateleira;
import br.coop.integrada.arquivomorto.repositories.PrateleiraRepository;

@Service
public class PrateleiraService {

    @Autowired
    private PrateleiraRepository prateleiraRep;

    @Transactional(readOnly = true)
    public List<Prateleira> findAll(){
        List<Prateleira> prateleiras = prateleiraRep.findAll();
        return prateleiras;
    }

    @Transactional(readOnly = true)
    public Optional<Prateleira> findById(Long id){
        return prateleiraRep.findById(id);
    }

    @Transactional
    public Prateleira insert(Prateleira prateleira){
        return prateleiraRep.save(prateleira);
    }

    @Transactional
    public void delete(Prateleira prateleira){
        prateleiraRep.delete(prateleira);
    }
    
}
