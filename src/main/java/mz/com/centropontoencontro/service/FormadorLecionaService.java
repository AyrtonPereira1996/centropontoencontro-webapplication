package mz.com.centropontoencontro.service;

import java.util.List;

import mz.com.centropontoencontro.domain.FormadorLeciona;

public interface FormadorLecionaService {
	void salvar(FormadorLeciona formadorLeciona);

	void editar(FormadorLeciona formadorLeciona);

	void excluir(Long id);

	FormadorLeciona pesquisarPorId(Long id);

	List<FormadorLeciona> pesquisarTodos();
	
	Long obterTotalFormadoresLecionando();

}
