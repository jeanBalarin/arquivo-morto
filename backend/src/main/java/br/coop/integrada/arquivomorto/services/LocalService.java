package br.coop.integrada.arquivomorto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.coop.integrada.arquivomorto.model.Local;
import br.coop.integrada.arquivomorto.repositories.LocalRepository;

@Service
public class LocalService {
	
	@Autowired
	private LocalRepository localRep;
		
	@Transactional(readOnly = true)
	public List<Local> findAll(){
		List<Local> setores = localRep.findAll();
		return setores;
	}
	
	@Transactional(readOnly = true)
	public Optional<Local> findById(Long id) {
		Optional<Local> setor = localRep.findById(id);
		return setor;
	}
	
 	@Transactional
	public Local insert(Local novo) {	
		return localRep.save(novo);
 	}
 	
 	@Transactional
 	public void delete(Local setor) {
 		 localRep.delete(setor);
 	}
 	
 	
}
