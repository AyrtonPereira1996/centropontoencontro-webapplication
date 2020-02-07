package mz.com.centropontoencontro.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "cat_categorialivro")
public class CategoriaLivro {

	
	@Id
	@Column(name = "cat_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O campo não pode estar vazio.")
	@NotBlank(message="O campo não pode conter espaços em branco.")
	@Column(name = "cat_familia")
	private String familia;
	
	@NotNull(message = "O campo não pode estar vazio.")
	@Column(name = "cat_cdd")
	private Integer cdd;
	
	@OneToMany(mappedBy = "categoriaInfantil")
	public List<LivroInfantil> livrosInfantil;
	
	@Column(name = "cat_data_registo")
	private LocalDateTime dataRegisto;
	
	@OneToMany(mappedBy = "categoria")
	private List<Livro> livros;
	
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<LivroInfantil> getLivrosInfantil() {
		return livrosInfantil;
	}

	public void setLivrosInfantil(List<LivroInfantil> livrosInfantil) {
		this.livrosInfantil = livrosInfantil;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public Integer getCdd() {
		return cdd;
	}

	public void setCdd(Integer cdd) {
		this.cdd = cdd;
	}

	public LocalDateTime getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(LocalDateTime dataRegisto) {
		this.dataRegisto = dataRegisto;
	}

	@Override
	public String toString() {
		return familia+"/"+cdd.toString();
	}
	
	
	
}
