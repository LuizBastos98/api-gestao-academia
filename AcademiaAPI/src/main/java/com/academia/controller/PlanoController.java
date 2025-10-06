// src/main/java/com/academia/controller/PlanoController.java
package com.academia.controller;

import com.academia.dto.*;
import com.academia.service.PlanoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/planos")
public class PlanoController {

    private final PlanoService service;

    public PlanoController(PlanoService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<PlanoResponseDTO> criar(@Valid @RequestBody PlanoRequestDTO dto) {
        PlanoResponseDTO criado = service.criar(dto);
        return ResponseEntity.created(URI.create("/api/v1/planos/" + criado.getId())).body(criado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<PlanoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody PlanoRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
