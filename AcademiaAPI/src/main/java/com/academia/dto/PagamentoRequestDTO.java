// src/main/java/com/academia/dto/PagamentoRequestDTO.java
package com.academia.dto;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PagamentoRequestDTO {
    @NotNull
    private BigDecimal valor;

    @NotNull
    private Long alunoId;

    // opcional status se desejar
    private String status;

    // getters/setters
    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }
    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
