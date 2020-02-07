package mz.com.centropontoencontro.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "usu_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_id")
	private Long id;
	
//	@Valid
	@ManyToOne
	@JoinColumn(name = "usu_idperfil")
	private Perfil perfil;
	
//	@NotBlank(message = "Campo inválido. Não deve conter espaços em branco!")
//	@NotNull(message = "Campo inválido. Não deve ficar vazio")
	@Column(name = "usu_nomeusuario")
	private String nomeUsuario;
	
//	@NotBlank(message = "Campo inválido. Não deve conter espaços em branco!")
//	@NotNull(message = "Campo inválido. Não deve ficar vazio!")
//	@Size(message = "Apenas são permitidos no minimo {min} e no máximo {max} caracteres para a senha!", max = 6, min=3)
	@Column(name = "usu_senha")
	private String senhaUsuario;
	
	@Column(name = "usu_dataregisto")
	private LocalDateTime dataRegisto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public LocalDateTime getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(LocalDateTime dataRegisto) {
		this.dataRegisto = dataRegisto;
	}
	
	
	

}
