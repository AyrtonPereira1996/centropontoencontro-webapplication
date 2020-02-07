package mz.com.centropontoencontro.service;

import java.util.List;

import mz.com.centropontoencontro.domain.InstituicaoEnsino;

public interface InstituicaoEnsinoInfantilService {
	
	void salvar(InstituicaoEnsino insEnsino);

	void editar(InstituicaoEnsino insEnsino);

	void excluir(Long id);

	InstituicaoEnsino pesquisarPorId(Long id);

	List<InstituicaoEnsino> pesquisarTodos();
	
	boolean instituicaoTemUtentes(Long id);
	
	boolean instituicaoTemUtentesMenores(Long id);
	
	List<InstituicaoEnsino> pesquisarTodasInstituicoesInfantis();
	
	Long obterTotalInstituicaoEnsinoInfantil();

}
