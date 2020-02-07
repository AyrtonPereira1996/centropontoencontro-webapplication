package mz.com.centropontoencontro.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.com.centropontoencontro.domain.Usuario;
import mz.com.centropontoencontro.service.UsuarioServiceCRUD;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServiceCRUD service;

	@GetMapping("/cadastro")
	public String cadastrar(Usuario usuario) {
		return "usuario/cadastro_usuario_por_coordenador";
	}

	@GetMapping("/cadastro_por_gestor")
	public String cadastrarByGestor(Usuario usuario) {
		return "usuario/cadastro_usuario";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "usuario/cadastro_usuario_por_coordenador";
		}
		service.salvar(usuario);
		attr.addFlashAttribute("success", "Usuário registado com sucesso!");
		return "redirect:/usuario/cadastro";
	}

	@PostMapping("/salvar_por_gestor")
	public String salvarByGestor(@Valid Usuario usuario, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "usuario/cadastro_usuario";
		}
		service.salvar(usuario);
		attr.addFlashAttribute("success", "Usuário registado com sucesso!");
		return "redirect:/usuario/cadastro_por_gestor";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("usuarios", service.pesquisarTodos());
		return "usuario/pesquisa_usuarios";
	}
	
	@GetMapping("/listar_por_gestor")
	public String listarByGestor(ModelMap model) {
		model.addAttribute("usuarios", service.pesquisarTodos());
		return "usuario/pesquisa_usuarios_por_gestor";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("usuario", service.pesquisarPorId(id));
		return "usuario/cadastro_usuario_por_coordenador";
	}
	
	@GetMapping("/editar_por_gestor/{id}")
	public String preEditarByGestor(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("usuario", service.pesquisarPorId(id));
		return "usuario/cadastro_usuario";
	}
	
	@PostMapping("/editar")
	public String editar(Usuario usuario, RedirectAttributes attr) {
		service.editar(usuario);
		attr.addFlashAttribute("success", "Usuário editado com sucesso!");
		return "redirect:/usuario/listar";
	}
	
	@PostMapping("/editar_por_gestor")
	public String editarByGestor(Usuario usuario, RedirectAttributes attr) {
		service.editar(usuario);
		attr.addFlashAttribute("success", "Usuário editado com sucesso!");
		return "redirect:/usuario/listar_por_gestor";
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

}
