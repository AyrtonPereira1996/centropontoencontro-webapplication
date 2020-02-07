package mz.com.centropontoencontro.controllers;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import mz.com.centropontoencontro.domain.EmprestimoInfantil;
import mz.com.centropontoencontro.service.EmprestimoInfantilService;


@Controller
@RequestMapping("/emprestimoinfantil")
public class EmprestimoInfantilController {
	
	@Autowired
	private EmprestimoInfantilService service;

	/*Metodo que abre a view de cadastro de emprestimo para o coordenador*/
	@GetMapping("/cadastro")
	public String cadastrar(EmprestimoInfantil emprestimoInfantil) {
		return "emprestimo/cadastro_emprestimoinfantil";
	}
	
	/*Metodo que abre a view de cadastro de emprestimo para os bibliotecarios*/
	@GetMapping("/cadastro_por_bibliotecario")
	public String cadastrarByBibliotecario(EmprestimoInfantil emprestimoInfantil) {
		return "emprestimo/cadastro_emprestimoinfantil_por_bibliotecario";
	}
	
	/*Metodo que abre a view que permite visualizar os registos de emprestimos para o coordenador*/
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("emprestimos", service.pesquisarTodosDesc());
		return "emprestimo/pesquisa_emprestimoinfantil";
	}
	
	/*Metodo que abre a view que permite visualizar os registos de emprestimos para os bibliotecarios*/
	@GetMapping("/listar_por_bibliotecario")
	public String listarByBibliotecario(ModelMap model) {
		model.addAttribute("emprestimos", service.pesquisarTodosDesc());
		return "emprestimo/pesquisa_emprestimoinfantil_por_bibliotecario";
	}
	
	/*Metodo que permite persistir*/
	@PostMapping("/salvar")
	public String salvar(@Valid EmprestimoInfantil emprestimoInfantil, BindingResult result, RedirectAttributes attr ) {
		if (result.hasErrors()) {
			return "emprestimo/cadastro_emprestimoinfantil";
		}
		
		if(emprestimoInfantil.getDataRegisto()== null) {
			emprestimoInfantil.setDataRegisto(LocalDateTime.now());
		}
		service.salvar(emprestimoInfantil);
		attr.addFlashAttribute("success", "Emprestimo registado com sucesso!");
		return "redirect:/emprestimoinfantil/listar";
	}
	
	/*Metodo que permite persistir para os bibliotecarios*/
	@PostMapping("/salvar_por_bibliotecario")
	public String salvarByBibliotecario(@Valid EmprestimoInfantil emprestimoInfantil, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "emprestimo/cadastro_emprestimoinfantil_por_bibliotecario";
		}
		if(emprestimoInfantil.getDataRegisto()==null) {
			emprestimoInfantil.setDataRegisto(LocalDateTime.now());
		}
		service.salvar(emprestimoInfantil);
		attr.addFlashAttribute("success", "Emprestimo registado com sucesso");
		return "redirect:/emprestimoinfantil/listar_por_bibliotecario";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("emprestimoInfantil", service.pesquisarPorId(id));
		return "emprestimo/cadastro_emprestimoinfantil";
	}
	
	
	@PostMapping("/editar")
	public String editar(@Valid EmprestimoInfantil emprestimoInfantil, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "emprestimo/cadastro_emprestimo";
		}
		service.editar(emprestimoInfantil);
		attr.addFlashAttribute("success", "Dados do emprestimo editados com sucesso!");
		return "redirect:/emprestimoinfantil/cadastro";
		
	}
	
	@GetMapping("/editar_por_bibliotecario/{id}")
	public String preEditarByBibliotecario(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("emprestimoInfantil", service.pesquisarPorId(id));
		return "emprestimo/cadastro_emprestimoinfantil_por_bibliotecario";
	}
	
	
	@PostMapping("/editar_por_bibliotecario")
	public String editarByBibliotecario(@Valid EmprestimoInfantil emprestimoInfantil, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "emprestimo/cadastro_emprestimoinfantil_por_bibliotecario";
		}
		service.editar(emprestimoInfantil);
		attr.addFlashAttribute("success", "Dados do emprestimo editados com sucesso!");
		return "redirect:/emprestimoinfantil/cadastro_por_bibliotecario";
		
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Emprestimo infantil devolvido com sucesso");
		return listar(model);
	}
	
	@GetMapping("/excluirporbibliotecario/{id}")
	public String excluirBybibliotecario(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Emprestimo infantil devolvido com sucesso");
		return listarByBibliotecario(model);
	}
	
	
	
	
}
