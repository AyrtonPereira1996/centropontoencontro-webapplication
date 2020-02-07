package mz.com.centropontoencontro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.com.centropontoencontro.dao.EstudanteDAO;
import mz.com.centropontoencontro.domain.Estudante;

@Service
@Transactional(readOnly = false)
public class EstudanteServiceImpl implements EstudanteService {
	
	@Autowired
	private EstudanteDAO estudantedao;

	@Override
	public void salvar(Estudante estudante) {
		if(estudante.getDataRegisto()==null) {
			estudante.setDataRegisto(LocalDateTime.now());
		}
		
		estudantedao.save(estudante);
	}

	@Override
	public void editar(Estudante estudante) {
		estudantedao.update(estudante);	
	}

	@Override
	public void excluir(Long id) {
		estudantedao.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Estudante pesquisarPorId(Long id) {
		return estudantedao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Estudante> pesquisarTodos() {
		return estudantedao.findAll();
	}

}
