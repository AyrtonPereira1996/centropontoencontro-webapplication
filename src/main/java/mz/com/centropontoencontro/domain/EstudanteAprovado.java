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
@Table(name = "uta_utentesaprovados")
public class EstudanteAprovado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uta_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "uta_utenteid")
	private Utente utente;
	
	@ManyToOne
	@JoinColumn(name = "uta_cursoid")
	private Curso curso;

	@Column(name = "uta_notafinal")
	private Float notaFinal;
	
	@Column(name = "uta_comentario")
	private String comentario;
	
	@Column(name = "uta_data_registo")
	private LocalDateTime dataAprovacao;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utenteAprovado) {
		this.utente = utenteAprovado;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso cursoAprovado) {
		this.curso = cursoAprovado;
	}

	public Float getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(Float notaFinal) {
		this.notaFinal = notaFinal;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public LocalDateTime getDataAprovacao() {
		return dataAprovacao;
	}

	public void setDataAprovacao(LocalDateTime dataAprovacao) {
		this.dataAprovacao = dataAprovacao;
	}
	
	
	
	
	
}
