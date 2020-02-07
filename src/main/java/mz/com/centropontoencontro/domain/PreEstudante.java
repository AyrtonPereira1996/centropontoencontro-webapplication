package mz.com.centropontoencontro.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

@Entity
@Table(name = "utente_pre_registo_curso")
public class PreEstudante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "upr_id")
	private Long id;

	@Valid
	@OneToOne
	@JoinColumn(name = "upr_utenteid")
	private Utente utente;

	@Valid
	@ManyToOne
	@JoinColumn(name = "upr_cursoid")
	private Curso curso;

	@Column(name = "upr_data_registo")
	private LocalDateTime dataRegisto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public LocalDateTime getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(LocalDateTime dataRegisto) {
		this.dataRegisto = dataRegisto;
	}

}
