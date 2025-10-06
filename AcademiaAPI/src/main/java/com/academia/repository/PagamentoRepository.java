package com.academia.repository;

import com.academia.model.Pagamento;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class PagamentoRepository {
    private final Map<Long, Pagamento> pagamentos = new HashMap<>();
    private Long contador = 1L;

    public List<Pagamento> findAll() { return new ArrayList<>(pagamentos.values()); }

    public Optional<Pagamento> findById(Long id) { return Optional.ofNullable(pagamentos.get(id)); }

    public Pagamento save(Pagamento pagamento) {
        if (pagamento.getId() == null) pagamento.setId(contador++);
        pagamentos.put(pagamento.getId(), pagamento);
        return pagamento;
    }

    public void deleteById(Long id) { pagamentos.remove(id); }
}
