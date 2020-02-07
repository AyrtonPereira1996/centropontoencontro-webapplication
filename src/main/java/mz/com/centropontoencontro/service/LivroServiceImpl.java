package mz.com.centropontoencontro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.com.centropontoencontro.dao.LivroDAO;
import mz.com.centropontoencontro.domain.Livro;

@Service
@Transactional(readOnly = false)
public class LivroServiceImpl implements LivroService  {
	
	@Autowired
	private LivroDAO livDAO;

	@Override
	public void salvar(Livro livro) {
		if(livro.getNumeropedidos()==null) {
			livro.setNumeropedidos(0L);
		}
		livro.setDataRegisto(LocalDateTime.now());
		livDAO.save(livro);
	}

	@Override
	public void editar(Livro livro) {
		livDAO.update(livro);
	}

	@Override
	public void excluir(Long id) {
		livDAO.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Livro pesquisarPorId(Long id) {
		return livDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Livro> pesquisarTodos() {
		return livDAO.findAll();
	}

	@Override
	public boolean livroTemEmprestimo(Long id) {
		if(pesquisarPorId(id).getEmprestimos().isEmpty()) {
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
	public List<Livro> pesquisarLivroNumeropedidos() {
		
		return livDAO.findAllByNameQuantidade();
	}

	@Override
	@Transactional(readOnly = true)
	public Long obterTotalLivros() {
		return livDAO.getTotalLivros();
	}

}
