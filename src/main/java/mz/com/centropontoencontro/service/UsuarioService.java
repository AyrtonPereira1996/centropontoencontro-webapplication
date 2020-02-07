package mz.com.centropontoencontro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import mz.com.centropontoencontro.domain.Usuario;
import mz.com.centropontoencontro.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;
	
	@Transactional(readOnly = true)
	public Usuario pesquisaPorNome(String nomeUsuario) {
		return repository.findByUsername(nomeUsuario);
	}
	
	@Transactional(readOnly = true)
	public List<Usuario> pesquisarTodos(){
			return repository.findAll();
	}

	@Transactional(readOnly = true)
	@Override  
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = pesquisaPorNome(username);
		return new User(
				usuario.getNomeUsuario(),
				usuario.getSenhaUsuario(),
				AuthorityUtils.createAuthorityList(usuario.getPerfil().getDescricao()));
	
	}
	
//	private String[] getAuthorities(List<Perfil> perfis) {
//		String[] authorities = new String[perfis.size()];
//		for (int i = 0; i < perfis.size(); i++) {
//			authorities[i] = perfis.get(i).getDescricao();
//		}
//		return authorities;
//	}
	
}
