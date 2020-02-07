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
import javax.validation.Valid;

@Entity
@Table(name = "formador_leciona_curso")
public class FormadorLeciona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flc_id")
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "flc_formadorid")
	private Formador formador;
	
	@ManyToOne
	@JoinColumn(name = "flc_cursoid")
	private Curso curso;
	
	@Column(name = "flc_data_registo")
	private LocalDateTime dataRegisto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Formador getFormador() {
		return formador;
	}

	public void setFormador(Formador formador) {
		this.formador = formador;
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
