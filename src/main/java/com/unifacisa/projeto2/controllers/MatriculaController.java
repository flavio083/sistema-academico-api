package com.unifacisa.projeto2.controllers;

import com.unifacisa.projeto2.entities.ProjetoExtensao;
import com.unifacisa.projeto2.services.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projetos")
public class MatriculaController {

    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    @PostMapping("/{projetoId}/alunos/{alunoId}")
    public ResponseEntity<ProjetoExtensao> matricular(
            @PathVariable Long projetoId,
            @PathVariable Long alunoId) {

        return service.matricular(projetoId, alunoId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{projetoId}/alunos/{alunoId}")
    public ResponseEntity<Void> removerAluno(
            @PathVariable Long projetoId,
            @PathVariable Long alunoId) {

        return service.removerAluno(projetoId, alunoId)
                .map(projeto -> ResponseEntity.noContent().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
