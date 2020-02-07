package mz.com.centropontoencontro.dao;

import java.util.List;

import mz.com.centropontoencontro.domain.Usuario;

public interface UsuarioDAO {

	void save(Usuario usuario);

	void update(Usuario usuario);

	void delete(Long id);

	Usuario findById(Long id);

	List<Usuario> findAll();
}
