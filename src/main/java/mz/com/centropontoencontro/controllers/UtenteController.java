package mz.com.centropontoencontro.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import mz.com.centropontoencontro.domain.InstituicaoEnsino;
import mz.com.centropontoencontro.domain.Utente;
import mz.com.centropontoencontro.service.InstituicaoEnsinoService;
import mz.com.centropontoencontro.service.UtenteService;

@Controller
@RequestMapping("/utente")
public class UtenteController {
	
	@Autowired
	private UtenteService service;
	
	@Autowired
	private InstituicaoEnsinoService insService;
	

	
	@GetMapping("/cadastro")
	public String cadastrar(Utente utente) {
		return "utente/cadastro_utente";
	}
	
	@GetMapping("/cadastro_por_bibliotecario")
	public String cadastrarByBibliotecario(Utente utente) {
		return "utente/cadastro_utente_por_bibliotecario";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("utentes", service.pesquisarTodos());
		return "utente/pesquisa_utente";
	}
	
	@GetMapping("/listar_por_bibliotecario")
	public String listarByBibliotecario(ModelMap model) {
		model.addAttribute("utentes", service.pesquisarTodos());
		return "utente/pesquisa_utente_por_bibliotecario";
	}
	
	@GetMapping("/listar_por_gestor")
	public String listarByGestor(ModelMap model) {
		model.addAttribute("utentes", service.pesquisarTodos());
		return "utente/pesquisa_utente_por_gestor";
	}
	
	@GetMapping("/listar_numeroemprestimos")
	public String listarNumeroEmprestimo(ModelMap model){
		model.addAttribute("utentes", service.pesquisarUtenteNumeroEmprestimos());
		return "utente/pesquisa_utente_numero_emprestimo";
	}
	
	@GetMapping("/listar_numeroemprestimos_por_gestor")
	public String listarNumeroEmprestimoByGestor(ModelMap model){
		model.addAttribute("utentes", service.pesquisarUtenteNumeroEmprestimos());
		return "utente/pesquisa_utente_numero_emprestimo_por_gestor";
	}
	
	@PostMapping("/salvar")
	public String salvar(Utente utente, BindingResult result, RedirectAttributes attr) {	
		service.salvar(utente);
		attr.addFlashAttribute("success", "Utente registado com sucesso!");
		return "redirect:/utente/cadastro";
	}
	
	@PostMapping("/salvar_por_bibliotecario")
	public String salvarByBibliotecario(Utente utente, BindingResult result, RedirectAttributes attr) {
	
		service.salvar(utente);
		attr.addFlashAttribute("success", "Utente registado com sucesso!");
		return "redirect:/utente/cadastro_por_bibliotecario";
	}
	
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable ("id") Long id, ModelMap model) {
		model.addAttribute("utente", service.pesquisarPorId(id));
		return "utente/cadastro_utente";
	}
	
	@PostMapping("/editar")
	public String editar( Utente utente,  BindingResult result, RedirectAttributes attr) {

		service.editar(utente);
		attr.addFlashAttribute("success", "Dados do utente editados com sucesso!");
		return "redirect:/utente/cadastro";
	}
	
	@GetMapping("/editar_por_bibliotecario/{id}")
	public String preEditarByBibliotecario(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("utente", service.pesquisarPorId(id));
		return "utente/cadastro_utente_por_bibliotecario";
	}
	
	@PostMapping("/editar_por_bibliotecario")
	public String editarByBibliotecario(Utente utente,  BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "utente/cadastro_utente_por_bibliotecario";
		}
		service.editar(utente);
		attr.addFlashAttribute("success", "Dados do utente editado com sucesso!");
		return "redirect:/utente/cadastro_por_bibliotecario";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if (service.utenteTemEmprestimos(id)) {
			model.addAttribute("fail", "Não foi possivel excluir porque este utente tem emprestimo(s) associados a ele(a).");
		} else if (service.utenteTemDevolucoes(id)) {
			model.addAttribute("fail", "Não foi possível excluir porque este utente tem devolução(ões) associados a ele(a).");
		}else if (service.utenteTemDevolucoes(id) && service.utenteTemEmprestimos(id)) {
			model.addAttribute("fail", "Não foi possivel excluir porque este utente tem emprestimo(s) e devolução(ões) associados a ele(a)");
		}else if (service.utenteTemAprovacoes(id)) {
			model.addAttribute("fail", "Não foi possivel excluir porque este utente possui registo(os) de aprovação em algum curso");
		}else if(service.utenteTemReprovacoes(id)) {
			model.addAttribute("fail", "Não foi possivel excluir porque este utente possui registo(os) de reprovação em algum curso");
		}else if (service.utenteTemDesistencias(id)) {
			model.addAttribute("fail", "Não foi possivel excluir porque este utente possui registo(os) de desistência em algum curso");
		}else {
			service.excluir(id);
			model.addAttribute("success", "Utente excluido com sucesso");
		}
		
		return listar(model);
	}
	
	@GetMapping("/interditar")
	public String interditarUtentes(ModelMap model, RedirectAttributes attr) {
		service.interditarUtentes();	
		attr.addFlashAttribute("success", "Utentes registados interditos com sucesso");
		return "redirect:/utente/listar";	
	}
	
	
	
	@ModelAttribute("instituicoes")
	public List<InstituicaoEnsino> listaInstituicao(){
		return insService.pesquisarTodasInstituicoesNãoInfantis();
	}	
	

	

}
