package br.coop.integrada.arquivomorto.model;

import java.io.Serializable;
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
public class Reparticao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reparticao")
    private Long idReparticao;
    private int nivel;
    @ManyToOne
    private Prateleira prateleira;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "reparticao")
    private List<Vaga> vagas;

    public Reparticao() {}

    public Reparticao(Prateleira prateleira, int nivel){
        this.prateleira = prateleira;
        this.nivel = nivel;
    }

    public Reparticao(Long idReparticao, Prateleira prateleira, int nivel) {
        this.idReparticao = idReparticao;
        this.prateleira = prateleira;
        this.nivel = nivel;
    }

    public Long getIdReparticao() {
        return idReparticao;
    }

    public void setIdReparticao(Long idReparticao) {
        this.idReparticao = idReparticao;
    }

    public Long getIdPrateleira() {
        return prateleira.getIdPrateleira();
    }

    public void setPrateleira(Prateleira prateleira) {
        this.prateleira = prateleira;
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
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
