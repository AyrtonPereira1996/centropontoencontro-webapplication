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

import mz.com.centropontoencontro.domain.Curso;
import mz.com.centropontoencontro.service.CursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private CursoService service;
	
	@GetMapping("/cadastro")
	public String cadastrar(Curso curso) {
		return "curso/cadastro_curso";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cursos", service.pesquisarTodos());
		return "curso/pesquisa_curso";
	}
	
	@GetMapping("/listar_por_gestor")
	public String listarByGestor(ModelMap model) {
		model.addAttribute("cursos", service.pesquisarTodos());
		return "curso/pesquisa_curso_por_gestor";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Curso curso, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "curso/cadastro_curso";
		}
		service.salvar(curso);
		attr.addFlashAttribute("success", "Curso registado com sucesso!");
		return "redirect:/curso/cadastro";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("curso", service.pesquisarPorId(id));
		return "curso/cadastro_curso";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Curso curso, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "curso/cadastro_curso";
		}
		service.editar(curso);
		attr.addFlashAttribute("success", "Dados de curso editados com sucesso!");
		return "redirect:/curso/cadastro";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		System.out.println("Chegou aqui");
		if (service.cursoTemEstudantes(id)) {
			
			model.addAttribute("fail", "Não foi possivel excluir o curso porque tem estudante(s) a frequentar o curso!");
		} else if (service.cursoTemFormador(id)) {
			model.addAttribute("fail", "Não foi possivel excluir o curso porque está a ser lecionado!");
		} else if (service.cursoTemPreEstudantes(id)) {
			model.addAttribute("fail", "Não foi possivel excluir o curso porque tem estudante(s) que querem frequentar o curso!");
		} else if (service.cursoTemEstudantes(id) && service.cursoTemFormador(id)) {
			model.addAttribute("fail", "Não foi possivel excluir o curso porque está a ser lecionado e tem estudante(s) a frequentar o curso!");
		}else if(service.cursoTemPreEstudantes(id) && service.cursoTemFormador(id)) {
			model.addAttribute("fail", "Não foi possivel excluir o curso porque está a ser lecionado e tem estudante(s) que querem frequentar o curso!");
		}else {
			service.excluir(id);
			model.addAttribute("success", "Curso excluido com sucesso!");
		}
		return listar(model);
	}

}
