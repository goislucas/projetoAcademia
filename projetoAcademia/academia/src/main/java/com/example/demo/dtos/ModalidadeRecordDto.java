package com.example.demo.dtos;

import jakarta.validation.constraints.NotNull;

public record ModalidadeRecordDto(@NotNull Integer id_modalidade, @NotNull String nome_modalidade) {
}
