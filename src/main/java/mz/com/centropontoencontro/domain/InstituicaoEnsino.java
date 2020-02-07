package mz.com.centropontoencontro.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ins_instituicaoensino")
public class InstituicaoEnsino {
	

	@Id
	@Column(name="ins_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ins_nome")
	private String nome;
	
	@Column(name = "ins_numero_estudantes", nullable = false)
	private Long numeroEstudantes;
	
	@Column(name = "ins_tipo")
	private String tipo;
	
	@Column(name = "ins_data_registo")
	private LocalDateTime dataRegisto;
	
	@OneToMany(mappedBy = "instituicaoEnsino")
	private List<Utente> utentes;
	
	@OneToMany(mappedBy = "instituicaoEnsinoInfantil")
	private List<UtenteMenor> utentesMenores;
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Utente> getUtentes() {
		return utentes;
	}

	public void setUtentes(List<Utente> utentes) {
		this.utentes = utentes;
	}

	public List<UtenteMenor> getUtentesMenores() {
		return utentesMenores;
	}

	public void setUtentesMenores(List<UtenteMenor> utentesMenores) {
		this.utentesMenores = utentesMenores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getNumeroEstudantes() {
		return numeroEstudantes;
	}

	public void setNumeroEstudantes(Long numeroEstudantes) {
		this.numeroEstudantes = numeroEstudantes;
	}

	public LocalDateTime getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(LocalDateTime dataRegisto) {
		this.dataRegisto = dataRegisto;
	}

	/**
	 * Substituido o metodo toString padrao de modo a obter mais informacoesa sobre o Objecto
	 */
	@Override
	public String toString() {
		return nome;
	}
	
	
	
	
}
