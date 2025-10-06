// src/main/java/com/academia/dto/AlunoResponseDTO.java
package com.academia.dto;

import com.academia.model.StatusAluno;

public class AlunoResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private StatusAluno status;
    private PlanoResumoDTO plano;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public StatusAluno getStatus() { return status; }
    public void setStatus(StatusAluno status) { this.status = status; }
    public PlanoResumoDTO getPlano() { return plano; }
    public void setPlano(PlanoResumoDTO plano) { this.plano = plano; }
}
