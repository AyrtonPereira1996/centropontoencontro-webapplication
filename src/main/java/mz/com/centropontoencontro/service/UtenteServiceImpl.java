package mz.com.centropontoencontro.service;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.com.centropontoencontro.dao.UtenteDAO;
import mz.com.centropontoencontro.domain.Utente;

@Service
@Transactional(readOnly = false)
public class UtenteServiceImpl implements UtenteService{
	
	@Autowired
	private UtenteDAO utenteDAO;
	
	@Override
	public void salvar(Utente utente) {
		if (utente.getEstado()==null) {
			utente.setEstado("Permitido");
		}
		utente.setNumeroEmprestimos(0L);
		utente.setDataRegisto(LocalDateTime.now());
		utenteDAO.save(utente);
	}

	@Override
	public void editar(Utente utente) {
		utenteDAO.update(utente);
	}

	@Override
	public void excluir(Long id) {
		utenteDAO.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Utente pesquisarPorId(Long id) {
		return utenteDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Utente> pesquisarTodos() {
		return utenteDAO.findAll();
	}

	@Override
	public boolean utenteTemEmprestimos(Long id) {
		if (pesquisarPorId(id).getEmprestimos().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean utenteTemDevolucoes(Long id) {
		if (pesquisarPorId(id).getDevolucoes().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean UtentePermitido(Long id) {
		if (pesquisarPorId(id).getEstado().equals("Permitido")) {
			return true;
		}
			return false;	
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Utente> pesquisarUtenteNumeroEmprestimos() {
		
		return utenteDAO.findAllUtenteByNumeroEmprestimos();
	}

	
	@Override
	@Transactional(readOnly = true)
	public Long obterTotalUtentes() {
		return utenteDAO.getTotalUtentes();
	}

	@Override
	public boolean utenteTemAprovacoes(Long id) {
		if (pesquisarPorId(id).getListaAprovados().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean utenteTemReprovacoes(Long id) {
		if (pesquisarPorId(id).getListaReprovacoes().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean utenteTemDesistencias(Long id) {
		if (pesquisarPorId(id).getListaDesistencia().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public void interditarUtentes() {
		utenteDAO.interdict();
		
	}

	




	
	
}
