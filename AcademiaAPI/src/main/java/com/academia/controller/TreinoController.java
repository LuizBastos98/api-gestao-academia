
package com.academia.controller;

import com.academia.dto.*;
import com.academia.service.TreinoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/treinos")
public class TreinoController {

    private final TreinoService service;

    public TreinoController(TreinoService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<TreinoResponseDTO> criar(@Valid @RequestBody TreinoRequestDTO dto) {
        TreinoResponseDTO criado = service.criar(dto);
        return ResponseEntity.created(URI.create("/api/v1/treinos/" + criado.getId())).body(criado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreinoResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<TreinoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreinoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody TreinoRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

