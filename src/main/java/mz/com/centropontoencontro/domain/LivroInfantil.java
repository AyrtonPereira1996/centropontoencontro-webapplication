package mz.com.centropontoencontro.domain;

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

import javax.validation.constraints.Size;

@Entity
@Table(name = "lin_livroinfantil")
public class LivroInfantil{
	

//	@NotNull(message = "Campo inválido. Não deve ficar vazio")
	@Id
	@Column(name="lin_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@NotBlank(message = "Campo inválido. Não deve conter espaços em branco")
//	@NotNull(message = "Campo inválido. Não deve ficar vazio")
	@Size(message = "Apenas são permitidos {max} caracteres", max = 100)
	@Column(name = "lin_titulo")
	private String titulo;
	
//	@NotBlank(message = "Campo inválido. Não deve conter espaços em branco")
//	@NotNull(message = "Campo inválido. Não deve ficar vazio")
//	@Size(message = "Apenas são permitidos {max} caracteres", max = 255)
	@Column(name = "lin_autor")
	private String autor;
	
//	@NotBlank(message = "Campo inválido. Não deve conter espaços em branco")
//	@NotNull(message = "Campo inválido. Não deve ficar vazio")
//	@Size(message = "Apenas são permitidos {max} caracteres", max = 4)
	@Column(name = "lin_anoedicao", length = 4)
	private String anoEdicao;
	
//	@NotBlank(message = "Campo inválido. Não deve conter espaços em branco")
//	@NotNull(message = "Campo inválido. Não deve ficar vazio")
//	@Size(message = "Apenas são permitidos {max} caracteres", max = 10)
	@Column(name = "lin_edicao", length = 10)
	private String edicao;
	
//	@NotBlank(message = "Campo inválido. Não deve conter espaços em branco")
//	@NotNull(message = "Campo inválido. Não deve ficar vazio")
//	@Size(message = "Apenas são permitidos {max} caracteres", max = 50)
	@Column(name = "lin_editora", length = 50)
	private String editora;
	
//	@NotBlank(message = "Campo inválido. Não deve conter espaços em branco")
//	@NotNull(message = "Campo inválido. Não deve ficar vazio")
//	@Size(message = "Apenas são permitidos {max} caracteres", max = 13)
	@Column(name = "lin_isbn", length = 20, unique = true)
	private String isbn;
	
	@Column(name = "lin_numeropedidos")
	private Long numeropedidos;
	
//	@Valid
	@ManyToOne
	@JoinColumn(name = "lin_categoriaid")
	private CategoriaLivro categoriaInfantil;
	
	public List<DevolucaoInfantil> getDevolucoes() {
		return devolucoes;
	}

	public void setDevolucoes(List<DevolucaoInfantil> devolucoes) {
		this.devolucoes = devolucoes;
	}

	@Column(name = "lin_data_registo")
	private LocalDateTime dataRegisto;
	
	@OneToMany(mappedBy = "livroEmprestimo")
	private List<EmprestimoInfantil> emprestimos;
	
	@OneToMany(mappedBy = "livroDevolucoes")
	private List<DevolucaoInfantil> devolucoes;

	public CategoriaLivro getCategoriaInfantil() {
		return categoriaInfantil;
	}

	public void setCategoriaInfantil(CategoriaLivro categoriaInfantil) {
		this.categoriaInfantil = categoriaInfantil;
	}

	public List<EmprestimoInfantil> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<EmprestimoInfantil> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAnoEdicao() {
		return anoEdicao;
	}

	public void setAnoEdicao(String anoEdicao) {
		this.anoEdicao = anoEdicao;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Long getNumeropedidos() {
		return numeropedidos;
	}

	public void setNumeropedidos(Long numeropedidos) {
		this.numeropedidos = numeropedidos;
	}

	public CategoriaLivro getCategoria() {
		return categoriaInfantil;
	}

	public void setCategoria(CategoriaLivro categoria) {
		this.categoriaInfantil = categoria;
	}

	public LocalDateTime getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(LocalDateTime dataRegisto) {
		this.dataRegisto = dataRegisto;
	} 
	
	

}
