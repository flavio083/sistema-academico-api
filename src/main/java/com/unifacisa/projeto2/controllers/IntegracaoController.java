package com.unifacisa.projeto2.controllers;

import com.unifacisa.projeto2.entities.Aluno;
import com.unifacisa.projeto2.entities.ProjetoExtensao;
import com.unifacisa.projeto2.services.IntegracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/integracao")
public class IntegracaoController {

    @Autowired
    private IntegracaoService service;

    @PostMapping("/projetos/{projetoId}/alunos/{alunoId}")
    public ResponseEntity<ProjetoExtensao> matricular(@PathVariable Long projetoId, @PathVariable Long alunoId) {
        return ResponseEntity.ok(service.matricular(projetoId, alunoId));
    }

    @DeleteMapping("/projetos/{projetoId}/alunos/{alunoId}")
    public ResponseEntity<ProjetoExtensao> desmatricular(@PathVariable Long projetoId, @PathVariable Long alunoId) {
        return ResponseEntity.ok(service.desmatricular(projetoId, alunoId));
    }

    @GetMapping("/projetos/{projetoId}/alunos")
    public List<Aluno> listarAlunosDoProjeto(@PathVariable Long projetoId) {
        return service.listarAlunosDoProjeto(projetoId);
    }

    @GetMapping("/alunos/{alunoId}/projetos")
    public List<ProjetoExtensao> listarProjetosDoAluno(@PathVariable Long alunoId) {
        return service.listarProjetosDoAluno(alunoId);
    }

    @PutMapping("/alunos/{alunoId}/curso/{cursoId}")
    public ResponseEntity<Aluno> trocarCurso(@PathVariable Long alunoId, @PathVariable Integer cursoId) {
        return ResponseEntity.ok(service.trocarCurso(alunoId, cursoId));
    }

    @GetMapping("/cursos/{cursoId}/alunos")
    public List<Aluno> listarAlunosDoCurso(@PathVariable Integer cursoId) {
        return service.listarAlunosDoCurso(cursoId);
    }
}