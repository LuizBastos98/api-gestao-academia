// src/main/java/com/academia/service/PlanoService.java
package com.academia.service;

import com.academia.dto.PlanoRequestDTO;
import com.academia.dto.PlanoResponseDTO;
import java.util.List;

public interface PlanoService {
    PlanoResponseDTO criar(PlanoRequestDTO dto);
    PlanoResponseDTO atualizar(Long id, PlanoRequestDTO dto);
    PlanoResponseDTO buscarPorId(Long id);
    List<PlanoResponseDTO> listarTodos();
    void deletar(Long id);
}
