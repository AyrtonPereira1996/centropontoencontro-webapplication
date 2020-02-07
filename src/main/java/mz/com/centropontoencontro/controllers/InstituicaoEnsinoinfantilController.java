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
import mz.com.centropontoencontro.service.InstituicaoEnsinoInfantilService;


@Controller
@RequestMapping("/instituicaoensinoinfantil")
public class InstituicaoEnsinoinfantilController {
	
	@Autowired
	private InstituicaoEnsinoInfantilService service;
	
	@GetMapping("/cadastro_instituicaoinfantil")
	public String cadastrarInfantil(InstituicaoEnsino instituicaoEnsino) {
		return "instituicaoensino/cadastro_instituicaoinfantil";
	}
	
	@GetMapping("/cadastro_instituicaoinfantil_por_bibliotecario")
	public String cadastrarInfantilByBibliotecario(InstituicaoEnsino instituicaoEnsino) {
		return "instituicaoensino/cadastro_instituicaoinfantil_por_bibliotecario";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("instituicoes", service.pesquisarTodasInstituicoesInfantis());
		return "instituicaoensino/pesquisa_instituicaoensinoinfantil";
	}
	
	@GetMapping("/listar_por_bibliotecario")
	public String listarByBibliotecario(ModelMap model) {
		model.addAttribute("instituicoes", service.pesquisarTodasInstituicoesInfantis());
		return "instituicaoensino/pesquisa_instituicaoensinoinfantil_por_bibliotecario";
	}
	
	@GetMapping("/listar_por_gestor")
	public String listarByGestor(ModelMap model) {
		model.addAttribute("instituicoes", service.pesquisarTodasInstituicoesInfantis());
		return "instituicaoensino/pesquisa_instituicaoensinoinfantil_por_gestor";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid InstituicaoEnsino insEnsino, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "instituicaoensino/cadastro_instituicaoinfantil";
		}
		service.salvar(insEnsino);
		attr.addFlashAttribute("success", "Escola registada com sucesso!");
		return "redirect:/instituicaoensinoinfantil/cadastro_instituicaoinfantil";
	}
	
	@PostMapping("/salvar_por_bibliotecario")
	public String salvarByBibliotecario(@Valid InstituicaoEnsino insEnsino, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "instituicaoensino/cadastro_instituicaoinfantil_por_bibliotecario";
		}
		service.salvar(insEnsino);
		attr.addFlashAttribute("success", "Escola registada com sucesso!");
		return "redirect:/instituicaoensinoinfantil/cadastro_instituicaoinfantil_por_bibliotecario";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("instituicaoEnsino", service.pesquisarPorId(id));
		return "instituicaoensino/cadastro_instituicaoinfantil";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid InstituicaoEnsino instituicaoEnsino, BindingResult result,  RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "instituicaoensino/cadastro_instituicaoinfantil";
		}
		service.editar(instituicaoEnsino);
		attr.addFlashAttribute("success", "Dados da instituição infantil editados com sucesso!");
		return "redirect:/instituicaoensinoinfantil/cadastro_instituicaoinfantil";
	}
	
	@GetMapping("/editar_por_bibliotecario/{id}")
	public String preEditarByBibliotecario(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("instituicaoEnsino", service.pesquisarPorId(id));
		return "instituicaoensino/cadastro_instituicaoinfantil_por_bibliotecario";
	}
	
	@PostMapping("/editar_por_bibliotecario")
	public String editarByBibliotecario(@Valid InstituicaoEnsino instituicaoEnsino, BindingResult result,  RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "instituicaoensino/cadastro_instituicaoinfantil_por_bibliotecario";
		}
		service.editar(instituicaoEnsino);
		attr.addFlashAttribute("success", "Dados da instituição infantil editados com sucesso!");
		return "redirect:/instituicaoensinoinfantil//cadastro_instituicaoinfantil_por_bibliotecario";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if (service.instituicaoTemUtentes(id)) {
			model.addAttribute("fail", "Não foi possivel excluir a instituição infantil porque tem utente(s) associado(os)!");
		} else if (service.instituicaoTemUtentesMenores(id)) {
			model.addAttribute("fail", "Não foi possivel excluir a instituição infantil porque tem utente(s) menor(es) associado(os)!");
		} else {
			service.excluir(id);
			model.addAttribute("success", "Instituição infantil excluida com sucesso!");
		}
		return listar(model);
	}

}
