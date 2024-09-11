package org.lesson.java.spring.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "offerte")
public class Offerta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@NotEmpty
	private String titoloOfferta;
	
	@UpdateTimestamp
	private LocalDateTime inizioOfferta;
	
	@UpdateTimestamp
	private LocalDateTime fineOfferta;
	
	@ManyToOne
	@JoinColumn(name="pizza_id", nullable=false)
	private Pizza pizza;

}
