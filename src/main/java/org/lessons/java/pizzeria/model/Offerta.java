package org.lessons.java.pizzeria.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Offerta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Titolo non può essere nullo")
	@NotEmpty(message = "Titolo non può essere vuoto")
	private String titolo;

	@NotNull(message = "Data inizio offerta non può essere nullo")
	private LocalDate inizio;

	@NotNull(message = "Data fine offerta non può essere nullo")
	private LocalDate fine;

	@JsonIgnore
	@ManyToOne
	private Pizza pizza;

	public Integer getIdInteger() {
		return id;
	}

	public void setIdInteger(Integer idInteger) {
		this.id = idInteger;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getInizio() {
		return inizio;
	}

	public void setInizio(LocalDate inizio) {
		this.inizio = inizio;
	}

	public LocalDate getFine() {
		return fine;
	}

	public void setFine(LocalDate fine) {
		this.fine = fine;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

}
