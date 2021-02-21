package br.coop.integrada.arquivomorto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vaga implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_vaga")
    private Long idVaga;
    private VagaStatus situacaoVaga;
    private String numeracaoVaga;
    @ManyToOne
    private Reparticao reparticao; 
    
    public Vaga (){}

    public Vaga(Long idVaga, Reparticao reparticao, VagaStatus situacaoVaga, String numeracaoVaga) {
        this.idVaga = idVaga;
        this.reparticao = reparticao;
        this.situacaoVaga = situacaoVaga;
        this.numeracaoVaga = numeracaoVaga;
    }

    //construtor utilizado no criar vagas no reparticaoService para criar vagas automaticamente.
    public Vaga(Reparticao reparticao, int posicao) {
        this.reparticao = reparticao;
        this.situacaoVaga = VagaStatus.LIVRE;
        this.numeracaoVaga = "" + reparticao.getNivel() + posicao;
    }

    public Long getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(Long idVaga) {
        this.idVaga = idVaga;
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
