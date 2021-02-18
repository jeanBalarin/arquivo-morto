package br.coop.integrada.arquivomorto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.coop.integrada.arquivomorto.model.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Long>{
    
}
