package br.coop.integrada.arquivomorto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reparticao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reparticao")
    private Long idReparticao;
    private int quantidadeVagas;

    @ManyToOne
    private Prateleira prateleira;

    public Reparticao() {}

    public Reparticao(Long idReparticao, int quantidadeVagas, Prateleira prateleira) {
        this.idReparticao = idReparticao;
        this.quantidadeVagas = quantidadeVagas;
        this.prateleira = prateleira;
    }

    public Long getIdReparticao() {
        return idReparticao;
    }

    public void setIdReparticao(Long idReparticao) {
        this.idReparticao = idReparticao;
    }

    public int getQuantidadeVagas() {
        return quantidadeVagas;
    }

    public void setQuantidadeVagas(int quantidadeVagas) {
        this.quantidadeVagas = quantidadeVagas;
    }

    public Long getIdPrateleira() {
        return prateleira.getIdPrateleira();
    }

    public void setPrateleira(Prateleira prateleira) {
        this.prateleira = prateleira;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idReparticao == null) ? 0 : idReparticao.hashCode());
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
        Reparticao other = (Reparticao) obj;
        if (idReparticao == null) {
            if (other.idReparticao != null)
                return false;
        } else if (!idReparticao.equals(other.idReparticao))
            return false;
        return true;
    }
}
