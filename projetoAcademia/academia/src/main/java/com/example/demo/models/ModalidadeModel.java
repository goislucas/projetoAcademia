package com.example.demo.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "modalidade")
public class ModalidadeModel implements Serializable {

    @Id
    private Integer id_modalidade;
    private String nome_modalidade;

    public Integer getId_modalidade() {
        return id_modalidade;
    }

    public void setId_modalidade(Integer id_modalidade) {
        this.id_modalidade = id_modalidade;
    }

    public String getNome_modalidade() {
        return nome_modalidade;
    }

    public void setNome_modalidade(String nome_modalidade) {
        this.nome_modalidade = nome_modalidade;
    }
}
