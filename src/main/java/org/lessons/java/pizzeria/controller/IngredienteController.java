package org.lessons.java.pizzeria.controller;

import java.util.List;

import org.lessons.java.pizzeria.model.Ingrediente;
import org.lessons.java.pizzeria.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ingredienti")
public class IngredienteController {

	@Autowired
	IngredienteRepository ingredienteRepo;

	@GetMapping
	public String index(Model model) {

		List<Ingrediente> ingredienti = ingredienteRepo.findAll();
		model.addAttribute("ingredienti", ingredienti);

		return "ingredienti/indexIngredienti";
	}

	@GetMapping("/create")
	public String createIngr(Model model) {
		model.addAttribute("ingrediente", new Ingrediente());
		return "ingredienti/createIngrediente";
	}

	@RequestMapping("/create")
	public String storeIngr(@Valid @ModelAttribute("ingrediente") Ingrediente formIngrediente,
			BindingResult bindingResult, Model model) {
		ingredienteRepo.save(formIngrediente);
		return "redirect:/ingredienti";
	}
}
