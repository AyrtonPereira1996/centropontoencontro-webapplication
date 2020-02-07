package mz.com.centropontoencontro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mz.com.centropontoencontro.service.DevolucaoInfantilService;


@Controller
@RequestMapping("/devolucaoinfantil")
public class DevolucaoInfantilController {

	@Autowired
	private DevolucaoInfantilService service;
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("devolucoes", service.pesquisarTodosDesc());
		return "devolucao/pesquisa_devolucaoinfantil";
	}
	
	@GetMapping("/listar_por_bibliotecario")
	public String listarByBibliotecario(ModelMap model) {
		model.addAttribute("devolucoes", service.pesquisarTodosDesc());
		return "devolucao/pesquisa_devolucaoinfantil_por_bibliotecario";
	}
}
