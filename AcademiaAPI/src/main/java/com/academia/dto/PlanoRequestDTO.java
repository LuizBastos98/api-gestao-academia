
package com.academia.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PlanoRequestDTO {
    @NotBlank
    private String nome;

    @NotNull
    private BigDecimal preco;

    @NotNull
    private Integer duracaoEmDias;

    // getters/setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
    public Integer getDuracaoEmDias() { return duracaoEmDias; }
    public void setDuracaoEmDias(Integer duracaoEmDias) { this.duracaoEmDias = duracaoEmDias; }
}

