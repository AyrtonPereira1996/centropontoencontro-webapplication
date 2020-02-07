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


@Entity
@Table(name = "liv_livro")
public class Livro {


	@Id
	@Column(name = "liv_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Column(name = "liv_titulo", nullable = false, length = 100)
	private String titulo;


	@Column(name = "liv_autor", nullable = false)
	private String autor;


	@Column(name = "liv_anoedicao", length = 4)
	private String anoEdicao;


	@Column(name = "liv_edicao", length = 10)
	private String edicao;


	@Column(name = "liv_editora", length = 50)
	private String editora;


	@Column(name = "liv_isbn", length = 20, unique = true)
	private String isbn;

	@Column(name = "liv_numeropedidos")
	private Long numeropedidos;


	@ManyToOne
	@JoinColumn(name = "liv_categoriaid")
	private CategoriaLivro categoria;

	@Column(name = "liv_data_registo")
	private LocalDateTime dataRegisto;

	@OneToMany(mappedBy = "livroEmprestimo")
	private List<Emprestimo> emprestimos;

	@OneToMany(mappedBy = "livroDevolucoes")
	private List<Devolucao> devolucoes;

	public List<Devolucao> getDevolucoes() {
		return devolucoes;
	}

	public void setDevolucoes(List<Devolucao> devolucoes) {
		this.devolucoes = devolucoes;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
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
		return categoria;
	}

	public void setCategoria(CategoriaLivro categoria) {
		this.categoria = categoria;
	}

	public LocalDateTime getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(LocalDateTime dataRegisto) {
		this.dataRegisto = dataRegisto;
	}

}
