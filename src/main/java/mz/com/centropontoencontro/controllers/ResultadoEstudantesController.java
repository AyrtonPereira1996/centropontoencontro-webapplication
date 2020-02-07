package mz.com.centropontoencontro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resultadoestudantes")
public class ResultadoEstudantesController {
	
	@GetMapping("/consultar_opcoes")
	public String consultaropcoes() {
		return "curso/pesquisa_resultadoestudantes";
	}
}
