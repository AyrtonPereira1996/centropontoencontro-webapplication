package mz.com.centropontoencontro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.com.centropontoencontro.domain.Curso;
import mz.com.centropontoencontro.domain.Estudante;
import mz.com.centropontoencontro.domain.EstudanteAprovado;
import mz.com.centropontoencontro.domain.EstudanteDesistencia;
import mz.com.centropontoencontro.domain.EstudanteReprovado;
import mz.com.centropontoencontro.service.CursoService;
import mz.com.centropontoencontro.service.EstudanteAprovadoService;
import mz.com.centropontoencontro.service.EstudanteDesistenciaService;
import mz.com.centropontoencontro.service.EstudanteReprovadoService;
import mz.com.centropontoencontro.service.EstudanteService;

@Controller
@RequestMapping("/estudante")
public class EstudanteController {

	@Autowired
	private EstudanteService service;
	
	@Autowired
	private CursoService curService;
	
	@Autowired
	private EstudanteAprovadoService serviceAprovados;
	
	@Autowired
	private EstudanteReprovadoService serviceReprovados;
	
	@Autowired
	private EstudanteDesistenciaService serviceDesistencia;

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("estudantes", service.pesquisarTodos());
		return "curso/pesquisa_estudante";
	}
	
	@PostMapping("/salvar")
	public String salvar(Estudante estudante) {
		service.salvar(estudante);
		return "redirect:/estudante/listar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model, Estudante estudante) {
		model.addAttribute("estudante", service.pesquisarPorId(id));
		return "curso/cadastro_estudante";
	}
	
	@PostMapping("/editar")
	public String editar(Estudante estudante, RedirectAttributes attr) {
		service.editar(estudante);
		attr.addFlashAttribute("success", "Dados de estudante editados com sucesso!");
		return "redirect:/estudante/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Estudante excluido com sucesso");
		return listar(model);
	}
	
//	Verificar este metodo exclusao
	@GetMapping("/aprovar/{id}")
	public String preAprovacao(@PathVariable("id") Long id, ModelMap model, EstudanteAprovado estudanteAprovado) {
		model.addAttribute("estudante", service.pesquisarPorId(id));
		return  "curso/cadastro_estudanteaprovado";
		
	}
	
	@PostMapping("/aprovar")
	public String aprovar(EstudanteAprovado estudanteAprovado) {
		serviceAprovados.salvar(estudanteAprovado);
		return "redirect:/estudantesaprovacao/listar";
	}
	
	@GetMapping("/reprovar/{id}")
	public String preReprovar(@PathVariable("id") Long id, ModelMap model, EstudanteReprovado estudanteReprovado) {
		model.addAttribute("estudante", service.pesquisarPorId(id));
		return "curso/cadastro_estudantereprovado";
	}
	
	@PostMapping("/reprovar")
	public String reprovar(EstudanteReprovado estudanteReprovado) {
		serviceReprovados.salvar(estudanteReprovado);
		return "redirect:/estudantesreprovacao/listar";
	}
	
	@GetMapping("/desistencia/{id}")
	public String preDesistencia(@PathVariable ("id") Long id, EstudanteDesistencia estudanteDesistencia, ModelMap model) {
		model.addAttribute("estudante", service.pesquisarPorId(id));
		return "curso/cadastro_estudantedesistencia";
	}
	
	@PostMapping("/desistencia")
	public String desistencia(EstudanteDesistencia estudanteDesistencia) {
		serviceDesistencia.salvar(estudanteDesistencia);
		return "redirect:/estudantesdesistiram/listar";
	}
	
	@ModelAttribute("cursos")
	public List<Curso> listaCursos(){
		return curService.pesquisarTodos();
	}
	

}
