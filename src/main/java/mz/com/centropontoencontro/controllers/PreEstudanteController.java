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
import mz.com.centropontoencontro.domain.Estudante;
import mz.com.centropontoencontro.domain.PreEstudante;
import mz.com.centropontoencontro.service.CursoService;
import mz.com.centropontoencontro.service.EstudanteService;
import mz.com.centropontoencontro.service.PreEstudanteService;

@Controller
@RequestMapping("/preestudante")
public class PreEstudanteController {

	@Autowired
	private CursoService curService;

	@Autowired
	private PreEstudanteService service;

	@Autowired
	private EstudanteService serviceEstudante;

	@GetMapping("/cadastro")
	public String cadastrar(PreEstudante preEstudante) {
		return "curso/cadastro_preestudante";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("preestudantes", service.pesquisarTodos());

		return "curso/pesquisa_preestudante";
	}

	@PostMapping("/salvar")
	public String salvar(PreEstudante preEstudante, RedirectAttributes attr) {

		service.salvar(preEstudante);
		attr.addFlashAttribute("success", "Pré registo de estudante realizado com sucesso");
		return "redirect:/preestudante/cadastro";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("preEstudante", service.pesquisarPorID(id));
		return "curso/cadastro_preestudante";
	}

	@PostMapping("/editar")
	public String editar(@Valid PreEstudante preEstudante, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "curso/cadastro_preestudante";
		}
		service.editar(preEstudante);
		attr.addFlashAttribute("success", "Dados do pré-estudante foram editados com sucesso!");
		return "redirect:/preestudante/cadastro";
	}

	@GetMapping("/confirmar_estudante/{id}")
	public String preConfirmacao(@PathVariable("id") Long id, ModelMap model, PreEstudante preEstudante,
			Estudante estudante) {
		model.addAttribute("preEstudante", service.pesquisarPorID(id));
		return "curso/cadastro_estudanteconfirmacao";
	}

	@PostMapping("/confirmar_estudante")
	public String confirmacao(Estudante estudante, RedirectAttributes attr) {
		serviceEstudante.salvar(estudante);
		attr.addFlashAttribute("success", "Estudante confirmado no curso!");
		return "redirect:/estudante/listar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Pré-registo de estudante excluido com sucesso");
		return listar(model);
	}

	@ModelAttribute("cursos")
	public List<Curso> listaCursos() {
		return curService.pesquisarTodos();
	}

}
