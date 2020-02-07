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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.com.centropontoencontro.domain.Emprestimo;
import mz.com.centropontoencontro.service.EmprestimoService;
import mz.com.centropontoencontro.service.UtenteService;

@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {

	@Autowired
	private EmprestimoService service;

	@Autowired
	private UtenteService serviceUt;

	@GetMapping("/cadastro")
	public String cadastrar(Emprestimo emprestimo) {
		return "emprestimo/cadastro_emprestimo";
	}

	@GetMapping("/cadastro_por_bibliotecario")
	public String cadastrarByBibliotecario(Emprestimo emprestimo) {
		return "emprestimo/cadastro_emprestimo_por_bibliotecario";
	}

	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("emprestimo/pesquisa_emprestimo");
		mv.addObject("emprestimos", service.pesquisarTodosDesc());

//model.addAttribute("emprestimos", service.pesquisarTodosDesc());
//		List<Emprestimo> lista = new ArrayList<Emprestimo>();
//		lista= service.pesquisarTodosDesc();
//		
//		for (Emprestimo emprestimo : lista) {
//			System.out.println(emprestimo.toString());
//		}
		return mv;
		

	}

	@GetMapping("/listar_por_bibliotecario")
	public ModelAndView listarByBibliotecario(ModelMap model) {
		model.addAttribute("emprestimos", service.pesquisarTodosDesc());
		return new ModelAndView("emprestimo/pesquisa_emprestimo_por_bibliotecario", model);
	}

	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid Emprestimo emprestimo, BindingResult result, RedirectAttributes attr) {
		ModelAndView mv = new ModelAndView("redirect:/emprestimo/listar");
		if(result.hasErrors()) {
			return new ModelAndView("emprestimo/cadastro_emprestimo");
			
		}
		
		if (serviceUt.UtentePermitido(emprestimo.getUtenteEmprestimo().getId())) {
			service.salvar(emprestimo);
			attr.addFlashAttribute("success", "Emprestimo registado com sucesso!");
		} else {
			attr.addFlashAttribute("fail",
					"Não foi possível realizar o emprestimo. Este utente está interdito de solicitar empréstimos!");
		}

		return mv;
	}

	@PostMapping("/salvar_por_bibliotecario")
	public ModelAndView salvarByBibliotecario(@Valid Emprestimo emprestimo, BindingResult result, RedirectAttributes attr) {
		ModelAndView mv = new ModelAndView("redirect:/emprestimo/listar_por_bibliotecario");
		if (result.hasErrors()) {
			return new ModelAndView("emprestimo/cadastro_emprestimo_por_bibliotecario");
		}

		if (serviceUt.UtentePermitido(emprestimo.getUtenteEmprestimo().getId())) {
			service.salvar(emprestimo);
			attr.addFlashAttribute("success", "Emprestimo registado com sucesso!");
		} else {
			attr.addFlashAttribute("fail",
					"Não foi possível realizar o emprestimo. Este utente está interdito de solicitar empréstimos!");
		}

		return mv;
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("emprestimo", service.pesquisarPorId(id));
		return "emprestimo/cadastro_emprestimo";
	}

	@PostMapping("/editar")
	public String editar(@Valid Emprestimo emprestimo, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "emprestimo/cadastro_emprestimo";
		}
		service.editar(emprestimo);
		attr.addFlashAttribute("success", "Dados do emprestimo editados com sucesso!");
		return "redirect:/emprestimo/cadastro";
	}

	@GetMapping("/editar_por_bibliotecario/{id}")
	public String preEditarByBibliotecario(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("emprestimo", service.pesquisarPorId(id));
		return "emprestimo/cadastro_emprestimo_por_bibliotecario";
	}

	@PostMapping("/editar_por_bibliotecario")
	public String editarByBiblioteca(@Valid Emprestimo emprestimo, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "emprestimo/cadastro_emprestimo_por_bibliotecario";
		}
		service.editar(emprestimo);
		attr.addFlashAttribute("success", "Dados do emprestimo editados com sucesso!");
		return "redirect:/emprestimo/cadastro_por_bibliotecario";
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		ModelAndView mv = new ModelAndView("redirect:/emprestimo/listar");
		service.excluir(id);
		attr.addFlashAttribute("success", "Devolução realizada com sucesso!");
		return mv;
	}

	@GetMapping("/excluirporbibliotecario/{id}")
	public ModelAndView excluirByBibliotecario(@PathVariable("id") Long id, RedirectAttributes attr) {
		ModelAndView mv = new ModelAndView("redirect:/emprestimo/listar_por_bibliotecario");
		service.excluir(id);
		attr.addFlashAttribute("success", "Devolução realizada com sucesso!");
		return mv;
	}

}
