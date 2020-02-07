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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import mz.com.centropontoencontro.domain.InstituicaoEnsino;
import mz.com.centropontoencontro.domain.UtenteMenor;
import mz.com.centropontoencontro.service.InstituicaoEnsinoInfantilService;

import mz.com.centropontoencontro.service.UtenteMenorService;

@Controller
@RequestMapping("/utentemenor")
public class UtenteMenorController {

	@Autowired
	private UtenteMenorService service;

	@Autowired
	private InstituicaoEnsinoInfantilService instiInfantilService;

	@GetMapping("/cadastro")
	public String cadastrar(UtenteMenor utentemenor) {
		return "utentemenor/cadastro_utentemenor";
	}

	@GetMapping("/cadastro_por_bibliotecario")
	public String cadastrarByBibliotecario(UtenteMenor utentemenor) {
		return "utentemenor/cadastro_utentemenor_por_bibliotecario";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("utentes", service.pesquisarTodos());
		return "utentemenor/pesquisa_utentemenor";
	}

	@GetMapping("/listar_por_bibliotecario")
	public String listarByBibliotecario(ModelMap model) {
		model.addAttribute("utentes", service.pesquisarTodos());
		return "utentemenor/pesquisa_utentemenor_por_bibliotecario";
	}

	@GetMapping("/listar_por_gestor")
	public String listarByGestor(ModelMap model) {
		model.addAttribute("utentes", service.pesquisarTodos());
		return "utentemenor/pesquisa_utentemenor_por_gestor";
	}

	@GetMapping("/listar_numeroemprestimos_por_gestor")
	public String listarNumeroEmprestimosByGestor(ModelMap model) {
		model.addAttribute("utentes", service.pesquisarPorNomeQuantidade());
		return "utentemenor/pesquisa_utentemenor_numero_emprestimo";
	}

	@GetMapping("/listar_numeroemprestimos")
	public String listarNumeroEmprestimos(ModelMap model) {
		model.addAttribute("utentes", service.pesquisarPorNomeQuantidade());
		return "utentemenor/pesquisa_utentemenor_numero_emprestimo_por_coordenador";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid UtenteMenor utenteMenor, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "utentemenor/cadastro_utentemenor";
		}
		service.salvar(utenteMenor);
		attr.addFlashAttribute("success", "Utente menor registado com sucesso!");
		return "redirect:/utentemenor/cadastro";
	}

	@PostMapping("/salvar_por_bibliotecario")
	public String salvarByBibliotecario(@Valid UtenteMenor utenteMenor, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "utentemenor/cadastro_utentemenor_por_bibliotecario";
		}
		service.salvar(utenteMenor);
		attr.addFlashAttribute("success", "Utente menor registado com sucesso!");
		return "redirect:/utentemenor/cadastro_por_bibliotecario";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("utenteMenor", service.pesquisarPorId(id));
		return "utentemenor/cadastro_utentemenor";
	}

	@PostMapping("/editar")
	public String editar(@Valid UtenteMenor utenteMenor, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "utentemenor/cadastro_utentemenor";
		}
		service.editar(utenteMenor);
		attr.addFlashAttribute("success", "Dados do utente menor editados com sucesso");
		return "redirect:/utentemenor/cadastro";
	}

	@GetMapping("/editar_por_bibliotecario/{id}")
	public String preEditarByBibliotecario(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("utenteMenor", service.pesquisarPorId(id));
		return "utentemenor/cadastro_utentemenor_por_bibliotecario";
	}

	@PostMapping("/editar_por_bibliotecario")
	public String editarByBibliotecario(@Valid UtenteMenor utenteMenor, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "redirect:/utentemenor/cadastro_por_bibliotecario";
		}
		service.editar(utenteMenor);
		attr.addFlashAttribute("success", "Dados do utente menor editados com sucesso");
		return "redirect:/utentemenor/cadastro_por_bibliotecario";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if (service.utenteMenorTemDevolucoes(id)) {
			model.addAttribute("fail",
					"Não foi possivel excluir o utente menor porque tem devolução(ões) associada(as)!");
		} else if (service.utenteMenorTemEmprestimos(id)) {
			model.addAttribute("fail",
					"Não foi possivel excluir o utente menor porque tem emprestimo(os) associado(os)!");
		} else {
			service.excluir(id);
			model.addAttribute("success", "Utente menor excluido com sucesso!");
		}
		return listar(model);
	}

	@ModelAttribute("instituicoes")
	public List<InstituicaoEnsino> listaInstituicoes() {
		return instiInfantilService.pesquisarTodasInstituicoesInfantis();
	}
	

	

}
