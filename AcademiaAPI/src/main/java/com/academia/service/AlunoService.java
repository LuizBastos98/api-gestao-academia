package com.academia.service;

import com.academia.model.Aluno;
import java.util.List;
import java.util.Optional;

public interface AlunoService {
    List<Aluno> getAll();
    Optional<Aluno> getById(Long id);
    Aluno createOrUpdate(Aluno aluno);
    void delete(Long id);
}
