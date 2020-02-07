package mz.com.centropontoencontro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.com.centropontoencontro.dao.UtenteMenorDAO;
import mz.com.centropontoencontro.domain.UtenteMenor;

@Service
@Transactional(readOnly = false)
public class UtenteMenorServiceImpl implements UtenteMenorService {
	
	@Autowired
	private UtenteMenorDAO utMenorDAO;

	@Override
	public void salvar(UtenteMenor utenteMenor) {
		utenteMenor.setNumeroEmprestimos(0L);
		utenteMenor.setDataRegisto(LocalDateTime.now());
		utMenorDAO.save(utenteMenor);
	}

	@Override
	public void editar(UtenteMenor utenteMenor) {
		utMenorDAO.update(utenteMenor);
	}

	@Override
	public void excluir(Long id) {
		utMenorDAO.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public UtenteMenor pesquisarPorId(Long id) {
		return utMenorDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UtenteMenor> pesquisarTodos() {
		return utMenorDAO.findAll();
	}

	@Override
	public boolean utenteMenorTemEmprestimos(Long id) {
		if (pesquisarPorId(id).getEmprestimos().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean utenteMenorTemDevolucoes(Long id) {
		if(pesquisarPorId(id).getDevolucoes().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public List<UtenteMenor> pesquisarPorNomeQuantidade() {

		return utMenorDAO.findAllUtenteByNomeQuantidade();
	}

	@Override
	@Transactional(readOnly = true)
	public Long obterTotalUtentesMenores() {

		return utMenorDAO.getTotalUtentesMenor();
	}





}
