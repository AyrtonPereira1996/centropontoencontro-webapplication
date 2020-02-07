package mz.com.centropontoencontro.service;

import java.io.FileNotFoundException;

import net.sf.jasperreports.engine.JRException;

public interface ReportsService {
	String getReportUtente(String reportFormat) throws FileNotFoundException, JRException;
	
	String getReportUtenteMaisFrequentes(String reportFormat) throws FileNotFoundException, JRException;
	
	String getReportUtenteMenor(String reportFormat) throws FileNotFoundException, JRException;
	
	String getReportUtenteMenorMaisFrequentes(String reportFormat) throws FileNotFoundException, JRException;
	
	String getReportInstituicaoEnsino(String reportFormat)throws FileNotFoundException, JRException;
	
	String getReportEscola(String reportFormat) throws FileNotFoundException, JRException;
	
	String getReportCategoriaLivros(String reportFormat) throws FileNotFoundException, JRException;
	
	String getReportLivrosMaisFrequentes(String reportFormat) throws FileNotFoundException, JRException;
	
	String getReportLivrosInfantisMaisFrequentes(String reportFormat) throws FileNotFoundException, JRException;
	
	String getReportLivros(String reportFormat) throws FileNotFoundException, JRException;
	
	String getReportLivrosInfantis(String reportFormat) throws FileNotFoundException, JRException;
	
	String getReportPreEstudantes(String reportFormat) throws FileNotFoundException, JRException;
	
	String getReportFormadoresLecionam(String reportFormat) throws FileNotFoundException, JRException;
	
	String getReportFormador(String reportFormat) throws FileNotFoundException, JRException;
	
	String getReportCursos(String reportFormat) throws FileNotFoundException, JRException;
			
}
