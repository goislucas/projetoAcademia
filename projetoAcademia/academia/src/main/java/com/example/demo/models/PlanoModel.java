package com.example.demo.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "plano")
public class PlanoModel implements Serializable {

    @Id
    private Integer id_plano;
    private Double valor_plano;
    private String tipo_plano;

    public Integer getId_plano() {
        return id_plano;
    }

    public void setId_plano(Integer id_plano) {
        this.id_plano = id_plano;
    }

    public Double getValor_plano() {
        return valor_plano;
    }

    public void setValor_plano(Double valor_plano) {
        this.valor_plano = valor_plano;
    }

    public String getTipo_plano() {
        return tipo_plano;
    }

    public void setTipo_plano(String tipo_plano) {
        this.tipo_plano = tipo_plano;
    }

}
