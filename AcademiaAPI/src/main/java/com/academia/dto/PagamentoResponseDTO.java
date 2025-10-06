// src/main/java/com/academia/dto/PagamentoResponseDTO.java
package com.academia.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import com.academia.model.StatusPagamento;

public class PagamentoResponseDTO {
    private Long id;
    private BigDecimal valor;
    private OffsetDateTime data;
    private StatusPagamento status;
    private Long alunoId;
    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }
    public OffsetDateTime getData() { return data; }
    public void setData(OffsetDateTime data) { this.data = data; }
    public StatusPagamento getStatus() { return status; }
    public void setStatus(StatusPagamento status) { this.status = status; }
    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }
}
