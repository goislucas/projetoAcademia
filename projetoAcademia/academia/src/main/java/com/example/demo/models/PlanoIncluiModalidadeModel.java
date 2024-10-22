package com.example.demo.models;

import com.example.demo.PlanoIncluiModalidadeId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "plano_inclui_modalidade")
public class PlanoIncluiModalidadeModel {

    @EmbeddedId
    private PlanoIncluiModalidadeId id;

    public PlanoIncluiModalidadeId getId() {
        return id;
    }

    public void setId(PlanoIncluiModalidadeId id) {
        this.id = id;
    }
}
