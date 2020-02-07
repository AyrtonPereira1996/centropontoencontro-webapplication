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
@Table(name = "utr_utentesreprovados")
public class EstudanteReprovado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="utr_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="utr_utenteid")
	private Utente utente;
	
	@ManyToOne
	@JoinColumn(name="utr_cursoid")
	private Curso curso;
	
	@Column(name ="utr_notafinal")
	private Float notaFinal;
	
	@Column(name="utr_comentario")
	private String comentario;
	
	@Column(name="utr_data_registo")
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

	public void setUtente(Utente utenteReprovado) {
		this.utente = utenteReprovado;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso cursoReprovado) {
		this.curso = cursoReprovado;
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

	public LocalDateTime getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(LocalDateTime dataRegisto) {
		this.dataRegisto = dataRegisto;
	}
	
	
	
	
	
}
