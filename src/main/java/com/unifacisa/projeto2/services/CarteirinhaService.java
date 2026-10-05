package com.unifacisa.projeto2.services;

import com.unifacisa.projeto2.entities.Carteirinha;
import com.unifacisa.projeto2.repositories.CarteirinhaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteirinhaService {

    private final CarteirinhaRepository repository;

    public CarteirinhaService(CarteirinhaRepository repository) {
        this.repository = repository;
    }

    public Carteirinha insert(Carteirinha carteirinha) {
        return repository.save(carteirinha);
    }

    public List<Carteirinha> findAll() {
        return repository.findAll();
    }

    public Carteirinha findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carteirinha não encontrada com o ID: " + id));
    }

    public Carteirinha update(Integer id, Carteirinha dadosAtualizados) {
        Carteirinha carteirinha = findById(id);
        carteirinha.setNumeroMatricula(dadosAtualizados.getNumeroMatricula());
        carteirinha.setDataValidade(dadosAtualizados.getDataValidade());
        return repository.save(carteirinha);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}