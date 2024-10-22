package com.example.demo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class PlanoIncluiModalidadeId implements Serializable {

    private Integer plano_id_plano;
    private Integer modalidade_id_modalidade;

    public Integer getPlano_id_plano() {
        return plano_id_plano;
    }

    public void setPlano_id_plano(Integer plano_id_plano) {
        this.plano_id_plano = plano_id_plano;
    }

    public Integer getModalidade_id_modalidade() {
        return modalidade_id_modalidade;
    }

    public void setModalidade_id_modalidade(Integer modalidade_id_modalidade) {
        this.modalidade_id_modalidade = modalidade_id_modalidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanoIncluiModalidadeId that = (PlanoIncluiModalidadeId) o;
        return Objects.equals(plano_id_plano, that.plano_id_plano) && Objects.equals(modalidade_id_modalidade, that.modalidade_id_modalidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plano_id_plano, modalidade_id_modalidade);
    }
}
