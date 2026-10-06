package com.unifacisa.projeto2.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aluno")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToOne(mappedBy = "aluno")
    private Carteirinha carteirinha;

    @ManyToMany(mappedBy = "alunos")
    private List<ProjetoExtensao> projetos = new ArrayList<>();


}