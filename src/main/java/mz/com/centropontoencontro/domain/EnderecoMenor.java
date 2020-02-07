package mz.com.centropontoencontro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "utm_endereco")
public class EnderecoMenor {
	
	@Id
	@Column(name = "utm_enderecoid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@NotBlank(message = "Campo inválido.")
//	@NotNull(message = "Campo inválido.")
//	@Size(message = "Apenas são permitidos {max} caracteres", max = 50)
	@Column(name="utm_cidade")
	private String cidade;
	
//	@NotBlank(message = "Campo inválido.")
//	@NotNull(message = "Campo inválido.")
//	@Size(message = "Apenas são permitidos {max} caracteres", max = 50)
	@Column(name = "utm_bairro", length = 50)
	private String bairro;
	
//	@NotBlank(message = "Campo inválido.")
//	@NotNull(message = "Campo inválido.")
//	@Size(message = "Apenas são permitidos {max} caracteres", max = 50)
	@Column(name = "utm_quarteirao")
	private String quarteirao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getQuarteirao() {
		return quarteirao;
	}

	public void setQuarteirao(String quarteirao) {
		this.quarteirao = quarteirao;
	}
	
	
}
