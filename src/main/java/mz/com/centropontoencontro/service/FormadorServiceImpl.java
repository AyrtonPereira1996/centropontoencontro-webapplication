package mz.com.centropontoencontro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.com.centropontoencontro.dao.FormadorDAO;
import mz.com.centropontoencontro.domain.Formador;

@Service
@Transactional(readOnly = false)
public class FormadorServiceImpl implements FormadorService {
	
	@Autowired
	private FormadorDAO formadorDAO;

	@Override
	public void salvar(Formador formador) {
		formador.setDataRegisto(LocalDateTime.now());
		formadorDAO.save(formador);
	}

	@Override
	public void editar(Formador formador) {
		formadorDAO.update(formador);
	}

	@Override
	public void excluir(Long id) {
		formadorDAO.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Formador pesquisarPorId(Long id) {
		return formadorDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Formador> pesquisarTodos() {
		return formadorDAO.findAll();
	}

	@Override
	public boolean formadorTemCurso(Long id) {
		if (pesquisarPorId(id).getCursoslecionados().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public Long obterTotalFormadores() {
		return formadorDAO.getTotalFormadores();
	}

}
