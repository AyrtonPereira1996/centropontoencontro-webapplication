package mz.com.centropontoencontro.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;

import mz.com.centropontoencontro.dao.CategoriaLivroDAO;
import mz.com.centropontoencontro.dao.CursoDAO;
import mz.com.centropontoencontro.dao.FormadorDAO;
import mz.com.centropontoencontro.dao.FormadorLecionaDAO;
import mz.com.centropontoencontro.dao.InstituicaoEnsinoDAO;
import mz.com.centropontoencontro.dao.LivroDAO;
import mz.com.centropontoencontro.dao.LivroInfantilDAO;
import mz.com.centropontoencontro.dao.PreEstudanteDAO;
import mz.com.centropontoencontro.dao.UtenteDAOImpl;
import mz.com.centropontoencontro.dao.UtenteMenorDAOImpl;
import mz.com.centropontoencontro.domain.CategoriaLivro;
import mz.com.centropontoencontro.domain.Curso;
import mz.com.centropontoencontro.domain.Formador;
import mz.com.centropontoencontro.domain.FormadorLeciona;
import mz.com.centropontoencontro.domain.InstituicaoEnsino;
import mz.com.centropontoencontro.domain.Livro;
import mz.com.centropontoencontro.domain.LivroInfantil;
import mz.com.centropontoencontro.domain.PreEstudante;
import mz.com.centropontoencontro.domain.Utente;
import mz.com.centropontoencontro.domain.UtenteMenor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Service
public class ReportsServiceImpl implements ReportsService {

	@Autowired
	private UtenteDAOImpl daoutente;
	
	@Autowired
	private UtenteMenorDAOImpl daoUtenteMenor;
	
	@Autowired
	private InstituicaoEnsinoDAO daoInstituicaoEnsino;
	
	@Autowired
	private CategoriaLivroDAO daoCategoria;

	@Autowired
	private LivroInfantilDAO daoLivroInfantil;
	
	@Autowired
	private LivroDAO daoLivro;
	
	@Autowired
	private PreEstudanteDAO daoPreEstudante;
	
	@Autowired
	private FormadorLecionaDAO daoFormadorLeciona;
	
	@Autowired
	private FormadorDAO daoFormador;
	
	@Autowired
	private CursoDAO daoCurso;
	
	private LocalDate dataActual;
	
	
	private LocalTime horaActual;

	@Override
	public String getReportUtente(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\Ayrton Pereira\\Downloads\\Reports";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'%'hh'horas'mm'min'");
		LocalDateTime dataHora = LocalDateTime.now();
		String data = formatter.format(dataHora);
		
