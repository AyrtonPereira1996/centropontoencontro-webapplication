package mz.com.centropontoencontro.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import mz.com.centropontoencontro.service.CursoService;
import mz.com.centropontoencontro.service.DevolucaoInfantilService;
import mz.com.centropontoencontro.service.DevolucaoService;
import mz.com.centropontoencontro.service.EmprestimoInfantilService;
import mz.com.centropontoencontro.service.EmprestimoService;
import mz.com.centropontoencontro.service.FormadorLecionaService;
import mz.com.centropontoencontro.service.FormadorService;
import mz.com.centropontoencontro.service.InstituicaoEnsinoInfantilService;
import mz.com.centropontoencontro.service.InstituicaoEnsinoService;
import mz.com.centropontoencontro.service.LivroInfantilService;
import mz.com.centropontoencontro.service.LivroService;
import mz.com.centropontoencontro.service.UtenteMenorService;
import mz.com.centropontoencontro.service.UtenteService;




@Controller
@RequestMapping("/area")
public class HomeAreasController {
	
	@Autowired
	private UtenteService serviceUtente;
	
	@Autowired
	private UtenteMenorService serviceUtenteMenor;
	
	@Autowired
	private FormadorService serviceFormadores;
	
	@Autowired
	private LivroService serviceLivro;
	
	@Autowired
	private LivroInfantilService serviceLivroInfantil;
	
	@Autowired
	private CursoService serviceCurso;
	
	@Autowired
	private FormadorLecionaService serviceLecionando;
	
	@Autowired
	private EmprestimoService serviceEmprestimo;
	
	@Autowired
	private EmprestimoInfantilService serviceEmprestimoInfantil;
	
	@Autowired
	private DevolucaoInfantilService serviceDevolucaoInfantil;
	
	@Autowired
	private DevolucaoService serviceDevolucao;
	
	@Autowired
	private InstituicaoEnsinoService serviceInstituicao;
	
	@Autowired
	private InstituicaoEnsinoInfantilService  serviceInstituicaoInfantil;

	
	@GetMapping("/areainfantil")
	public String homeAreaBiblioInfantil(ModelMap model) {
		model.addAttribute("totalUtentesMenores", serviceUtenteMenor.obterTotalUtentesMenores());
		model.addAttribute("totalLivros", serviceLivroInfantil.obterTotalLivrosInfantis());
		model.addAttribute("totalEmprestimos", serviceEmprestimoInfantil.obterTotalEmprestimoInfantil());
		model.addAttribute("totalDevolucoes", serviceDevolucaoInfantil.obterTotalDevolucaoInfantil());
		model.addAttribute("totalInstituicoes", serviceInstituicaoInfantil.obterTotalInstituicaoEnsinoInfantil());
//		Long numero = serviceInstituicaoInfantil.obterTotalInstituicaoEnsinoInfantil();
//		System.out.println(numero);
		
		
		
		return "perfis/perfil_biblioInfantil";
	}
	
	@GetMapping("/area_biblioteca_ponto_encontro")
	public String homeAreaBiblioPontoEncontro(ModelMap model) {
		model.addAttribute("totalUtentes", serviceUtente.obterTotalUtentes());
		model.addAttribute("totalLivros", serviceLivro.obterTotalLivros());
		model.addAttribute("totalEmprestimo", serviceEmprestimo.obterTotalEmprestimo());
		model.addAttribute("totalDevolucao", serviceDevolucao.obterTotalDevolucao());
		model.addAttribute("totalInstituicao", serviceInstituicao.obterTotalInstituicaoEnsino());
//		Long numero = serviceInstituicao.obterTotalInstituicaoEnsino();
//		System.out.println(numero);
		
		return "perfis/perfil_bibliotecapontoencontro";
	}
	
	@GetMapping("/areacoordenador")
	public String homeCoodenador(ModelMap model) {
		model.addAttribute("totalUtentesMenores", serviceUtenteMenor.obterTotalUtentesMenores());
		model.addAttribute("totalUtentes", serviceUtente.obterTotalUtentes());	
		model.addAttribute("totalFormadores", serviceFormadores.obterTotalFormadores());
		model.addAttribute("totalLivros", serviceLivroInfantil.obterTotalLivrosInfantis() + serviceLivro.obterTotalLivros());
		model.addAttribute("totalCursos", serviceCurso.obterTotalCursos());
		model.addAttribute("totalLecionando", serviceLecionando.obterTotalFormadoresLecionando());
//		Long numero = serviceLecionando.obterTotalFormadoresLecionando();
//		System.out.println(numero);
		return "perfis/perfil_coordenador";
	}
	
	@GetMapping("/areagestor")
	public String homeGestor(ModelMap model) {
		model.addAttribute("totalUtentesMenores", serviceUtenteMenor.obterTotalUtentesMenores());
		model.addAttribute("totalUtentes", serviceUtente.obterTotalUtentes());	
		model.addAttribute("totalFormadores", serviceFormadores.obterTotalFormadores());
		model.addAttribute("totalLivros", serviceLivroInfantil.obterTotalLivrosInfantis() + serviceLivro.obterTotalLivros());
		model.addAttribute("totalCursos", serviceCurso.obterTotalCursos());
		model.addAttribute("totalLecionando", serviceLecionando.obterTotalFormadoresLecionando());
		return "perfis/perfil_gestor";
	}
	
	@GetMapping("/verificaousuario")
	public String verificaoUsuario(@AuthenticationPrincipal User user) {
		if (user.getAuthorities().contains(new SimpleGrantedAuthority("GESTOR"))) {
			return "redirect:/area/areagestor";
		} else if (user.getAuthorities().contains(new SimpleGrantedAuthority("COORDENADOR"))) {
			return "redirect:/area/areacoordenador";
		} else if(user.getAuthorities().contains(new SimpleGrantedAuthority("BIBLIOTECARIO"))) {
			return "redirect:/area/area_biblioteca_ponto_encontro";
		} else if(user.getAuthorities().contains(new SimpleGrantedAuthority("BIBLIOTECARIOINFANTIL"))) {
			return "redirect:/area/areainfantil";
		} else {
			return "/login";
		}

	}

}
