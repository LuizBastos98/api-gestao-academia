package com.academia.service;

import com.academia.model.Aluno;
import com.academia.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository repository;

    public AlunoServiceImpl(AlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Aluno> getAll() { return repository.findAll(); }

    @Override
    public Optional<Aluno> getById(Long id) { return repository.findById(id); }

    @Override
    public Aluno createOrUpdate(Aluno aluno) { return repository.save(aluno); }

    @Override
    public void delete(Long id) { repository.deleteById(id); }
}
