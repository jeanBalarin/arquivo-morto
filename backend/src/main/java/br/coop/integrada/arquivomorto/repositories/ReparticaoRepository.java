package br.coop.integrada.arquivomorto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.coop.integrada.arquivomorto.model.Reparticao;

public interface ReparticaoRepository extends JpaRepository<Reparticao, Long>{
    
}
