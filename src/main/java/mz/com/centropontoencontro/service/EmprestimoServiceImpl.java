package mz.com.centropontoencontro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.com.centropontoencontro.dao.EmprestimoDAO;
import mz.com.centropontoencontro.domain.Emprestimo;

@Service
@Transactional(readOnly = false)
public class EmprestimoServiceImpl implements EmprestimoService {
	
	@Autowired
	private EmprestimoDAO empDAO; 
	
	

	@Override
	public void salvar(Emprestimo emprestimo) {
		emprestimo.setDataRegisto(LocalDateTime.now());
		empDAO.save(emprestimo);
	}

	@Override
	public void editar(Emprestimo emprestimo) {
		empDAO.update(emprestimo);	
	}

	@Override
	public void excluir(Long id) {
		empDAO.delete(id);	
	}

	@Override
	@Transactional(readOnly = true)
	public Emprestimo pesquisarPorId(Long id) {
		return empDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Emprestimo> pesquisarTodos() {
		return empDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Long obterTotalEmprestimo() {
		
		return empDAO.getTotalEmprestimos();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Emprestimo> pesquisarTodosDesc() {
		return empDAO.findAllDesc();
	}



	
	

	



}
