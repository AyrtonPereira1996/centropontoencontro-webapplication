package mz.com.centropontoencontro.controllers;

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

import mz.com.centropontoencontro.domain.InstituicaoEnsino;
import mz.com.centropontoencontro.service.InstituicaoEnsinoService;

@Controller
@RequestMapping("/instituicaoensino")
public class InstituicaoEnsinoController {
	
	@Autowired
	private InstituicaoEnsinoService service;
	
	@GetMapping("/cadastro_instituicao")
	public String cadastrar(InstituicaoEnsino instituicaoEnsino) {
		return "instituicaoensino/cadastro_instituicao";
	}
	
	@GetMapping("/cadastro_instituicao_por_bibliotecario")
	public String cadastrarByBibliotecario(InstituicaoEnsino instituicaoEnsino) {
		return "instituicaoensino/cadastro_instituicao_por_bibliotecario";
		
	}
	
	@GetMapping("/listar_instituicaoensino")
	public String listar(ModelMap model) {
		model.addAttribute("instituicoes", service.pesquisarTodasInstituicoesNãoInfantis());
		return "instituicaoensino/pesquisa_instituicaoensino";
	}
	
	@GetMapping("/listar_instituicaoensino_por_bibliotecario")
	public String listarByBibliotecario(ModelMap model){
		model.addAttribute("instituicoes", service.pesquisarTodasInstituicoesNãoInfantis());
		return "instituicaoensino/pesquisa_instituicaoensino_por_bibliotecario";
	}
	
	@GetMapping("/listar_instituicaoensino_por_gestor")
	public String listarByGestor(ModelMap model){
		model.addAttribute("instituicoes", service.pesquisarTodasInstituicoesNãoInfantis());
		return "instituicaoensino/pesquisa_instituicaoensino_por_gestor";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid InstituicaoEnsino instituicaoEnsino, BindingResult result, RedirectAttributes  attr) {
		if (result.hasErrors()) {
			return "instituicaoensino/cadastro_instituicao";
		}
		service.salvar(instituicaoEnsino);
		attr.addFlashAttribute("success", "Instituição de ensino registada com sucesso!");
		return "redirect:/instituicaoensino/cadastro_instituicao";
	}
	
	@PostMapping("/salvar_por_bibliotecario")
	public String salvarByBibliotecario(@Valid InstituicaoEnsino instituicaoEnsino, BindingResult result, RedirectAttributes  attr) {
		if (result.hasErrors()) {
			return "instituicaoensino/cadastro_instituicao_por_bibliotecario";
		}
		service.salvar(instituicaoEnsino);
		attr.addFlashAttribute("success", "Instituição de ensino registada com sucesso!");
		return "redirect:/instituicaoensino/cadastro_instituicao_por_bibliotecario";
	}
	
	
	/*Metodo preparacao para editar por coordenador*/
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		//System.out.println(service.pesquisarPorId(id).toString());
		model.addAttribute("instituicaoEnsino", service.pesquisarPorId(id));
		return "instituicaoensino/cadastro_instituicao";
	}
	
	
	/*Metodo editar por coordenador*/
	@PostMapping("/editar")
	public String editar(@Valid InstituicaoEnsino instituicaoEnsino, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "instituicaoensino/cadastro_instituicao";
		}
		service.editar(instituicaoEnsino);
		attr.addFlashAttribute("success", "Dados da instituição de ensino editados com sucesso!");
		return "redirect:/instituicaoensino/cadastro_instituicao";
	}
	
	/*Metodo preparacao para editar por bibliotecario*/
	@GetMapping("/editar_por_bibliotecario/{id}")
	public String preEditarByBibliotecario(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("instituicaoEnsino", service.pesquisarPorId(id));
		return "instituicaoensino/cadastro_instituicao_por_bibliotecario";
	}

	/*Metodo editar por bibliotecario*/
	@PostMapping("/editar_por_bibliotecario")
	public String editarByBibliotecario(@Valid InstituicaoEnsino instituicaoEnsino, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "instituicaoensino/cadastro_instituicao_por_bibliotecario";
		}
		service.editar(instituicaoEnsino);
		attr.addFlashAttribute("success", "Dados da instituição de ensino editados com sucesso!");
		return "redirect:/instituicaoensino/cadastro_instituicao_por_bibliotecario";
	}
	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if (service.instituicaoTemUtentes(id)) {
			model.addAttribute("fail", "Não foi possível excluir a instituição de ensino. Possui utente(s) vinculado(s) a esta instituição");
		} else {
			service.excluir(id);
			model.addAttribute("success", "Instituição de ensino excluída com sucesso!");
		}
		
		return listar(model);
	}
	
	
	
	
	
	

}
