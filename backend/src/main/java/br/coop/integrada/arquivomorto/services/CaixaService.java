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

	//lista todos os caixas 
	
	
	@Transactional(readOnly = true)
	public List<Caixa> findAll(){
		List<Caixa> caixas = caixaRep.findAll();
		return caixas;
	}
	
	@Transactional(readOnly = true)
	public Optional<Caixa> findById(Long id) {
		Optional<Caixa> caixa = caixaRep.findById(id);
		return caixa;
	}

	//retorna uma caixa com o id informado.
	@Transactional(readOnly = true)
	public Caixa findByCaixaId(Long id){
		Optional<Caixa> caixa = caixaRep.findById(id);
		return (caixa.isPresent()) ?  caixa.get() :  null;
	}
	
 	@Transactional
	public Caixa insert(Caixa novo) {
		return caixaRep.save(novo);
 	}
 	
 	@Transactional
 	public Caixa update(Caixa update) {
 		//Caixa caixa = caixaRep.getOne(update.getIdCaixa());
 		//update.setArquivos(caixa.getArquivos());
 		return caixaRep.save(update);
 	}
 	
 	@Transactional
 	public void delete(Caixa caixa) {
 		 caixaRep.delete(caixa);
 	}

}
