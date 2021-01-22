package br.coop.integrada.arquivomorto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.coop.integrada.arquivomorto.model.Setor;

public interface SetorRepository extends JpaRepository<Setor, Long> {

	@Query("SELECT idSetor, nome, sigla FROM Setor ORDER BY idSetor")
	List<Setor> findSetores();

	
}
