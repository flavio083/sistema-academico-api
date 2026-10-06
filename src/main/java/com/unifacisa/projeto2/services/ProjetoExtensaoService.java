package com.unifacisa.projeto2.services;

import com.unifacisa.projeto2.entities.ProjetoExtensao;
import com.unifacisa.projeto2.repositories.ProjetoExtensaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoExtensaoService {

    @Autowired
    private ProjetoExtensaoRepository repository;

    public List<ProjetoExtensao> findAll() {
        return repository.findAll();
    }

    public ProjetoExtensao findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ProjetoExtensao save(ProjetoExtensao projetoExtensao) {
        return repository.save(projetoExtensao);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
