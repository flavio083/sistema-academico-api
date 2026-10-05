package com.unifacisa.projeto2.services;

import com.unifacisa.projeto2.entities.Curso;
import com.unifacisa.projeto2.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public Curso insert(Curso curso) {
        return repository.save(curso);
    }

    public List<Curso> findAll() {
        return repository.findAll();
    }

    public Curso findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID: " + id));
    }

    public Curso update(Integer id, Curso dadosAtualizados) {
        Curso curso = findById(id);
        curso.setNome(dadosAtualizados.getNome());
        curso.setCargaHoraria(dadosAtualizados.getCargaHoraria());
        return repository.save(curso);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}