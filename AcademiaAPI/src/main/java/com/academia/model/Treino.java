package com.academia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private NivelTreino nivel;

   
    @ManyToMany(mappedBy = "treinos")
    @JsonIgnore 
    private List<Aluno> alunos = new ArrayList<>();
    

}
