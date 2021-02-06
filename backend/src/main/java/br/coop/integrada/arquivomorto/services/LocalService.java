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
		List<Local> locais = localRep.findAll();
		return locais;
	}
	
	@Transactional(readOnly = true)
	public Optional<Local> findById(Long id) {
		Optional<Local> local = localRep.findById(id);
		return local;
	}
	
 	@Transactional
	public Local insert(Local novo) {	
		return localRep.save(novo);
 	}
 	
 	@Transactional
 	public void delete(Local local) {
 		 localRep.delete (local);
 	}
 	
 	
}
