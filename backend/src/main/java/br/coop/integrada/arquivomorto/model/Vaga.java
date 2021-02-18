package br.coop.integrada.arquivomorto.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Vaga implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVaga;
    private int nivel;
    private VagaStatus situacaoVaga;
    
    @ManyToMany
    private Reparticao reparticao;


    // identificação da vaga é comporta por
    // nivel + nivel * 10 + id do vetor da posição da vaga.
    // ex nivel= 2 + (posição do vetor[15]) = 215
    // px nivel= 3 + (posição do vetor[15]) = 315 
    // primeiro digito sempre vai representar o nivel da repartição.
    private String numeracaoVaga;

    public Vaga (){}

    public Vaga(Long idVaga, int nivel, Reparticao reparticao, VagaStatus situacaoVaga, String numeracaoVaga) {
        this.idVaga = idVaga;
        this.nivel = nivel;
        this.reparticao = reparticao;
        this.situacaoVaga = situacaoVaga;
        this.numeracaoVaga = numeracaoVaga;
    }

    public Vaga(Long idVaga, int nivel, Reparticao reparticao, VagaStatus situacaoVaga, int posicao) {
        this.idVaga = idVaga;
        this.nivel = nivel;
        this.reparticao = reparticao;
        this.situacaoVaga = situacaoVaga;
        this.numeracaoVaga = ""+this.nivel + posicao;
    }

    public Long getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(Long idVaga) {
        this.idVaga = idVaga;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Long getIdReparticao() {
        return reparticao.getIdReparticao();
    }

    public void setReparticao(Reparticao reparticao) {
        this.reparticao = reparticao;
    }

    public VagaStatus getSituacaoVaga() {
        return situacaoVaga;
    }

    public void setSituacaoVaga(VagaStatus situacaoVaga) {
        this.situacaoVaga = situacaoVaga;
    }

    public String getNumeracaoVaga() {
        return numeracaoVaga;
    }

    public void setNumeracaoVaga(String numeracaoVaga) {
        this.numeracaoVaga = numeracaoVaga;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idVaga == null) ? 0 : idVaga.hashCode());
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
        Vaga other = (Vaga) obj;
        if (idVaga == null) {
            if (other.idVaga != null)
                return false;
        } else if (!idVaga.equals(other.idVaga))
            return false;
        return true;
    }
}
