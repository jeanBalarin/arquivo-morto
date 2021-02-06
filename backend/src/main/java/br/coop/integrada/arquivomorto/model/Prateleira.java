package br.coop.integrada.arquivomorto.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Prateleira implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrateleira;
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_local")
    private Local local;

    public Prateleira(Long idPrateleira, String nome, Local local) {
        this.idPrateleira = idPrateleira;
        this.nome = nome;
        this.local = local;
    }

    public Prateleira(){}

    public Long getIdPrateleira() {
        return idPrateleira;
    }

    public void setIdPrateleira(Long idPrateleira) {
        this.idPrateleira = idPrateleira;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdLocal(){
        return local.getIdLocal();
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idPrateleira == null) ? 0 : idPrateleira.hashCode());
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
        Prateleira other = (Prateleira) obj;
        if (idPrateleira == null) {
            if (other.idPrateleira != null)
                return false;
        } else if (!idPrateleira.equals(other.idPrateleira))
            return false;
        return true;
    }
    
    
    

}
