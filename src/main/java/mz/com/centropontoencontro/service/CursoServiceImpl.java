package mz.com.centropontoencontro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.com.centropontoencontro.dao.CursoDAO;
import mz.com.centropontoencontro.domain.Curso;

@Service
@Transactional(readOnly = false)
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoDAO curDAO;

	@Override
	public void salvar(Curso curso) {
		curso.setNumeroAprovacoes(0L);
		curso.setNumeroDesistencias(0L);
		curso.setNumeroReprovacoes(0L);
		curso.setDataRegisto(LocalDateTime.now());
		curDAO.save(curso);
	}

	@Override
	public void editar(Curso curso) {
		curDAO.update(curso);
	}

	@Override
	public void excluir(Long id) {
		curDAO.delete(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Curso pesquisarPorId(Long id) {
		return curDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Curso> pesquisarTodos() {
		return curDAO.findAll();
	}

	@Override
	public boolean cursoTemEstudantes(Long id) {
		if (pesquisarPorId(id).getEstudante().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean cursoTemPreEstudantes(Long id) {
		if (pesquisarPorId(id).getPreEstudantes().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean cursoTemFormador(Long id) {
		if (pesquisarPorId(id).getCursoLecionado().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public Long obterTotalCursos() {
		return curDAO.getTotalCurso();
	}

}
