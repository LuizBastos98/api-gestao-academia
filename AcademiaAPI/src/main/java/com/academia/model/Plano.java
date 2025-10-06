package com.academia.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "planos") 
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private BigDecimal preco;

    private Integer duracaoEmDias;

    public Plano() {}

    public Plano(Long id, String nome, BigDecimal preco, Integer duracaoEmDias) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.duracaoEmDias = duracaoEmDias;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public Integer getDuracaoEmDias() { return duracaoEmDias; }
    public void setDuracaoEmDias(Integer duracaoEmDias) { this.duracaoEmDias = duracaoEmDias; }
}

