package org.lessons.java.spring.repository;

import java.util.Optional;

import org.lessons.java.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

	public Optional<User> findByUsername(String username);

}
