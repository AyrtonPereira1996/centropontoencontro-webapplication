package mz.com.centropontoencontro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.com.centropontoencontro.dao.EstudanteAprovadoDAO;
import mz.com.centropontoencontro.domain.EstudanteAprovado;

@Service
@Transactional(readOnly = false)
public class EstudanteAprovadoServiceImpl implements EstudanteAprovadoService  {
	
	@Autowired
	private EstudanteAprovadoDAO dao;

	@Override
	public void salvar(EstudanteAprovado estudanteAprovado) {
		
		if (estudanteAprovado.getDataAprovacao()==null) {
			estudanteAprovado.setDataAprovacao(LocalDateTime.now());
		}
		dao.save(estudanteAprovado);
		
	}

	@Override
	public void editar(EstudanteAprovado estudanteAprovado) {
		dao.update(estudanteAprovado);
		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public EstudanteAprovado pesquisarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<EstudanteAprovado> pesquisarTodos() {
		
		return dao.findAll();
	}

}
