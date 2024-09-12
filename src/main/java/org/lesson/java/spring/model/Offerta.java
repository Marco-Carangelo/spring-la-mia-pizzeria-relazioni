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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
	
	@NotNull
	@Min(5)
	@Max(50)
	private Integer percentualeSconto;
	
	@UpdateTimestamp
	private LocalDateTime inizioOfferta;
	
	@UpdateTimestamp
	private LocalDateTime fineOfferta;
	
	@ManyToOne
	@JoinColumn(name="pizza_id", nullable=false)
	private Pizza pizza;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitoloOfferta() {
		return titoloOfferta;
	}

	public void setTitoloOfferta(String titoloOfferta) {
		this.titoloOfferta = titoloOfferta;
	}

	public LocalDateTime getInizioOfferta() {
		return inizioOfferta;
	}

	public void setInizioOfferta(LocalDateTime inizioOfferta) {
		this.inizioOfferta = inizioOfferta;
	}

	public LocalDateTime getFineOfferta() {
		return fineOfferta;
	}

	public void setFineOfferta(LocalDateTime fineOfferta) {
		this.fineOfferta = fineOfferta;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public Integer getPercentualeSconto() {
		return percentualeSconto;
	}

	public void setPercentualeSconto(Integer percentualeSconto) {
		this.percentualeSconto = percentualeSconto;
	}
	
	

}
