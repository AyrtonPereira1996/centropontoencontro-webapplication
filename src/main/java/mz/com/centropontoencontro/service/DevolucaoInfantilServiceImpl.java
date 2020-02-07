package mz.com.centropontoencontro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.com.centropontoencontro.dao.DevolucaoInfantilDAO;
import mz.com.centropontoencontro.domain.DevolucaoInfantil;

@Service
@Transactional(readOnly = false)
public class DevolucaoInfantilServiceImpl implements DevolucaoInfantilService {
	
	@Autowired
	private DevolucaoInfantilDAO devDAO;

	@Override
	public void salvar(DevolucaoInfantil devInfantil) {
		devInfantil.setDataRegisto(LocalDateTime.now());
		devDAO.save(devInfantil);
	}

	@Override
	public void editar(DevolucaoInfantil devInfantil) {
		devDAO.update(devInfantil);
	}

	@Override
	public void excluir(Long id) {
		devDAO.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public DevolucaoInfantil pesquisarPorId(Long id) {
		return devDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DevolucaoInfantil> pesquisarTodos() {
		return devDAO.findAll();
	}

	@Override
	public Long obterTotalDevolucaoInfantil() {
		
		return devDAO.getTotalDevolucao();
	}

	@Override
	@Transactional(readOnly = true)
	public List<DevolucaoInfantil> pesquisarTodosDesc() {
		
		return devDAO.findAllDesc();
	}

}
