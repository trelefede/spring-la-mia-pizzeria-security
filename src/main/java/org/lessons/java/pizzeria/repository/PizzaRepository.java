package org.lessons.java.pizzeria.repository;

import java.util.List;

import org.lessons.java.pizzeria.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

	List<Pizza> findByNameLike(String pizza);

}
