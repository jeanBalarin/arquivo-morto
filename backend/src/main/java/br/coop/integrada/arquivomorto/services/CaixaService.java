package br.coop.integrada.arquivomorto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.coop.integrada.arquivomorto.model.Caixa;
import br.coop.integrada.arquivomorto.repositories.CaixaRepository;

@Service
public class CaixaService {
	
	@Autowired
	private CaixaRepository caixaRep;

	//lista todos os arquivos 
	
	
	@Transactional(readOnly = true)
	public List<Caixa> findAll(){
		List<Caixa> arquivos = caixaRep.findAll();
		return arquivos;
	}
	
	@Transactional(readOnly = true)
	public Optional<Caixa> findById(Long id) {
		Optional<Caixa> caixa = caixaRep.findById(id);
		return caixa;
	}
	
 	@Transactional
	public Caixa insert(Caixa novo) {
		return caixaRep.save(novo);
 	}
 	
 	@Transactional
 	public void delete(Caixa arquivo) {
 		 caixaRep.delete(arquivo);
 	}

}
