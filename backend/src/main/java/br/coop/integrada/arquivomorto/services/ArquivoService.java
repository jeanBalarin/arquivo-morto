package br.coop.integrada.arquivomorto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.coop.integrada.arquivomorto.model.Arquivo;
import br.coop.integrada.arquivomorto.model.Caixa;
import br.coop.integrada.arquivomorto.repositories.ArquivoRepository;
import br.coop.integrada.arquivomorto.repositories.CaixaRepository;

@Service
public class ArquivoService {
	
	@Autowired
	private ArquivoRepository arquivoRep;
	
	@Autowired
	private CaixaRepository caixaRep;
	
	//lista todos os arquivos 
	
	
	@Transactional(readOnly = true)
	public List<Arquivo> findAll(){
		List<Arquivo> arquivos = arquivoRep.findAll();
		return arquivos;
	}
	
	@Transactional(readOnly = true)
	public Optional<Arquivo> findById(Long id) {
		Optional<Arquivo> arquivo = arquivoRep.findById(id);
		return arquivo;
	}
	
 	@Transactional
	public Arquivo insert(Arquivo novo) {
 		Caixa caixa = caixaRep.getOne(novo.getIdCaixa());
 		
 		Arquivo arquivo = new Arquivo(null,novo.getDescricao(),novo.getDataArquivo(),caixa);
 		
		return arquivoRep.save(arquivo);
 	}
 	
 	@Transactional
 	public Arquivo update(Arquivo alterar) {
 		
 		return arquivoRep.save(alterar);
 	}
 	
 	@Transactional
 	public void delete(Arquivo arquivo) {
 		 arquivoRep.delete(arquivo);
 	}

}
