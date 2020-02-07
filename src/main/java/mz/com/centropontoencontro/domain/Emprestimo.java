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

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "emp_emprestimo")
public class Emprestimo {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long id;
	
	@Valid
	@ManyToOne
	@JoinColumn(name = "emp_utenteid")
	private Utente utenteEmprestimo;
	
	@Valid
	@ManyToOne
	@JoinColumn(name = "emp_livroid")
	private Livro livroEmprestimo;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(name = "emp_dataRegisto", columnDefinition = "DATETIME")
	private LocalDateTime dataRegisto;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Utente getUtenteEmprestimo() {
		return utenteEmprestimo;
	}


	public void setUtenteEmprestimo(Utente utente) {
		this.utenteEmprestimo = utente;
	}


	public Livro getLivroEmprestimo() {
		return livroEmprestimo;
	}


	public void setLivroEmprestimo(Livro livro) {
		this.livroEmprestimo = livro;
	}


	public LocalDateTime getDataRegisto() {
		return dataRegisto;
	}


	public void setDataRegisto(LocalDateTime dataRegisto) {
		this.dataRegisto = dataRegisto;
	}


	@Override
	public String toString() {
		return "Emprestimo [id=" + id + ", utenteEmprestimo=" + utenteEmprestimo + ", livroEmprestimo="
				+ livroEmprestimo + ", dataRegisto=" + dataRegisto + "]";
	}
	
	


}
