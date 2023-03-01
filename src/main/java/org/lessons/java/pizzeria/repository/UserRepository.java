package org.lessons.java.pizzeria.repository;

import java.util.Optional;

import org.lessons.java.pizzeria.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);

}
