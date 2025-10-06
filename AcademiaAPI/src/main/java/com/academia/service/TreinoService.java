// src/main/java/com/academia/service/TreinoService.java
package com.academia.service;

import com.academia.dto.TreinoRequestDTO;
import com.academia.dto.TreinoResponseDTO;
import java.util.List;

public interface TreinoService {
    TreinoResponseDTO criar(TreinoRequestDTO dto);
    TreinoResponseDTO atualizar(Long id, TreinoRequestDTO dto);
    TreinoResponseDTO buscarPorId(Long id);
    List<TreinoResponseDTO> listarTodos();
    void deletar(Long id); // deve verificar associação com alunos
}
