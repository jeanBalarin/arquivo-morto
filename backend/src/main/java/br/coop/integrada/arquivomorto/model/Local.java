package br.coop.integrada.arquivomorto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Local implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_local")
	private Long idLocal;
	private String nome;
	private String descricao;
	
	public Local() {};
	
	public Local (Local entity) {
		idLocal = entity.getIdLocal();
		nome = entity.getNome();
		descricao = entity.getDescricao();
	}	
	
	public Local(Long idLocal, String nome, String descricao) {
		this.idLocal = idLocal;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Long getIdLocal() {
		return idLocal;
	}
	public void setidLocal(Long idLocal) {
		this.idLocal = idLocal;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLocal == null) ? 0 : idLocal.hashCode());
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
		Local other = (Local) obj;
		if (idLocal == null) {
			if (other.idLocal != null)
				return false;
		} else if (!idLocal.equals(other.idLocal))
			return false;
		return true;
	}
	
	
	
}
