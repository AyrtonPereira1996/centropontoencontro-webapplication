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


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "utm_utentemenor")
public class UtenteMenor {



	@Column(name = "utm_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Column(name = "utm_nome")
	private String nome;


	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "utm_datanascimento")
	private LocalDate dataNascimento;


	@Column(name = "utm_genero")
	private String genero;


	@Column(name = "utm_naturalidade")
	private String naturalidade;
	

	@Column(name = "utm_bi")
	private String numeroBi;

	@Column(name = "utm_nomemae", length = 100)
	private String nomeMae;

	

	@Column(name = "utm_nomepai", length = 100)
	private String nomePai;
	

	@Column(name = "utm_turma")
	private String turma;


	@Column(name = "utm_classe")
	private String classe;
	
	@Column(name = "utm_numeroemps")
	private Long numeroEmprestimos;

	@Column(name = "utm_data_registo")
	private LocalDateTime dataRegisto;

	@JoinColumn(name = "utm_encarregadoid")
	@OneToOne(cascade = CascadeType.ALL)
	private EncarregadoEducacao encarregado;

	@JoinColumn(name = "utm_enderecoid")
	@OneToOne(cascade = CascadeType.ALL)
	private EnderecoMenor endereco;

	@JoinColumn(name ="utm_instituicaoid")
	@ManyToOne
	private InstituicaoEnsino instituicaoEnsinoInfantil;
	
	@OneToMany(mappedBy = "utenteEmprestimo")
	private List<EmprestimoInfantil> emprestimos;

	@OneToMany(mappedBy = "utenteDevolucoes")
	private List<DevolucaoInfantil> devolucoes;

	public Long getNumeroEmprestimos() {
		return numeroEmprestimos;
	}

	public void setNumeroEmprestimos(Long numeroEmprestimos) {
		this.numeroEmprestimos = numeroEmprestimos;
	}

	public InstituicaoEnsino getInstituicaoEnsinoInfantil() {
		return instituicaoEnsinoInfantil;
	}

	public void setInstituicaoEnsinoInfantil(InstituicaoEnsino instituicaoEnsinoInfantil) {
		this.instituicaoEnsinoInfantil = instituicaoEnsinoInfantil;
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

	public String getNome() {
		return nome;
	}

	public List<DevolucaoInfantil> getDevolucoes() {
		return devolucoes;
	}

	public void setDevolucoes(List<DevolucaoInfantil> devolucoes) {
		this.devolucoes = devolucoes;
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

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public Long getNumeroEmps() {
		return numeroEmprestimos;
	}

	public void setNumeroEmps(Long numeroEmps) {
		this.numeroEmprestimos = numeroEmps;
	}

	public LocalDateTime getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(LocalDateTime dataRegisto) {
		this.dataRegisto = dataRegisto;
	}

	public EncarregadoEducacao getEncarregado() {
		return encarregado;
	}

	public void setEncarregado(EncarregadoEducacao encarregado) {
		this.encarregado = encarregado;
	}

	public EnderecoMenor getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoMenor endereco) {
		this.endereco = endereco;
	}

	public InstituicaoEnsino getInstituicao() {
		return instituicaoEnsinoInfantil;
	}

	public void setInstituicao(InstituicaoEnsino instituicao) {
		this.instituicaoEnsinoInfantil = instituicao;
	}

}
