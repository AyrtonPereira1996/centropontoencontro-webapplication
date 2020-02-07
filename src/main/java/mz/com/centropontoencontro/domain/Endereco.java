package mz.com.centropontoencontro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ute_endereco")
public class Endereco {
	
	@Id
	@Column(name = "ute_enderecoid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ute_cidade")
	private String cidade;
	
	@Column(name = "ute_bairro")
	private String bairro;
	
	@Column(name = "ute_quarteirao")
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
