package com.example.demo.dtos;

import jakarta.validation.constraints.NotNull;

public record PlanoRecordDto(@NotNull Integer id_plano, @NotNull Double valor_plano, @NotNull String tipo_plano) {
}
