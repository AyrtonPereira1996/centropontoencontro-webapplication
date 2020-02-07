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
import mz.com.centropontoencontro.domain.LivroInfantil;
import mz.com.centropontoencontro.service.CategoriaLivroService;
import mz.com.centropontoencontro.service.LivroInfantilService;

@Controller
@RequestMapping("/livroinfantil")
public class LivroInfantilController {
	
	@Autowired
	private LivroInfantilService service;
	
	@Autowired
	private CategoriaLivroService serviceCatLivro;
	
	@GetMapping("/cadastro")
	public String cadastrar(LivroInfantil livInfantil) {
		return "livro/cadastro_livroinfantil";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("livros", service.pesquisarTodos());
		return "livro/pesquisa_acervolivroinfantil";
	}
	
	@GetMapping("/listar_por_bibliotecario")
	public String listarByBibliotecario(ModelMap model) {
		model.addAttribute("livros", service.pesquisarTodos());
		return "livro/pesquisa_acervolivroinfantil_por_bibliotecario";
	}
	
	@GetMapping("/listar_por_gestor")
	public String listarByGestor(ModelMap model) {
		model.addAttribute("livros", service.pesquisarTodos());
		return "livro/pesquisa_acervolivroinfantil_por_gestor";
	}
	
	@GetMapping("/listar_numeropedidos")
	public String listarNumeroPedidos(ModelMap model) {
		model.addAttribute("livros", service.pesquisarLivroNumeroPedidos());
		return "livro/pesquisa_acervolivroinfantil_quantidade";
	}
	
	@GetMapping("/listar_numeropedidos_gestor")
	public String listarNumeroPedidosByGestor(ModelMap model) {
		model.addAttribute("livros", service.pesquisarLivroNumeroPedidos());
		return "livro/pesquisa_acervolivroinfantil_quantidade_por_gestor";
	}
	
	
	
	@PostMapping("/salvar")
	public String salvar(@Valid LivroInfantil livroInfantil, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "livro/cadastro_livroinfantil";
		}
		service.salvar(livroInfantil);
		attr.addFlashAttribute("success", "Livro infantil registado com sucesso");
		return "redirect:/livroinfantil/cadastro";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("livroInfantil", service.pesquisarPorId(id));
		return "livro/cadastro_livroinfantil";
		
	}
	
	@PostMapping("/editar")
	public String editar(@Valid LivroInfantil livroInfantil, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "livro/cadastro_livroinfantil";
		}
		service.editar(livroInfantil);
		attr.addFlashAttribute("success", "Dados do livro infantil editados com sucesso!");
		return "redirect:/livroinfantil/cadastro";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if (service.livroTemDevolucoes(id)) {
			model.addAttribute("fail", "Não foi possivel excluir o livro infantil porque tem devolução(ões) associado(as)!");
		} else if (service.livroTemEmprestimos(id)) {
			model.addAttribute("fail", "Não foi possivel excluir o livro infantil porque tem emprestimo(os) associado(os)!");
		} else {
			service.excluir(id);
			model.addAttribute("success", "Livro excluido com sucesso!");
		}
		
		return listar(model);
	}
	
	
	@ModelAttribute("categorias")
	public List<CategoriaLivro> listaCategoriasLivro(){
		return serviceCatLivro.pesquisarTodos();
	}
	
	


}
