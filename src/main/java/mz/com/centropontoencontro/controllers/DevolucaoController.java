package mz.com.centropontoencontro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mz.com.centropontoencontro.service.DevolucaoService;

@Controller
@RequestMapping("/devolucao")
public class DevolucaoController {
	
	@Autowired
	private DevolucaoService service;
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("devolucoes", service.pesquisarTodosDesc());
		return "devolucao/pesquisa_devolucao";
	}
	
	@GetMapping("/listar_por_bibliotecario")
	public String listarbyBibliotecario(ModelMap model) {
		model.addAttribute("devolucoes", service.pesquisarTodosDesc());
		return "devolucao/pesquisa_devolucao_por_bibliotecario";
	}
}
