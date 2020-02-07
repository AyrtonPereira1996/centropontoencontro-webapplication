package mz.com.centropontoencontro.domain;

import java.math.BigDecimal;
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

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "cur_curso")
public class Curso {
	
	
	@Column(name = "cur_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(name = "cur_nome")
	private String nome;
	
	@Column(name = "cur_duracao")
	private String duracao;
	
	@Column(name = "cur_preco", nullable = false)
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal preco;
	
	@Column(name = "cur_numeroaprovacoes")
	private Long numeroAprovacoes;
	
	@Column(name = "cur_numeroreprovacoes")
	private Long numeroReprovacoes;
	
	@Column(name = "cur_numerodesistencias")
	private Long numeroDesistencias;
	
	@Column(name = "cur_data_registo")
	private LocalDateTime dataRegisto;
	
	@OneToMany(mappedBy = "curso")
	private List<Estudante> estudante;
	
	@OneToMany(mappedBy = "curso")
	private List<PreEstudante> listaPreEstudante;
	
	public List<EstudanteAprovado> getListaCurso() {
		return listaAprovacao;
	}

	public void setListaCurso(List<EstudanteAprovado> listaCurso) {
		this.listaAprovacao = listaCurso;
	}

	@OneToMany(mappedBy = "curso")
	private List<FormadorLeciona> cursoLecionado;
	
	@OneToMany(mappedBy = "curso")
	private List<PreEstudante> preEstudantes;
	
	@OneToMany(mappedBy = "curso")
	private List<EstudanteAprovado> listaAprovacao;
	
	@OneToMany(mappedBy = "curso")
	private List<EstudanteReprovado> listaReprovacao;
	
	
	public Long getNumeroAprovacoes() {
		return numeroAprovacoes;
	}

	public void setNumeroAprovacoes(Long numeroAprovacoes) {
		this.numeroAprovacoes = numeroAprovacoes;
	}

	public Long getNumeroReprovacoes() {
		return numeroReprovacoes;
	}

	public void setNumeroReprovacoes(Long numeroReprovacoes) {
		this.numeroReprovacoes = numeroReprovacoes;
	}

	public Long getNumeroDesistencias() {
		return numeroDesistencias;
	}

	public void setNumeroDesistencias(Long numeroDesistencias) {
		this.numeroDesistencias = numeroDesistencias;
	}

	public List<PreEstudante> getListaPreEstudante() {
		return listaPreEstudante;
	}

	public void setListaPreEstudante(List<PreEstudante> listaPreEstudante) {
		this.listaPreEstudante = listaPreEstudante;
	}

	public List<PreEstudante> getPreEstudantes() {
		return preEstudantes;
	}

	public List<EstudanteAprovado> getListaAprovacao() {
		return listaAprovacao;
	}

	public void setListaAprovacao(List<EstudanteAprovado> listaAprovacao) {
		this.listaAprovacao = listaAprovacao;
	}

	public List<EstudanteReprovado> getListaReprovacao() {
		return listaReprovacao;
	}

	public void setListaReprovacao(List<EstudanteReprovado> listaReprovacao) {
		this.listaReprovacao = listaReprovacao;
	}

	public void setPreEstudantes(List<PreEstudante> preEstudantes) {
		this.preEstudantes = preEstudantes;
	}

	public List<FormadorLeciona> getCursoLecionado() {
		return cursoLecionado;
	}

	public void setCursoLecionado(List<FormadorLeciona> cursoLecionado) {
		this.cursoLecionado = cursoLecionado;
	}

	public List<Estudante> getEstudante() {
		return estudante;
	}

	public void setEstudante(List<Estudante> estudante) {
		this.estudante = estudante;
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

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
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
