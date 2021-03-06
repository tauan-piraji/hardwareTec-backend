package com.tauanoliveira.softwaretec.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.tauanoliveira.softwaretec.domain.enums.EstadoPagamento;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include =JsonTypeInfo.As.PROPERTY, property = "type")//adciona propriedade type no json
public class Pagamento implements Serializable{
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    private EstadoPagamento estadoPagamento;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="OrdenServico_Id")
    @MapsId
    private OrdemServico ordemServico;

    public Pagamento() {
    }

    public Pagamento(Integer id, EstadoPagamento estadoPagamento, OrdemServico ordemServico) {
        this.id = id;
        this.estadoPagamento = estadoPagamento;
        this.ordemServico = ordemServico;
    }

    public Integer getId() {
        return id;
    }

    public EstadoPagamento getEstadoPagamento() {
        return estadoPagamento;
    }
    
    public void setEstadoPagamento(EstadoPagamento estadoPagamento) { 
        this.estadoPagamento = estadoPagamento;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Pagamento other = (Pagamento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}