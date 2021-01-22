package br.coop.integrada.arquivomorto.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Arquivo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_arquivo")
	private Long idArquivo;
    private String descricao;
    @Column(name = "data_arquivo")
    private Date dataArquivo;
    
    @ManyToOne
    private Caixa caixa;
    
    public Arquivo() {};
    
    public Arquivo(Long idArquivo, String descricao, Date dataArquivo, Caixa caixa) {
		this.idArquivo = idArquivo;
		this.descricao = descricao;
		this.dataArquivo = dataArquivo;
		this.caixa = caixa;
	}

	public Long getIdArquivo() {
        return this.idArquivo;
    }

    public void setIdArquivo(Long idArquivo) {
        this.idArquivo = idArquivo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataArquivo() {
        return this.dataArquivo;
    }

    public void setDataArquivo(Date dataArquivo) {
        this.dataArquivo = dataArquivo;
    }
    
    public Long getIdCaixa() {
    	return caixa.getIdCaixa();
    }
    
    public void setCaixa(Caixa caixa) {
    	this.caixa = caixa;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idArquivo == null) ? 0 : idArquivo.hashCode());
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
		Arquivo other = (Arquivo) obj;
		if (idArquivo == null) {
			if (other.idArquivo != null)
				return false;
		} else if (!idArquivo.equals(other.idArquivo))
			return false;
		return true;
	}        
}