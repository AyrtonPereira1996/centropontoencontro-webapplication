package mz.com.centropontoencontro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import mz.com.centropontoencontro.service.UsuarioService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioService service;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/webjars/**", "/css/**", "/js/**", "/_css/**", "/_imgs/**", "/_js/**").permitAll().antMatchers("/", "/login")
				.permitAll()

				.antMatchers("/instituicaoensino/listar_instituicaoensino_por_gestor",
						"/instituicaoensinoinfantil/listar_por_gestor", "/livro/listar_por_gestor",
						"/livro/listar_numeropedidos_por_gestor", "/livroinfantil/listar_por_gestor",
						"/livroinfantil/listar_numeropedidos_gestor", "/usuario/cadastro_por_gestor",
						"/utente/listar_por_gestor", "/usuario/listar_numeroemprestimos_por_gestor",
						"/utentemenor/listar_por_gestor", "/utentemenor/listar_numeroemprestimos_por_gestor", "/area/areagestor" )
				.hasAuthority("GESTOR")
				.antMatchers("/categorialivro/cadastro", "/categorialivro/listar", "/curso/cadastro", "/curso/listar",
						"/devolucao/listar", "/devolucaoinfantil/listar", "/emprestimo/cadastro", "/emprestimo/listar",
						"/emprestimoinfantil/cadastro", "/emprestimoinfantil/listar", "/estudante/listar",
						"/estudantesaprovacao/cadastro", "/estudantesaprovacao/listar", "/estudantesdesistiram/listar",
						"/estudantesreprovacao/listar", "/formador/cadastro", "/formador/listar",
						"/formadorleciona/cadastro", "/formadorleciona/listar", "/area/areacoordenador",
						"/instituicaoensino/cadastro_instituicao", "/instituicaoensino/listar_instituicaoensino",
						"/instituicaoensinoinfantil/cadastro_instituicaoinfantil", "/instituicaoensinoinfantil/listar",
						"/livro/cadastro", "/livro/listar", "/livro/listar_numeropedidos", "/livroinfantil/cadastro",
						"/livroinfantil/listar", "/livroinfantil/listar_numeropedidos", "/preestudante/cadastro",
						"/preestudante/listar", "/resultadoestudantes/consultar_opcoes","/usuario/cadastro",
						"/utente/cadastro", "/utente/listar", "/utente/listar_numeroemprestimos",
						"/utentemenor/cadastro", "/utentemenor/listar", "/utentemenor/listar_numeroemprestimos")
				.hasAuthority("COORDENADOR")
				.antMatchers("/categorialivro/listar_por_bibliotecario", "/devolucao/listar_por_bibliotecario",
						"/emprestimo/cadastro_por_bibliotecario", "/emprestimo/listar_por_bibliotecario",
						"/area/area_biblioteca_ponto_encontro", "/instituicaoensino/cadastro_instituicao_por_bibliotecario",
						"/instituicaoensino/listar_instituicaoensino_por_bibliotecario",
						"/livro/listar_por_bibliotecario", "/utente/cadastro_por_bibliotecario",
						"/listar_por_bibliotecario", "/utente/listar_por_bibliotecario")
				.hasAuthority("BIBLIOTECARIO")
				.antMatchers("/devolucaoinfantil/listar_por_bibliotecario",
						"/emprestimoinfantil/cadastro_por_bibliotecario",
						"/emprestimoinfantil/listar_por_bibliotecario", "/area/areainfantil",
						"/instituicaoensinoinfantil/cadastro_instituicaoinfantil_por_bibliotecario",
						"/instituicaoensinoinfantil/listar_por_bibliotecario",
						"/livroinfantil/listar_por_bibliotecario", "/utentemenor/cadastro_por_bibliotecario",
						"/utentemenor/listar_por_bibliotecario")
				.hasAuthority("BIBLIOTECARIOINFANTIL")

				.anyRequest().authenticated().and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/area/verificaousuario", true).failureUrl("/login-error").permitAll().and().logout()
				.logoutSuccessUrl("/login")

		;

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
	}

}
