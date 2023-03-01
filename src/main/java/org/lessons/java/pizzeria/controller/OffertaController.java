package org.lessons.java.pizzeria.controller;

import org.lessons.java.pizzeria.model.Offerta;
import org.lessons.java.pizzeria.model.Pizza;
import org.lessons.java.pizzeria.repository.OffertaRepository;
import org.lessons.java.pizzeria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/offerte")
public class OffertaController {

	@Autowired
	PizzaRepository pizzaRepository;

	@Autowired
	OffertaRepository offertaRepository;

	@GetMapping("/create")
	public String create(@RequestParam(name = "pizzaId", required = true) Integer pizzaId, Model model) {

		Offerta offerta = new Offerta();
		Pizza pizza = pizzaRepository.getReferenceById(pizzaId);
		offerta.setPizza(pizza);
		model.addAttribute("offerta", offerta);

		return ("offerte/createOfferta");
	}

	@PostMapping("/create")
	public String store(@Valid @ModelAttribute("offerta") Offerta formOfferta, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "offerte/create";
		}
		offertaRepository.save(formOfferta);

		return "redirect:/pizze";
	}
}
