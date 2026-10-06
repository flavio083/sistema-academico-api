package com.unifacisa.projeto2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carteirinha")
public class Carteirinha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String numeroMatricula;
    private String dataValidade;

    @OneToOne
    @JoinColumn(name = "aluno_id", unique = true)
    private Aluno aluno;

}