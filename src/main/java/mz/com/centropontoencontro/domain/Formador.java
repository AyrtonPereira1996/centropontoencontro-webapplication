package mz.com.centropontoencontro.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;

import org.aspectj.lang.annotation.Before;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "for_formador")
public class Formador{

	@Column(name = "for_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "for_nome")
	private String nome;
	
	@Column(name = "for_data_nascimento")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;
	
	@Column(name = "for_genero")
	private String genero;

	@Column(name="for_contacto")
	private String contacto;
	
	@Column(name = "for_competencias")
	private String competencias;
	
	@Column(name = "for_email")
	private String email;
	
	@Column(name = "for_data_registo")
	private LocalDateTime dataRegisto;
	
	@OneToMany(mappedBy = "formador")
	private List<FormadorLeciona> formadorleciona;

	public List<FormadorLeciona> getFormadorleciona() {
		return formadorleciona;
	}

	public void setFormadorleciona(List<FormadorLeciona> formadorleciona) {
		this.formadorleciona = formadorleciona;
	}

	public List<FormadorLeciona> getCursoslecionados() {
		return formadorleciona;
	}

	public void setCursoslecionados(List<FormadorLeciona> cursoslecionados) {
		this.formadorleciona = cursoslecionados;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getCompetencias() {
		return competencias;
	}

	public void setCompetencias(String competencias) {
		this.competencias = competencias;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(LocalDateTime dataRegisto) {
		this.dataRegisto = dataRegisto;
	}

	@Override
	public String toString() {
		return  nome;
	}
	
	
	
	
}
