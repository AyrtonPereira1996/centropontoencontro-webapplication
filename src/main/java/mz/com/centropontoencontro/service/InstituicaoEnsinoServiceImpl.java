package mz.com.centropontoencontro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.com.centropontoencontro.dao.InstituicaoEnsinoDAO;
import mz.com.centropontoencontro.domain.InstituicaoEnsino;

@Service
@Transactional(readOnly = false)
public class InstituicaoEnsinoServiceImpl implements InstituicaoEnsinoService {
	
	@Autowired
	private InstituicaoEnsinoDAO insEnsinoDAO;

	@Override
	public void salvar(InstituicaoEnsino insEnsino) {
		if (insEnsino.getNumeroEstudantes()==null) {
			insEnsino.setNumeroEstudantes(0L);
		}
		insEnsino.setTipo("Não infantil");
		insEnsino.setDataRegisto(LocalDateTime.now());
		insEnsinoDAO.save(insEnsino);
	}

	@Override
	public void editar(InstituicaoEnsino insEnsino) {
		
		insEnsinoDAO.update(insEnsino);
	}

	@Override
	public void excluir(Long id) {
		insEnsinoDAO.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public InstituicaoEnsino pesquisarPorId(Long id) {
		return insEnsinoDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<InstituicaoEnsino> pesquisarTodos() {
		return insEnsinoDAO.findAll();
	}

	@Override
	public boolean instituicaoTemUtentes(Long id) {
		if (pesquisarPorId(id).getUtentes().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean instituicaoTemUtentesMenores(Long id) {
		if(pesquisarPorId(id).getUtentesMenores().isEmpty()) {
			return false;
		}
		return true;
	}

	
	@Transactional(readOnly = true)
	@Override
	public List<InstituicaoEnsino> pesquisarTodasInstituicoesNãoInfantis() {

		return insEnsinoDAO.FindAllInstituicaoEnsino();
	}

	@Override
	@Transactional(readOnly = true)
	public Long obterTotalInstituicaoEnsino() {
		
		return insEnsinoDAO.getTotalInstituicaoEnsino();
	}

}
