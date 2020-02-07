package mz.com.centropontoencontro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.com.centropontoencontro.dao.DevolucaoDAO;
import mz.com.centropontoencontro.domain.Devolucao;


@Service
@Transactional(readOnly = false)
public class DevolucaoServiceImpl implements DevolucaoService {
	
	@Autowired
	private DevolucaoDAO devDAO;

	@Override
	public void salvar(Devolucao devolucao) {
		devolucao.setDataRegisto(LocalDateTime.now());
		devDAO.save(devolucao);
	}

	@Override
	public void editar(Devolucao devolucao) {
		devDAO.update(devolucao);
		
	}

	@Override
	public void delete(Long id) {
		devDAO.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Devolucao pesquisarPorId(Long id) {
		return devDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Devolucao> pesquisarTodos() {
		return devDAO.findAll();
	}

	@Override
	public Long obterTotalDevolucao() {
		
		return devDAO.getTotalDevolucao();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Devolucao> pesquisarTodosDesc() {
		return devDAO.findAllDesc();
	}

}
