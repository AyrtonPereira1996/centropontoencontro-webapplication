package mz.com.centropontoencontro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mz.com.centropontoencontro.domain.EstudanteAprovado;
import mz.com.centropontoencontro.service.EstudanteAprovadoService;


@Controller
@RequestMapping("/estudantesaprovacao")
public class EstudantesAprovadosController {
	
	@Autowired
	private EstudanteAprovadoService service;
	
	
	@GetMapping("/cadastro")
	public String abrirCadastro(EstudanteAprovado estudanteAprovado) {
		return "curso/cadastro_estudanteaprovado";
	}
	
	@RequestMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("estudanteAprovado", service.pesquisarTodos());
		return "curso/pesquisa_estudantesaprovados";
	}
	
	@RequestMapping("/listar_por_gestor")
	public String listarByGestor(ModelMap model) {
		model.addAttribute("estudanteAprovado", service.pesquisarTodos());
		return "curso/pesquisa_estudantesaprovados_por_gestor";
	}
	
	


}
