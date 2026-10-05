package com.unifacisa.projeto2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "carteirinha")
public class Carteirinha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String numeroMatricula;
    private String dataValidade;

    @OneToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Carteirinha() {}

    public Carteirinha(Integer id, String numeroMatricula, String dataValidade, Aluno aluno) {
        this.id = id;
        this.numeroMatricula = numeroMatricula;
        this.dataValidade = dataValidade;
        this.aluno = aluno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}