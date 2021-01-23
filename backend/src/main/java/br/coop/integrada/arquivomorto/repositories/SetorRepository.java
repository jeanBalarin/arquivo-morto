package br.coop.integrada.arquivomorto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.coop.integrada.arquivomorto.model.Setor;

public interface SetorRepository extends JpaRepository<Setor, Long> {
	
}
