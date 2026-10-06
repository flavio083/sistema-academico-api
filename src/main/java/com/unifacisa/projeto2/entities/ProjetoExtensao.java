package com.unifacisa.projeto2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projeto_extensao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoExtensao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @ManyToMany
    @JoinTable(
            name = "projeto_extensao_aluno",
            joinColumns = @JoinColumn(name = "projeto_extensao_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private List<Aluno> alunos = new ArrayList<>();


}
