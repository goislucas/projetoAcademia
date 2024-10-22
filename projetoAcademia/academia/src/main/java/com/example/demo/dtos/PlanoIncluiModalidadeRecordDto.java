package com.example.demo.dtos;

import jakarta.validation.constraints.NotNull;

public record PlanoIncluiModalidadeRecordDto(@NotNull Integer plano_id_plano,@NotNull Integer modalidade_id_modalidade) {
}
