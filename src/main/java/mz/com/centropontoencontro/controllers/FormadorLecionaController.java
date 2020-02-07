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

import mz.com.centropontoencontro.domain.Curso;
import mz.com.centropontoencontro.domain.Formador;
import mz.com.centropontoencontro.domain.FormadorLeciona;
import mz.com.centropontoencontro.service.CursoService;
import mz.com.centropontoencontro.service.FormadorLecionaService;
import mz.com.centropontoencontro.service.FormadorService;

@Controller
@RequestMapping("/formadorleciona")
public class FormadorLecionaController {
	
	@Autowired
	private FormadorLecionaService service;
	
	@Autowired
	private FormadorService forService;
	
	@Autowired
	private CursoService curService;
	
	@GetMapping("/cadastro")
	public String cadastar(FormadorLeciona formadorLeciona) {
		return "curso/cadastro_cursolecionado";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("formadores", service.pesquisarTodos());
		return "curso/pesquisa_cursolecionado";
	}
	
	@GetMapping("/listar_por_gestor")
	public String listarByGestor(ModelMap model) {
		model.addAttribute("formadores", service.pesquisarTodos());
		return "curso/pesquisa_cursolecionado_por_gestor";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid FormadorLeciona formadorLeciona, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "curso/cadastro_cursolecionado";
		}
		service.salvar(formadorLeciona);
		attr.addFlashAttribute("success", "Associou-se um formador a um curso! Ação realizada com sucesso.");
		return "redirect:/formadorleciona/cadastro";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("formadorLeciona", service.pesquisarPorId(id));
		return "curso/cadastro_cursolecionado";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid FormadorLeciona formadorLeciona, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "curso/cadastro_cursolecionado";
		}
		service.editar(formadorLeciona);
		attr.addFlashAttribute("success", "Dados de formador que leciona curso editado com sucesso!");
		return "redirect:/formadorleciona/cadastro";
	}
	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Associação entre o formador que leciona e curso a ser lecionado excluido com sucesso!");
		return listar(model);
	}
	
	
	@ModelAttribute("cursos")
	public List<Curso> listaCursos(){
		return curService.pesquisarTodos();
	}
	
	@ModelAttribute("formadores")
	public List<Formador> listaFormadores(){
		return forService.pesquisarTodos();
	}
	

}
