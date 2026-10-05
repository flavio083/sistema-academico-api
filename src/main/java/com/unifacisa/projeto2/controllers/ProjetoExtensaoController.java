package com.unifacisa.projeto2.controllers;

import com.unifacisa.projeto2.entities.ProjetoExtensao;
import com.unifacisa.projeto2.services.ProjetoExtensaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos-extensao")
public class ProjetoExtensaoController {

    @Autowired
    private ProjetoExtensaoService service;

    @GetMapping
    public List<ProjetoExtensao> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoExtensao> findById(@PathVariable Long id) {
        ProjetoExtensao projeto = service.findById(id);

        if (projeto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(projeto);
    }

    @PostMapping
    public ProjetoExtensao save(@RequestBody ProjetoExtensao projetoExtensao) {
        return service.save(projetoExtensao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ProjetoExtensao projeto = service.findById(id);

        if (projeto == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProjetoExtensao> update(
            @PathVariable Long id,
            @RequestBody ProjetoExtensao projetoExtensao) {

        ProjetoExtensao projetoExistente = service.findById(id);

        if (projetoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        projetoExistente.setNome(projetoExtensao.getNome());
        projetoExistente.setDescricao(projetoExtensao.getDescricao());

        return ResponseEntity.ok(service.save(projetoExistente));
    }
}
