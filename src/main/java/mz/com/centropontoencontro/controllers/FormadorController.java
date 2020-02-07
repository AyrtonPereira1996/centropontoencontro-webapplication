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

import mz.com.centropontoencontro.domain.Formador;
import mz.com.centropontoencontro.service.FormadorService;

@Controller
@RequestMapping("/formador")
public class FormadorController {
	
	@Autowired
	private FormadorService service;
	
	@GetMapping("/cadastro")
	public String cadastrar(Formador formador) {
		return "formador/cadastro_formador";
	}
	
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("formadores", service.pesquisarTodos());
		return "formador/pesquisa_formador";
	}
	
	@GetMapping("/listar_por_gestor")
	public String listarByGestor(ModelMap model) {
		model.addAttribute("formadores", service.pesquisarTodos());
		return "formador/pesquisa_formador_por_gestor";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Formador formador, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "formador/cadastro_formador";
		}
		service.salvar(formador);
		attr.addFlashAttribute("success", "Formador registado com sucesso!");
		return ("redirect:/formador/cadastro");
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("formador", service.pesquisarPorId(id));
		return "formador/cadastro_formador";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Formador formador, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "curso/cadastro_formador";
		}
		service.editar(formador);
		attr.addFlashAttribute("success", "Dados de formador editados com sucesso!");
		return "redirect:/formador/cadastro";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if (service.formadorTemCurso(id)) {
			model.addAttribute("fail", "Não foi possivel excluir o formador porque está a leccionar curso(s)");
		} else {
			service.excluir(id);
			model.addAttribute("success", "Formador excluido com sucesso");
		}
		return listar(model);
	}

}
