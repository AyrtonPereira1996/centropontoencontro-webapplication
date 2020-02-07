package mz.com.centropontoencontro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.com.centropontoencontro.dao.FormadorLecionaDAO;
import mz.com.centropontoencontro.domain.FormadorLeciona;

@Service
@Transactional(readOnly = false)
public class FormadorLecionaServiceImpl implements FormadorLecionaService {
	
	@Autowired
	private FormadorLecionaDAO formadorlecionaDAO;

	@Override
	public void salvar(FormadorLeciona formadorLeciona) {
		formadorLeciona.setDataRegisto(LocalDateTime.now());
		formadorlecionaDAO.save(formadorLeciona);
	}

	@Override
	public void editar(FormadorLeciona formadorLeciona) {
		formadorlecionaDAO.update(formadorLeciona);
	}

	@Override
	public void excluir(Long id) {
		formadorlecionaDAO.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public FormadorLeciona pesquisarPorId(Long id) {
		return formadorlecionaDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FormadorLeciona> pesquisarTodos() {
		return formadorlecionaDAO.findAll();
	}

	@Override
	public Long obterTotalFormadoresLecionando() {

		return formadorlecionaDAO.getTotalFormadoresTeaching();
	}

}
