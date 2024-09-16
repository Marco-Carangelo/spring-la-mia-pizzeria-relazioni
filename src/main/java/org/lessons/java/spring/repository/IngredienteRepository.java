package org.lessons.java.spring.repository;

import org.lessons.java.spring.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer>{

}
