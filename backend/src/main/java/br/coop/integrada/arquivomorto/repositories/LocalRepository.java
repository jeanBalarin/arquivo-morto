package br.coop.integrada.arquivomorto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.coop.integrada.arquivomorto.model.Local;

public interface LocalRepository extends JpaRepository <Local, Long> {
    
}
