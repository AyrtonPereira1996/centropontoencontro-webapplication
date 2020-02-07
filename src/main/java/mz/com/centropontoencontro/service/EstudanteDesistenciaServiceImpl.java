package mz.com.centropontoencontro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.com.centropontoencontro.dao.EstudanteDesistenciaDAO;
import mz.com.centropontoencontro.domain.EstudanteDesistencia;

@Service
@Transactional(readOnly = false)
public class EstudanteDesistenciaServiceImpl implements EstudanteDesistenciaService {
	
	@Autowired
	private EstudanteDesistenciaDAO dao;

	@Override
	public void salvar(EstudanteDesistencia estudanteDesistencia) {
		if(estudanteDesistencia.getDataRegisto()==null) {
			estudanteDesistencia.setDataRegisto(LocalDateTime.now());
		}
		
		dao.save(estudanteDesistencia);
		
	}

	@Override
	public void editar(EstudanteDesistencia estudanteDesistencia) {
		dao.update(estudanteDesistencia);
		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override
	public EstudanteDesistencia pesquisarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override
	public List<EstudanteDesistencia> pesquisarTodos() {
		
		return dao.findAll();
	}

}
