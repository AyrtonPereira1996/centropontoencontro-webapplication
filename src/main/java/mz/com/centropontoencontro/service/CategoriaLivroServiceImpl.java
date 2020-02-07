package mz.com.centropontoencontro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.com.centropontoencontro.dao.CategoriaLivroDAO;
import mz.com.centropontoencontro.domain.CategoriaLivro;

@Service
@Transactional(readOnly = false)
public class CategoriaLivroServiceImpl implements CategoriaLivroService {

	@Autowired
	private CategoriaLivroDAO catLivroDAO;

	@Override
	public void salvar(CategoriaLivro catLivro) {
		catLivro.setDataRegisto(LocalDateTime.now());
		catLivroDAO.save(catLivro);
		
	}

	@Override
	public void editar(CategoriaLivro catLivro) {
		catLivroDAO.update(catLivro);
		
	}

	@Override
	public void excluir(Long id) {
		catLivroDAO.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public CategoriaLivro pesquisarPorId(Long id) {
		return catLivroDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CategoriaLivro> pesquisarTodos() {
		return catLivroDAO.findAll();
	}

	@Override
	public boolean categoriaTemLivro(Long id) {
		if (pesquisarPorId(id).getLivros().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean categoriaInfantilTemLivro(Long id) {
		if(pesquisarPorId(id).getLivrosInfantil().isEmpty()) {
			return false;
		}
		return true;
	}

}
