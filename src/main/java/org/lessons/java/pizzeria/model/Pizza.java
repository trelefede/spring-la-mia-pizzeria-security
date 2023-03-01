package org.lessons.java.pizzeria.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pizze")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Nome pizza non può essere nullo")
	@NotEmpty(message = "Nome pizza non può essere vuoto")
	@Size(min = 5, max = 100, message = "Nome pizza troppo corta/lunga")
	private String name;

	@NotNull(message = "Descrizione non può essere nullo")
	@NotEmpty(message = "Descrizione non può essere vuoto")
	@Size(min = 10, max = 300, message = "Descrizione troppo corta/lunga")
	private String description;

	@NotNull(message = "Prezzo non può essere vuoto")
	@Positive(message = "Prezzo deve essere maggiore di zero")
	private BigDecimal price;

	@Column(name = "image", nullable = true)
	private String imgUrl;

	// relazioni
	@OneToMany(mappedBy = "pizza")
	private List<Offerta> offerte;

	@ManyToMany
	private List<Ingrediente> ingredienti;

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Offerta> getOfferte() {
		return offerte;
	}

	public void setOfferte(List<Offerta> offerte) {
		this.offerte = offerte;
	}

	public List<Ingrediente> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}

}
