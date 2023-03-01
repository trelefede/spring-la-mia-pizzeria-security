package org.lessons.java.pizzeria.controller;

import java.util.List;

import org.lessons.java.pizzeria.model.Ingrediente;
import org.lessons.java.pizzeria.model.Pizza;
import org.lessons.java.pizzeria.repository.IngredienteRepository;
import org.lessons.java.pizzeria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pizze")

public class IndexController {

	@Autowired
	private PizzaRepository pizze;

	@Autowired
	private IngredienteRepository ingredienteRepo;

	@GetMapping
	public String index(@RequestParam(name = "pizza", required = false) String pizza, Model model) {

		List<Pizza> result;

		if (pizza != null && !pizza.isEmpty()) {
			result = pizze.findByNameLike("%" + pizza + "%");
		} else {
			result = pizze.findAll();
		}

		model.addAttribute("result", result);
		return "index";
	}

	@GetMapping("/{id}")
	public String showPizza(@PathVariable("id") Integer id, Model model) {
		Pizza pizza = pizze.getReferenceById(id);
		model.addAttribute("pizza", pizza);
		return "pizzaDettaglio";
	}

	@GetMapping("/create")
	public String createPizza(Model model) {
		List<Ingrediente> ingredienti = ingredienteRepo.findAll();
		model.addAttribute("ingredienti", ingredienti);
		model.addAttribute("pizza", new Pizza());
		return "createPizza";
	}

	@RequestMapping("/create")
	public String storePizza(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "createPizza";
		}

		pizze.save(formPizza);
		return "redirect:/pizze";
	}

	@GetMapping("/edit/{id}")
	public String editPizza(@PathVariable("id") Integer id, Model model) {
		List<Ingrediente> ingredienti = ingredienteRepo.findAll();
		model.addAttribute("ingredienti", ingredienti);
		model.addAttribute("pizza", pizze.getReferenceById(id));
		return ("editPizza");
	}

	@PostMapping("/edit/{id}")
	public String updatePizza(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "editPizza";
		}

		pizze.save(formPizza);
		return "redirect:/pizze";
	}

	@PostMapping("/delete/{id}")
	public String deletePizza(@PathVariable("id") Integer id) {
		pizze.deleteById(id);
		return "redirect:/pizze";
	}
}
