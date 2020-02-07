package mz.com.centropontoencontro.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.com.centropontoencontro.dao.PreEstudanteDAO;
import mz.com.centropontoencontro.domain.PreEstudante;

@Service
@Transactional(readOnly = false)
public class PreEstudanteServiceImpl implements PreEstudanteService {



	@Autowired
	private PreEstudanteDAO preEstudanteDAO;

	@Autowired
	private EntityManager entityManager;

	@Override
	public void salvar(PreEstudante preEstudante) {
		preEstudante.setDataRegisto(LocalDateTime.now());
		preEstudanteDAO.save(preEstudante);
	}

	@Override
	public void editar(PreEstudante preEstudante) {
		preEstudanteDAO.update(preEstudante);

	}

	@Override
	public void excluir(Long id) {
		preEstudanteDAO.delete(id);

	}

	@Override
	@Transactional(readOnly = true)
	public PreEstudante pesquisarPorID(Long id) {
		return preEstudanteDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PreEstudante> pesquisarTodos() {
		return preEstudanteDAO.findAll();
	}

	@Override
	public void salvarConfirmacao(PreEstudante preEstudante) {

		entityManager.createNativeQuery(
				"Insert into estudante values (default, ufc_utenteid, ufc_cursoid, ufc_data_registo) values (?,?,?, now())")
				.setParameter(1, null)
				.setParameter(2, preEstudante.getUtente().getId())
				.setParameter(3, preEstudante.getCurso().getId());
			
	}

}
