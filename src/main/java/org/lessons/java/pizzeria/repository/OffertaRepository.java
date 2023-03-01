package org.lessons.java.pizzeria.repository;

import org.lessons.java.pizzeria.model.Offerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffertaRepository extends JpaRepository<Offerta, Integer> {

}
