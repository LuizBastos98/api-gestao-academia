// src/main/java/com/academia/service/impl/PlanoServiceImpl.java
package com.academia.service.impl;

import com.academia.dto.PlanoRequestDTO;
import com.academia.dto.PlanoResponseDTO;
import com.academia.exception.ResourceNotFoundException;
import com.academia.model.Plano;
import com.academia.repository.PlanoRepository;
import com.academia.service.PlanoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlanoServiceImpl implements PlanoService {

    private final PlanoRepository repo;

    public PlanoServiceImpl(PlanoRepository repo) { this.repo = repo; }

    @Override
    public PlanoResponseDTO criar(PlanoRequestDTO dto) {
        Plano p = new Plano();
        p.setNome(dto.getNome());
        p.setPreco(dto.getPreco());
        p.setDuracaoEmDias(dto.getDuracaoEmDias());
        Plano salvo = repo.save(p);
        return toResponse(salvo);
    }

    @Override
    public PlanoResponseDTO atualizar(Long id, PlanoRequestDTO dto) {
        Plano p = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado"));
        p.setNome(dto.getNome());
        p.setPreco(dto.getPreco());
        p.setDuracaoEmDias(dto.getDuracaoEmDias());
        return toResponse(repo.save(p));
    }

    @Override
    public PlanoResponseDTO buscarPorId(Long id) {
        return repo.findById(id).map(this::toResponse).orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado"));
    }

    @Override
    public List<PlanoResponseDTO> listarTodos() {
        return repo.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public void deletar(Long id) {
        // opcional: verificar se há alunos atrelados e impedir remoção se necessário
        repo.deleteById(id);
    }

    private PlanoResponseDTO toResponse(Plano p) {
        PlanoResponseDTO dto = new PlanoResponseDTO();
        dto.setId(p.getId());
        dto.setNome(p.getNome());
        dto.setPreco(p.getPreco());
        dto.setDuracaoEmDias(p.getDuracaoEmDias());
        return dto;
    }
}
