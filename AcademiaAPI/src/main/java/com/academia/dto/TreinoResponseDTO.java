package com.academia.dto;

import lombok.Data;

@Data
public class TreinoResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String nivel;
}