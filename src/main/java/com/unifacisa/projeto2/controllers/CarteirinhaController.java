package com.unifacisa.projeto2.controllers;

import com.unifacisa.projeto2.entities.Carteirinha;
import com.unifacisa.projeto2.services.CarteirinhaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/carteirinhas")
public class CarteirinhaController {

    private final CarteirinhaService service;

    public CarteirinhaController(CarteirinhaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Carteirinha>> findAll() {
        List<Carteirinha> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Carteirinha> findById(@PathVariable Integer id) {
        Carteirinha obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Carteirinha> insert(@RequestBody Carteirinha obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Carteirinha> update(@PathVariable Integer id, @RequestBody Carteirinha obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}