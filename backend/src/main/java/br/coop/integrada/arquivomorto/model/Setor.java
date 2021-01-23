package br.coop.integrada.arquivomorto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Setor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_setor")
	private Long idSetor;
	private String nome;
	private String sigla;
	
	public Setor() {};
	
	public Setor (Setor entity) {
		idSetor = entity.getIdSetor();
		nome = entity.getNome();
		sigla = entity.getSigla();
	}	
	
	public Setor(Long idSetor, String nome, String sigla) {
		this.idSetor = idSetor;
		this.nome = nome;
		this.sigla = sigla;
	}

	public Long getIdSetor() {
		return idSetor;
	}
	public void setIdSetor(Long idSetor) {
		this.idSetor = idSetor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSetor == null) ? 0 : idSetor.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Setor other = (Setor) obj;
		if (idSetor == null) {
			if (other.idSetor != null)
				return false;
		} else if (!idSetor.equals(other.idSetor))
			return false;
		return true;
	}
	
	
	
}