		List<Utente> listaUtentes= daoutente.findAll();
		//carregar o arquivo jasper e compilar
		File file = ResourceUtils.getFile("classpath:reports/utentes_report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaUtentes, false);
		Map<String, Object> parameters= new HashMap<>();
		parameters.put("criadopor", "Centro Ponto de Encontro");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
	
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\relatorioUtentes" + data + ".pdf");
		}	
		return path;
	}

	@Override
	public String getReportUtenteMaisFrequentes(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\Ayrton Pereira\\Downloads\\Reports";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'%'hh'horas'mm'min'");
		LocalDateTime dataHora = LocalDateTime.now();
		String data = formatter.format(dataHora);
		
		List<Utente> listaUtentes = daoutente.findAll();
		File file = ResourceUtils.getFile("classpath:reports/utentesmaisfrequentes_report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaUtentes, false);
		Map<String, Object> parameters= new HashMap<>();
		parameters.put("criadopor", "Centro Ponto de Encontro");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\relatorioUtentesMaisFrequentes" + data + ".pdf");
		}
		return path;
	}

	@Override
	public String getReportUtenteMenor(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\Ayrton Pereira\\Downloads\\Reports";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'%'hh'horas'mm'min'");
		LocalDateTime dataHora = LocalDateTime.now();
		String data = formatter.format(dataHora);
		
		List<UtenteMenor> listaUtentes = daoUtenteMenor.findAll();
		File file = ResourceUtils.getFile("classpath:reports/utentemenor_report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaUtentes, false);
		Map<String, Object> parameters= new HashMap<>();
		parameters.put("criadopor", "Centro Ponto de Encontro");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\relatorioUtentesMenores" + data + ".pdf");
		}	
		return path;
	}

	@Override
	public String getReportUtenteMenorMaisFrequentes(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\Ayrton Pereira\\Downloads\\Reports";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'%'hh'horas'mm'min'");
		LocalDateTime dataHora = LocalDateTime.now();
		String data = formatter.format(dataHora);
		
		List<UtenteMenor> listaUtentes = daoUtenteMenor.findAll();
		File file = ResourceUtils.getFile("classpath:reports/utentemenormaisfrequentes_report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaUtentes, false);
		Map<String, Object> parameters= new HashMap<>();
		parameters.put("criadopor", "Centro Ponto de Encontro");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\relatorioUtentesMenoresMaisFrequentes" + data + ".pdf");
		}
		return path;
	}

	@Override
	public String getReportInstituicaoEnsino(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\Ayrton Pereira\\Downloads\\Reports";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'%'hh'horas'mm'min'");
		LocalDateTime dataHora = LocalDateTime.now();
		String data = formatter.format(dataHora);
		
		List<InstituicaoEnsino> listaInstituicao = daoInstituicaoEnsino.FindAllInstituicaoEnsino();
		File file = ResourceUtils.getFile("classpath:reports/instituicoesensino_report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaInstituicao, false);
		Map<String, Object> parameters= new HashMap<>();
		parameters.put("criadopor", "Centro Ponto de Encontro");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\relatorioInstituicaoEnsino" + data + ".pdf");
		}
		return path;
	}

	@Override
	public String getReportEscola(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\Ayrton Pereira\\Downloads\\Reports";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'%'hh'horas'mm'min'");
		LocalDateTime dataHora = LocalDateTime.now();
		String data = formatter.format(dataHora);
		
		List<InstituicaoEnsino> listaEscola = daoInstituicaoEnsino.findAllInstituicaoEnsinoInfantil();
		File file = ResourceUtils.getFile("classpath:reports/escolas_report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaEscola, false);
		Map<String, Object> parameters= new HashMap<>();
		parameters.put("criadopor", "Centro Ponto de Encontro");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\relatorioEscolas" + data + ".pdf");
		}	
		return path;
	}

	@Override
	public String getReportCategoriaLivros(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\Ayrton Pereira\\Downloads\\Reports";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'%'hh'horas'mm'min'");
		LocalDateTime dataHora = LocalDateTime.now();
		String data = formatter.format(dataHora);
		
		List<CategoriaLivro> listaCategorias = daoCategoria.findAll();
		File file = ResourceUtils.getFile("classpath:reports/categoriaslivro_report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaCategorias, false);
		Map<String, Object> parameters= new HashMap<>();
		parameters.put("criadopor", "Centro Ponto de Encontro");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\relatorioCategoriaLivros" + data + ".pdf");
		}
		return path;
	}

	@Override
	public String getReportLivrosMaisFrequentes(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\Ayrton Pereira\\Downloads\\Reports";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'%'hh'horas'mm'min'");
		LocalDateTime dataHora = LocalDateTime.now();
		String data = formatter.format(dataHora);
		
		List<Livro> listaLivros = daoLivro.findAll();
		File file = ResourceUtils.getFile("classpath:reports/acervolivrosmaisfrequentes_report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaLivros, false);
		Map<String, Object> parameters= new HashMap<>();
		parameters.put("criadopor", "Centro Ponto de Encontro");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\relatorioLivrosFrequentes" + data + ".pdf");
		}
		return path;
	}

	@Override
	public String getReportLivrosInfantisMaisFrequentes(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\Ayrton Pereira\\Downloads\\Reports";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'%'hh'horas'mm'min'");
		LocalDateTime dataHora = LocalDateTime.now();
		String data = formatter.format(dataHora);
		
		List<LivroInfantil> listaLivrosInfantis = daoLivroInfantil.findAll();
		File file = ResourceUtils.getFile("classpath:reports/acervolivrosmaisfrequentes_report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaLivrosInfantis, false);
		Map<String, Object> parameters= new HashMap<>();
		parameters.put("criadopor", "Centro Ponto de Encontro");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\relatorioLivrosInfantisFrequentes" + data + ".pdf");
		}
		return path;
		
	}

	@Override
	public String getReportLivros(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\Ayrton Pereira\\Downloads\\Reports";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'%'hh'horas'mm'min'");
		LocalDateTime dataHora = LocalDateTime.now();
		String data = formatter.format(dataHora);
		
		List<Livro> listaLivros = daoLivro.findAll();
		File file = ResourceUtils.getFile("classpath:reports/acervolivros_report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaLivros, false);
		Map<String, Object> parameters= new HashMap<>();
		parameters.put("criadopor", "Centro Ponto de Encontro");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\relatorioLivros" + data + ".pdf");
		}
		return path;
	}

	@Override
	public String getReportLivrosInfantis(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\Ayrton Pereira\\Downloads\\Reports";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'%'hh'horas'mm'min'");
		LocalDateTime dataHora = LocalDateTime.now();
		String data = formatter.format(dataHora);
		
		List<LivroInfantil> listaLivrosInfantis = daoLivroInfantil.findAll();
		File file = ResourceUtils.getFile("classpath:reports/acervolivroinfantil_report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaLivrosInfantis, false);
		Map<String, Object> parameters= new HashMap<>();
		parameters.put("criadopor", "Centro Ponto de Encontro");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\relatorioLivrosInfantis" + data + ".pdf");
		}
		return path;
		
	}

	@Override
	public String getReportPreEstudantes(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\Ayrton Pereira\\Downloads\\Reports";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'%'hh'horas'mm'min'");
		LocalDateTime dataHora = LocalDateTime.now();
		String data = formatter.format(dataHora);
		
		List<PreEstudante> listaPreEstudantes = daoPreEstudante.findAll();
		File file = ResourceUtils.getFile("classpath:reports/pre-estudantes_report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaPreEstudantes, false);
		Map<String, Object> parameters= new HashMap<>();
		parameters.put("criadopor", "Centro Ponto de Encontro");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\relatorioPreEstudantes" + data + ".pdf");
		}
		return path;
	}

	@Override
	public String getReportFormadoresLecionam(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\Ayrton Pereira\\Downloads\\Reports";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'%'hh'horas'mm'min'");
		LocalDateTime dataHora = LocalDateTime.now();
		String data = formatter.format(dataHora);
		
		List<FormadorLeciona> listaFormadoresLecionam = daoFormadorLeciona.findAll();
		File file = ResourceUtils.getFile("classpath:reports/formadoreslecionam_report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaFormadoresLecionam, false);
		Map<String, Object> parameters= new HashMap<>();
		parameters.put("criadopor", "Centro Ponto de Encontro");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\relatorioFormadoresLecionam" + data + ".pdf");
		}
		return path;
	}

	@Override
	public String getReportFormador(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\Ayrton Pereira\\Downloads\\Reports";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'%'hh'horas'mm'min'");
		LocalDateTime dataHora = LocalDateTime.now();
		String data = formatter.format(dataHora);
		
		List<Formador> listaFormadores = daoFormador.findAll();
		File file = ResourceUtils.getFile("classpath:reports/formadores_report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaFormadores, false);
		Map<String, Object> parameters= new HashMap<>();
		parameters.put("criadopor", "Centro Ponto de Encontro");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\relatorioFormadores" + data + ".pdf");
		}
		return path;
	}

	@Override
	public String getReportCursos(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\Ayrton Pereira\\Downloads\\Reports";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'%'hh'horas'mm'min'");
		LocalDateTime dataHora = LocalDateTime.now();
		String data = formatter.format(dataHora);
		
		List<Curso> listaCursos = daoCurso.findAll();
		File file = ResourceUtils.getFile("classpath:reports/cursos_report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaCursos, false);
		Map<String, Object> parameters= new HashMap<>();
		parameters.put("criadopor", "Centro Ponto de Encontro");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\relatorioCursos" + data + ".pdf");
		}
		return path;
	}
	
	

}
