package com.unifacisa.projeto2.repositories;

import com.unifacisa.projeto2.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}