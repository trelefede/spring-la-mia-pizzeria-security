package org.lessons.java.pizzeria.repository;

import org.lessons.java.pizzeria.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {

}
