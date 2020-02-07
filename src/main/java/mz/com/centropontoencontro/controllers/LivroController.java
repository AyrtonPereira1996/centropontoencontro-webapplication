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

import mz.com.centropontoencontro.domain.CategoriaLivro;
import mz.com.centropontoencontro.domain.Livro;
import mz.com.centropontoencontro.service.CategoriaLivroService;
import mz.com.centropontoencontro.service.LivroService;

@Controller
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	private LivroService service;
	
	@Autowired
	private CategoriaLivroService catLivroService;
	
	@GetMapping("/cadastro")
	public String cadastrar(Livro livro) {
		return "livro/cadastro_livro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("livros", service.pesquisarTodos());
		return "/livro/pesquisa_acervolivro";
	}
	
	@GetMapping("/listar_por_bibliotecario")
	public String listarByBibliotecario(ModelMap model) {
		model.addAttribute("livros", service.pesquisarTodos());
		return "/livro/pesquisa_acervolivro_por_bibliotecario";
	}
	
	@GetMapping("/listar_por_gestor")
	public String listarByGestor(ModelMap model) {
		model.addAttribute("livros", service.pesquisarTodos());
		return "/livro/pesquisa_acervolivro_por_gestor";
	}
	
	@GetMapping("/listar_numeropedidos")
	public String listarNumeroPedidos(ModelMap model) {
		model.addAttribute("livros", service.pesquisarTodos());
		return "/livro/pesquisa_acervolivro_quantidade";
	}
	
	@GetMapping("/listar_numeropedidos_por_gestor")
	public String listarNumeroPedidosByGestor(ModelMap model) {
		model.addAttribute("livros", service.pesquisarLivroNumeropedidos());
		return "/livro/pesquisa_acervolivro_quantidade_por_gestor";
	}
	

	@PostMapping("/salvar")
	public String salvar(@Valid Livro livro, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "livro/cadastro_livro";
		}
		service.salvar(livro);
		attr.addFlashAttribute("success", "Livro registado com sucesso!");
		return "redirect:/livro/cadastro";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("livro", service.pesquisarPorId(id));
		return "/livro/cadastro_livro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Livro livro, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "livro/cadastro_livro";
		}
		service.editar(livro);
		attr.addFlashAttribute("success", "Dados do livro editados com sucesso");
		return "redirect:/livro/cadastro";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if (service.livroTemEmprestimo(id)) {
			model.addAttribute("fail", "Não foi possivel excluir o livro porque tem emprestimo(s) associado(s)");
		} else if (service.livroTemDevolucoes(id)) {
			model.addAttribute("fail", "Não foi possivel excluit o livro porque tem devolução(ões) associado(s)");
		} else {
			service.excluir(id);
			model.addAttribute("success", "Livro excluido com sucesso");
		}
		return listar(model);
	}
	
	
	@ModelAttribute("categorias")
	public List<CategoriaLivro> listaCategoriasLivros(){
		return catLivroService.pesquisarTodos();
	}
	
	
}
