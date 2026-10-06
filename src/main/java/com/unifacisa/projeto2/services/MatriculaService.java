package com.unifacisa.projeto2.services;

import com.unifacisa.projeto2.entities.Aluno;
import com.unifacisa.projeto2.entities.ProjetoExtensao;
import com.unifacisa.projeto2.repositories.AlunoRepository;
import com.unifacisa.projeto2.repositories.ProjetoExtensaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MatriculaService {

    private final AlunoRepository alunoRepository;
    private final ProjetoExtensaoRepository projetoRepository;

    public MatriculaService(
            AlunoRepository alunoRepository,
            ProjetoExtensaoRepository projetoRepository) {
        this.alunoRepository = alunoRepository;
        this.projetoRepository = projetoRepository;
    }

    @Transactional
    public Optional<ProjetoExtensao> matricular(Long projetoId, Long alunoId) {

        Optional<ProjetoExtensao> projetoOptional =
                projetoRepository.findById(projetoId);

        Optional<Aluno> alunoOptional =
                alunoRepository.findById(alunoId);

        if (projetoOptional.isEmpty() || alunoOptional.isEmpty()) {
            return Optional.empty();
        }

        ProjetoExtensao projeto = projetoOptional.get();
        Aluno aluno = alunoOptional.get();

        if (!projeto.getAlunos().contains(aluno)) {
            projeto.getAlunos().add(aluno);
            projetoRepository.save(projeto);
        }

        return Optional.of(projeto);
    }

    @Transactional
    public Optional<ProjetoExtensao> removerAluno(
            Long projetoId,
            Long alunoId) {

        Optional<ProjetoExtensao> projetoOptional =
                projetoRepository.findById(projetoId);

        Optional<Aluno> alunoOptional =
                alunoRepository.findById(alunoId);

        if (projetoOptional.isEmpty() || alunoOptional.isEmpty()) {
            return Optional.empty();
        }

        ProjetoExtensao projeto = projetoOptional.get();
        Aluno aluno = alunoOptional.get();

        projeto.getAlunos().remove(aluno);
        projetoRepository.save(projeto);

        return Optional.of(projeto);
    }
}
