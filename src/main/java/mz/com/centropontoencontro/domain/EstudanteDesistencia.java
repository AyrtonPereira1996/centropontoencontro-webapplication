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
@Table(name = "utd_utentesdesistiram")
public class EstudanteDesistencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "utd_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "utd_utenteid")
	private Utente utente;
	
	@ManyToOne
	@JoinColumn(name = "utd_cursoid")
	private Curso curso;
	
	@Column(name = "utd_comentario")
	private String comentario;
	
	@Column(name="utd_data_registo")
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

	public void setUtente(Utente utenteDesistiram) {
		this.utente = utenteDesistiram;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso cursoDesistiram) {
		this.curso = cursoDesistiram;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public LocalDateTime getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(LocalDateTime dataRegisto) {
		this.dataRegisto = dataRegisto;
	}
	
	
	
}
