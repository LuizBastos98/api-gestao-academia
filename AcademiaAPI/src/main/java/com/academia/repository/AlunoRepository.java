package com.academia.repository;

import com.academia.model.Aluno;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class AlunoRepository {
    private final Map<Long, Aluno> alunos = new HashMap<>();
    private Long contador = 1L;

    public List<Aluno> findAll() { return new ArrayList<>(alunos.values()); }

    public Optional<Aluno> findById(Long id) { return Optional.ofNullable(alunos.get(id)); }

    public Aluno save(Aluno aluno) {
        if (aluno.getId() == null) aluno.setId(contador++);
        alunos.put(aluno.getId(), aluno);
        return aluno;
    }

    public void deleteById(Long id) { alunos.remove(id); }
}
