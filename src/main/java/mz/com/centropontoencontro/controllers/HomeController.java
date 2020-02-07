package mz.com.centropontoencontro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	@GetMapping({"/login", "/"})
	public String homeController() {
		return "login";
	}
	
	@GetMapping("/login-error")
	public String loginError(ModelMap model) {
		model.addAttribute("alerta", "erro");
		model.addAttribute("titulo", "Crendencias inválidas!");
		model.addAttribute("texto", "Nome de usuário ou senha incorrectos");
		model.addAttribute("usererro", "Introduza o nome de usuário válido");
		model.addAttribute("senhaerro", "Introduza a senha de acesso válido");
		
		return "login";
	}
	
}
