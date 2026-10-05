package com.unifacisa.projeto2.services;

import com.unifacisa.projeto2.entities.Aluno;
import com.unifacisa.projeto2.repositories.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public Aluno insert(Aluno aluno) {
        return repository.save(aluno);
    }

    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public Aluno findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado com o ID: " + id));
    }

    public Aluno update(Long id, Aluno dadosAtualizados) {
        Aluno aluno = findById(id);

        aluno.setNome(dadosAtualizados.getNome());
        aluno.setEmail(dadosAtualizados.getEmail());
        aluno.setCurso(dadosAtualizados.getCurso());

        return repository.save(aluno);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
