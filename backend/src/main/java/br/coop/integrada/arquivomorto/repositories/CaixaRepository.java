package br.coop.integrada.arquivomorto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.coop.integrada.arquivomorto.model.Caixa;

public interface CaixaRepository extends JpaRepository<Caixa, Long> {
	
}
