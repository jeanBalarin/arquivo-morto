package br.coop.integrada.arquivomorto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.coop.integrada.arquivomorto.model.Setor;
import br.coop.integrada.arquivomorto.repositories.SetorRepository;

@Service
public class SetorService {
	
	@Autowired
	private SetorRepository setorRep;
	
	@Transactional(readOnly = true)
	public List<Setor> findAll(){
		List<Setor> setores = setorRep.findAll();
		return setores;
	}
	
	@Transactional(readOnly = true)
	public Optional<Setor> findById(Long id) {
		Optional<Setor> setor = setorRep.findById(id);
		return setor;
	}
	
 	@Transactional
	public Setor insert(Setor novo) {	
		return setorRep.save(novo);
 	}
 	
 	@Transactional
 	public void delete(Setor setor) {
 		 setorRep.delete(setor);
 	}
 	
 	
}
