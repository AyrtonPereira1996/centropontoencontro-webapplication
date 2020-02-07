package mz.com.centropontoencontro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mz.com.centropontoencontro.service.EstudanteDesistenciaService;

@Controller
@RequestMapping("/estudantesdesistiram")
public class EstudantesDesistiramController {
	
	@Autowired
	private EstudanteDesistenciaService service;
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("estudanteDesistencia", service.pesquisarTodos());
		return "curso/pesquisa_estudantesdesistiram";
	}
	
	@GetMapping("/listar_por_gestor")
	public String listarByGestor(ModelMap model) {
		model.addAttribute("estudanteDesistencia", service.pesquisarTodos());
		return "curso/pesquisa_estudantesdesistiram_por_gestor";
	}
}
