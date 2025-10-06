package com.academia.service.impl;

import com.academia.dto.TreinoRequestDTO;
import com.academia.dto.TreinoResponseDTO;
import com.academia.exception.BadRequestException;
import com.academia.exception.ResourceNotFoundException;
import com.academia.model.NivelTreino;
import com.academia.model.Treino;
import com.academia.repository.TreinoRepository;
import com.academia.service.TreinoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreinoServiceImpl implements TreinoService {

    private final TreinoRepository treinoRepository;

    public TreinoServiceImpl(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }

    @Override
    public TreinoResponseDTO criar(TreinoRequestDTO treinoDTO) { // <-- RENOMEADO
        Treino treino = new Treino();
        treino.setNome(treinoDTO.getNome());
        treino.setDescricao(treinoDTO.getDescricao());

        try {
            NivelTreino nivelEnum = NivelTreino.valueOf(treinoDTO.getNivel().toUpperCase());
            treino.setNivel(nivelEnum);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Nível de treino inválido: " + treinoDTO.getNivel());
        }

        Treino novoTreino = treinoRepository.save(treino);
        return convertToResponseDTO(novoTreino);
    }

    @Override
    public void deletar(Long id) {
        Treino treino = treinoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Treino com id " + id + " não encontrado."));

        if (treino.getAlunos() != null && !treino.getAlunos().isEmpty()) {
            throw new BadRequestException("Não é possível remover um treino que possui alunos associados.");
        }

        treinoRepository.delete(treino);
    }

    // --- Métodos adicionais que sua interface pode exigir ---
    @Override
    public TreinoResponseDTO atualizar(Long id, TreinoRequestDTO treinoDTO) {
        // TODO: Implementar a lógica de atualização aqui
        return null;
    }

    @Override
    public TreinoResponseDTO buscarPorId(Long id) {
        // TODO: Implementar a lógica de busca por ID aqui
        return null;
    }

    @Override
    public List<TreinoResponseDTO> listarTodos() {
        // TODO: Implementar a lógica de listagem aqui
        return new ArrayList<>();
    }


    private TreinoResponseDTO convertToResponseDTO(Treino treino) {
        TreinoResponseDTO dto = new TreinoResponseDTO();
        dto.setId(treino.getId());
        dto.setNome(treino.getNome());
        dto.setDescricao(treino.getDescricao());
        if (treino.getNivel() != null) {
            dto.setNivel(treino.getNivel().toString());
        }
        return dto;
    }
}