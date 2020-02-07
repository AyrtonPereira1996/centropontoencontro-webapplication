package mz.com.centropontoencontro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.com.centropontoencontro.dao.LivroInfantilDAO;
import mz.com.centropontoencontro.domain.LivroInfantil;

@Service
@Transactional(readOnly = false)
public class LivroInfantilServiceImpl implements LivroInfantilService {
	
	@Autowired
	private LivroInfantilDAO livInfantilDAO;

	@Override
	public void salvar(LivroInfantil livInfantil) {
		livInfantil.setNumeropedidos(0L);
		livInfantil.setDataRegisto(LocalDateTime.now());
		livInfantilDAO.save(livInfantil); 
	}

	@Override
	public void editar(LivroInfantil livInfantil) {
		livInfantilDAO.update(livInfantil);
		
	}

	@Override
	public void excluir(Long id) {
		livInfantilDAO.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public LivroInfantil pesquisarPorId(Long id) {
		return livInfantilDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<LivroInfantil> pesquisarTodos() {
		return livInfantilDAO.findAll();
	}

	@Override
	public boolean livroTemEmprestimos(Long id) {
		if (pesquisarPorId(id).getEmprestimos().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean livroTemDevolucoes(Long id) {
		if (pesquisarPorId(id).getDevolucoes().isEmpty()) {
			return false;
		}
		return true;
	}

	@Transactional(readOnly = true)
	@Override
	public List<LivroInfantil> pesquisarLivroNumeroPedidos() {
		
		return livInfantilDAO.findAllByNameQuantidade();
	}

	@Override
	public Long obterTotalLivrosInfantis() {
	
		return livInfantilDAO.getTotalLivrosInfantis();
	}

}
