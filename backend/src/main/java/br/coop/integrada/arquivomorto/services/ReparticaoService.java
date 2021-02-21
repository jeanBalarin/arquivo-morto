package br.coop.integrada.arquivomorto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.coop.integrada.arquivomorto.model.Prateleira;
import br.coop.integrada.arquivomorto.model.Reparticao;
import br.coop.integrada.arquivomorto.model.Vaga;
import br.coop.integrada.arquivomorto.repositories.ReparticaoRepository;

@Service
public class ReparticaoService {
    @Autowired
    private ReparticaoRepository reparticaoRep;

    @Autowired
    private VagaService vagaService;

    @Transactional(readOnly = true)
    public List<Reparticao> findAll(){
        return reparticaoRep.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Reparticao> findById(Long id){
        return reparticaoRep.findById(id);
    }

    @Transactional(readOnly = true)
    public Reparticao findByIdReparticao(Long id){
        return reparticaoRep.findById(id).get();
    }

    @Transactional
    public Reparticao insert(Reparticao reparticao){
        return reparticaoRep.save(reparticao);
    }

    @Transactional
    public void delete(Reparticao reparticao){
        reparticaoRep.delete(reparticao);
    }

    public Reparticao criarReparticao(Prateleira prateleira, int nivel){
        Reparticao reparticao = new Reparticao(prateleira, nivel);
        reparticao = insert(reparticao);
        int qtvagas = prateleira.getQuantidadeVagas();
        
        for (int i=1; i <= qtvagas; i++){
            Vaga vg = new Vaga(reparticao, i);
            vg = vagaService.insert(vg);
        }
        
        reparticao = findByIdReparticao(reparticao.getIdReparticao());

        return reparticao;
    }
}
