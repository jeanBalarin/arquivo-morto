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

    @Autowired
    private ReparticaoService reparticaoService;

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

    public Prateleira criarPrateleira(Prateleira prateleira){
        prateleira = insert(prateleira);
        int rep = prateleira.getQuantidadeReparticoes();
        for (int i = 1; i <= rep; i++){
            reparticaoService.criarReparticao(prateleira, i);
        }
                
        return findById(prateleira.getIdPrateleira()).get();
    }
    
}
