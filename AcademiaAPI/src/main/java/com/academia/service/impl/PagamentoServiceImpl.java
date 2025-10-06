package com.academia.service;

import com.academia.model.Pagamento;
import com.academia.repository.PagamentoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    private final PagamentoRepository repository;

    public PagamentoServiceImpl(PagamentoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pagamento> getAll() { return repository.findAll(); }

    @Override
    public Optional<Pagamento> getById(Long id) { return repository.findById(id); }

    @Override
    public Pagamento createOrUpdate(Pagamento pagamento) { return repository.save(pagamento); }

    @Override
    public void delete(Long id) { repository.deleteById(id); }
}
