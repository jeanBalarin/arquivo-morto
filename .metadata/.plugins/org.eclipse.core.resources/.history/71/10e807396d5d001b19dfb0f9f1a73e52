package br.coop.integrada.arquivomorto.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Caixa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_caixa")
	private Long idCaixa;
	private String numero;
	private Date prescricao;
	private CaixaStatus situacao;
	
	@ManyToOne
	private Setor setor;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "caixa")
	private List<Arquivo> arquivos;
	
	public Caixa() {};
	
	public Caixa(Long idCaixa, String numero, Date prescricao, CaixaStatus situacao, Setor setor) {
		this.idCaixa = idCaixa;
		this.numero = numero;
		this.prescricao = prescricao;
		this.situacao = situacao;
		this.setor = setor;
	}

	public Long getIdCaixa() {
		return idCaixa;
	}

	public void setIdCaixa(Long idCaixa) {
		this.idCaixa = idCaixa;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(Date prescricao) {
		this.prescricao = prescricao;
	}

	public CaixaStatus getSituacao() {
		return situacao;
	}

	public void setSituacao(CaixaStatus situacao) {
		this.situacao = situacao;
	}

	public Long getIDSetor() {
		return setor.getIdSetor();
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public List<Arquivo> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCaixa == null) ? 0 : idCaixa.hashCode());
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
		Caixa other = (Caixa) obj;
		if (idCaixa == null) {
			if (other.idCaixa != null)
				return false;
		} else if (!idCaixa.equals(other.idCaixa))
			return false;
		return true;
	}
	
	
	
	
}
