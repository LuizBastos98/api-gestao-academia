package com.academia.controller;

import com.academia.model.Pagamento;
import com.academia.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    private final PagamentoService service;

    public PagamentoController(PagamentoService service) { this.service = service; }

    @GetMapping
    public List<Pagamento> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pagamento create(@RequestBody Pagamento pagamento) { return service.createOrUpdate(pagamento); }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> update(@PathVariable Long id, @RequestBody Pagamento pagamento) {
        return service.getById(id).map(existing -> {
            pagamento.setId(id);
            return ResponseEntity.ok(service.createOrUpdate(pagamento));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
