package mz.com.centropontoencontro.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "ute_utente")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ute_id")
	private Long id;

	@Column(name = "ute_nome")
	private String nome;

	@Column(name = "ute_datanascimento")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;

	
	@Column(name = "ute_genero")
	private String genero;

	@Column(name = "ute_naturalidade")
	private String naturalidade;

	@Column(name = "ute_bi")
	private String numeroBi;

	@Column(name = "ute_nomemae")
	private String nomeMae;

	@Column(name = "ute_nomepai")
	private String nomePai;

	@Column(name = "ute_localtrabalho")
	private String localTrabalho;

	@Column(name = "ute_contacto")
	private String contacto;

	@Column(name = "ute_estado")
	private String estado;

	@Column(name = "ute_numeroemps")
	private Long numeroEmprestimos;

	@Column(name = "ute_data_registo", nullable = false)
	private LocalDateTime dataRegisto;

	@ManyToOne
	@JoinColumn(name = "ute_instituicaoid")
	private InstituicaoEnsino instituicaoEnsino;

	@JoinColumn(name = "ute_enderecoid")
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	@OneToMany(mappedBy = "utenteEmprestimo")
	private List<Emprestimo> emprestimos;

	@OneToMany(mappedBy = "utenteDevolucoes")
	private List<Devolucao> devolucoes;

	@OneToMany(mappedBy = "utente")
	private List<EstudanteAprovado> listaAprovados;

	@OneToMany(mappedBy = "utente")
	private List<EstudanteReprovado> listaReprovacoes;

	@OneToMany(mappedBy = "utente")
	private List<EstudanteDesistencia> listaDesistencia;

	public List<EstudanteDesistencia> getListaDesistencia() {
		return listaDesistencia;
	}

	public void setListaDesistencia(List<EstudanteDesistencia> listaDesistencia) {
		this.listaDesistencia = listaDesistencia;
	}

	public List<EstudanteReprovado> getListaReprovacoes() {
		return listaReprovacoes;
	}

	public void setListaReprovacoes(List<EstudanteReprovado> listaReprovacoes) {
		this.listaReprovacoes = listaReprovacoes;
	}

	public List<EstudanteAprovado> getListaAprovados() {
		return listaAprovados;
	}

	public void setListaAprovados(List<EstudanteAprovado> listaAprovados) {
		this.listaAprovados = listaAprovados;
	}

	public List<Devolucao> getDevolucoes() {
		return devolucoes;
	}

	public void setDevolucoes(List<Devolucao> devolucoes) {
		this.devolucoes = devolucoes;
	}

	public InstituicaoEnsino getInstituicaoEnsino() {
		return instituicaoEnsino;
	}

	public void setInstituicaoEnsino(InstituicaoEnsino instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
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

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNumeroBi() {
		return numeroBi;
	}

	public void setNumeroBi(String numeroBi) {
		this.numeroBi = numeroBi;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getLocalTrabalho() {
		return localTrabalho;
	}

	public void setLocalTrabalho(String localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getNumeroEmprestimos() {
		return numeroEmprestimos;
	}

	public void setNumeroEmprestimos(Long numeroEmprestimos) {
		this.numeroEmprestimos = numeroEmprestimos;
	}

	public LocalDateTime getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(LocalDateTime dataRegisto) {
		this.dataRegisto = dataRegisto;
	}

	public InstituicaoEnsino getInsEnsino() {
		return instituicaoEnsino;
	}

	public void setInsEnsino(InstituicaoEnsino insEnsino) {
		this.instituicaoEnsino = insEnsino;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return nome;
	}

}
