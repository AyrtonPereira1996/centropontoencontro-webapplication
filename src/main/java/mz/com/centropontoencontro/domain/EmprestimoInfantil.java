package mz.com.centropontoencontro.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "emp_emprestimoinfantil")
public class EmprestimoInfantil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long id;

//	@Valid
	@ManyToOne
	@JoinColumn(name = "emp_utenteid")
	private UtenteMenor utenteEmprestimo;
	
//	@Valid
	@ManyToOne
	@JoinColumn(name = "emp_livroid")
	private LivroInfantil livroEmprestimo;
	
	@Column(name = "emp_data_registo")
	private LocalDateTime dataRegisto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UtenteMenor getUtenteEmprestimo() {
		return utenteEmprestimo;
	}

	public void setUtenteEmprestimo(UtenteMenor utenteMenor) {
		this.utenteEmprestimo = utenteMenor;
	}

	public LivroInfantil getLivroEmprestimo() {
		return livroEmprestimo;
	}

	public void setLivroEmprestimo(LivroInfantil livroInfantil) {
		this.livroEmprestimo = livroInfantil;
	}

	public LocalDateTime getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(LocalDateTime dataRegisto) {
		this.dataRegisto = dataRegisto;
	}
}
