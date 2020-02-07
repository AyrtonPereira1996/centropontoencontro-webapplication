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

import mz.com.centropontoencontro.domain.CategoriaLivro;
import mz.com.centropontoencontro.service.CategoriaLivroService;

@Controller
@RequestMapping("/categorialivro")
public class CategoriaLivroController {

	@Autowired
	private CategoriaLivroService service;

	@GetMapping("/cadastro")
	public String cadastrar(CategoriaLivro categorialivro) {
		return "livro/cadastro_catlivro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("categorias", service.pesquisarTodos());
		return "livro/pesquisa_categorialivro";
	}

	@GetMapping("/listar_por_bibliotecario")
	public String listarByBibliotecario(ModelMap model) {
		model.addAttribute("categorias", service.pesquisarTodos());
		return "livro/pesquisa_categorialivro_por_bibliotecario";
	}
	
	@GetMapping("/listar_por_gestor")
	public String listarByGestor(ModelMap model) {
		model.addAttribute("categorias", service.pesquisarTodos());
		return "livro/pesquisa_categorialivro_por_gestor";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid CategoriaLivro categorialivro, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "livro/cadastro_catlivro";
		}
		
			service.salvar(categorialivro);
			attr.addFlashAttribute("success", "Categoria de livro registada com sucesso!");
			return "redirect:/categorialivro/cadastro";
		
		
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {

		model.addAttribute("categoriaLivro", service.pesquisarPorId(id));
		return "livro/cadastro_catlivro";
	}

	@PostMapping("/editar")
	public String editar(@Valid CategoriaLivro catLivro, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "livro/cadastro_catlivro";
		}
		System.out.println("id = " + catLivro.getId());
		service.editar(catLivro);
		attr.addFlashAttribute("success", "Dados de categoria de livro editados com sucesso!");
		return "redirect:/categorialivro/cadastro";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if (service.categoriaTemLivro(id)) {
			model.addAttribute("fail", "Não foi possivel excluir a categoria de livro porque tem livro(s) associado(s) a ele.");
		} else if (service.categoriaInfantilTemLivro(id)) {
			model.addAttribute("fail", "Não foi possivel excluir a categoria de livro infantil porque tem livro(s) infantis associado(s) a ele.");
		} else {
		service.excluir(id);
		model.addAttribute("success", "Categoria de livro excluida com sucesso!");}
		return listar(model);
	}

}
