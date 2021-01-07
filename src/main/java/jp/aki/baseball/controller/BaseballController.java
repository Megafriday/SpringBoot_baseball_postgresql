package jp.aki.baseball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jp.aki.baseball.domain.Player;
import jp.aki.baseball.service.BaseBallService;

@Controller
public class BaseballController {

	@Autowired
	private BaseBallService service;

	@GetMapping("/players")
	public String findAll(Model model) {
		model.addAttribute("players", service.findAll());
		return "index";
	}

	@GetMapping("/players/new")
	public String getNew(Model model) {
		model.addAttribute("player", new Player());
		return "new";
	}

	@GetMapping("/players/{id}/edit")
	public String edit(Model model, @PathVariable Integer id) {
		model.addAttribute("player", service.findById(id));
		return "edit";
	}

	@GetMapping("/players/{id}")
	public String findById(Model model, @PathVariable Integer id) {
		model.addAttribute("player", service.findById(id));
		return "show";
	}

	@PostMapping("/players/{id}/edit")
	public String update(@PathVariable Integer id, @ModelAttribute Player player) {
		player.setId(id);
		service.save(player);
		return "redirect:/players";
	}

	@PostMapping("/players")
	public String save(
			@Validated @ModelAttribute Player player,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors())
			return "new";

		service.save(player);
		return "redirect:/players";
	}

	@PostMapping("/players/{id}/delete")
	public String destroy(@PathVariable Integer id) {
		service.deleteById(id);
		return "redirect:/players";
	}
}
