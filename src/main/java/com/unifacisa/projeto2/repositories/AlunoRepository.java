package com.unifacisa.projeto2.repositories;

import com.unifacisa.projeto2.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
