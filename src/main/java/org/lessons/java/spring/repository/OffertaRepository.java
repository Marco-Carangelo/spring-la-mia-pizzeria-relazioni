package org.lessons.java.spring.repository;

import org.lessons.java.spring.model.Offerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffertaRepository extends JpaRepository<Offerta, Integer>{ 

}
