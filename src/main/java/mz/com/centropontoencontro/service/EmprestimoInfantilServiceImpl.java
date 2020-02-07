package mz.com.centropontoencontro.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.com.centropontoencontro.dao.EmprestimoInfantilDAO;
import mz.com.centropontoencontro.domain.EmprestimoInfantil;

@Service
@Transactional(readOnly = false)
public class EmprestimoInfantilServiceImpl implements EmprestimoInfantilService {
	
	@Autowired
	private EmprestimoInfantilDAO empInfantilDAO;

	@Override
	public void salvar(EmprestimoInfantil empInfantil) {
		empInfantilDAO.save(empInfantil);
	}

	@Override
	public void editar(EmprestimoInfantil empInfantil) {
		empInfantilDAO.update(empInfantil);
	}

	@Override
	public void excluir(Long id) {
		empInfantilDAO.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public EmprestimoInfantil pesquisarPorId(Long id) {
		return empInfantilDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<EmprestimoInfantil> pesquisarTodos() {
		return empInfantilDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Long obterTotalEmprestimoInfantil() {
		return empInfantilDAO.getTotalEmprestimos();
	}

	@Override
	@Transactional(readOnly = true)
	public List<EmprestimoInfantil> pesquisarTodosDesc() {
		return empInfantilDAO.findAllByDesc();
	}
	
	




}
