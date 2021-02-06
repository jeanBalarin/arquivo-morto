package br.coop.integrada.arquivomorto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.coop.integrada.arquivomorto.model.Prateleira;

public interface PrateleiraRepository extends JpaRepository<Prateleira, Long> {
    
}
