package mz.com.centropontoencontro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.com.centropontoencontro.dao.UsuarioDAO;
import mz.com.centropontoencontro.domain.Usuario;

@Service
@Transactional(readOnly = false)
public class UsuarioServiceImpl implements UsuarioServiceCRUD {

	@Autowired
	private UsuarioDAO dao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void salvar(Usuario usuario) {
		if (usuario.getDataRegisto() == null) {
			usuario.setDataRegisto(LocalDateTime.now());
		}
		usuario.setSenhaUsuario(passwordEncoder.encode(usuario.getSenhaUsuario()));
		dao.save(usuario);

	}

	@Override
	public void editar(Usuario usuario) {
		String senhaAtual = obterSenhaUsuario();
		String senhaNova = usuario.getSenhaUsuario();

		if (senhaNova == null) {
			usuario.setSenhaUsuario(passwordEncoder.encode(senhaAtual));
		} else if (senhaNova != null) {
			usuario.setSenhaUsuario(passwordEncoder.encode(senhaNova));
		}

		dao.update(usuario);

	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);

	}

	@Transactional(readOnly = true)
	@Override
	public Usuario pesquisarPorId(Long id) {
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> pesquisarTodos() {
		return dao.findAll();
	}

	@Override
	public String obterSenhaUsuario() {
		return new Usuario().getSenhaUsuario();
	}

}
