package com.academia.service;

import com.academia.model.Pagamento;
import java.util.List;
import java.util.Optional;

public interface PagamentoService {
    List<Pagamento> getAll();
    Optional<Pagamento> getById(Long id);
    Pagamento createOrUpdate(Pagamento pagamento);
    void delete(Long id);
}
