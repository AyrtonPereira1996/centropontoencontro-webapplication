package mz.com.centropontoencontro.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mz.com.centropontoencontro.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	
	@Query("select u from Usuario u where u.nomeUsuario like :nomeusuario")
	Usuario findByUsername(@Param("nomeusuario") String nomeusuario);
	
	@Query("select u from Usuario u")
	List<Usuario> findAll();
}
