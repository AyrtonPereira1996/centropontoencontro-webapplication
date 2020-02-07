package mz.com.centropontoencontro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.com.centropontoencontro.dao.EstudanteReprovadoDAO;
import mz.com.centropontoencontro.domain.EstudanteReprovado;

@Service
@Transactional(readOnly = false)
public class EstudanteReprovadoServiceImpl implements EstudanteReprovadoService {
	
	@Autowired
	private EstudanteReprovadoDAO dao;

	@Override
	public void salvar(EstudanteReprovado estudanteReprovado) {
		if (estudanteReprovado.getDataRegisto()==null) {
			estudanteReprovado.setDataRegisto(LocalDateTime.now());
		}
		dao.save(estudanteReprovado);
		
		
	}

	@Override
	public void editar(EstudanteReprovado estudanteReprovado) {
		dao.update(estudanteReprovado);
		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);;
		
	}

	@Transactional(readOnly = true)
	@Override
	public EstudanteReprovado pesquisarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<EstudanteReprovado> pesquisarTodos() {
		
		return dao.findAll();
	}

}
