package mz.com.centropontoencontro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "utm_encarregadoeducacao")
public class EncarregadoEducacao {
	
	@Id
	@Column(name = "utm_encarregadoid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Size(message = "Apenas são permitidos {max} caracteres", max = 100)
	@Column(name = "utm_nome_encarregado", length = 100)
	private String nome;
	
	
	@Column(name = "utm_parentesco")
	private String parentesco;
	

	@Size(message = "Apenas são permitidos {max} caracteres", max = 9)
	@Column(name="utm_contacto", length = 9)
	private String contacto;

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

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
}
