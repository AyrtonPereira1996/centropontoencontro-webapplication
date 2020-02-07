package mz.com.centropontoencontro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import mz.com.centropontoencontro.service.EstudanteReprovadoService;

@Controller
@RequestMapping("/estudantesreprovacao")
public class EstudantesReprovadosController {
	
	@Autowired
	private EstudanteReprovadoService service;

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("estudanteReprovado", service.pesquisarTodos());
		return "curso/pesquisa_estudantesreprovados";
	}
	
	@GetMapping("/listar_por_gestor")
	public String listarByGestor(ModelMap model) {
		model.addAttribute("estudanteReprovado", service.pesquisarTodos());
		return "curso/pesquisa_estudantesreprovados_por_gestor";
	}
	

	
	
	
}
