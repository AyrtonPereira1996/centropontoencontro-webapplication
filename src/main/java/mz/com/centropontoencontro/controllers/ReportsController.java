package mz.com.centropontoencontro.controllers;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.com.centropontoencontro.service.ReportsService;
import net.sf.jasperreports.engine.JRException;

@Controller
public class ReportsController {
	
	@Autowired
	private ReportsService service;
	
	@GetMapping("/obterutentes_report/{formato}")
	public String getUtenteReport(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException {
		service.getReportUtente(formato);
		String path =service.getReportUtente(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relátorio guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/utente/listar";
	}
	
	@GetMapping("/obterutentes_report_gestor/{formato}")
	public String getUtenteReportByGestor(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException {
		service.getReportUtente(formato);
		String path = service.getReportUtente(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relátorio guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/utente/listar_por_gestor";
	}
	
	@GetMapping("/obterutentes_frequentes_report/{formato}")
	public String getUtenteMaisFrequentesReport(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException {
		service.getReportUtenteMaisFrequentes(formato);
		String path = service.getReportUtenteMaisFrequentes(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relátorio guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/utente/listar_numeroemprestimos";
		
	}
	
	@GetMapping("/obterutentes_frequentes_report_gestor/{formato}")
	public String getUtenteMaisFrequentesReportByGestor(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException {
		service.getReportUtenteMaisFrequentes(formato);
		String path = service.getReportUtenteMaisFrequentes(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relátorio guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/utente/listar_numeroemprestimos_por_gestor";
	}
	
	@GetMapping("/obterutentesmenores_report/{formato}")
	public String getUtenteMenorReport(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException {
		service.getReportUtenteMenor(formato);
		String path =service.getReportUtenteMenor(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relátorio guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/utentemenor/listar";
	}
	
	@GetMapping("/obterutentesmenores_report_gestor/{formato}")
	public String getUtenteMenorReportByGestor(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException {
		service.getReportUtenteMenor(formato);
		String path =service.getReportUtenteMenor(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relátorio guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/utentemenor/listar_por_gestor";
	}
	
	@GetMapping("/obterutentesmenores_frequentes_report/{formato}")
	public String getUtenteMenoresMaisFrequentesReport(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException {
		service.getReportUtenteMenorMaisFrequentes(formato);
		String path = service.getReportUtenteMenorMaisFrequentes(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relátorio guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/utentemenor/listar_numeroemprestimos";
		
	}
	
	@GetMapping("/obterutentesmenores_frequentes_report_gestor/{formato}")
	public String getUtenteMenoresMaisFrequentesReportByGestor(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException {
		service.getReportUtenteMenorMaisFrequentes(formato);
		String path = service.getReportUtenteMenorMaisFrequentes(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relátorio guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/utentemenor/listar_numeroemprestimos_por_gestor";
		
	}
	
	@GetMapping("/obterinstituicoesensino_report/{formato}")
	public String getInstituicoesEnsinoReport(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException {
		service.getReportInstituicaoEnsino(formato);
		String path = service.getReportInstituicaoEnsino(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relátorio guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/instituicaoensino/listar_instituicaoensino";
		
	}
	
	@GetMapping("/obterinstituicoesensino_report_gestor/{formato}")
	public String getInstituicoesEnsinoReportByGestor(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException {
		service.getReportInstituicaoEnsino(formato);
		String path = service.getReportInstituicaoEnsino(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relátorio guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/instituicaoensino/listar_instituicaoensino_por_gestor";
		
	}
	

	@GetMapping("/obterescolas_report/{formato}")
	public String getEscolasReport(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException {
		service.getReportInstituicaoEnsino(formato);
		String path = service.getReportEscola(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relátorio guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/instituicaoensinoinfantil/listar";
		
	}
	
	@GetMapping("/obterescolas_report_gestor/{formato}")
	public String getEscolasReportByGestor(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException {
		service.getReportInstituicaoEnsino(formato);
		String path = service.getReportEscola(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relátorio guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/instituicaoensinoinfantil/listar_por_gestor";
		
	}
	
	@GetMapping("/obtercategorialivros_report/{formato}")
	public String getCategoriasLivrosReport(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException {
		service.getReportCategoriaLivros(formato);
		String path = service.getReportCategoriaLivros(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relatório guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/categorialivro/listar";
	}
	
	@GetMapping("/obtercategorialivros_report_gestor/{formato}")
	public String getCategoriasLivrosReportGestor(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException {
		service.getReportCategoriaLivros(formato);
		String path = service.getReportCategoriaLivros(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relatório guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/categorialivro/listar_por_gestor";
	}
	
	@GetMapping("/obterlivros_report/{formato}")
	public String getLivrosReport(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException{
		service.getReportLivros(formato);
		String path = service.getReportLivros(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relatório guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/livro/listar";
	}
	
	@GetMapping("/obterlivros_report_gestor/{formato}")
	public String getLivrosReportByGestor(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException{
		service.getReportLivros(formato);
		String path = service.getReportLivros(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relatório guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/livro/listar_por_gestor";
	}
	
	@GetMapping("/obterlivros_frequentes_report/{formato}")
	public String getLivrosFrequentesReport(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException{
		service.getReportLivrosMaisFrequentes(formato);
		String path = service.getReportLivrosMaisFrequentes(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relatório guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/livro/listar_numeropedidos";
	}
	
	@GetMapping("/obterlivros_frequentes_report_gestor/{formato}")
	public String getLivrosFrequentesReportByGestor(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException{
		service.getReportLivrosMaisFrequentes(formato);
		String path = service.getReportLivrosMaisFrequentes(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relatório guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/livro/listar_numeropedidos_por_gestor";
	}
	
	@GetMapping("/obterlivrosinfantis_report/{formato}")
	public String getLivrosInfantisReport(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException{
		service.getReportLivrosInfantis(formato);
		String path = service.getReportLivrosInfantis(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relatório guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/livroinfantil/listar";
	}
	
	@GetMapping("/obterlivrosinfantis_report_gestor/{formato}")
	public String getLivrosInfantisReportByGestor(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException{
		service.getReportLivrosInfantis(formato);
		String path = service.getReportLivrosInfantis(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relatório guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/livroinfantil/listar_por_gestor";
	}
	
	@GetMapping("/obterlivrosinfantis_frequentes_report/{formato}")
	public String getLivrosInfantisFrequentesReport(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException{
		service.getReportLivrosInfantisMaisFrequentes(formato);
		String path = service.getReportLivrosInfantisMaisFrequentes(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relatório guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/livroinfantil/listar_numeropedidos";
	}
	
	@GetMapping("/obterlivrosinfantis_frequentes_report_gestor/{formato}")
	public String getLivrosInfantisFrequentesReportByGestor(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException{
		service.getReportLivrosInfantisMaisFrequentes(formato);
		String path = service.getReportLivrosInfantisMaisFrequentes(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relatório guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/livroinfantil/listar_numeropedidos_gestor";
	}
	
	@GetMapping("/obterpreestudantes_report/{formato}")
	public String getPreEstudantesReport(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException {
		service.getReportPreEstudantes(formato);
		String path = service.getReportPreEstudantes(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relatório guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/preestudante/listar";
	}
	
	@GetMapping("/obterformadores_report/{formato}")
	public String getFormadoresReport(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException {
		service.getReportFormador(formato);
		String path = service.getReportFormador(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relatório guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/formador/listar";
	}
	
	@GetMapping("/obterformadores_report_gestor/{formato}")
	public String getFormadoresReportByGestor(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException {
		service.getReportFormador(formato);
		String path = service.getReportFormador(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relatório guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/formador/listar_por_gestor";
	}
	
	@GetMapping("/obterformadoreslecionam_report/{formato}")
	public String getFormadoresLecionamReport(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException{
		service.getReportFormadoresLecionam(formato);
		String path= service.getReportFormadoresLecionam(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relatório guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/formadorleciona/listar";
		
	}
	
	@GetMapping("/obterformadoreslecionam_report_gestor/{formato}")
	public String getFormadoresLecionamReportByGestor(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException{
		service.getReportFormadoresLecionam(formato);
		String path= service.getReportFormadoresLecionam(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relatório guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/formadorleciona/listar_por_gestor";
		
	}
	
	@GetMapping("/obtercursos_report/{formato}")
	public String getCursosReport(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException {
		service.getReportCursos(formato);
		String path = service.getReportCursos(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relatório guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/curso/listar";
	}
	
	@GetMapping("/obtercursos_report_gestor/{formato}")
	public String getCursosReportByGestor(@PathVariable("formato") String formato, RedirectAttributes attr) throws FileNotFoundException, JRException {
		service.getReportCursos(formato);
		String path = service.getReportCursos(formato);
		StringBuilder builder = new StringBuilder();
		builder.append("Arquivo de relatório guardado em " + path);
		attr.addFlashAttribute("success", builder.toString());
		return "redirect:/curso/listar_por_gestor";
	}
	

}
