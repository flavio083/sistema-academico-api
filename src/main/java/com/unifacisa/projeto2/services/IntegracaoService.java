package com.unifacisa.projeto2.services;

import com.unifacisa.projeto2.entities.Aluno;
import com.unifacisa.projeto2.entities.Curso;
import com.unifacisa.projeto2.entities.ProjetoExtensao;
import com.unifacisa.projeto2.repositories.AlunoRepository;
import com.unifacisa.projeto2.repositories.CursoRepository;
import com.unifacisa.projeto2.repositories.ProjetoExtensaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntegracaoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ProjetoExtensaoRepository projetoRepository;

    private Aluno buscarAluno(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno nao encontrado"));
    }

    private Curso buscarCurso(Integer id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso nao encontrado"));
    }

    private ProjetoExtensao buscarProjeto(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Projeto nao encontrado"));
    }

    // matricula o aluno no projeto
    @Transactional
    public ProjetoExtensao matricular(Long projetoId, Long alunoId) {
        ProjetoExtensao projeto = buscarProjeto(projetoId);
        Aluno aluno = buscarAluno(alunoId);

        if (projeto.getAlunos().contains(aluno)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Aluno ja esta nesse projeto");
        }

        projeto.getAlunos().add(aluno);
        return projetoRepository.save(projeto);
    }

    // tira o aluno do projeto
    @Transactional
    public ProjetoExtensao desmatricular(Long projetoId, Long alunoId) {
        ProjetoExtensao projeto = buscarProjeto(projetoId);
        Aluno aluno = buscarAluno(alunoId);

        if (!projeto.getAlunos().contains(aluno)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno nao esta nesse projeto");
        }

        projeto.getAlunos().remove(aluno);
        return projetoRepository.save(projeto);
    }

    @Transactional
    public List<Aluno> listarAlunosDoProjeto(Long projetoId) {
        return new ArrayList<>(buscarProjeto(projetoId).getAlunos());
    }

    @Transactional
    public List<ProjetoExtensao> listarProjetosDoAluno(Long alunoId) {
        Aluno aluno = buscarAluno(alunoId);

        List<ProjetoExtensao> lista = new ArrayList<>();
        for (ProjetoExtensao p : projetoRepository.findAll()) {
            if (p.getAlunos().contains(aluno)) {
                lista.add(p);
            }
        }
        return lista;
    }

    // muda o aluno de curso
    @Transactional
    public Aluno trocarCurso(Long alunoId, Integer cursoId) {
        Aluno aluno = buscarAluno(alunoId);
        Curso curso = buscarCurso(cursoId);

        aluno.setCurso(curso);
        return alunoRepository.save(aluno);
    }

    @Transactional
    public List<Aluno> listarAlunosDoCurso(Integer cursoId) {
        buscarCurso(cursoId);

        List<Aluno> lista = new ArrayList<>();
        for (Aluno a : alunoRepository.findAll()) {
            if (a.getCurso() != null && a.getCurso().getId().equals(cursoId)) {
                lista.add(a);
            }
        }
        return lista;
    }
}